#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int x = 0, y = 0, z = 0;
    for (int i=0; i<n; i++) {
        int dx, dy, dz;
        cin >> dx >> dy >> dz;
        x += dx;
        y += dy;
        z += dz;
    }

    if (x == 0 && y == 0 && z == 0) {
        cout << "YES";
    } else {
        cout << "NO";
    }
}