#include <iostream>
#include <string>
using namespace std;

int main() {
    string input;
    cin >> input;
    
    int count = 0;
    for (int i=0; i<input.length(); i++) {
        if (count == 0 && input[i] == 'h') count++;
        else if (count == 1 && input[i] == 'e') count++;
        else if (count == 2 && input[i] == 'l') count++;
        else if (count == 3 && input[i] == 'l') count++;
        else if (count == 4 && input[i] == 'o') count++;
    }

    if (count == 5) {
        cout << "YES";
    } else {
        cout << "NO";
    }
}