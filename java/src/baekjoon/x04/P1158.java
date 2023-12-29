package baekjoon.x04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1158 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }

        bw.write("<");
        int k = sc.nextInt();
        while (!que.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                que.offer(que.poll());
            }
            bw.write(String.valueOf(que.poll()));
            if (!que.isEmpty()) {
                bw.write(", ");
            }
        }

        bw.write(">");
        bw.close();
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
