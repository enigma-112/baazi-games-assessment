package assessment.games.baazi;

public class Main {

    public static void main(String[] args) {
	    final ProducerConsumerProcessor processor = new ProducerConsumerProcessor();
	    Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
	    Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

	    t1.start();
	    t2.start();
    }
}
