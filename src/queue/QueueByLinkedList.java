package queue;

import linkedList.SingleLinkedList;

public class QueueByLinkedList {
	
	private SingleLinkedList linkedList;
	
	
	//constructor
	public QueueByLinkedList() {
		linkedList = new SingleLinkedList();
	}

	
	public void enQueue(int value) {
		if (linkedList.getHead() == null) {
			linkedList.createSingleLinkedList(value);
		} else {
			// push a value on last of queue, update list tail too
			linkedList.insertInLinkedList(value, linkedList.getSize());
		}
	}

	
	public int deQueue() {
		int value = -1;
		if (isQueueEmpty()) {
			System.out.println("Queue underflow error!!");
		} else {
			value = linkedList.getHead().getValue();
			linkedList.deletionOfNode(0);
		}
		return value;
	}
	
	
	public int peek() {
		if (!isQueueEmpty())
			return linkedList.getHead().getValue();
		else {
			System.out.println("The queue is empty!!");
			return -1;
		}
	}

	
	public boolean isQueueEmpty() {
		return linkedList.getHead() == null;
	}
	
	
	public void deleteStack() {
		linkedList.setHead(null);
	}

}
