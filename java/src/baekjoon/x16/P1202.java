package baekjoon.x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class P1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        List<GEM> gems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] gemInfo = br.readLine().split(" ");
            gems.add(new GEM(Integer.parseInt(gemInfo[0]), Integer.parseInt(gemInfo[1])));
        }
        Collections.sort(gems);
        TreeMap<Integer, Integer> capacities = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            int capacity = Integer.parseInt(br.readLine());
            capacities.put(capacity, capacities.getOrDefault(capacity, 0) + 1);
        }

        long answer = 0;
        for (GEM gem : gems) {
            Entry<Integer, Integer> ceilingEntry = capacities.ceilingEntry(gem.weight);
            if (ceilingEntry == null) {
                continue;
            }
            if (ceilingEntry.getValue() > 1) {
                capacities.put(ceilingEntry.getKey(), ceilingEntry.getValue() - 1);
            } else {
                capacities.remove(ceilingEntry.getKey());
            }
            answer += gem.price;
        }
        System.out.print(answer);
    }

    private static class GEM implements Comparable<GEM> {
        int weight;
        int price;

        public GEM(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(GEM o) {
            return o.price - this.price;
        }
    }
}
