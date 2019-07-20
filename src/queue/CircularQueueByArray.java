package queue;

public class CircularQueueByArray {

    private int[] arr;
    private int topOfQueue;
    private int size;
    private int start;

    // constructor
    public CircularQueueByArray(int size) {
        this.arr = new int[size];
        this.size = size;
        this.topOfQueue = -1;
        start = -1;
        System.out.println("Successfully created an empty queue of size: " + size);
    }


    public void enQueue(int value) {
        if (arr == null) {
            System.out.println("Array is not yet created. Please create one first.");
        } else if (isQueueFull()) {
            System.out.println("\nQueue overflow error!!");
        } else {
            initializeStartOfArray();
            if (topOfQueue + 1 == size) {
                //if top is already at last cell of array, then reset it to first cell
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            arr[topOfQueue] = value;
            System.out.println("\nSuccessfully inserted " + value + " in the queue");
        }
    }


    private void initializeStartOfArray() {
        if (start == -1) {
            start = 0;
        }
    }


    public void deQueue() {
        if (isQueueEmpty()) {
            System.out.println("Queue underflow error!!");
        } else {
            System.out.println("\n---------------------------------------------");
            System.out.println("Before Dequeue..");
            printArray();
            System.out.println("\nDequeing value from Queue...");
            System.out.println("Dequeued: " + arr[start] + " from queue");
            arr[start] = 0; //initialize the unused cell to 0
            if (start == topOfQueue) {
                //if there is only 1 element in Queue
                start = topOfQueue = -1;
            } else if (start + 1 == size) {
                //if start has reached end of array, then start again from 0
                start = 0;
            } else {
                start++;
            }
        }
        System.out.println("After Dequeue..");
        printArray();
        System.out.println("---------------------------------------------");
    }


    public boolean isQueueEmpty() {
        return topOfQueue == -1;
    }


    public boolean isQueueFull() {
        if (topOfQueue + 1 == start) {
            //If we have completed a circle, then we can say that Queue is full
            return true;
        } else if ((start == 0) && (topOfQueue + 1 == size)) {
            //Trivial case of Queue being full
            return true;
        } else {
            return false;
        }
    }


    public void peekOperation() {
        //if stack is not empty, return the value on top of stack
        if (!isQueueEmpty()) {
            System.out.println("\nPeeking value from queue...");
            System.out.println(arr[start]);
        } else {
            System.out.println("The queue is empty!!");
        }
    }


    public void deleteStack() {
        System.out.println("\n\nDeleting the entire Queue...");
        arr = null;
        System.out.println("Queue is successfully deleted !");
    }


    //Print entire array
    public void printArray() {
        System.out.println("Array now...");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("\nStart = " + start);
        System.out.println("End = " + topOfQueue);
    }

}
