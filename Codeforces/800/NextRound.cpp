#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    int K;
    cin >> N >> K;
    int a[N];
    for (int i=0; i<N; i++) {
        cin >> a[i];
    }

    int score = a[K-1];
    int ans = 0;
    for (int i=0; i<N; i++) {
        if (a[i] >= score && a[i] > 0) {
            ans++;
        }
    }

    cout << ans << endl;
}
