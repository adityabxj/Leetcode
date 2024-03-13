class Solution {
    public int fib(int n) {
        int f = 0, s = 1, nx = 0;

        if (n <= 1) {
            return n;
        } else {
            for (int i = 2; i <= n; i++) {
                nx = f + s;
                f = s;
                s = nx;
            }
            return nx;
        }
    }
}
