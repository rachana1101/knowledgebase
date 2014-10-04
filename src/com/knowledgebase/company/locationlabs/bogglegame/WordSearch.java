package com.knowledgebase.company.locationlabs.bogglegame;

import java.util.Arrays;
/**
 * This game check for all the 8 direction of the tile i.e char 
 * 
 * @author rachana
 *
 */
public class WordSearch {
    public static void main(String... values) {
        char[][] board = { {'n', 's', 's', 'e' },
                           {'g', 'a', 't', 'l' },
                           {'e', 'o', 'r', 'e' },
                           {'w', 'e', 'a', 'd' },
                         };
        
        for(String value : Arrays.asList("less", "goat", "road", "artless", "a", "erase", "gator", "drags", "gtl")) {
            System.out.println(value +" -- "+ exist(board, value));
        }
        
        //System.out.println(exist(board, "goat"));
    }
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null
                || word.length() == 0) {
            return false;
        }
        boolean[][] checker = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (isFind(checker, board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private  static boolean isFind(boolean[][] checker, char[][] board, String word,
            int i, int row, int col) {
        if (board[row][col] != word.charAt(i) || checker[row][col]) {
            return false;
        }
        checker[row][col] = true;
        if (i == word.length() - 1) {
            return true;
        }
        if (row - 1 >= 0 && isFind(checker, board, word, i + 1, row - 1, col)) {
            return true;
        }
        if (row + 1 < board.length
                && isFind(checker, board, word, i + 1, row + 1, col)) {
            return true;
        }
        if (col - 1 >= 0 && isFind(checker, board, word, i + 1, row, col - 1)) {
            return true;
        }
        if (col + 1 < board[0].length
                && isFind(checker, board, word, i + 1, row, col + 1)) {
            return true;
        }
        //for diagonal detection 
        if(row-1 >=0 && col-1 >=0 && isFind(checker, board, word, i+1, row-1, col-1)) {
            return true;
        }
        if(row-1 >=0 && col+1 <board[0].length && isFind(checker, board, word, i+1, row-1, col+ 1)) {
            return true;
        }
        if(row+1 <board.length && col-1 >=0 && isFind(checker, board, word, i+1, row + 1, col-1)) {
            return true;
        }
        if(row+1 <board.length && col+1 <board[0].length && isFind(checker, board, word, i+1, row+1, col+ 1)) {
            return true;
        }
        checker[row][col] = false;
        return false;
    }
}