#include <iostream>
#include <string>
#define endl "\n";
using namespace std;

int M;
int set = 0;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> M;

    while(M--){
        string s;
        int n;
        cin >> s;
        if(s=="add"){
            cin >> n;
            set |= (1<<n);
        }else if(s=="check"){
            cin >> n;
            if(set & (1<<n)){
                cout << "1"<< endl;
            }else {
                cout << "0" << endl;
            }
        }else if(s=="remove"){
            cin >> n;
            set &= ~(1<<n);
        }else if(s=="toggle"){
            cin >> n;
            set ^= (1<<n);
        }else if(s=="empty"){
            set = 0;
        }else if(s=="all"){
            set = (1<<21)-1;
        }
    }
    return 0;
}
