class Solution {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        int cap = 0, sm = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i])) {
                cap++;
            } else if (Character.isLowerCase(arr[i])) {
                sm++;
            }
        }
        if (cap == arr.length || sm == arr.length || (cap == 1 && Character.isUpperCase(arr[0]))) {
            return true;
        } else {
            return false;
        }

    }
}
