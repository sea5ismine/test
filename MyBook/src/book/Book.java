package book;

public class Book {
	public Book()
	{
		ISBN=null;
		title=null;
		authorID=null;
		publishDate=null;
		publisher=null;
		price=null;
	}
	public Book(String i,String t,String a,String d,String e,String p)
	{
		ISBN=i;
		title=t;
		authorID=a;
		publishDate=d;
		publisher=e;
		price=p;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private String ISBN;
	private String title;
	private String authorID;
	private String publisher;
	private String publishDate;
	private String price;
}
