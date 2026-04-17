class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        large = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {
        small.add(num);

        // small should have <= large values
        if(!large.isEmpty() && small.peek() > large.peek()){
            large.add(small.poll());
        }

        // small should not have greater than large + 1 element
        if(small.size() > large.size() +1){
            large.add(small.poll());
        }

        if(large.size() > small.size() +1){
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size() > large.size()){
            return small.peek();
        }
        if(large.size() > small.size()){
            return large.peek();
        }

        return (small.peek() + large.peek() )/2.0;
    }
}
