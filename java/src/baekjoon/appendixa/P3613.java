package baekjoon.appendixa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String format = getFormat(input);
        try {
            System.out.print(solve(input, format));
        } catch (IllegalArgumentException e) {
            System.out.print("Error!");
        }
    }

    private static String getFormat(String input) {
        if (input.contains("_")) {
            return "C++";
        }
        return "JAVA";
    }

    private static String solve(String input, String format) {
        if (format.equals("C++")) {
            if (input.startsWith("_") || input.endsWith("_")) {
                throw new IllegalArgumentException();
            }
            if (!input.toLowerCase().equals(input)) {
                throw new IllegalArgumentException();
            }
            return toJava(input);
        } else {
            if (Character.isUpperCase(input.charAt(0))) {
                throw new IllegalArgumentException();
            }
            return toCPP(input);
        }
    }

    private static String toJava(String input) {
        StringBuilder sb = new StringBuilder();
        char pre = 0;
        for (char cur : input.toCharArray()) {
            if (pre == '_') {
                if (cur == '_') {
                    throw new IllegalArgumentException();
                }
                cur = Character.toUpperCase(cur);
            }
            pre = cur;
            if (cur != '_') {
                sb.append(cur);
            }
        }
        return sb.toString();
    }

    private static String toCPP(String input) {
        StringBuilder sb = new StringBuilder();
        for (char cur : input.toCharArray()) {
            if (Character.isUpperCase(cur)) {
                sb.append("_");
                cur = Character.toLowerCase(cur);
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}
