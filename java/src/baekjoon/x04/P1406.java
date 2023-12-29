package baekjoon.x04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1406 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        String text = sc.next();
        Arrays.stream(text.split(""))
                .forEach(stack1::push);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            char c = command.charAt(0);
            switch (c) {
                case 'L':
                    if (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    break;
                case 'D':
                    if (!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                    }
                    break;
                case 'B':
                    if (!stack1.isEmpty()) {
                        stack1.pop();
                    }
                    break;
                case 'P':
                    stack1.push(sc.next());
                    break;
            }
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            bw.write(stack2.pop());
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
