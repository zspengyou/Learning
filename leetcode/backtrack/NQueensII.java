package leetcode.backtrack;

import java.util.HashMap;
import java.util.Map;

public class NQueensII {
    public static void main(String[] args) {
        NQueensII nQueensII = new NQueensII();
        nQueensII.test();
    }

    private void test() {
        Solution solution = new Solution();
        int result = solution.totalNQueens(4);
        System.out.println("result = " + result);
    }

    class Solution {
        int countOfAnswer = 0;

        public int totalNQueens(int n) {
            boolean[][] puzzle = new boolean[n][n];
            int row = 0;
            backtrack(puzzle, row);
            return countOfAnswer;
        }

        private void backtrack(boolean[][] puzzle, int row) {
            if (row == puzzle.length) {
                countOfAnswer++;
                return;
            }
            for (int j = 0; j < puzzle.length; j++) {
                puzzle[row][j] = true;
                if (isValid(puzzle)) {
                    backtrack(puzzle, row + 1);
                }
                puzzle[row][j] = false;
            }

        }

        private boolean isValid(boolean[][] puzzle) {
            return isValidRow(puzzle) && isValidCol(puzzle) && isValidDiag(puzzle) && isValidReverseDiag(puzzle);
        }

        private boolean isValidReverseDiag(boolean[][] puzzle) {
            for (int sum = 0; sum <= 2 * (puzzle.length - 1); sum++) {
                boolean foundQueen = false;
                for (int i = puzzle.length - 1; (puzzle.length - i) <= sum; i--) {
                    if (i < 0) {
                        continue;
                    }
                    int j = sum - (puzzle.length - i);
                    if (j < puzzle.length) {
                        if (puzzle[j][i] && !foundQueen) {
                            foundQueen = true;
                        } else if (puzzle[j][i] && foundQueen) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private boolean isValidDiag2(boolean[][] puzzle) {
            for (int sum = 0; sum <= 2 * (puzzle.length - 1); sum++) {
                boolean foundQueen = false;
                for (int i = 0; i <= sum; i++) {
                    if (i >= puzzle.length) {
                        continue;
                    }
                    int j = sum - i;
                    if (j < puzzle.length) {
                        if (puzzle[i][j] && !foundQueen) {
                            foundQueen = true;
                        } else if (puzzle[i][j] && foundQueen) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private boolean isValidDiag(boolean[][] puzzle) {
            Map<Integer, Boolean> diagonal = new HashMap<>();
            for (int i = 0; i < puzzle.length; i++) {
                for (int j = 0; j < puzzle.length; j++) {
                    int sum = i + j;
                    boolean exist = diagonal.getOrDefault(sum, false);
                    if (puzzle[i][j] && exist) {
                        return false;
                    } else if (puzzle[i][j] && !exist) {
                        diagonal.put(sum, true);
                    }
                }
            }
            return true;
        }

        private boolean isValidCol(boolean[][] puzzle) {
            for (int i = 0; i < puzzle.length; i++) {
                boolean foundQueen = false;
                for (int j = 0; j < puzzle.length; j++) {
                    if (puzzle[j][i] && !foundQueen) {
                        foundQueen = true;
                    } else if (puzzle[j][i] && foundQueen) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValidRow(boolean[][] puzzle) {

            for (int i = 0; i < puzzle.length; i++) {
                boolean foundQueen = false;
                for (int j = 0; j < puzzle.length; j++) {
                    if (puzzle[i][j] && !foundQueen) {
                        foundQueen = true;
                    } else if (puzzle[i][j] && foundQueen) {
                        return false;
                    }
                }
            }
            return true;
        }
    }


}

