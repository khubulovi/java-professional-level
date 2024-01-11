package lesson4;

public class WaitAndNotify implements Runnable {
    static volatile char c = 'A';
    static Object obj = new Object();
    private char letter;
    private char nextletter;

    public WaitAndNotify(char letter, char nextletter) {
        this.letter = letter;
        this.nextletter = nextletter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (obj) {
                try {
                    if (c != letter)
                        obj.wait();
                    System.out.print(letter);
                    c = nextletter;
                    obj.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

