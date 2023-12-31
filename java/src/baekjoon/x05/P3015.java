package baekjoon.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P3015 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        Stack<Person> stack = new Stack<>();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            Person person = new Person(height, 1);
            while (!stack.isEmpty() && stack.peek().height <= height) {
                Person pop = stack.pop();
                if (pop.height == height) {
                    person.count += pop.count;
                }
                answer += pop.count;
            }
            if (!stack.isEmpty()) {
                answer++;
            }
            stack.push(person);
        }
        System.out.println(answer);
    }

    private static class Person {
        int height, count;

        public Person(int height, int count) {
            this.height = height;
            this.count = count;
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
            return java.lang.Integer.parseInt(next());
        }
    }
}
