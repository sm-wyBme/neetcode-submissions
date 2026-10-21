class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int result[] = new int[n+1];
        int carry = 0;
        for(int i = n - 1; i >= 0; i--){
            int sum = digits[i] + carry;
            if(i == n-1) sum += 1;
            result[i+1] = sum%10;
            carry = sum/10;
        }

        if(carry == 1) result[0] = 1;
        return (result[0] == 1)? result: Arrays.copyOfRange(result, 1, n+1);
    }
}
