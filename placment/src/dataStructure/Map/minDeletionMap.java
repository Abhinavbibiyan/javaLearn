package dataStructure.Map;
import java.util.*;
public class minDeletionMap {
	public int minDeletions(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        maxHeap.addAll(frequencyMap.values());
        int count = 0;
        while (maxHeap.size() > 1) {
            int top = maxHeap.poll();
            if (maxHeap.peek() != null && maxHeap.peek() == top && top != 0) {
                count++;
                maxHeap.add(top - 1);
            }
        }
        return count;
    }
public static void main(String[] args) {
	
}
}
