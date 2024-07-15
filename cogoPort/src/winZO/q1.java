package winZO;
import java.util.*;
public class q1 {
	static class Position {
        int row, col, time;

        Position(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int getMaxSurvivalTime(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        Queue<Position> ghostQueue = new LinkedList<>();
        Queue<Position> droidQueue = new LinkedList<>();
        boolean[][] ghostVisited = new boolean[R][C];
        boolean[][] droidVisited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 5) {
                    ghostQueue.add(new Position(i, j, 0));
                    ghostVisited[i][j] = true;
                } else if (grid[i][j] == 3) {
                    droidQueue.add(new Position(i, j, 0));
                    droidVisited[i][j] = true;
                }
            }
        }

        int[] rowDirection = {-1, 1, 0, 0};
        int[] colDirection = {0, 0, -1, 1};

        while (!droidQueue.isEmpty()) {
            int ghostQueueSize = ghostQueue.size();
            for (int i = 0; i < ghostQueueSize; i++) {
                Position ghost = ghostQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int newRow = ghost.row + rowDirection[d];
                    int newCol = ghost.col + colDirection[d];
                    if (isValid(newRow, newCol, R, C, grid, ghostVisited)) {
                        ghostVisited[newRow][newCol] = true;
                        ghostQueue.add(new Position(newRow, newCol, ghost.time + 1));
                    }
                }
            }

            int droidQueueSize = droidQueue.size();
            for (int i = 0; i < droidQueueSize; i++) {
                Position droid = droidQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int newRow = droid.row + rowDirection[d];
                    int newCol = droid.col + colDirection[d];
                    if (isValid(newRow, newCol, R, C, grid, droidVisited)) {
                        if (ghostVisited[newRow][newCol] && ghostVisited[newRow][newCol] <= droid.time + 1) {
                            continue;
                        }
                        droidVisited[newRow][newCol] = true;
                        droidQueue.add(new Position(newRow, newCol, droid.time + 1));
                    }
                }
            }

            if (droidQueue.isEmpty()) {
                return -1;
            }
        }

        return -1;
    }

    private static boolean isValid(int row, int col, int R, int C, int[][] grid, boolean[][] visited) {
        return row >= 0 && row < R && col >= 0 && col < C && grid[row][col] == 0 && !visited[row][col];
    }

    public static void main(String[] args) {
        int[][] grid1 = {
            {5, 0, 0},
            {0, 3, 0},
            {0, 0, 0}
        };

        int[][] grid2 = {
            {5, 0, 0, 1, 0},
            {0, 5, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 3, 0}
        };

        System.out.println(getMaxSurvivalTime(grid1)); // Output: 4
        System.out.println(getMaxSurvivalTime(grid2)); // Output: -1
    }
}

