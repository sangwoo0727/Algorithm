#include <iostream>
#include <string>
#define endl '\n'

using namespace std;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int N=0,M=0,num=0;
    cin >> M;
    while(M--){
        string s;
        cin >> s;
        if(s == "add"){
            cin >> num;
            N |= (1<<num);
        }
        else if(s=="remove"){
            cin >> num;
            N &= ~(1<<num);
        }
        else if(s=="check"){
            cin >> num;
            int tmp = (1<<num);
            if(N & tmp) {
                cout << "1"<<endl;
            }
            else {
                cout << "0"<<endl;
            }
        }
        else if(s=="toggle"){
            cin >> num;
            N ^= (1<<num);
        }
        else if(s=="all"){
            N ^= (1<<21)-1;
        }
        else if(s=="empty"){
            N = 0;
        }
    }
    return 0;
}