public class fibonacci {
    //this is the bottom up approach (Iterative)
    static int dp_fibo(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n<=1){
            return n;
        }
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //non iterative and recursive approach => top-down approach
    static int fibo(int n){
        int[] dp = new int[n+1];
        if(n==0)    return 0;
        if(n==1)    return 1;
        if(dp[n]!=0)    return dp[n];       //if already stored then return
        return dp[n] = fibo(n-1) + fibo(n-2);       //calculate the fibonaci number
    }

    //just similar to the previous problem
    //try to do factorial of number n

    //bottom up approach

    static int fact(int n){
        int[] dp = new int[n+1];        //to store the factorial
        if(n==0 || n==1)    return 1;
        dp[0] = dp[1] = 1;
        for(int i=2;i<=n;i++){
          dp[i] = i*dp[i-1];
        }
        return dp[n];
    }

    //lets try to code top to down approach
    static int factTTD(int n){
        int[] dp = new int[n+1];
        if(n==1 || n==0)    return 1;
        dp[0] = dp[1] = 1;
        if(dp[n]!=0)    return dp[n];
        return dp[n] = factTTD(n-1)*n;
    }
    public static void main(String[] args) {
        System.out.println(factTTD(5));
    }
}
