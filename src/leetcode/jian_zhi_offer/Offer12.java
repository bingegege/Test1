package leetcode.jian_zhi_offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author zhenghuan
 * @date 2022/2/22
 */
public class Offer12 {
    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length()) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (recusive(board, word, i, j, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recusive(char[][] board, String word, int i, int j, int wordIndex,
            boolean[][] visited) {
        if (wordIndex > word.length() - 1) {
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] == word.charAt(wordIndex)) {
            visited[i][j] = true;
            boolean res = (recusive(board, word, i - 1, j,
                    wordIndex + 1, visited) || recusive(board, word, i + 1, j, wordIndex + 1,
                    visited) ||
                    recusive(board, word, i, j - 1, wordIndex + 1, visited) || recusive(board, word,
                    i,
                    j + 1,
                    wordIndex + 1, visited));
            if (!res) {
                visited[i][j] = false;
            }
            return res;
        }
        return false;
    }

    public static void main(String[] args) {
        char a = 'A';
        String s = "ABC";
        System.out.println(a == s.charAt(0));
        boolean[][] visit = new boolean[3][3];
        System.out.println(visit[0][0]);
    }
}
