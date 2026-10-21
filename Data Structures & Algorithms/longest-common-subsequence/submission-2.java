class Solution {
    int memo[][];
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return lcs(text1, text1.length() - 1, text2, text2.length() - 1);
    }

    public int lcs(String text1, int i, String text2, int j){
        if(i < 0 || j < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            return memo[i][j] = 1 + lcs(text1, i - 1, text2, j - 1);
        } else {
            return memo[i][j] = Math.max(lcs(text1, i, text2, j - 1), lcs(text1, i - 1, text2, j));
        }
    }
}
