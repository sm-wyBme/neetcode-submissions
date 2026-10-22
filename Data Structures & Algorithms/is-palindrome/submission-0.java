class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(!isValidCharacter(s.charAt(left))){
                left++;
            }else if(!isValidCharacter(s.charAt(right))){
                right--;
            }else if(!compare(s.charAt(left), s.charAt(right))){
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isValidCharacter(char c) {
        return (c >= 'A' && c <= 'Z') ||
           (c >= 'a' && c <= 'z') ||
           (c >= '0' && c <= '9');
    }

    public boolean compare(Character a, Character b){
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
