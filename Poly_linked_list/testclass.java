package Poly_linked_list;

public class testclass {
	
public static void main(String[] args) {
	polynomial test = new polynomial();
	polynomial test2 = new polynomial();
	
	System.out.println("insert polynomial-1");
	test.insert(-12,0);
	test.insert(32,1);
	test.insert(-15,2);
	test.insert(-3,3);
	test.insert(2,4);
	test.display();
	System.out.println("//--------------------------------------------------------");
	//--------------------------------------------------------
	System.out.println("insert polynomial-2");
	test2.insert(-12,0);
	test2.insert(-4,1);
	test2.insert(1,2);
	//test2.insert(5,5);
	//test2.insert(9,9);
	//test2.display();
	System.out.println("//--------------------------------------------------------");
	//--------------------------------------------------------
	System.out.println("scale polynomial-1");
	//test.scale(2);
	//test.display();
	//--------------------------------------------------------
	System.out.println("//--------------------------------------------------------");
	System.out.println("evaluate polynomial-1");
	//System.out.print(test.evaluate(2)); 
	//--------------------------------------------------------
	System.out.println();
	System.out.println("//--------------------------------------------------------");
	
	System.out.println("add polynomial");
	//test.add(test2);
	//test.display();
	System.out.println();
	System.out.println("//--------------------------------------------------------");
	//--------------------------------------------------------
	System.out.println("sub polynomial");
	//test.subtract(test2);
	//test.display();
	System.out.println();
	System.out.println("//--------------------------------------------------------");
	//--------------------------------------------------------
	System.out.println("multiply polynomial");
	test.multiple(test2);
	test.display();
	System.out.println();
	System.out.println("//--------------------------------------------------------");
	//--------------------------------------------------------
	System.out.println("product polynomial");
	test.product(test,test2);
	test.display();

}
}
