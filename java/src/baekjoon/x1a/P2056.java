package baekjoon.x1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2056 {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] indeg = new int[n + 1];
        int[] time = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            int t = sc.nextInt();
            int m = sc.nextInt();
            indeg[i] = m;
            time[i] = t;
            for (int j = 0; j < m; j++) {
                int k = sc.nextInt();
                adj.get(k).add(i);
            }
        }
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                que.offer(i);
                que.offer(time[i]);
            }
        }
        int[] max = new int[n + 1];
        int answer = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            int t = que.poll();
            answer = Math.max(t, answer);
            for (int next : adj.get(cur)) {
                indeg[next]--;
                max[next] = Math.max(max[next], time[next] + t);
                if (indeg[next] == 0) {
                    que.offer(next);
                    que.offer(max[next]);
                }
            }
        }
        System.out.print(answer);
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
