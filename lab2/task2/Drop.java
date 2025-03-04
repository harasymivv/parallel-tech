package lab2.task2;

public class Drop {

    private Integer message;
    private boolean empty = true;
    
    public synchronized Integer take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        
        empty = true;
        
        notifyAll();
        return message;
    }
    
    public synchronized void put(Integer message) {

        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        
        empty = false;
        

        this.message = message;
        
        notifyAll();
    }
}