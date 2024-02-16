import math
a, b, c, d, k = [float(x) for x in input().split(' ')]
a = int(a)
k = int(k)


def n(logba):
    is_int = float.is_integer(logba)
    if is_int and logba == 0:
        return ''
    if is_int and logba == 1:
        return 'n'
    if is_int:
        return f'n^{int(logba)}'
    return f'n^{round(logba, 1)}'

def log(k):
    if k == 0:
        return ''
    if k == 1:
        return 'log n'
    return f'log^{k} n'


def main():
    logba = math.log(a, b)
    # case 1
    if logba > d:
        print(n(logba))
    # case 2
    if logba == d:
        if k >= 0:
            print(n(logba), log(k+1))
            return
        if k == -1:
            print(n(logba), 'log log n')
            return
        if k < -1:
            print(n(logba))
            return
        print("not applicable")
        return
    # case 3:
    if logba < d:
        # check regularity condition
        if c == 0:
            print(f'{n(d)}')
            return
        log_s = log(k)
        c_s = '' if c == 1  else f' {str(c)}'
        print(f'{n(d)} {log_s}')


main()
