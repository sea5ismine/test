#include <cstdio>
#include <cstring>
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <set>
#include <queue>
#define ll long long
using namespace std;
const int inf = 0x3f3f3f3f;
const int maxn = 2222;
int dp[10][150][32], rec[10][150][32][3], cont[10][150];
char name[maxn][111];
struct Film
{
    int id, time;
    int flag;
} film[5][maxn];
int num[5];
bool cmp(Film a, Film b)
{
    return a.time<b.time;
}
void dfs(int x, int y, int z)
{
    if (x==0) return ;
    dfs(x-1, rec[x][y][z][1], rec[x][y][z][2]);
    int r=rec[x][y][z][0], pre=rec[x][y][z][1];
    for (int i=0; i<num[r]; i++)
    {
        if (!film[r][i].flag&&film[r][i].time>=pre&&film[r][i].time<=y)
        {
            film[r][i].flag=1;
            printf("\"%s\"\n", name[film[r][i].id]);
        }
    }
}
int main()
{
    //freopen("dvd.in", "r", stdin);
    //freopen("dvd.out", "w", stdout);
    int n;
    char ch;
    scanf("%d", &n);
    for (int i=0; i<n; i++)
    {
        int cnt=0;
        while ((ch=getchar())!='"');
        while ((ch=getchar())!='"')
        {
            name[i][cnt++]=ch;
        }
        name[i][cnt]='\0';
        int t, r;
        scanf("%d%d", &t, &r);
        t-=1870;
        r--;
        film[r][num[r]].id=i;
        film[r][num[r]].time=t;
        cont[r][t]++;
        num[r]++;
    }
    for (int i=0; i<5; i++)
        sort(film[i], film[i]+num[i], cmp);
    for(int i=1;)
    dp[0][0][0]=0;
    for (int i=0; i<6; i++)
    {
        for (int x=0; x<=134; x++)
        {
            for (int st=0; st<32; st++)
            {
                if (dp[i][x][st]==-1)
                    continue;
                for (int j=0; j<5; j++)
                {
                    int sum=0;
                    for (int y=x; y<=134; y++)
                    {
                        if (y==x&&(st&(1<<j)))
                            continue;
                        sum+=cont[j][y];
                        int nst=(1<<j);
                        if (y==x)
                            nst=st|(1<<j);
                        if (dp[i+1][y][nst]<dp[i][x][st]+sum)
                        {
                            dp[i+1][y][nst]=dp[i][x][st]+sum;
                            rec[i+1][y][nst][0]=j;
                            rec[i+1][y][nst][1]=x;
                            rec[i+1][y][nst][2]=st;
                        }
                    }
                }
            }
        }
    }
    int ans=0, rr;
    for (int i=0; i<32; i++)
    {
        if (ans<dp[6][134][i])
        {
            ans=dp[6][134][i];
            rr=i;
        }
    }
    printf("%d\n", ans);
    dfs(6, 134, rr);
    return 0;
}
