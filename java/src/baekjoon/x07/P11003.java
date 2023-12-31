package baekjoon.x07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P11003 {

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Pair> dq = new ArrayDeque<>();

        int n = sc.nextInt();
        int l = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            Pair pair = new Pair(num, i);
            // 이전에 들어온 값이 현재 값보다 크거나 같으면 최소값이 될 수 없기 때문에 제거
            while (!dq.isEmpty() && dq.peekLast().value >= pair.value) {
                dq.pollLast();
            }
            dq.offer(pair);
            // l 범위를 넘은 값 제거
            while (!dq.isEmpty() && dq.peek().index <= pair.index - l) {
                dq.poll();
            }

            bw.write(dq.peek().value + " ");
        }

        bw.close();
    }

    private static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
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
