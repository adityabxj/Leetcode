// import javafx.util.Pair;
// import java.util.*;

// class Solution {
// // This method finds the cheapest price from source city to destination city
// // with at most k stops
// public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
// {
// // Initialize graph as an array of lists to represent the adjacency list
// // representation of the graph
// List<Pair<Integer, Integer>>[] graph = new List[n];

// // Initialize each element of the graph array as an empty ArrayList
// for (int i = 0; i < n; i++)
// graph[i] = new ArrayList<>();

// // Populate the graph with flights data
// for (int[] flight : flights) {
// final int u = flight[0]; // Source city
// final int v = flight[1]; // Destination city
// final int w = flight[2]; // Cost of flight
// // Add the destination city and its corresponding flight cost to the
// adjacency
// // list of the source city
// graph[u].add(new Pair<>(v, w));
// }

// // Call the Dijkstra's algorithm function to find the cheapest price
// return dijkstra(graph, src, dst, k);
// }

// // Dijkstra's algorithm to find the cheapest price
// private int dijkstra(List<Pair<Integer, Integer>>[] graph, int src, int dst,
// int k) {
// // Initialize a 2D array to keep track of the minimum distance from the
// source
// // city to each city with a certain number of stops
// int[][] dist = new int[graph.length][k + 2];
// // Initialize each element of the dist array with maximum integer value to
// // represent infinity
// Arrays.stream(dist).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE));
// // Priority queue to store tuples (distance, city, stops) sorted by distance
// Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

// // Set the distance of the source city with k+1 stops to 0 and add it to the
// // priority queue
// dist[src][k + 1] = 0;
// minHeap.offer(new int[] { dist[src][k + 1], src, k + 1 });

// // Iterate through the priority queue until it is empty
// while (!minHeap.isEmpty()) {
// // Extract the tuple with the minimum distance
// final int d = minHeap.peek()[0]; // Distance
// final int u = minHeap.peek()[1]; // Current city
// final int stops = minHeap.poll()[2]; // Number of stops

// // If the current city is the destination city, return the minimum distance
// if (u == dst)
// return d;

// // If the number of stops has reached 0, skip to the next iteration
// if (stops == 0)
// continue;

// // Iterate through all the neighbors of the current city
// for (Pair<Integer, Integer> pair : graph[u]) {
// final int v = pair.getKey(); // Neighbor city
// final int w = pair.getValue(); // Cost of flight to neighbor city

// // If the distance from the source city to the neighbor through the current
// city
// // is shorter than the previously calculated distance
// if (d + w < dist[v][stops - 1]) {
// // Update the distance and add the neighbor to the priority queue with one
// fewer
// // stop
// dist[v][stops - 1] = d + w;
// minHeap.offer(new int[] { dist[v][stops - 1], v, stops - 1 });
// }
// }
// }

// // If no path is found within the given constraints, return -1
// return -1;
// }
// }
