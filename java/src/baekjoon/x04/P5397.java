package baekjoon.x04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class P5397 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String input = sc.next();
            for (char c : input.toCharArray()) {
                switch (c) {
                    case '<':
                        if (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                        break;
                    case '>':
                        if (!stack2.isEmpty()) {
                            stack1.push(stack2.pop());
                        }
                        break;
                    case '-':
                        if (!stack1.isEmpty()) {
                            stack1.pop();
                        }
                        break;
                    default:
                        stack1.push(c);
                }
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            while (!stack2.isEmpty()) {
                bw.write(String.valueOf(stack2.pop()));
            }
            bw.newLine();
            bw.flush();
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
