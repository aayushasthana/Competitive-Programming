#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;

    int heights[n];
    for (int i=0; i<n; i++) {
        cin >> heights[i];
    }

    sort(heights, heights + n);
    
    for (int i=0; i<n; i++) {
        cout << heights[i] << " ";
    }

    return 0;
}