#include <bits/stdc++.h>
using namespace std;

int main() {
    int x;
    int y;
    int curr;
    for (int i=1; i<6; i++) {
        for (int j=1; j<6; j++) {
            cin >> curr;
            if (curr == 1) {
                x = i;
                y = j;
            }
        }
    }

    cout << abs(x-3) + abs(y-3) << endl;
}
