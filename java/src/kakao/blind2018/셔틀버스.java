package kakao.blind2018;

import java.util.*;

public class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> times = new PriorityQueue<>();
        for (String time : timetable) {
            int amount = 0;
            String[] hourAndMinute = time.split(":");
            amount += Integer.parseInt(hourAndMinute[0]) * 60;
            amount += Integer.parseInt(hourAndMinute[1]);
            times.offer(amount);
        }

        int time = 9 * 60;
        int kon = 0;

        for (int i = 0; i < n; i++) {
            if (time >= 60 * 24) {
                break;
            }

            int passenger = 0;
            while (!times.isEmpty() && times.peek() <= time && passenger < m) {
                kon = times.poll() - 1;
                passenger++;
            }

            if (passenger < m) {
                kon = time;
            }
            time += t;
        }

        int hour = kon / 60;
        int minute = kon % 60;

        return String.format("%02d:%02d", hour, minute);
    }
}
