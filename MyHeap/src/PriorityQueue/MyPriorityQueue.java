package PriorityQueue;

import java.util.Comparator;

public class MyPriorityQueue<T> {
	T[] cache;
	int size;
	int capacity;
	Comparator cp;
	public MyPriorityQueue(int cap,Comparator cp){
		this.capacity=cap;
		this.cache=(T[]) new Object[cap];
		this.size=1;
		this.cp=cp;
	}
	public void offer(T t){
		if(size==capacity) return;
		cache[size]=t;
		size++;
		upReorder(size-1);
	}
	public T poll(){
		T output=cache[1];
		cache[1]=cache[size-1];
		size--;
		downReorder(1);
		return output;
	}
	public void downReorder(int i){
		int[] children=findChildren(i);
		if(children[0]<size){
			if(cp.compare(cache[i],cache[children[0]])>0){
				swap(i,children[0]);
			}
		}
		if(children[1]<size){
			if(cp.compare(cache[i],cache[children[1]])>0) 
				swap(i,children[1]);
		}
		if(children[0]<size) downReorder(children[0]);
		if(children[1]<size) downReorder(children[1]);
	}
	public void upReorder(int i){
		if(i==1) return;
		else{
			int parent=findParent(i);
			if(cp.compare(cache[i],cache[parent])<0) swap(i,parent);
			upReorder(parent);
		}
	}
	public int findParent(int i){return i/2;}
	public int[] findChildren(int i){return new int[]{i*2,i*2+1};}
	public void swap(int i,int j){
		T t=cache[i];cache[i]=cache[j];cache[j]=t;
	}
	
}
