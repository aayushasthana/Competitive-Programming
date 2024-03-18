#include <iostream>
using namespace std;

int main() {
    int num;
    cin >> num;

    bool lucky = true;
    string strNum = to_string(num);
    for (int i=0; i<strNum.length(); i++) {
        if (strNum[i] != '4' && strNum[i] != '7') lucky = false;
    }

    if (lucky || num%4 == 0 || num%7 == 0 || num%44 == 0 || num%47 == 0) {
        cout << "YES";
    } else {
        cout << "NO";
    }
}