#include <iostream>
#include <set>

using namespace std;

int main() {
  set<char> s;
  string input;
  cin >> input;
  for (int i = 0; i < input.length(); i++) {
    s.insert(input[i]);
  }

  if (s.size() % 2 == 1) {
    cout << "IGNORE HIM!" << endl;
  } else {
    cout << "CHAT WITH HER!" << endl;
  }
  return 0;
}