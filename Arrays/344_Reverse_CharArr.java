package Arrays;

class Solution {
    public void reverseString(char[] s) {
        char[] a = new char[s.length];
        for (int i = 0; i <= s.length - 1; i++) {
            a[a.length - 1 - i] = s[i];
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = a[i];
        }
    }
}

// OR
// Using Two pointers
// class Solution {
// public void reverseString(char[] s) {
// int left = 0;
// int right = s.length - 1;
// while (left < right) {
// char temp = s[left];
// s[left] = s[right];
// s[right] = temp;
// left++;
// right--;
// }
// }
// }