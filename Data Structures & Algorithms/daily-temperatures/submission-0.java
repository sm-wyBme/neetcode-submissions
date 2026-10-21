class Solution {
    public int[] dailyTemperatures(int[] temperature) {
        int n = temperature.length;
        int results[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            if(stack.size() == 0) {
                results[i] = 0;
            } else if(stack.size() != 0 && temperature[stack.peek()] > temperature[i]){
                results[i] = stack.peek() - i;
            } else if(stack.size() != 0 && temperature[stack.peek()] <= temperature[i]){
                while(stack.size() != 0 && temperature[stack.peek()] <= temperature[i]){
                    stack.pop();
                }
                if(stack.size() == 0){
                    results[i] = 0;
                }else{
                    results[i] = stack.peek() - i;
                }
            }
            stack.push(i);
        }
        return results;
    }
}
