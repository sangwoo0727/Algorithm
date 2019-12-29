#include <iostream>
#include <algorithm>
#define endl '\n'
using namespace std;

int arr[7];
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int sum=0, Min=100;
    for(int i=0;i<7;i++){
        cin >> arr[i];
        if(arr[i]%2){
            sum+=arr[i];
            Min = min(Min,arr[i]);
        }
    }
    if(!sum) cout << "-1" << endl;
    else {
        cout << sum << endl;
        cout << Min << endl;
    }
    return 0;
}