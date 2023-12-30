package baekjoon.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P6198 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(1_000_000_001);
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            while (stack.peek() <= number) {
                stack.pop();
            }
            answer += stack.size();
            stack.push(number);
        }
        answer -= n;
        System.out.println(answer);
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
