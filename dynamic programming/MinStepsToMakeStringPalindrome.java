// Given a string s. In one step you can insert any character at any index of the string.

// Return the minimum number of steps to make s palindrome.

// A Palindrome String is one that reads the same backward as well as forward.

// Example 1:
// Input: s = "zzazz"
// Output: 0
// Explanation: The string "zzazz" is already palindrome we do not need any insertions.

// Example 2:
// Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".

// Example 3:
// Input: s = "leetcode"
// Output: 5
// Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 
// Constraints:
// 1 <= s.length <= 500
// s consists of lowercase English letters.

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            dp[i][i] = 1;
        }
        for(int i=1; i<n; i++) {
            for(int j=0; j+i<n; j++) {
                if(s.charAt(j) == s.charAt(j+i))
                    dp[j][j+i] = 2 + dp[j+1][j+i-1];
                else
                    dp[j][j+i] = Math.max(dp[j][j+i-1], dp[j+1][j+i]);
            }
        }
        return n-dp[0][n-1];
    }
}
