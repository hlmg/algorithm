package baekjoon.appendixa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class P9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        pattern = pattern.replace("*", ".*");
        Pattern regex = Pattern.compile(pattern);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String filename = br.readLine();
            if (regex.matcher(filename).matches()) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        System.out.print(sb);
    }
}
