package baekjoon.x0c;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class P15663 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, m;
    private static List<Number> nums;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Number number = new Number(sc.nextInt());
            if (nums.contains(number)) {
                int idx = nums.indexOf(number);
                nums.get(idx).increase();
            } else {
                nums.add(number);
            }
        }
        answer = new int[m];

        Collections.sort(nums);
        func(0);
        bw.close();
    }

    private static void func(int depth) throws IOException {
        if (depth == m) {
            for (int num : answer) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (Number num : nums) {
            if (num.isEmpty()) {
                continue;
            }
            answer[depth] = num.num;
            num.decrease();
            func(depth + 1);
            num.increase();
        }
    }

    private static class Number implements Comparable<Number> {
        public final int num;
        private int remain;

        private Number(int num) {
            this.num = num;
            this.remain = 1;
        }

        public boolean isEmpty() {
            return remain == 0;
        }

        public void decrease() {
            remain--;
        }

        public void increase() {
            remain++;
        }

        @Override
        public int compareTo(Number o) {
            return num - o.num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Number)) {
                return false;
            }
            Number number = (Number) o;
            return num == number.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }
}

/*
다른 풀이, 속도 빠른 분 코드 봤더니 이렇게 구현함

int tmp = 0;
for(int i=0;i<N;i++) {
    int cur = arr[i];
    if(!visited[i] && tmp != arr[i]) {
        visited[i] = true;
        nums[k] = arr[i];
        tmp = arr[i];
        func(k+1);
        visited[i] = false;
    }
}

개수를 세지 않고 tmp 변수를 사용하는 방식, 해당 depth에서 사용했다면 그 값은 사용하지 않는다.
예를들어 1, 1, 3, 7이 있고 depth가 0일때 1을 사용했다면, tmp는 1이되기 때문에 같은 자리에 중복된 숫자를 사용하지 않게 됨
 */
