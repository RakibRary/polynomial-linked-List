//Rakib Rary
//Mon/wed 9:15am
//Anne Smith Thompson
package Poly_linked_list;

public class polynomial {
	private Node head;
	private int degree;

	public polynomial() {
	}
//----------------------------------------------------
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
//----------------------------------------------------
	public void insert(double coeff, int power) { // use the coeff and power to help move in the linked list
		Terms terms = new Terms(coeff, power);
		Node node = new Node(terms);
		
		if(power > degree) {
			degree = power;
		}
		if (head == null) {
			head = node;
		} else {
			Node current = head;

			
			//loop through linked list
			while (current.getNext() != null && power >= current.getNext().getTerm().getPower()) {
				// System.out.println(current.getTerm().getPower());
				// System.out.println(power + ", " +current.getNext().getTerm().getPower());
				current = current.getNext();
				// System.out.println(current.getTerm().getPower() + "\n");
			}
			// System.out.println(current.getTerm().getPower());
			if (current == head) {
				if (head.getTerm().getPower() == power) {
					head.getTerm().setCoeff(head.getTerm().getCoeff() + coeff);
				} else if (power < head.getTerm().getPower()) {
					node.setNext(head);
					head = node;
					// System.out.println(node.getNext() + ", " + node);
				} else {
					if (head.getNext() == null) {
						head.setNext(node);
					} else {
						node.setNext(head.getNext());
						head.setNext(node);
					}
				}
			} else if (current.getNext() != null) {
				if (current.getTerm().getPower() == power) {
					current.getTerm().setCoeff(current.getTerm().getCoeff() + coeff);
				} else {
					node.setNext(current.getNext());
					current.setNext(node);
				}
			} else {
				if (current.getTerm().getPower() == power) {
					current.getTerm().setCoeff(current.getTerm().getCoeff() + coeff);
				} else {
					current.setNext(node);
				}
				
			}
		}
	}
	public void scale(int x) {
		Node current = head;
        //loop through list and scale at the same time
		while (current != null) {
			current.getTerm().setCoeff(current.getTerm().getCoeff() * x);
			current = current.getNext();
		}
	}
//----------------------------------------------------
	public int evaluate(int x) {  //
		Node current = head;
		int exponent = current.getTerm().getPower();
		int total = 0;
        //loop through while using recursion
		while (current != null) {
			total += current.getTerm().coeff * power(x, exponent);
			current = current.getNext();
		}
		return total;
	}
	private int power(int x, int exponent) {
		//recursion method
		if (exponent == 0)
			return 1;
		return x * power(x, exponent - 1);
	}
//----------------------------------------------------
	public void add(polynomial q) {
		Node current = head; // KEEP TRACK OF PREVIOUS AND CURRENT
		Node previous = head;
		Node poly = q.getHead(); // second polynomial

		if(q.getDegree() > degree) {
			degree = q.getDegree();
		}
		//loop through list
		while (current != null && poly != null) {
			Terms terms = new Terms(poly.getTerm().getCoeff(), poly.getTerm().getPower());
			Node node = new Node(terms);
          // ---------------------------------------------------------------------------------
			//check if power is less than
			if (poly.getTerm().getPower() < current.getTerm().getPower()) { 
				if (current == head) { // check
					node.setNext(head);
					head = node;
				} else {
					previous.setNext(node);
					node.setNext(current);
				}
				poly = poly.getNext();
				// ---------------------------------------------------------------------------------
				//check if power is equal
			} else if (poly.getTerm().getPower() == current.getTerm().getPower()) { // middle of list
				current.getTerm().setCoeff(current.getTerm().getCoeff() + poly.getTerm().getCoeff());

				previous = current;

				current = current.getNext(); // move up
				poly = poly.getNext(); // move up
			}
			// --------------------------------------------------------------------------------------
			//check for remaining cases
			else {
				if (current.getNext() != null) { // end of list
					previous = current;
					current = current.getNext();
				} else {
					current.setNext(node);
					poly = poly.getNext(); // move
				}
			}
		}
	}
//----------------------------------------------------
	public void subtract(polynomial q) {
		Node current = head; // KEEP TRACK OF PREVIOUS AND CURRENT
		Node previous = head;
		Node poly = q.getHead(); // second polynomial

		if(q.getDegree() > degree) {
			degree = q.getDegree();
		}
		
		while (current != null && poly != null) {
			Terms terms = new Terms(-poly.getTerm().getCoeff(), poly.getTerm().getPower());// add minus infront
			Node node = new Node(terms);

			if (poly.getTerm().getPower() < current.getTerm().getPower()) { // if poly list is less than curreent list {
				if (current == head) { // check
					node.setNext(head);
					head = node;
				} else {
					previous.setNext(node);
					node.setNext(current);
				}
				poly = poly.getNext();
				// ---------------------------------------------------------------------------------
			} else if (poly.getTerm().getPower() == current.getTerm().getPower()) { // middle of list
				current.getTerm().setCoeff(current.getTerm().getCoeff() - poly.getTerm().getCoeff()); // change plus to
																										// minus
				previous = current;
				current = current.getNext(); // move up
				poly = poly.getNext(); // move up
			}
			// --------------------------------------------------------------------------------------
			else {
				if (current.getNext() != null) { // end of list
					previous = current;
					current = current.getNext();
				} else {
					current.setNext(node);
					poly = poly.getNext(); // move
				}
			}
		}

	}
//----------------------------------------------------
	public void multiple(polynomial q) {
		Node current = head;
		Node poly;
		polynomial temp = new polynomial();

		if(q.getDegree() > degree) {
			degree = q.getDegree();
		}
		
		while (current != null) {    //loop
			poly = q.getHead();      //brings polynomial back to beginning
			while (poly != null) {

				double coeff = current.getTerm().getCoeff() * poly.getTerm().getCoeff(); //multiply coeff
				int degree = current.getTerm().getPower() + poly.getTerm().getPower();   //add power

				temp.insert(coeff, degree);//insert

				poly = poly.getNext();//move
			}
			current = current.getNext();//move
		}
		head = temp.getHead();
	}

//----------------------------------------------------
	public polynomial sum(polynomial p, polynomial q) {
		Node current = p.getHead(); 
		polynomial r = new polynomial();
		
		while(current != null) { //get power and coeff into r
			double coeff = current.getTerm().getCoeff();
			int power = current.getTerm().getPower();
			r.insert(coeff, power);
			current = current.getNext();
		}
		r.add(q);
		return r;
	}
//----------------------------------------------------
	public polynomial diff(polynomial p, polynomial q) {
		Node current = p.getHead(); 
		polynomial r = new polynomial();
	
		while(current != null) {
			double coeff = current.getTerm().getCoeff();
			int power = current.getTerm().getPower();
			r.insert(coeff, power);
			current = current.getNext();
		}
		r.subtract(q);
		return r;
	}
//----------------------------------------------------
	public polynomial product(polynomial p, polynomial q) {
		Node current = p.getHead(); 
		polynomial r = new polynomial();
		
		while(current != null) {
			double coeff = current.getTerm().getCoeff();
			int power = current.getTerm().getPower();
			r.insert(coeff, power);
			current = current.getNext();
		}
		r.multiple(q);
		return r;
	}
//----------------------------------------------------
	public void display() {
		//display method
		Node current = head;
		
		while (current != null) {
			System.out.print(current.getTerm().getCoeff() + " , ");
			current = current.getNext();
		}
		System.out.println();
	}
}
