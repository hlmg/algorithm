package baekjoon.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input += "-";
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        boolean minus = false;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c - '0');
                continue;
            }
            if (minus) {
                answer -= Integer.parseInt(sb.toString());
            } else {
                if (c == '-') {
                    minus = true;
                }
                answer += Integer.parseInt(sb.toString());
            }
            sb = new StringBuilder();
        }
        System.out.print(answer);
    }
}
