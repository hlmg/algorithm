package baekjoon.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class P2941 {
    private static final Set<String> set = new HashSet<>() {{
        addAll(List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="));
    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int answer = input.length();
        int[] index = {0, 2};
        int moveIndex = 1;
        while (index[1] <= input.length()) {
            if (set.contains(input.substring(index[0], index[1]))) {
                answer -= index[1] - index[0] - 1;
                input = input.substring(index[1]);
                index[0] = 0;
                index[1] = 2;
                moveIndex = 1;
                continue;
            }
            index[moveIndex] += 1;
            moveIndex = (moveIndex + 1) % 2;
        }

        System.out.println(answer);
    }
}
