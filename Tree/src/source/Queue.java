package source;

public class Queue<T> implements QueueInterface<T> {
	
	@SuppressWarnings("hiding")
	private class Node<T>{
		private T data;
		private Node<T> next;
		
		private Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		private Node(T data) {
			this.data = data;
		}
		
		private T getNodeData() {
			return data;
		}
		private void setNodeData(T newEntry) {
			data = newEntry;
		}
		private Node<T> getNextNode() {
			return next;
		}
		private void setNextNode(Node<T> newNode) {
			next = newNode;
		}
		
	}
	
	private Node<T> firstNode;
	private Node<T> lastNode;
	
	public Queue() {
		firstNode = null;
		lastNode = null;
	}

	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		if(firstNode == null) {
			firstNode = newNode;
		}
		else {
			lastNode.setNextNode(newNode);
		}
		lastNode = newNode;
	}
	public T getFront() {
		return firstNode.getNodeData();
	}
	public T dequeue() {
		T front = getFront();
		firstNode.setNodeData(null);
		firstNode = firstNode.getNextNode();
		if(firstNode == null) {
			lastNode = null;
		}
		return front;
	}
	public boolean isEmpty() {
		return firstNode == null && lastNode == null;
	}
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

}
