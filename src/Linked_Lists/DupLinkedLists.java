package Linked_Lists;

public class DupLinkedLists {

	public static void main(String[] args) {

		KLinkedList objSingle = new KLinkedList(1);
		KLinkedList objDouble = new KLinkedList(1);
		
		objSingle.addSingle(5);
		objSingle.addSingle(3);
		objSingle.addSingle(2);
		
		objDouble.addDouble(5);
		objDouble.addDouble(3);
		objDouble.addDouble(2);
		
		objDouble.deleteDouble(3);
		objSingle.deleteSingle(3);
		
		objDouble.KthLastDouble(2);
		objSingle.KthLastSingle(2);
		
		objSingle.print();
		objDouble.printBackDouble();
		
	}

}
