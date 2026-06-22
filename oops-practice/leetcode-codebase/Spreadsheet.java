import java.util.*;

class Spreadsheet {
    private int[][] sheet;
    private int rows;
    private int cols;

    public Spreadsheet(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        sheet = new int[rows][cols];
    }

    public void setCell(int row, int col, int value) {
        sheet[row][col] = value;
    }

    public int getCell(int row, int col) {
        return sheet[row][col];
    }

    public void addRow(int row, int[] values) {
        for (int j = 0; j < cols && j < values.length; j++) {
            sheet[row][j] = values[j];
        }
    }

    public int sumRange(int r1, int c1, int r2, int c2) {
        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sum += sheet[i][j];
            }
        }
        return sum;
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(sheet[i]));
        }
    }

    public static void main(String[] args) {
        Spreadsheet ss = new Spreadsheet(3, 3);
        ss.setCell(0, 0, 5);
        ss.setCell(0, 1, 10);
        ss.setCell(1, 0, 15);
        ss.setCell(1, 1, 20);
        System.out.println(ss.getCell(0, 0));
        System.out.println(ss.sumRange(0, 0, 1, 1));
        ss.addRow(2, new int[]{3, 6, 9});
        ss.display();
    }
}
