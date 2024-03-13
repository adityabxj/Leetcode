package Hard.PriorityQueue;

import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings based on their start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Priority queue to track the end time of meetings and the room they were held
        // in
        PriorityQueue<long[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0]));

        // Array to keep track of the number of meetings in each room
        int[] roomCount = new int[n];

        // Variable to store the result (room with the most meetings)
        int result = 0;

        // Initialize the priority queue with all rooms available at time 0
        for (int i = 0; i < n; i++)
            queue.add(new long[] { 0, i });

        // Iterate through each meeting
        for (int[] item : meetings) {
            int time = item[0];

            // Update the priority queue to reflect the current time
            while (queue.peek()[0] < time)
                queue.add(new long[] { time, queue.poll()[1] });

            // Attend the meeting with the earliest end time
            long[] current = queue.poll();
            int curRoom = (int) current[1];
            long meetingEndTime = current[0] + (item[1] - item[0]);
            roomCount[curRoom]++;

            // Update the result based on the room with the most meetings
            if (roomCount[curRoom] > roomCount[result])
                result = curRoom;
            else if (roomCount[curRoom] == roomCount[result])
                result = Math.min(result, curRoom);

            // Add the next available time slot for the current room to the priority queue
            queue.add(new long[] { meetingEndTime, curRoom });
        }

        // Return the room with the most meetings
        return result;
    }
}
