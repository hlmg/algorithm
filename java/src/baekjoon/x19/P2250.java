package baekjoon.x19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P2250 {
    static int[] lc;
    static int[] rc;
    static int[] indexes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        lc = new int[n + 1];
        rc = new int[n + 1];
        indexes = new int[n + 1];
        boolean[] isChild = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);
            int r = Integer.parseInt(input[2]);
            if (l != -1) {
                lc[node] = l;
                isChild[l] = true;
            }
            if (r != -1) {
                rc[node] = r;
                isChild[r] = true;
            }
        }
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (!isChild[i]) {
                root = i;
            }
        }

        dfs(root, 0);
        Queue<Integer> que = new ArrayDeque<>();
        int level = 1;
        int firstIndex = indexes[root];
        int lastIndex = indexes[root];
        que.offer(root);
        que.offer(1);
        int[] widths = new int[n + 1];
        int maxWidth = 0;
        int levelAnswer = 0;
        while (!que.isEmpty()) {
            int node = que.poll();
            int l = que.poll();
            if (level != l) {
                widths[level] = lastIndex - firstIndex + 1;
                if (widths[level] > maxWidth) {
                    maxWidth = widths[level];
                    levelAnswer = level;
                }
                level = l;
                firstIndex = indexes[node];
            }
            lastIndex = indexes[node];
            if (lc[node] != 0) {
                que.offer(lc[node]);
                que.offer(l + 1);
            }
            if (rc[node] != 0) {
                que.offer(rc[node]);
                que.offer(l + 1);
            }
        }
        widths[level] = lastIndex - firstIndex + 1;
        if (widths[level] > maxWidth) {
            maxWidth = widths[level];
            levelAnswer = level;
        }
        System.out.printf("%d %d", levelAnswer, maxWidth);
    }

    private static int dfs(int node, int index) {
        int count = 1;
        if (lc[node] != 0) {
            count += dfs(lc[node], index);
        }
        indexes[node] = count + index;
        if (rc[node] != 0) {
            count += dfs(rc[node], indexes[node]);
        }
        return count;
    }
}
