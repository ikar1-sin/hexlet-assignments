package exercise;

import java.util.Random;

// BEGIN
public class ListThread extends Thread {
    private SafetyList list;

    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        var random = new Random();
        for (int i = 0; i < 1000; i++) {
            var num = random.nextInt(0, 10);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add(num);
        }
    }
}
// END
