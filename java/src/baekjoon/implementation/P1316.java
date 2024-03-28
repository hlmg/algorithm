package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isGroup(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static boolean isGroup(String s) {
        boolean[] visited = new boolean['z' + 1];
        char pre = ' ';
        for (char c : s.toCharArray()) {
            if (pre == c) {
                continue;
            }
            if (visited[c]) {
                return false;
            }
            visited[c] = true;
            pre = c;
        }
        return true;
    }
}
