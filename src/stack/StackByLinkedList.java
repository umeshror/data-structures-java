package stack;
import linkedList.SingleLinkedList;
import node.SingleNode;

public class StackByLinkedList {

	private SingleLinkedList linkedList;

	
	//constructor
	public  StackByLinkedList() {
		linkedList = new SingleLinkedList();
	}

	
	public void push(int value) {
		if(linkedList.getHead()== null) {
			linkedList.createSingleLinkedList(value);
		}else {
			linkedList.insertInLinkedList(value, 0);
		}
		System.out.println("Inserted " + value + " in Stack !");
	}

	
	public int pop() {
		int value = -1;
		if (isEmpty()) {
			System.out.println("Stack underflow error!!");
		} else {
			value = linkedList.getHead().getValue();
			linkedList.deletionOfNode(0);
		}
		return value;
	}

	
	public boolean isEmpty() {
		return linkedList.getHead() == null;
	}


	public int peek() {
		if (!isEmpty())
			return linkedList.getHead().getValue();
		else {
			System.out.println("The stack is empty!!");
			return -1;
		}
	}
	

	public void deleteStack() {
		linkedList.setHead(null);
	}
	
}
