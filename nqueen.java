import java.util.Scanner;

public class nqueen {

    public static boolean isSafe(int[][] arr, int x, int y) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][y] == 1) {
                return false;
            }
        }
        int row = x;
        int col = y;
        while (col >= 0 && row >= 0) {
            if (arr[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }
        row = x;
        col = y;
        while (row >= 0 && col < arr.length) {
            if (arr[row][col] == 1) {
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    public static boolean nqueenSolution(int[][] arr, int x) {
        if (x >= arr.length) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (isSafe(arr, x, i)) {
                arr[x][i] = 1;
                if (nqueenSolution(arr, x + 1)) {
                    return true;
                }
                arr[x][i] = 0;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
            }
        }
        System.out.println("Solution of nqueen problem is given below");
        if (nqueenSolution(arr, 0)) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}


/*abstract



8
PS C:\Users\dell\Desktop\Practice C++> cd "c:\Users\dell\Desktop\Practice C++\" ; if ($?) { javac nqueen.java } ; if ($?) { java nqueen }
8
Solution of nqueen problem is given below
1 0 0 0 0 0 0 0 
0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 1
0 0 0 0 0 1 0 0
0 0 1 0 0 0 0 0
0 0 0 0 0 0 1 0
0 1 0 0 0 0 0 0
0 0 0 1 0 0 0 0

*/