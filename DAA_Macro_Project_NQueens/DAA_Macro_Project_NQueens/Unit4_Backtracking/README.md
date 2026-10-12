# Project 10: N-Queens Problem using Backtracking

## Description
This project implements the N-Queens problem for N = 4 using backtracking.
The algorithm places one queen in each row and checks whether the position is
safe with respect to columns and diagonals.

The state-space tree visualizes recursive exploration, rejection of invalid
branches, and backtracking until a complete solution is found.

## Algorithm
1. Start from the first row.
2. Try each column in the current row.
3. Check whether the position is safe.
4. If safe, place the queen and recursively process the next row.
5. If the recursive call fails, remove the queen and try another column.
6. When all rows contain queens, a solution is found.

## Prompt Used
See `Prompt.txt`.

## Output
See `Visualization.png` and `Sample_Output.txt`.

## Complexity
The straightforward N-Queens backtracking solution has factorial/exponential
worst-case search behavior, commonly expressed as O(N!) for the search.
The safety check takes O(N) per attempted placement in this implementation.

## Learning Outcome
- Understood recursive backtracking.
- Understood state-space trees.
- Learned how invalid branches are pruned.
- Practiced AI-assisted algorithm visualization.
- Practiced GitHub project documentation.
