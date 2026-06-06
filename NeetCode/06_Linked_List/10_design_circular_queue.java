class MyCircularQueue {
    int [] arr;
    int first; // first element in queue
    int last; // last element in queue
    int size; // no of elements in queue
    int capacity; // max no of elements

    public MyCircularQueue(int k) {
        arr = new int[k];
        capacity = k;
        size = 0;
        first = 0;
        last = -1; 
    }
    
    public boolean enQueue(int value) {
        if(size == capacity){
            return false;
        }
        last = (last + 1) % capacity;
        arr[last] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        first = (first + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if(size < 1){
            return -1;
        }
        return arr[first];
    }
    
    public int Rear() {
        if(size < 1){
            return -1;
        }
        return arr[last];
    }
    
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(size == capacity){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */