import java.util.LinkedList;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        // Display Name and USN at the start
        System.out.println("Name: Krish Bam and USN: 1BM23CS158\n");

        // Create shared buffer
        Buffer buffer = new Buffer();
        
        // Create producer and consumer threads
        Thread producer = new Thread(new Producer(buffer), "Producer");
        Thread consumer = new Thread(new Consumer(buffer), "Consumer");

        // Start producer and consumer threads
        producer.start();
        consumer.start();
    }
}

// Shared buffer for producer and consumer
class Buffer {
    private final LinkedList<Integer> list = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce() throws InterruptedException {
        while (list.size() == capacity) {
            wait(); // Wait if buffer is full
        }
        int value = (int) (Math.random() * 100);
        list.add(value);
        System.out.println(Thread.currentThread().getName() + " produced: " + value);
        notify(); // Notify consumer
    }

    public synchronized void consume() throws InterruptedException {
        while (list.isEmpty()) {
            wait(); // Wait if buffer is empty
        }
        int value = list.removeFirst();
        System.out.println(Thread.currentThread().getName() + " consumed: " + value);
        notify(); // Notify producer
    }
}

class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.produce();
                Thread.sleep(500); // Simulate production delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(500); // Simulate consumption delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
