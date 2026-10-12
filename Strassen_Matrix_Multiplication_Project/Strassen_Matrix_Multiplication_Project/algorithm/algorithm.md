# Strassen's Algorithm --- Algorithm and Pseudocode

## Input

Two square matrices A and B of size n × n.

## Output

Matrix C = A × B.

## Algorithm Steps

1.  Check whether n = 1.
2.  If yes, multiply the two scalar values and return the result.
3.  Divide A into A11, A12, A21, A22.
4.  Divide B into B11, B12, B21, B22.
5.  Recursively calculate P1 through P7.
6.  Calculate C11, C12, C21 and C22.
7.  Combine the four blocks.
8.  Return C.

## Pseudocode

``` text
STRASSEN(A, B, n)

IF n == 1
    RETURN A[0][0] * B[0][0]

Divide A into A11, A12, A21, A22
Divide B into B11, B12, B21, B22

P1 = STRASSEN(A11, B12 - B22)
P2 = STRASSEN(A11 + A12, B22)
P3 = STRASSEN(A21 + A22, B11)
P4 = STRASSEN(A22, B21 - B11)
P5 = STRASSEN(A11 + A22, B11 + B22)
P6 = STRASSEN(A12 - A22, B21 + B22)
P7 = STRASSEN(A11 - A21, B11 + B12)

C11 = P5 + P4 - P2 + P6
C12 = P1 + P2
C21 = P3 + P4
C22 = P5 + P1 - P3 - P7

RETURN [[C11, C12],
        [C21, C22]]
```
