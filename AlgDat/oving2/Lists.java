public abstract class Lists{
	abstract void push(int i);
	abstract int pop();
	

}

class ArrayStrack extends Lists{
	int[] is = new int[7];
	int count = 0;
	
	void push(int i){
		is[count] = i;
		count++;
	}
	
	int pop(){
		--count;
		return is[count];
	}
	
	int size(){
		return count;
	}

}

class LinkedStack extends Lists{
	Node first;
	
	void push(int i){
		first = new Node(i, first)
		
}

class ArrayList extends Lists{
	int[] is = new int[7];
	int first = 0, last = 0;
	
	void push(int i){
		is[first++] = i;
	}
	
	int pop(){
		int i = is[last];
		last++;
		return i;
	}
	
	int size(){
		return first - last;
	}

}

class LinkedList extends Lists{
	Node head = new Node(0), last = head;
	
	void push(int i) {
		Node n = new Node(i);
		last.n = n;
		last = n;
	}
	
	void push(int i){
		last = last.n
}

class Node {
	Node n;
	int i;
	
	Node(int i){
		this.i = i;
	}
	
	Node(int i, Node n){
		this(i);
		this.n = n;
	}
	
}