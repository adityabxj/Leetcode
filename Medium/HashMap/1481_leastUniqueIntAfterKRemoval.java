package Medium.HashMap;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int n : arr) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(hm.values());

        while (!minHeap.isEmpty() && k > 0) {
            if (minHeap.peek() <= k) {
                k -= minHeap.peek();
                minHeap.remove();
            } else {
                break;
            }
        }
        return minHeap.size();
    }
}
