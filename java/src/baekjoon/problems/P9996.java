package baekjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] patterns = pattern.split("[*]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String filename = br.readLine();
            if (filename.length() < pattern.length() - 1) {
                sb.append("NE").append("\n");
                continue;
            }
            if (filename.startsWith(patterns[0]) && filename.endsWith(patterns[1])) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        System.out.print(sb);
    }
}
