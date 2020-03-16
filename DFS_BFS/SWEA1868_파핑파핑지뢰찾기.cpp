#include <iostream>
#include <string>
#include <cstring>
#include <queue>
#include <utility>
#define endl "\n"
using namespace std;

int tc,N,ans;
queue<pair<int,int>> q;
char bd[301][301];
int vt[301][301];
int d[2][8]={{0,-1,-1,-1,0,1,1,1},{-1,-1,0,1,1,1,0,-1}};

bool inner(int n, int m){
    return 0<=n && n<N && 0<=m && m<N && !vt[n][m];
}
void bfs(int n, int m){
    q.push(make_pair(n,m));
    while(!q.empty()){
        int n = q.front().first;
        int m = q.front().second;
        vt[n][m]=1;
        q.pop();
        bool flg = 0;
        for(int k=0; k<8; k++){
            int nn = n+d[0][k];
            int nm = m+d[1][k];
            if(inner(nn,nm)&& bd[nn][nm]=='*') {
                flg = true;
                break;
            }
        }
        if(!flg){
            for(int k=0; k<8; k++){
                int nn = n+d[0][k];
                int nm = m+d[1][k];
                if(inner(nn,nm)&& bd[nn][nm]=='.'){
                    vt[nn][nm]=1;
                    q.push(make_pair(nn,nm));
                }
            }
        }
    }
}


int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> tc;
    for(int t=1; t<=tc; t++){
        memset(vt,0, sizeof(vt));
        cin >> N;
        for(int i=0; i<N; i++){
            string s;
            cin >> s;
            for(int j=0; j<N; j++){
                bd[i][j]=s[j];
            }
        }
        ans = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bool flg=false;
                if(!vt[i][j] && bd[i][j]=='.'){
                    for(int k=0; k<8; k++) {
                        int n = i+d[0][k];
                        int m = j+d[1][k];
                        if(0<=n && n<N && 0<=m && m<N && bd[n][m]=='*'){
                            flg = true;
                            break;
                        }
                    }
                    if(!flg) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(bd[i][j]=='.' && !vt[i][j])
                    ans++;
            }
        }
        cout << "#" << t << " " << ans << endl;
    }
}

