#include <iostream>
#include <set>
using namespace std;

int N;
set<int> s;
set<int> ::iterator it;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++){
        int a;
        cin >> a;
        s.insert(a);
    }
    for(it=s.begin(); it!=s.end(); it++){
        cout << *it << " ";
    }
    return 0;
}
