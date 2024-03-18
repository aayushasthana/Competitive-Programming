#include <iostream>
using namespace std;

int main() {
    long long n, m, a;
    cin >> n >> m >> a;
    if (n % a != 0 && m % a != 0) {
        cout << (n/a + 1) * (m/a + 1) << endl;
        return 0;
    } else if (n % a != 0) {
        cout << (n/a + 1) * (m/a) << endl;
        return 0;
    } else if (m % a != 0) {
        cout << (n/a) * (m/a + 1) << endl;
        return 0;
    } else {
        cout << (n/a) * (m/a) << endl;
        return 0;
    }
}
    