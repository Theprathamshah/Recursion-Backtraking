import java.util.Scanner;

public class ratmaze
{
    public static boolean isSafe(int [][]arr,int x,int y)
    {
        if(arr[x][y]==1)
        {
            return true;
        }
        return false;
    }

    public static boolean ratInMazeSolution(int [][]arr,int x,int y,int [][]ans)
    {
        if(x<0 || y<0 || x>=arr.length || y>=arr.length)
        {
            return false;
        }
        if(x==arr.length-1 && y==arr.length-1)
        {
            ans[x][y] = 1;
            return true;
        }
        if(isSafe(arr,x,y))
        {
            ans[x][y] = 1;
            if(ratInMazeSolution(arr,x+1,y,ans))
            {
                return true;
            }
            if(ratInMazeSolution(arr,x,y+1,ans))
            {
                return true;
            } 
            ans[x][y] = 0;
            return false;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int [][]ans= new int[n][n];
        System.out.println("Solution of rat in maze is given below");
        if(ratInMazeSolution(arr, 0, 0, ans))
        {
            for(int[] i:ans)
            {
                for(int j : i)
                {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }
}