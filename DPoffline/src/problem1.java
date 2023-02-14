import java.util.BitSet;
import java.util.Scanner;



public class problem1 {

    static String LCS(String str1, String str2, int m, int n)
    {
        String subSeq="";

      int[][]dpTable=new int[m+1][n+1];
      //fill up the dpTable

      for(int i=0;i<=m;i++)
      {
          for(int j=0;j<=n;j++)
          {
              if(i==0||j==0)
                  dpTable[i][j]=0;
              else if(str1.charAt(i-1)==str2.charAt(j-1)) //because of 0 indexing of string
              {
                  dpTable[i][j]=dpTable[i-1][j-1]+1; //comes from upper corner
              }
              else
              {
                  dpTable[i][j]=Math.max(dpTable[i-1][j],dpTable[i][j-1]); //either up or left cell
              }
          }
      }
      int index=dpTable[m][n];// length of the subSeq

      int temp=index;
        char[] longestCommonSubsequence = new char[index+1 ];
        //longestCommonSubsequence[index] = ;
        int i = m, j = n;
        //for backtracking from filled up DpTable
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                longestCommonSubsequence[index - 1] = str1.charAt(i - 1); //0 indexing
                i--;
                j--; //goes corner(backtracking)
                index--;
            }
            else if (dpTable[i - 1][j] > dpTable[i][j - 1]) //goes up(backtracking)
                i--;
            else
                j--; //goes left(backtracking)
        }
        for (int k = 0; k <temp; k++)
            subSeq = subSeq + longestCommonSubsequence[k];

        return subSeq;



    }




    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
//        StringBuilder str1=new StringBuilder();
//        str1.append(scanner.nextLine());
//        StringBuilder str2=new StringBuilder();
//        str2.append(scanner.nextLine());
        String str1=new String();
        String str2=new String();
        str1=scanner.nextLine();
        str2=scanner.nextLine();
//        char[]X=str1.toCharArray();
//        char []Y=str2.toCharArray();


        int len1,len2;
        len1=str1.length();
        len2=str2.length();
        //subLen=lcs(X,Y,len1,len2);
       String  sub=LCS(str1,str2,len1,len2);

        System.out.println(sub);
        System.out.println(sub.length());





    }
}
