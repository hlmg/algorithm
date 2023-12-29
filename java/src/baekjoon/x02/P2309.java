package baekjoon.x02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int num = sc.nextInt();
            nums.add(num);
            sum += num;
        }

        solve(nums, sum);

        Collections.sort(nums);
        for (Integer num : nums) {
            System.out.println(num);
        }
    }

    private static void solve(List<Integer> nums, int sum) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                Integer a = nums.get(i);
                Integer b = nums.get(j);
                if ((sum - a - b) == 100) {
                    nums.remove(a);
                    nums.remove(b);
                    return;
                }
            }
        }
    }
}
