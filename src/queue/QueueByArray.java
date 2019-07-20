package queue;

public class QueueByArray {

    private int[] arr;
    private int topOfQueue;
    private int beginningOfQueue;


    public QueueByArray(int size) {
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Successfully created an empty queue of size: " + size);
    }


    public void enQueue(int value) {
        if (isQueueFull()) {
            System.out.println("Queue overflow error!!");
        } else if (isQueueEmpty()) { //If the queue is empty then we need to initialize beginning index
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        } else { //if the queue already has some elements in it then no need to initialize beginning index
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        }
        printQueue();
    }


    public void printQueue() {
        if (!isQueueEmpty()) {
            System.out.println("Queue now ...");
            for (int i = beginningOfQueue; i <= topOfQueue; i++) {
                System.out.println(arr[i] + "   ");
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty !");
        }
    }

    public void deQueue() {
        if (isQueueEmpty()) {
            System.out.println("Queue underflow error!!");
        } else {
            System.out.println("Dequeing value from Queue...");
            System.out.println("Dequeued: " + arr[beginningOfQueue] + " from queue");
            beginningOfQueue++;
            if (beginningOfQueue > topOfQueue) { //If last element in the Queue is Dequeued
                beginningOfQueue = topOfQueue = -1;
            }
        }
        printQueue();
        System.out.println();
    }


    private boolean isQueueEmpty() {
        return (beginningOfQueue == -1) || (beginningOfQueue == arr.length);
    }


    private boolean isQueueFull() {
        return topOfQueue == arr.length - 1;
    }


    public void peekOperation() {
        if (!isQueueEmpty()) {
            System.out.println(arr[beginningOfQueue]);
        } else {
            System.out.println("The queue is empty!!");
        }
    }


    public void deleteQueue() {
        arr = null;
        System.out.println("Queue is successfully deleted !");
    }

}
