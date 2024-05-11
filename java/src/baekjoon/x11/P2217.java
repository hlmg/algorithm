package baekjoon.x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Collections.reverseOrder());
        int count = 0;
        int maxWeight = 0;
        for (int rope : list) {
            count++;
            int weight = rope * count;
            if (maxWeight < weight) {
                maxWeight = weight;
            }
        }
        System.out.print(maxWeight);
    }
}
