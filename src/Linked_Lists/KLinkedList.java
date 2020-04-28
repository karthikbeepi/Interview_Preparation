package Linked_Lists;


public class KLinkedList {
	KNode head, tail;
	
	public KLinkedList(int headVal) {
		head = new KNode(headVal);
		tail = head;
	}
	
	public void addDouble(int val) {
		KNode newNode = new KNode(val);
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}
	
	public void addSingle(int val) {
		KNode newNode = new KNode(val);
		KNode cur = head;
		while(cur.next!=null) 
			cur = cur.next;
		cur.next = newNode;
	}

	public void print() {
		KNode cur = head;
		while(cur.next!=null) {
			System.out.print(cur.data);
			cur = cur.next;
		}
		System.out.print(cur.data);
		System.out.println();
	}
	
	public void printBackDouble() {
		KNode cur = tail;
		while(cur.prev!=null) {
			System.out.print(cur.data);
			cur = cur.prev;
		}
		System.out.print(cur.data);
		System.out.println();
	}
	
	public void deleteSingle(int val) {
		KNode cur = head;
		if (head.data == val) {
			head = head.next;
			return;
		}
		while(cur.next!=null) {
			if(cur.next.data == val) {
				KNode toDelete = cur.next;
				cur.next = toDelete.next;
			}
			cur = cur.next;
		}
	}
	
	public void deleteDouble(int val)
	{
		KNode cur = head;
		if (head.data == val) {
			head = head.next;
			head.prev = null;
			return;
		}
		while(cur.next!=null) {
			if(cur.next.data == val) {
				KNode toDelete = cur.next;
				cur.next = toDelete.next;
				toDelete.next.prev = cur;
			}
			cur = cur.next;
		}
	}
	
	public void KthLastSingle(int k) {
		KNode cur = head;
		int noOfNodes = 0;
		while(cur!=null) {
			cur = cur.next;
			noOfNodes++;
		}
		int reqNode = noOfNodes+1 -k;
		cur = head;
		while(reqNode>1) {
			cur = cur.next;
			reqNode--;
		}
		System.out.println(cur.data);
		
	}
	
	public void KthLastDouble(int k) {
		KNode cur = tail;
		while(cur.prev != null && k > 1) {
			cur = cur.prev;
			k--;
		}
		System.out.println(cur.data);
	}
	
	
}