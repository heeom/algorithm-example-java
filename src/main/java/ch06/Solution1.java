package ch06;

public class Solution1 {

    public static void main(String[] args) {
        boolean palindrome2 = Solution1.isPalindrome2("A man, a plan, a canal: Panama");
        System.out.println(palindrome2);
    }
    private boolean isPalindrome(String s) {
        String strings = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int end = strings.length() - 1;
        for (int i = 0; i < strings.length() / 2; i++) {
            if (strings.charAt(i) != strings.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome2(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
