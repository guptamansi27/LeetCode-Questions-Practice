/*Using 2 queue
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
    }
    
    public void push(int x) {
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        queue2.add(x);
        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
    }
    
    public int pop() {
        return queue2.poll();
    }
    
    public int top() {
        return queue2.peek();
    }
    
    public boolean empty() {
        return queue2.isEmpty();
    }
}*/
//Using 1 queue
class MyStack{
    Queue<Integer> q;
    public MyStack(){
        q=new LinkedList();
    }
    public void push(int x){
        int size = q.size();
        q.add(x);
        while(size-->0){
            q.add(q.poll());
        }
    }
    public int pop(){
        return q.poll();
    }
    public int top(){
        return q.peek();
    }
    public boolean empty(){
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */