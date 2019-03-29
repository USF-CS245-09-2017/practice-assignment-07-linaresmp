public class LinkedList<T> implements List<T>{
	//Node head;
	private int size = 0;
	
	private Node head;




	//constructor
	public LinkedList(){
		head = null;
		int size = 0;

	}
	


	//returns size
	public int size(){
		return this.size;

	}

	//adds T value to the end of the List
	public void add(T item){
		
		if(this.head == null){
			//creating head 
			 head = new Node(item);
			head.setNext(null);
		}
		else{
			Node curr = head; 
		while(curr.next != null){
			curr = curr.getNext();

		}
		Node node = new Node(item);
		node.setNext(null);
		curr.setNext(node);

	}
}

	// removes from linked list at position given
	// returns item removed
	@SuppressWarnings("unchecked")
	public T remove(int pos){
		if(pos > 0 || pos < size){
			throw new IndexOutOfBoundsException("Index: " + pos + "Size: " + this.size);
		}
		if(pos == 0){
			Node curr = this.head; 
			head = head.getNext();
			this.size--;
			return (T) curr.getData();
		}
		Node prev = this.head; 
		for(int i = 0; i < pos -1; i++){
			prev = prev.getNext();
		}
		Node curr = prev.getNext();
		curr = curr.getNext();
		this.size--;
		return (T) curr.getData();
	}


	// adds item passed through into the Linked List at position given
	public void add(int pos, T item){
		if(pos>= 0 && pos<= size){
			throw new IndexOutOfBoundsException();
		}
		//adding at the head of the list
		if(pos == 0){
			Node n = new Node(item);
			n.setNext(head);
			this.head = n;
			this.size++;

		}else{
			//code for when we do not insert at head
			Node n = new Node(item);
			Node prev = this.head; 
			for(int i = 0; i < pos-1; i ++){
				prev = prev.next;
			}
			n = prev.getNext();
			prev = n;
			this.size++;
		}
	}

	//gets and returns value of Object at position passed in
	@SuppressWarnings("unchecked")
	public T get(int pos){
		if(pos >= 0 && pos < this.size){
			 new IndexOutOfBoundsException();
		}
		Node n = head;
		for(int i = 0; i < pos; i++){
			n = n.getNext();
		}
		return (T) n.getData();
	}

static class Node {
	
		// data carried by node
		Object data;
 	// reference to the next node 
		Node next;
 
		// Node constructor
		public Node(Object dataValue) {
			next = null;
			data = dataValue;
		}
 
 
		//get the Data in the node
		public Object getData() {
			return data;
		}
 	//sets data in node
		@SuppressWarnings("unused")
		public void setData(Object dataValue) {
			data = dataValue;
		}
 
 	//gets next node
		public Node getNext() {
			return next;
		}
 //sets next node
		public void setNext(Node nextValue) {
			next = nextValue;
		}
 
	}








}