class MyCircularQueue {

    int[] arr;
    int front;
    int rear;
    int size;
    int k;
    
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
        size = 0;
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        
        if(size == k) return false;

        rear = (rear + 1) % k;
        arr[rear] = value;
        
        size++;

        return true;
    }
    
    public boolean deQueue() {
        
        if(size <= 0 ) return false;

        front = (front + 1) % k;
        size--;

        return true;
    }
    
    public int Front() {
        
        if(size == 0) return -1;

        return arr[(front + 1) % k];
    }
    
    public int Rear() {
        
        if(size == 0) return -1;

        return arr[rear];
    }
    
    public boolean isEmpty() {
        
        return size == 0;
    }
    
    public boolean isFull() {
        
        return size == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */