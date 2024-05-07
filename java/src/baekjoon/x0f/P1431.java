package baekjoon.x0f;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1431 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        list.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            int sum1 = getSum(s1);
            int sum2 = getSum(s2);
            if (sum1 != sum2) {
                return sum1 - sum2;
            }
            return s1.compareTo(s2);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    private static int getSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                sum += c - '0';
            }
        }
        return sum;
    }

}
