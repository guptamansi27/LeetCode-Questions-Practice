class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid:asteroids){
            while(!stack.isEmpty() && stack.peek()>0 && asteroid<0 && stack.peek()<-asteroid){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek()>0 && asteroid<0){
                if(stack.peek() == -asteroid){
                    stack.pop();
                }
            }
            else{
                stack.push(asteroid);
            }
        }
        int ans[]=new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}