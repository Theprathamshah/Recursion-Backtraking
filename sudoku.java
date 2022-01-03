import java.util.Scanner;

public class sudoku {

    public static boolean isSafe(int[][] arr, int x, int y, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][y] == val || arr[x][i] == val) {
                return false;
            }
        }
        int r = x / 3 * 3;
        int c = y / 3 * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (arr[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int[][] arr, int x, int y) {
        if (x == arr.length) {
            return true;
        }
        if (y == arr.length) {
            return sudokuSolver(arr, x + 1, 0);
        }
        if (arr[x][y] != 0) {
            return sudokuSolver(arr, x, y + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (isSafe(arr, x, y, i)) {
                arr[x][y] = i;
                if (sudokuSolver(arr, x, y)) {
                    return true;
                }

            }
        }
        arr[x][y] = 0;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        int[][] arr = new int[9][9];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Solution of sudoku is given below");
        if (sudokuSolver(arr, 0, 0)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
/*
 * abstract
 * 
 * 
 * 3 0 6 5 0 8 4 0 0
 * 5 2 0 0 0 0 0 0 0
 * 0 8 7 0 0 0 0 3 1
 * 0 0 3 0 1 0 0 8 0
 * 9 0 0 8 6 3 0 0 5
 * 0 5 0 0 9 0 6 0 0
 * 1 3 0 0 0 0 2 5 0
 * 0 0 0 0 0 0 0 7 4
 * 0 0 5 2 0 6 3 0 0
 * 
 * 
 * 
 * 
 * 3 0 6 5 0 8 4 0 0
 * 5 2 0 0 0 0 0 0 0
 * 0 8 7 0 0 0 0 3 1
 * 0 0 3 0 1 0 0 8 0
 * 9 0 0 8 6 3 0 0 5
 * 0 5 0 0 9 0 6 0 0
 * 1 3 0 0 0 0 2 5 0
 * 0 0 0 0 0 0 0 7 4
 * 0 0 5 2 0 6 3 0 0
 * Solution of sudoku is given below
 * 3 1 6 5 7 8 4 9 2
 * 5 2 9 1 3 4 7 6 8
 * 4 8 7 6 2 9 5 3 1
 * 2 6 3 4 1 5 9 8 7
 * 9 7 4 8 6 3 1 2 5
 * 8 5 1 7 9 2 6 4 3
 * 1 3 8 9 4 7 2 5 6
 * 6 9 2 3 5 1 8 7 4
 * 7 4 5 2 8 6 3 1 9
 * 
 * 
 */