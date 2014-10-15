package book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import com.opensymphony.xwork2.ActionSupport;



public class BookAction extends ActionSupport{
	private String jspTitle;
	private String target;
	private ArrayList<Book> B=new ArrayList<Book>();
	private ArrayList<Author> A=new ArrayList<Author>();
	private Author newAuthor=new Author();
	private Book newBook=new Book(); 
	private DBConnection bookConnection=new DBConnection();
	public String searchByName()
	{
		B.clear();
		try{
			String initializeString="select * from book where authorID = ?";
			String searchAuthorString="select * from author where name= ?";
			Connection tempConnection=bookConnection.getConnection();
			PreparedStatement bookstmt=tempConnection.prepareStatement(searchAuthorString);
			PreparedStatement jokePreparedStatement=tempConnection.prepareStatement(initializeString); 
			bookstmt.setString(1, target);
			ResultSet tempSet=bookstmt.executeQuery();
			ResultSet rs=null;
			if(tempSet.next())
			{	
				jspTitle=target+"'s Book";
				do
				{
					jokePreparedStatement.setInt(1,	tempSet.getInt("authorID"));
					rs=jokePreparedStatement.executeQuery();
					if(rs.next())
					{
						do{
							Book tempBook=new Book(rs.getString("ISBN"),rs.getString("title"),
									(String)Integer.toString(rs.getInt("authorID")),rs.getString("publishDate"),
									rs.getString("publisher"),(String)Double.toString(rs.getDouble("price")));
							B.add(tempBook);
						}while(rs.next());
					}
					else {
						System.out.println("find no book");
					}
				}while(tempSet.next());
			}	
			else {
				jspTitle="Not Find Author:"+target;
				System.out.print("not find author");
			}
			}catch(Exception e){
				jspTitle="Search Fail";
				System.out.println("fail in searchByBook");
			}
			return SUCCESS;
	}
	//*************************************************************************************************************
	public String information()
	{
		B.clear();
		try{
			String initializeString="select * from author where authorID = ?";
			String searchBookString="select * from book where ISBN= ?";
			Connection tempConnection=bookConnection.getConnection();
			PreparedStatement jokePreparedStatement=tempConnection.prepareStatement(initializeString); 
			PreparedStatement bookstmt=tempConnection.prepareStatement(searchBookString);
			bookstmt.setString(1, target);
			ResultSet rs= bookstmt.executeQuery();
			target="1";
			if(rs.next())
			{
				target="2";
				jspTitle="¡¶"+rs.getString("title")+"¡·'s information";
				target="3";
				do{
					target="4";
					Book tempBook=new Book(rs.getString("ISBN"),rs.getString("title"),
								Integer.toString(rs.getInt("authorID")),rs.getString("publishDate"),
								rs.getString("publisher"),Double.toString(rs.getDouble("price")));
					target="5";
					B.add(tempBook);
					jokePreparedStatement.setInt(1,	rs.getInt("authorID"));
					target="6";
					ResultSet temp=jokePreparedStatement.executeQuery();
					target="7";
					if(temp.next()){
						target="8";
						Author tempAuthor=new Author((String)temp.getString("authorID"),temp.getString("name"),temp.getString("age"),temp.getString("country"));
						A.add(tempAuthor);
					}
					else {
						Author nullAuthor=new Author();
						A.add(nullAuthor);
					}
					target="9";
				}while(rs.next());
			}
			else {
				jspTitle="No this book:"+target;
				System.out.println("not find");
			}
			}catch(Exception e){
				jspTitle="Fail in Finding This Book:"+target;
				System.out.println("fail in information");
			}
			return SUCCESS;
	}
	//*************************************************************************************************************
	public String searchByBook() throws SQLException
	{	
		B.clear();
		try{
		Connection tempConnection=bookConnection.getConnection();
		//Statement bookstmt=tempConnection.createStatement();
		String initialString="select * from book where title= ?";
		PreparedStatement bookstmt=tempConnection.prepareStatement(initialString);
		bookstmt.setString(1, target);
		ResultSet rs= bookstmt.executeQuery();
		if(rs.next())
		{
			jspTitle="Searching Result";
			do{
				Book tempBook=new Book(rs.getString("ISBN"),rs.getString("title"),
							Integer.toString(rs.getInt("authorID")),rs.getString("publishDate"),
							rs.getString("publisher"),Double.toString(rs.getDouble("price")));
				B.add(tempBook);
			}while(rs.next());
		}
		else {
			jspTitle="not find";
			System.out.println("not find");
		}
		}catch(Exception e){
			jspTitle="search fail";
			System.out.println("fail in searchByBook");
		}
		return SUCCESS;
	}
	public String AddBook() 
	{
		B.clear();
		try{
		Connection tempConnection=bookConnection.getConnection();
		String searchAuthorIDString="select * from author where authorID= ?";
		String searchISBNString="select * from book where ISBN= ?";
		String addBookString="insert into book (ISBN,title,authorID,publisher,publishDate,price) values (?,?,?,?,?,?)";
		PreparedStatement searchAuthorIDPreparedStatement=tempConnection.prepareStatement(searchAuthorIDString);
		PreparedStatement searchISBNPreparedStatement=tempConnection.prepareStatement(searchISBNString);
		PreparedStatement addBookPreparedStatement=tempConnection.prepareStatement(addBookString);
		searchAuthorIDPreparedStatement.setInt(1, Integer.parseInt(newBook.getAuthorID()));
		ResultSet rs=searchAuthorIDPreparedStatement.executeQuery();
		if(rs.next()){
			searchISBNPreparedStatement.setString(1, newBook.getISBN());
			ResultSet tempResultSet=searchISBNPreparedStatement.executeQuery();
			if(tempResultSet.next()){
				jspTitle="the ISBN already exsits";
				target=newBook.getTitle();
			}
			else {
			jspTitle="Add Succeed";
			addBookPreparedStatement.setString(1, newBook.getISBN());
			addBookPreparedStatement.setString(2, newBook.getTitle());
			addBookPreparedStatement.setInt(3, Integer.parseInt(newBook.getAuthorID()));
			addBookPreparedStatement.setString(4, newBook.getPublisher());
			addBookPreparedStatement.setString(5, newBook.getPublishDate());
			addBookPreparedStatement.setDouble(6, Double.parseDouble(newBook.getPrice()));
			addBookPreparedStatement.executeUpdate();
			System.out.println("Add succeed");
			}
		}
		else {
			jspTitle="authorID does not exist, add author first";
			System.out.println("authorID does not exist, add author first");
			B.clear();
		}
		}catch (Exception e) {
			// TODO: handle exception
			jspTitle="fail in AddBook";
			System.out.println("fail in AddBook");
		}
		return SUCCESS;
	}
	//******************************************************************************************************
	public String AddAuthor()
	{
		A.clear();
		try{
		Connection tempConnection=bookConnection.getConnection();
		Statement bookstmt=tempConnection.createStatement();
		String sqlString="select * from author where authorID= ?";
		String addAuthorString="insert into author (authorID,name,age,country) values (?,?,?,?)";
		PreparedStatement addAuthorPreparedStatement=tempConnection.prepareStatement(addAuthorString);
		PreparedStatement jokePreparedStatement=tempConnection.prepareStatement(sqlString);
		jokePreparedStatement.setString(1, newAuthor.getAuthorID());
		ResultSet rs=jokePreparedStatement.executeQuery();
		System.out.println("prepare succeed");
		if(rs.next()){
			jspTitle="authorID already exist";
			System.out.println("authorID already exist");
		}
		else {
			addAuthorPreparedStatement.setInt(1, Integer.parseInt(newAuthor.getAuthorID()));
			addAuthorPreparedStatement.setString(2, newAuthor.getName());
			addAuthorPreparedStatement.setString(3, newAuthor.getAge());
			addAuthorPreparedStatement.setString(4, newAuthor.getCountry());
			addAuthorPreparedStatement.executeUpdate();
			System.out.println("Add succeed");
			jspTitle="Add Succeed";
		}
		}catch (Exception e) {
			// TODO: handle exception
			jspTitle="fail in AddBook";
			System.out.println("fail in AddAuthor");
		}
		return SUCCESS;
	}
	//******************************************************************************************************
	public String delete()
	{
		B.clear();
		try{
		Connection tempConnection=bookConnection.getConnection();
		Statement bookstmt=tempConnection.createStatement();
		bookstmt.executeUpdate("delete from book where ISBN= '"+target+"'");
		jspTitle="Delete Succeed";
		}catch(Exception e){
			jspTitle="fail in delete";
			System.out.println("fail in delete");
		}
		return SUCCESS;
	}
	//**************************************************************************************************
	public void display(Book i)
	{
		System.out.println(i.getISBN()+"   "+i.getTitle()+"   "+
						i.getAuthorID()+"   "+i.getPublisher()+"   "+
						i.getPublishDate()+"   "+i.getPrice());
	}
	public void display(Author i)
	{
		System.out.println(i.getAuthorID()+"   "+i.getName()+"   "+
						i.getAge()+"   "+i.getCountry());
	}
	public String getJspTitle() {
		return jspTitle;
	}
	public void setJspTitle(String jspTitle) {
		this.jspTitle = jspTitle;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public ArrayList<Book> getB() {
		return B;
	}
	public void setB(ArrayList<Book> b) {
		B = b;
	}
	public ArrayList<Author> getA() {
		return A;
	}
	public void setA(ArrayList<Author> a) {
		A = a;
	}
	public Book getNewBook() {
		return newBook;
	}
	public void setNewBook(Book newBook) {
		this.newBook = newBook;
	}
	public Author getNewAuthor() {
		return newAuthor;
	}
	public void setNewAuthor(Author newAuthor) {
		this.newAuthor = newAuthor;
	}
}
