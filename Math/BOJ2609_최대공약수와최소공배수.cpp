#include <iostream>
using namespace std;

int gcd(int n,int m){
    while(m!=0){
        int r=n%m;
        n=m;
        m=r;
    }
    return n;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    int n; int m;
    cin >> n >> m;
    int g = gcd(n,m);
    cout << g << endl;
    cout << n*m/g << endl;
    return 0;
}

