# Divide-and-Conquer Matrix Multiplication using Strassen's Algorithm

**Student:** Rohith\
**Roll No.:** 24wh1a05y9\
**Course:** Design and Analysis of Algorithms\
**Project:** Divide-and-Conquer Matrix Multiplication\
**Topic:** Illustrate recursive division of matrices in Strassen's
algorithm\
**Submission Deadline:** 5 October 2026

## 1. Project Overview

This project demonstrates how Strassen's matrix multiplication algorithm
applies the **divide-and-conquer** technique.

Instead of directly performing eight recursive matrix multiplications
after dividing two matrices into four submatrices, Strassen's algorithm
reduces the number of recursive multiplications from **8 to 7**. It
introduces additional matrix additions and subtractions to achieve this
reduction.

The project visualizes:

1.  The original matrices A and B.
2.  Division of each matrix into four submatrices.
3.  The seven recursive products P1 to P7.
4.  Combination of those products to obtain C11, C12, C21, and C22.
5.  The final result matrix C.
6.  The recursive flow and base case.

## 2. Objective

To understand and visually illustrate the recursive divide-and-conquer
process used by Strassen's algorithm for matrix multiplication.

## 3. Algorithm

Given two n × n matrices:

A = \[\[A11, A12\], \[A21, A22\]\]

B = \[\[B11, B12\], \[B21, B22\]\]

Strassen computes seven products:

-   P1 = A11 × (B12 − B22)
-   P2 = (A11 + A12) × B22
-   P3 = (A21 + A22) × B11
-   P4 = A22 × (B21 − B11)
-   P5 = (A11 + A22) × (B11 + B22)
-   P6 = (A12 − A22) × (B21 + B22)
-   P7 = (A11 − A21) × (B11 + B12)

Then:

-   C11 = P5 + P4 − P2 + P6
-   C12 = P1 + P2
-   C21 = P3 + P4
-   C22 = P5 + P1 − P3 − P7

Finally:

C = \[\[C11, C12\], \[C21, C22\]\]

## 4. Pseudocode

``` text
STRASSEN(A, B, n)

1. If n == 1:
       return A × B

2. Divide A into:
       A11, A12, A21, A22

3. Divide B into:
       B11, B12, B21, B22

4. P1 = STRASSEN(A11, B12 - B22)
5. P2 = STRASSEN(A11 + A12, B22)
6. P3 = STRASSEN(A21 + A22, B11)
7. P4 = STRASSEN(A22, B21 - B11)
8. P5 = STRASSEN(A11 + A22, B11 + B22)
9. P6 = STRASSEN(A12 - A22, B21 + B22)
10. P7 = STRASSEN(A11 - A21, B11 + B12)

11. C11 = P5 + P4 - P2 + P6
12. C12 = P1 + P2
13. C21 = P3 + P4
14. C22 = P5 + P1 - P3 - P7

15. Combine:
       C = [[C11, C12],
            [C21, C22]]

16. Return C
```

## 5. Divide-and-Conquer Logic

The algorithm follows three major stages:

### Divide

Each n × n matrix is divided into four approximately equal-sized
submatrices.

### Conquer

The seven required products are computed recursively. Each recursive
call again divides its matrices until the base case is reached.

### Combine

The seven products are added and subtracted using Strassen's formulas to
form the four blocks of the final matrix.

## 6. Why Strassen's Algorithm?

The conventional divide-and-conquer matrix multiplication performs **8
recursive multiplications** for each division.

Strassen reduces this to **7 recursive multiplications**, at the cost of
additional matrix additions and subtractions.

The recurrence is:

T(n) = 7T(n/2) + O(n²)

Therefore, the asymptotic time complexity is:

T(n) = O(n\^log₂7) ≈ O(n\^2.807)

This improves on the conventional O(n³) matrix multiplication for
sufficiently large matrices.

## 7. Visualization

The AI-generated visualization shows:

**Original Matrices → Divide into Submatrices → Seven Recursive Products
→ Combine Results → Final Matrix**

It also includes a recursive-flow diagram showing the base case and
repeated division.

## 8. AI Prompt Used

> Illustrate recursive division of matrices in Strassen's algorithm.
> Create a professional educational block diagram showing the original
> n×n matrices A and B, division into four submatrices A11, A12, A21,
> A22 and B11, B12, B21, B22, the seven recursive products P1 through
> P7, the formulas used to combine them into C11, C12, C21, C22, and the
> final result matrix C. Include a recursive flow showing the base case
> n=1, divide, recursively compute seven products, and combine. Use a
> clean academic design with a dark navy/blue theme, white background
> panels, and orange accents. Clearly label all matrix blocks, arrows,
> formulas, and stages.

## 9. Visualization Explanation

The visualization represents the complete recursive process.

-   **Stage 1:** A and B are the original matrices.
-   **Stage 2:** Each matrix is divided into four blocks.
-   **Stage 3:** Seven products are calculated recursively.
-   **Stage 4:** The seven products are combined to form four blocks of
    C.
-   **Stage 5:** The four blocks are assembled into the final matrix C.
-   **Recursive Flow:** If the matrix size is greater than 1, the
    process repeats. At n = 1, ordinary scalar multiplication is
    performed.

## 10. Complexity Analysis

  Operation                               Complexity
  --------------------------------------- -------------------------
  Standard matrix multiplication          O(n³)
  Strassen's algorithm                    O(n\^log₂7) ≈ O(n²·⁸⁰⁷)
  Matrix addition/subtraction per level   O(n²)
  Number of recursive multiplications     7

The theoretical advantage becomes more relevant as matrix size
increases, although practical implementations may use conventional
multiplication for small matrices because recursion and additional
additions have overhead.

## 11. Learning Outcomes

After completing this project, the student should be able to:

-   Explain the divide-and-conquer paradigm.
-   Divide a matrix into submatrices.
-   Explain the seven Strassen products.
-   Trace recursive calls.
-   Explain the base case.
-   Derive the final matrix from C11, C12, C21 and C22.
-   Compare O(n³) multiplication with Strassen's O(n\^2.807) approach.
-   Create and document an algorithm visualization using an AI tool.

## 12. Suggested Repository Structure

``` text
strassen-matrix-multiplication/
│
├── README.md
├── algorithm/
│   ├── algorithm.md
│   └── pseudocode.txt
│
├── visualization/
│   ├── strassen_recursive_division.png
│   └── ai_prompt.txt
│
├── documentation/
│   └── explanation.md
│
├── presentation/
│   └── Strassen_Algorithm_Presentation.pptx
│
└── LICENSE
```

## 13. GitHub Submission Checklist

-   [ ] Algorithm written
-   [ ] Pseudocode included
-   [ ] Short algorithm explanation included
-   [ ] AI prompt included
-   [ ] AI-generated diagram included
-   [ ] Visualization explained
-   [ ] Complexity analysis included
-   [ ] Professional README added
-   [ ] GitHub repository created
-   [ ] Project files uploaded
-   [ ] PPT completed
-   [ ] Presentation/video walkthrough prepared
-   [ ] Roll number verified as **24wh1a05y9**
-   [ ] Final review completed before **5 October 2026**

## 14. Conclusion

Strassen's algorithm demonstrates how divide-and-conquer can reduce the
number of recursive matrix multiplications. By dividing matrices into
smaller blocks and using seven carefully constructed recursive products
instead of eight, the algorithm achieves a theoretical complexity of
approximately O(n²·⁸⁰⁷). The visualization makes the recursive structure
and combination process easier to understand and present.
