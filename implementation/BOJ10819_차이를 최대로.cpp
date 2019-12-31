#include <iostream>
#include <vector>
#include <cmath>
#define endl '\n'
using namespace std;

vector <int> v;
int N;
int arr[10];
int Max;
bool check[10];

void permu(int r){
    if(r == N){
        int result=0;
        for(int i=0;i<N-1;i++){
            result += abs(v[i]-v[i+1]);
        }
        Max = max(Max,result);
    }
    for(int i=0;i<N;i++){
        if(!check[i]){
            check[i]=true;
            v.push_back(arr[i]);
            permu(r+1);
            v.pop_back();
            check[i]=false;
        }
    }
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for(int i=0;i<N;i++){
        cin >> arr[i];
    }
    permu(0);
    cout << Max << endl;
    return 0;
}
