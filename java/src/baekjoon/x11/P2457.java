package baekjoon.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2457 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();

        Integer[][] days = new Integer[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                days[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(days, (day1, day2) -> {
            if (day1[0].equals(day2[0])) {
                return day1[1] - day2[1];
            } else {
                return day1[0] - day2[0];
            }
        });

        int month = 3;
        int day = 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (month >= 12) {
                break;
            }
            int endMonth = month;
            int endDay = day;
            // 시작일이 현재 날짜 이하여야 함.
            while (i < n && (days[i][0] < month || (days[i][0] == month && days[i][1] <= day))) {
                // 끝나는 날이 가장 긴 날짜가 endMonth, endDay에 저장됨
                if (endMonth < days[i][2] || (endMonth == days[i][2] && endDay < days[i][3])) {
                    endMonth = days[i][2];
                    endDay = days[i][3];
                }
                i++;
            }
            count++;
            // 시작일이 현재 날짜 이하인 게 없으면 종료
            if (endMonth == month && endDay == day) {
                break;
            }
            month = endMonth;
            day = endDay;
            i--;
        }
        if (month < 12) {
            System.out.print(0);
            return;
        }
        System.out.print(count);
    }

    private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new IllegalArgumentException();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
