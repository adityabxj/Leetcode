import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableDays = new PriorityQueue<>();

        int maxEvents = 0;
        int day = 1;
        int index = 0;

        while (index < events.length || !availableDays.isEmpty()) {
            while (index < events.length && events[index][0] <= day) {
                availableDays.offer(events[index][1]);
                index++;
            }

            while (!availableDays.isEmpty() && availableDays.peek() < day) {
                availableDays.poll();
            }

            if (!availableDays.isEmpty()) {
                availableDays.poll();
                maxEvents++;
            }

            day++;
        }

        return maxEvents;
    }
}