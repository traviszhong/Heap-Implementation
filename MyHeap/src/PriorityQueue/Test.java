package PriorityQueue;

import java.util.Comparator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPriorityQueue<Integer> heap=new MyPriorityQueue<Integer>(15,new Comparator<Integer>(){
			public int compare(Integer i1,Integer i2){
				return i1-i2;
			}
		});
		heap.offer(3);
		heap.offer(9);
		heap.offer(6);
		heap.offer(8);
		heap.offer(8);
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
	}

}
