class MedianFinder {
    
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.isEmpty()) max.add(num);
        else if(max.peek() < num){
            min.add(num);
        }
        else{
            max.add(num);
        }

        if(min.size() > max.size()) max.add(min.poll());
        else if(max.size()-min.size() > 1) min.add(max.poll());
       
    }
    
    public double findMedian() {
        int n = max.size()+min.size();
        if(n%2 != 0){//odd
            return (double)max.peek();
        }
        else{
            double avg = ((double)max.peek()+(double)min.peek())/2.0;
            return avg;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */