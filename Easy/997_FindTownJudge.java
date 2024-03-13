
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1]; // Array to count how many people trust each person
        boolean[] isTrusted = new boolean[n + 1]; // Array to check if each person is trusted

        for (int[] relation : trust) {
            int a = relation[0]; // Person who trusts
            int b = relation[1]; // Person who is trusted
            trustCount[a]--; // Decrement trust count for person who trusts
            trustCount[b]++; // Increment trust count for person who is trusted
            isTrusted[a] = true; // Mark person who trusts as not a judge
        }

        for (int i = 1; i <= n; i++) {
            if (!isTrusted[i] && trustCount[i] == n - 1) { // Check if person is not a judge and is trusted by everyone
                                                           // else
                return i; // Return label of the town judge
            }
        }

        return -1; // No town judge found
    }
}
