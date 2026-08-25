class MyStack {

    Queue<Integer> stack;
    Queue<Integer> queue;
    public MyStack() {
        stack = new LinkedList<>();
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        
        while(!stack.isEmpty()) {
            queue.add(stack.poll());
        }

        stack.add(x);

        while(!queue.isEmpty()) {
            stack.add(queue.poll());
        }
    }
    
    public int pop() {
        
        return stack.poll();
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public boolean empty() {
        
        return stack.isEmpty();
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