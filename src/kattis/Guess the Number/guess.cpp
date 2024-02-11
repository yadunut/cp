// #include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
  int upper = 1000;
  int lower = 1;
  int n;
  string i;
  cout << i[100] << endl;

  while (i[0] != 'c') {
    n = (upper + lower) / 2;
    cout << n << endl;
    cin >> i;
    if (i[0] == 'l') {
      upper = n - 1;
    } else if (i[0] == 'h') {
      lower = n + 1;
    }
  }
  return 0;
}
