#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n; 

    int coins[n];
    int total = 0;
    for (int i=0; i<n; i++) {
        cin >> coins[i];
        total += coins[i];
    }

    sort(coins, coins + n);
    int mySum = 0;
    for (int i=n-1; i>=0; i--) {
        mySum += coins[i];
        if (mySum > (total - mySum)) {
            cout << (n - i) << endl;
            return 0;
        }
    }
}