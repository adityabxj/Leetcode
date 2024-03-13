class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        String res = new String(arr);
        String[] str = res.split(" ");
        int low = 0;
        int high = str.length - 1;
        while (low < high) {
            String temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
        StringBuilder finalString = new StringBuilder();
        for (String word : str) {
            finalString.append(word).append(" ");
        }
        return finalString.toString().trim();
    }
}