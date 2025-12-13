// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Example 2:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true

  
// Example 3:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 
// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.
 

// Follow up: Could you use search pruning to make your solution faster with a larger board?

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++){
                if(wordExists(board, word, i, j, 0, vis))
                    return true;
            }
        }
        return false;
    }
    
    int next[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public boolean wordExists(char[][] board, String word, int i, int j, int idx, boolean[][] vis) {
        if(idx == word.length())
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;
        if(board[i][j] != word.charAt(idx) || vis[i][j])
            return false;
        vis[i][j] = true;
        for(int m=0; m<4; m++) {
            if(wordExists(board, word, i+next[m][0], j+next[m][1], idx+1, vis)) {
                return true;
            }
        }
        vis[i][j] = false; 
        return false;
    }
    
}
