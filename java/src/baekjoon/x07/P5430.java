package baekjoon.x07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P5430 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        Deque<String> dq = new ArrayDeque<>();
        for (int i = 0; i < t; i++) {
            boolean reverse = false;
            String command = sc.next();
            int n = sc.nextInt();
            String input = sc.next();
            String substring = input.substring(1, input.length() - 1);
            String[] split = substring.split(",");
            for (String s : split) {
                if (s.isEmpty()) {
                    continue;
                }
                dq.offer(s);
            }

            boolean isError = false;
            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                    continue;
                }
                String poll;
                if (reverse) {
                    poll = dq.pollLast();
                } else {
                    poll = dq.poll();
                }
                if (poll == null) {
                    bw.write("error\n");
                    isError = true;
                    break;
                }
            }

            if (isError) {
                continue;
            }

            if (dq.isEmpty()) {
                bw.write("[]\n");
                continue;
            }

            bw.write("[");
            while (dq.size() > 1) {
                String poll;
                if (reverse) {
                    poll = dq.pollLast();
                } else {
                    poll = dq.poll();
                }
                bw.write(poll);
                bw.write(",");
            }
            bw.write(dq.poll() + "]\n");
        }
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
