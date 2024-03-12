#include <iostream>
#include <algorithm>
using namespace std;

int main() {
  int result = 0;
  int a, b, c;

  cin >> a >> b >> c;

  result = max(result, a + b + c);
  result = max(result, a * b + c);
  result = max(result, (a + b) * c);
  result = max(result, a * (b + c));
  result = max(result, a * b * c);

  cout << result;
}