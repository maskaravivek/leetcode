from math import sqrt
from math import log
from math import pow


def solution(total_lambs):
    eps = pow(10, -10)
    golden_search_ratio = (1+sqrt(5))/2
    tau = (1-sqrt(5))/2

    max_hunchmen = int(
        round(log((total_lambs + 1) * sqrt(5)+eps, golden_search_ratio))) - 2

    fibonacci_number = int(round(
        (pow(golden_search_ratio, max_hunchmen+2)-pow(tau, max_hunchmen+2))/sqrt(5)))
    if total_lambs+1 < fibonacci_number:
        max_hunchmen -= 1

    min_hunchmen = int(log((total_lambs + 1), 2))

    return abs(max_hunchmen - min_hunchmen)