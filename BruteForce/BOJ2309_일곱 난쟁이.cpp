#include <iostream>
#include <algorithm>
#define endl '\n'
using namespace std;

int arr[9];

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int sum=0,a=0,b=0;
    for(int i=0;i<9;i++){
        cin >> arr[i];
        sum+=arr[i];
    }
    sort(arr,arr+9);
    for(int i=0;i<8;i++){
        bool flag = false;
        for(int j=i;j<9;j++){
            if(sum - arr[i] - arr[j] == 100){
                a = i; b = j;
                flag = true;
                break;
            }
        }
        if(flag) break;
    }
    for(int i=0;i<9;i++){
        if(i!=a && i!=b){
            cout << arr[i] << endl;
        }
    }
    return 0;
}