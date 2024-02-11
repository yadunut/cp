#include <iostream>
using namespace std;

int main() {
  unsigned long a, b;
  char op;
  while (cin >> a >> op >> b) {
    if (op == '+') {
      a = a % 10000;
      b = b % 10000;
      cout << (a + b) % 10000 << "\n";
    } else if (op == '*') {
      a = a % 10000;
      b = b % 10000;
      cout << (a * b) % 10000 << "\n";
    } else if (op == '^') {
      unsigned long r = 1;
      while (b > 0) {
        if (b & 1)
          r = (r * a) % 10000;
        a = (a * a) % 10000;
        b /= 2;
      }
      cout << r % 10000 << "\n";
    } else {
      break;
    }
  }
  return 0;
}
