import java.util.Arrays;

public class Project10_NQueens {
    static final int N = 4;
    static int[] board = new int[N];

    static boolean isSafe(int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r] == col ||
                Math.abs(board[r] - col) == Math.abs(r - row)) {
                return false;
            }
        }
        return true;
    }

    static boolean solve(int row) {
        if (row == N) {
            System.out.println("Solution: " + Arrays.toString(board));
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col;

                if (solve(row + 1)) {
                    return true;
                }

                board[row] = -1; // Backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Arrays.fill(board, -1);
        System.out.println("N-Queens Problem for N = " + N);

        if (!solve(0)) {
            System.out.println("No solution exists.");
        }
    }
}
