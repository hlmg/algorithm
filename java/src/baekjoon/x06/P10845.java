package baekjoon.x06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P10845 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();

        Deque<Integer> que = new ArrayDeque<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            switch (command) {
                case "push":
                    que.offer(sc.nextInt());
                    break;
                case "pop":
                    println(que.poll());
                    break;
                case "size":
                    println(que.size());
                    break;
                case "empty":
                    println(que.isEmpty());
                    break;
                case "front":
                    println(que.peek());
                    break;
                case "back":
                    println(que.peekLast());
                    break;
            }
        }
        bw.close();
    }

    private static void println(boolean empty) throws IOException {
        if (empty) {
            println(1);
        } else {
            println(0);
        }
    }

    private static void println(Integer num) throws IOException {
        if (num == null) {
            num = -1;
        }
        bw.write(num + "\n");
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
