# Project Explanation

## What is being demonstrated?

This project demonstrates recursive division in Strassen's matrix
multiplication algorithm.

Suppose A and B are n × n matrices. Instead of multiplying every row and
column directly, Strassen first divides both matrices into four smaller
blocks.

The algorithm then performs seven specially constructed recursive
multiplications. These products are combined using addition and
subtraction to obtain the four blocks of the answer.

## Why is this divide-and-conquer?

The problem is divided into smaller matrix multiplication problems. Each
smaller problem is solved recursively, and the partial results are
combined to form the final answer.

## Visualization flow

``` text
A, B
 ↓
Divide into 4 submatrices
 ↓
P1 P2 P3 P4 P5 P6 P7
 ↓
Combine using Strassen formulas
 ↓
C11 C12 C21 C22
 ↓
Final C = A × B
```

## Important presentation point

The key idea to explain in class is:

**Normal divide-and-conquer:** 8 recursive multiplications.

**Strassen:** 7 recursive multiplications + additional
additions/subtractions.

That single reduction changes the recurrence from approximately 8T(n/2)
to 7T(n/2), giving the theoretical improvement from O(n³) to
approximately O(n².807).
