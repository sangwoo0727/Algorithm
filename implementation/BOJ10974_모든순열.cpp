#include <iostream>
#include <vector>
#define endl '\n'
using namespace std;

vector <int> v;
int N;
bool check[8];

void permu(int r){
    if(r==N){
        for(int i=0;i<N;i++){
            cout << v[i] << ' ';
        }
        cout << endl;
        return;
    }
    for(int i=0;i<N;i++){
        if(!check[i]){
            check[i]=true;
            v.push_back(i+1);
            permu(r+1);
            v.pop_back();
            check[i]=false;
        }
    }
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    permu(0);
}