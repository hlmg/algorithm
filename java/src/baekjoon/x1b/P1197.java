package baekjoon.x1b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// prim
public class P1197 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int v = sc.nextInt();
        int e = sc.nextInt();

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj.get(a).add(new Pair(b, c));
            adj.get(b).add(new Pair(a, c));
        }

        Queue<Pair> pq = new PriorityQueue<>();
        for (Pair p : adj.get(1)) {
            pq.offer(p);
        }
        boolean[] visited = new boolean[v + 1];
        int count = 0;
        int answer = 0;
        visited[1] = true;
        while (count < v - 1) {
            Pair cur = pq.poll();
            if (visited[cur.v]) {
                continue;
            }
            answer += cur.w;
            visited[cur.v] = true;
            for (Pair next : adj.get(cur.v)) {
                if (!visited[next.v]) {
                    pq.offer(next);
                }
            }
            count++;
        }
        System.out.print(answer);
    }

    private static class Pair implements Comparable<Pair> {
        int v;
        int w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {
            return w - o.w;
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
