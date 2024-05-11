package baekjoon.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P1931 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            times.add(new Time(start, end));
        }
        times.sort(Comparator.comparingInt(t -> t.start));
        times.sort(Comparator.comparingInt(t -> t.end));
        int answer = 0;
        int currentTime = 0;
        for (Time time : times) {
            if (currentTime <= time.start) {
                answer++;
                currentTime = time.end;
            }
        }
        System.out.print(answer);
    }

    private static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
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
/*
11
1 1
1 2
1 3

 */