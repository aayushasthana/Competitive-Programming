#include <iostream>
using namespace std;

int main() {
    string team;
    cin >> team;
    if (team.length() < 7) {
        cout << "NO" << endl;
        return 0;
    } else {
        for (int i=0; i<team.length()-6; i++) {
            bool is1 = true;
            bool is0 = true;
            for (int j=i; j<i+7; j++) {
                if (team[j] == '0') is1 = false;
                else is0 = false;
            }

            if (is0 || is1) {
                cout << "YES" << endl;
                return 0;
            }
        }
        cout << "NO" << endl;
        return 0;
    }
}