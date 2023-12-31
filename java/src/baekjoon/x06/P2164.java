package baekjoon.x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2164 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }

        while (que.size() > 1) {
            que.poll();
            que.offer(que.poll());
        }
        System.out.println(que.poll());
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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
