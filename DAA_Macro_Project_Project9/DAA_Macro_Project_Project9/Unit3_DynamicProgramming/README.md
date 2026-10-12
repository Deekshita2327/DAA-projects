# Project 9 – 0/1 Knapsack using Dynamic Programming

## Description
This project implements the 0/1 Knapsack problem using Dynamic Programming.
The project uses 4 items and a knapsack capacity of 10, as specified for
Unit III – Project 9.

## Input
| Item | Weight | Profit |
|---|---:|---:|
| 1 | 2 | 3 |
| 2 | 3 | 4 |
| 3 | 4 | 5 |
| 4 | 5 | 6 |

Knapsack capacity: **10**

## Algorithm
A two-dimensional DP table is constructed where `dp[i][w]` stores the
maximum profit possible using the first `i` items with capacity `w`.

If the current item fits:

`dp[i][w] = max(profit[i-1] + dp[i-1][w-weight[i-1]], dp[i-1][w])`

Otherwise:

`dp[i][w] = dp[i-1][w]`

The final answer is `dp[n][W]`.

See `Algorithm_Pseudocode.txt` for the complete pseudocode.

## Prompt Used
See `Prompt.txt`.

## Visualization
`Visualization.png` contains the DP table for capacities 0 through 10 and
shows the computed values. The final maximum profit is **13**.

## Output
The program prints the DP table, maximum profit, and selected items.

Maximum Profit: **13**

Selected Items: **1, 2, 4**

Total Weight: **10**

## Complexity
- Time Complexity: **O(n × W)**
- Space Complexity: **O(n × W)**

## Learning Outcome
- Understood Dynamic Programming for the 0/1 Knapsack problem.
- Learned how a DP table stores solutions to smaller subproblems.
- Understood item inclusion and exclusion decisions.
- Practiced algorithm documentation and prompt-based visualization.
- Prepared a project structure suitable for GitHub submission.
