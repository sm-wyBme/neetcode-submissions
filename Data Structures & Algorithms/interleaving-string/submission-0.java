class Solution {
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, s1.length() - 1, s2.length() - 1);
    }

    public boolean dfs(String s1, String s2, String s3, int i, int j){
        if (i + j == -2)
            return i == -1 && j == -1;
        if(dp[i+1][j+1] != null) return dp[i+1][j+1];

        boolean ans = false;
        if(i >= 0 && s3.charAt(i + j + 1) == s1.charAt(i)){
            ans = dfs(s1, s2, s3, i-1, j);
        }
        if(ans == false && j >= 0 && s3.charAt(i + j + 1) == s2.charAt(j)){
            ans = dfs(s1, s2, s3, i, j-1);
        }
        return dp[i+1][j+1] = ans;
    }
}
