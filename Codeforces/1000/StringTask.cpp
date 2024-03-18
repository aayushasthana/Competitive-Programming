#include <iostream>
#include <string>
using namespace std;

int main() {
    string input;
    cin >> input;
    string retval = "";
    for (int i=0; i<input.length(); i++) {
        char c = input[i];
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U' && c != 'y' && c != 'Y') {
            retval += ".";
            retval += tolower(c);
        }
    }
    cout << retval << endl;
}