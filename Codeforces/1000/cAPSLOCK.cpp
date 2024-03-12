#include <iostream>
using namespace std;

int main() {
  string input;
  int count = 0;
  cin >> input;

  for (int i = 0; i < input.length(); i++) {
    if (isupper(input[i])) {
      count++;
    }
  }
  
  if (count == input.length()) {
    string retval = "";
    for (int i=0; i<input.length(); i++) {
      retval += tolower(input[i]);
    }
    cout << retval << endl;
  }
  
  else if (islower(input[0]) && count == input.length()-1) {
    string retval = "";
    retval += toupper(input[0]);
    for (int i = 1; i < input.length(); i++) {
      retval += tolower(input[i]);
    }

    cout << retval;
  }

  else {
    cout << input;
  }
}