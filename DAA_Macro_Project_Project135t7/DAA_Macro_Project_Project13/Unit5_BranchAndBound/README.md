# Project 13 – 0/1 Knapsack using Branch and Bound

## Description

This project implements the **0/1 Knapsack problem using Branch and Bound** and illustrates how bounding is used to prune unpromising branches of the state-space tree.

The project uses the same simple 4-item, capacity-10 style as the provided Project 9 example, but replaces the Dynamic Programming table with a Branch-and-Bound search tree.

The faculty prompt for Unit V – Project 13 is:

> “Illustrate bounding and pruning in 0/1 Knapsack using node values.”

The required outcome is a tree containing bound values and pruned branches.

## Input

| Item | Weight | Profit | Profit/Weight |
|---|---:|---:|---:|
| 1 | 2 | 3 | 1.50 |
| 2 | 3 | 4 | 1.33 |
| 3 | 4 | 5 | 1.25 |
| 4 | 5 | 6 | 1.20 |

Knapsack capacity: **10**

## Branch-and-Bound Idea

Each node represents a partial selection of items.

For every node we store:

- **Level** – number of items considered.
- **Weight** – total weight selected so far.
- **Profit** – total profit selected so far.
- **Bound** – an optimistic upper bound on the best profit that can be obtained from this node.

The bound is calculated by taking remaining items completely whenever possible and then taking a fractional part of the next item if necessary. The fractional part is used only to calculate the upper bound; the actual solution remains 0/1.

## Pruning

A node is pruned when:

1. Its weight is greater than the knapsack capacity, or
2. Its bound is less than or equal to the best profit already found.

This avoids exploring branches that cannot improve the current solution.

## Algorithm / Pseudocode

See `Algorithm_Pseudocode.txt`.

## Prompt Used

See `Prompt.txt`.

## Visualization

`Visualization.png` shows the Branch-and-Bound state-space tree.

Each node displays:

- Weight
- Profit
- Bound

Branches that are not useful are marked as **PRUNED**.

## Output

For the given input:

- **Maximum Profit = 13**
- **Total Weight = 10**
- **Selected Items = 1, 2, 4**

The selected items have total weight `2 + 3 + 5 = 10` and total profit `3 + 4 + 6 = 13`.

## Complexity

- Worst-case time complexity: **O(2^n)**
- Space complexity: **O(n)** for the recursive search path, excluding the stored visualization tree.

Branch and Bound can be much faster than exhaustive enumeration when strong bounds allow many branches to be pruned.

## Learning Outcome

- Understood the 0/1 Knapsack problem using Branch and Bound.
- Learned how an upper bound is calculated for a search-tree node.
- Understood how bounding helps prune unnecessary branches.
- Learned to represent algorithm execution as a state-space tree.
- Practiced Java implementation and prompt-based visualization.
