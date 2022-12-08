package Poly_linked_list;

public class Node {
	protected Terms term;
    protected Node next;
    protected Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node(Terms term) {
    	this.term = term;
    }
    
	public Terms getTerm() {
		return term;
	}
	public void setTerm(Terms term) {
		this.term = term;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
  
    }

