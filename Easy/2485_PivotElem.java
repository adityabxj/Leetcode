class Solution {
    public int pivotInteger(int n) {
        int sum = n*(n+1)/2;
        int sqrt = (int) Math.sqrt(sum);
        if (sqrt * sqrt == sum) {
            return sqrt;
        } else {
            return -1;
        }
    }
}