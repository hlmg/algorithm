package baekjoon.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1874 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        int num = 1;
        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();

            if (stack.isEmpty()) {
                stack.push(num++);
                sb.append("+\n");
            }

            while (stack.peek() < target) {
                stack.push(num++);
                sb.append("+\n");
            }

            if (stack.pop() != target) {
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
        }
        System.out.println(sb);
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
