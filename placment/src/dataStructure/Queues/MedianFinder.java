package dataStructure.Queues;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	class MedianFinderPQ {
	      double num; 
	      PriorityQueue<Integer> maxHeap;
	      PriorityQueue<Integer> minHeap;

	    public MedianFinderPQ() {
	       maxHeap=new PriorityQueue<>(Collections.reverseOrder());
	       minHeap=new PriorityQueue<>();
	    
	    }
	 
	    
	    public void addNum(int num) {
	       
	        if(maxHeap.isEmpty()||maxHeap.peek()>=num){
	            maxHeap.add(num);
	        }
	        else
	            minHeap.add(num);
	        if(maxHeap.size()>minHeap.size()+1){
	            minHeap.add(maxHeap.poll());
	            
	            
	        }else if(maxHeap.size()<minHeap.size())
	            maxHeap.add(minHeap.poll());
	        
	    }
	    
	    public double findMedian() {
	        if(maxHeap.size()==minHeap.size())
	            return (double)(maxHeap.peek()+minHeap.peek())/2;
	        
	    
	    return maxHeap.peek();}
	}
	
	
	public static void main(String[] args) {
		 
	}
	/**
	 * 
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */
}
