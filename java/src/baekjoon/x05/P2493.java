package baekjoon.x05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2493 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        Stack<Pair> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            while (!stack.isEmpty()) {
                Pair peek = stack.peek();
                if (peek.getValue() >= num) {
                    bw.write(peek.getIndex() + " ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                bw.write(0 + " ");
            }
            stack.push(new Pair(i, num));
        }
        bw.close();
    }

    private static class Pair {
        private final int index;
        private final int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
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
