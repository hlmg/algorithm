package kakao.blind2018;

public class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            boolean[][] mark = new boolean[m][n];
            int markCount = 0;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c1 = map[i][j];
                    char c2 = map[i + 1][j];
                    char c3 = map[i][j + 1];
                    char c4 = map[i + 1][j + 1];
                    if (c1 == ' ') {
                        continue;
                    }

                    if (c1 == c2 && c2 == c3 && c3 == c4) {
                        mark[i][j] = true;
                        mark[i + 1][j] = true;
                        mark[i][j + 1] = true;
                        mark[i + 1][j + 1] = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mark[i][j]) {
                        map[i][j] = ' ';
                        markCount++;
                    }
                }
            }

            if (markCount == 0) {
                break;
            }

            answer += markCount;

            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == ' ') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != ' ') {
                                map[i][j] = map[k][j];
                                map[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        프렌즈4블록 solution = new 프렌즈4블록();
        System.out.println(
                solution.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }
}
