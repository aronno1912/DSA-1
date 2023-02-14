import java.util.Scanner;
import java.util.Vector;


public class problem2 {

    static int findMinCost(int[][]costMatrix,int[]visitedCity,int[]dp)
    {
      if(dp[visitedCity]!=-1)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        int[][] costMatrix=new int[n][n];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                costMatrix[i][j]=scanner.nextInt();
            }

        }
//        for (int i=0;i<n;i++)
//        {
//            for (int j=0;j<n;j++)
//            {
//                System.out.print(costMatrix[i][j]);
//            }
//            System.out.println();
//        }
    int sz= (int) Math.pow(2,n);
        int[]dp=new int[sz];
        for(int i=0;i<sz;i++)
            dp[i]=-1; //set all the values to -1
        dp[sz-1]=0;

        int[] visitedCity=new int[10];
        for(int i=0;i<10;i++)
            visitedCity[i]=0;
        int result=findMinCost(costMatrix,visitedCity,dp);




    }
}
