package cogoPort;
import java.util.*;

public class  rotateMatrix
{
    public static void rotate(int[][] Grid)
    {
        if (Grid == null || Grid.length == 0) {
            return;
        }
        int rLen = Grid.length;
        for (int i = 0; i < rLen; i++)
        {
            for (int j = 0; j < i; j++)
            {
                int temp = Grid[i][j];
                Grid[i][j] = Grid[j][i];
                Grid[j][i] = temp;
            }
        }
        for (int i = 0; i < rLen; i++)
        {
            for (int j = 0; j < rLen / 2; j++)
            {
                int temp = Grid[i][j];
                Grid[i][j] = Grid[i][rLen - j - 1];
                Grid[i][rLen - j - 1] = temp;
            }
        }
    }
 
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (N x N): ");
        int rLen = sc.nextInt();

        int[][] Grid = new int[rLen][rLen];

        System.out.println("Enter the matrix:");

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < rLen; j++) {
                Grid[i][j] = sc.nextInt();
            }
        }
        rotate(Grid);
 
        for (int[] r: Grid) {
            System.out.println(Arrays.toString(r));
        }
    }
}    
