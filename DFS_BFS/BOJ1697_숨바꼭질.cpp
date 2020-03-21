#include <iostream>
#include <queue>
#include <utility>
#define endl "\n";
using namespace std;

int visit[200000];
int N,K;
int ans;
queue <pair<int,int>> q;

void bfs(){
    q.push(make_pair(N,0));
    while(!q.empty()){
        int n = q.front().first;
        int lev = q.front().second;
        visit[n]=1;
        q.pop();
        if(n==K){
            ans = lev;
            break;
        }
        else if(n>K){
            int nn = n-1;
            if(!visit[nn]){
                visit[nn]=1;
                q.push(make_pair(nn,lev+1));
            }
        }else{
            int nn = n-1;
            if(!visit[nn] && nn>=0){
                visit[nn]=1;
                q.push(make_pair(nn,lev+1));
            }
            nn = n+1;
            if(!visit[nn]){
                visit[nn]=1;
                q.push(make_pair(nn,lev+1));
            }
            nn = 2*n;
            if(!visit[nn]){
                visit[nn]=1;
                q.push(make_pair(nn,lev+1));
            }
        }
    }
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    bfs();
    cout << ans << endl;
    return 0;
}
