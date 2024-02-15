//Problem:- Longest common subsequence
//recursion:- O(2^n) time complexity
//this recursive solution works well for small string but for longer strings it will take alot of time.
public class LCS {
    static int recLCS(int m, int n, String a, String b){
        if(m==0 || n==0)
            return 0;

        else if(a.charAt(m-1)==b.charAt(n-1))
            return 1 + recLCS(m-1,n-1,a,b);

        else
            return Math.max(recLCS(m,n-1,a,b),recLCS(m-1,n,a,b));

    }

    //we use memoization in this solution=> dynamic programming comes into picture

    private static int UtilLCS(int m, int n, String a, String b, int[][] dp){
        if(m==0 || n==0)
            return 0;

        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        else if(a.charAt(m-1)==b.charAt(n-1))
            return dp[m][n] = 1 + UtilLCS(m-1,n-1,a,b,dp);

        else
            return dp[m][n] = Math.max(UtilLCS(m,n-1,a,b,dp),UtilLCS(m-1,n,a,b,dp));

    }

    static int DPLCS(int m, int n, String a, String b){
        int[][] dp = new int[m+1][n+1];     //initialize array with  -1 and 0th row and 0th column is filled with zero means that it will 0 for empty string
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        return UtilLCS(m,n,a,b,dp);
    }


    public static void main(String[] args) {
        System.out.println(DPLCS(5,4,"abcab","aecb"));
    }
}
