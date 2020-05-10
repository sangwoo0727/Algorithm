#include <iostream>
#include <utility>
#include <deque>
using namespace std;

int n,l,tmp;
deque<pair<int,int>> dq;

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> n >> l;
    for(int i=0; i<n; i++) {
        cin >> tmp;
        while(dq.size() && dq.back().first > tmp){
            dq.pop_back();
        }
        dq.push_back({tmp,i});
        if(dq.front().second < i-l+1){
            dq.pop_front();
        }
        cout << dq.front().first << " ";
    }
    return 0;
}