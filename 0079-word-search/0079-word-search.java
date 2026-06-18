class Solution {
    public boolean helper(char[][] board, int i, int j, String word, int idx) {

        if (idx == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx))
            return false;

        char temp = board[i][j];
        board[i][j] = '#';   

        boolean found =
                helper(board, i + 1, j, word, idx + 1) ||
                helper(board, i - 1, j, word, idx + 1) ||
                helper(board, i, j + 1, word, idx + 1) ||
                helper(board, i, j - 1, word, idx + 1);

        board[i][j] = temp; 

        return found;
    }
    public boolean exist(char[][] board, String word) {
          for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, i, j, word, 0))
                        return true;
                }
            }
        }

        return false;
    }
}