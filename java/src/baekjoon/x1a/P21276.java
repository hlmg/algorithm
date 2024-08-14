package baekjoon.x1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P21276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = br.readLine().split(" ");
        Arrays.sort(names);
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(names[i], i);
        }
        int m = Integer.parseInt(br.readLine());
        int[] indeg = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] xy = br.readLine().split(" ");
            String x = xy[0];
            String y = xy[1];
            indeg[index.get(x)]++;
            adj.get(index.get(y)).add(index.get(x));
        }
        List<String> roots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                roots.add(names[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(roots.size()).append("\n");
        for (String root : roots) {
            sb.append(root).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < n; i++) {
            sb.append(names[i]).append(" ");

            List<Integer> list = adj.get(i);
            List<Integer> children = new ArrayList<>();
            for (Integer child : list) {
                if (indeg[child] - indeg[i] == 1) {
                    children.add(child);
                }
            }
            Collections.sort(children);
            sb.append(children.size()).append(" ");
            for (Integer child : children) {
                sb.append(names[child]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
