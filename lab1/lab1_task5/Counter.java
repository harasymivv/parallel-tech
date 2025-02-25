package lab1.lab1_task5;

class Counter {
    protected int count = 0;
    
    public void increment() {
        count++;
    }
    
    public void decrement() {
        count--;
    }
    
    public int getValue() {
        return count;
    }
}
