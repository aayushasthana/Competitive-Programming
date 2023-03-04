#include <bits/stdc++.h>
using namespace std;

int main() {
    string first;
    string second;
    cin >> first >> second;

    for (int i=0; i < first.length(); i++) first[i] = tolower(first[i]);
    for (int i=0; i < second.length(); i++) second[i] = tolower(second[i]);

    cout << first.compare(second) << endl;
}
