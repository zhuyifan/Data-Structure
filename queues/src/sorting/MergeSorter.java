package sorting;

import structures.Queue;

/**
 * A class containing methods to sort queues and merge sorted queues.
 * 
 * "Sorted" means in ascending order: the front of the queue is the smallest
 * element, and the rear of the queue is the largest.
 * 
 * e1 is less than or equal to e2 if and only if (e1.compareTo(e2) <= 0)
 *
 * You may not use loops (for, while, do, etc.) in this class. You must
 * instead use recursion.
 */
public class MergeSorter<T extends Comparable<T>> {
	
	
	
	/**
	 * Returns a new queue containing the elements from the input queue
	 * in sorted order.
	 * 
	 * Do not modify the input queue! Work on a copy of the input.
	 * 
	 * Implement this method recursively:
	 * 
	 *   In the base case, return the sorted queue.
	 *
	 *   Otherwise:
	 * 
	 *     First, divide the input queue into two smaller output queues.
	 * 
	 *     Then, recursively mergeSort each of these smaller queues. 
	 * 
	 *     Finally, return the result of merging these two queues.
	 * 
	 * @param queue an input queue
	 * @return a sorted copy of the input queue
	 */
	public Queue<T> mergeSort(Queue<T> queue) {
		// TODO 1
		Queue<T> c=new Queue<T>(queue);
		Queue<T> a=new Queue<T>();
		Queue<T> b=new Queue<T>();
		
		if(c.size()==1||c.size()==0){
			return c;
		}
		divide(c,a,b);
		return (merge(mergeSort(a),mergeSort(b)));
		
		
	}

	/**
	 * Places elements from the input queue into the output queues, roughly
	 * half and half.
	 * 
	 * Implement this method recursively:
	 * 
	 *   In the base case, there's nothing left to do.
	 *   
	 *   Otherwise:
	 *   
	 *     Make progress on moving elements from the input to the output.
	 *     
	 *     Then make a recursive call to divide.
	 *   
	 * @param input a queue
	 * @param output1 a queue into which about half of the elements in input should go
	 * @param output2 a queue into which the other half of the elements in input should go
	 */
	void divide(Queue<T> input, Queue<T> output1, Queue<T> output2) {
		// TODO 2
		if(input.isEmpty()){
			return;
		}
		
		output1.enqueue(input.dequeue());
		divide(input,output2,output1);
	}
	
	/**
	 * Merges sorted input queues into an output queue in sorted order,
	 * and returns that queue. 
	 * 
	 * Use mergeHelper to accomplish this goal.
	 *  
	 * @param input1 a sorted queue
	 * @param input2 a sorted queue
	 * @return a sorted queue consisting of all elements from input1 and input2
	 */
	Queue<T> merge(Queue<T> input1, Queue<T> input2) {
		// TODO 3
		Queue<T> output=new Queue<T>();
		mergeHelper(input1, input2, output);
		return output;
		
	}
	
	/**
	 * Merges the sorted input queues into the output queue in sorted order.
	 * 
	 * Implement this method recursively:
	 * 
	 *   In the base case, there's nothing left to do.
	 *   
	 *   Otherwise:
	 *   
	 *     Make progress on moving elements from an input to the output.
	 *     
	 *     Then make a recursive call to mergeHelper.
	 *     
	 * @param input1 a sorted queue
	 * @param input2 a sorted queue
	 * @param output a sorted queue containing the accumulated progress so far
	 */
	void mergeHelper(Queue<T> input1, Queue<T> input2, Queue<T> output) {
		// TODO 4
		if(input1.isEmpty()&&input2.isEmpty()){
			return;
		}
		if(input1.isEmpty()&&!input2.isEmpty()){
			output.enqueue(input2.dequeue());
			mergeHelper(input1,input2,output);
			return;
		}
		if(input2.isEmpty()&&!input1.isEmpty()){
			output.enqueue(input1.dequeue());
			mergeHelper(input1,input2,output);
			return;
			
		}
		if(input1.peek().compareTo(input2.peek())<0||input1.peek().compareTo(input2.peek())==0){
			output.enqueue(input1.dequeue());
			mergeHelper(input1,input2,output);
			return;
			}
		if(input1.peek().compareTo(input2.peek())>0){
			output.enqueue(input2.dequeue());
			mergeHelper(input1,input2,output);
			return;
			}
		
		
	}
}
