package baekjoon.x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class P1697 {
    private static final List<Function<Integer, Integer>> functions =
            List.of(
                    x -> x + 1,
                    x -> x - 1,
                    x -> x * 2
            );

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();

        // x -> x+1 or x-1 or x*2
        Queue<Integer> que = new ArrayDeque<>();
        int[] distance = new int[100_001];
        Arrays.fill(distance, -1);
        que.offer(n);
        distance[n] = 0;
        while (!que.isEmpty()) {
            Integer x = que.poll();
            if (x == k) {
                System.out.println(distance[x]);
                break;
            }
            for (Function<Integer, Integer> function : functions) {
                int nx = function.apply(x);
                if (nx < 0 || nx > 100_000 || distance[nx] != -1) {
                    continue;
                }
                que.offer(nx);
                distance[nx] = distance[x] + 1;
            }
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
