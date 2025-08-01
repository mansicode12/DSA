class MyStack {
    Queue<Integer> queue; // this is interface
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        for(int i =0;i< size-1;i++){
            queue.add(queue.remove()); //remove from front and added it at back in rear
            // so the queue will be reverse
        }
    }
    
    public int pop() {
   return             queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
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