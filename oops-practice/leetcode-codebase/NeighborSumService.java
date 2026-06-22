import java.util.*;

class NeighborSumService {
    private int[][] grid;
    private Map<Integer, int[]> positions;
    private int n;

    public NeighborSumService(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                positions.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        int[] pos = positions.get(value);
        int sum = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            int r = pos[0] + d[0], c = pos[1] + d[1];
            if (r >= 0 && r < n && c >= 0 && c < n) {
                sum += grid[r][c];
            }
        }
        return sum;
    }

    public int diagonalSum(int value) {
        int[] pos = positions.get(value);
        int sum = 0;
        int[][] dirs = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] d : dirs) {
            int r = pos[0] + d[0], c = pos[1] + d[1];
            if (r >= 0 && r < n && c >= 0 && c < n) {
                sum += grid[r][c];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        NeighborSumService nss = new NeighborSumService(grid);
        System.out.println(nss.adjacentSum(5));
        System.out.println(nss.diagonalSum(5));
        System.out.println(nss.adjacentSum(1));
        System.out.println(nss.diagonalSum(1));
    }
}
