#include <iostream>
using namespace std;

int main() {
    string input;
    cin >> input;
    if (input.find('H') != input.npos || input.find('Q') != input.npos || input.find('9') != input.npos) {
        cout << "YES" << endl;
        return 0;
    } else {
        cout << "NO" << endl;
        return 0;
    }
}