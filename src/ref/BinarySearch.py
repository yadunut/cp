ARR = [False, False, False, False, False, True]


def func(idx):
    return ARR[idx]


def binSearch():
    l, r = 0, len(ARR) - 1

    while l <= r:
        mid = (l + r) // 2
        # if mid is false, check right.
        # if mid is true, check if it's teh left most true item. return if true
