package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        var list = new SafetyList();
        Thread thread1 = new ListThread(list);
        Thread thread2 = new ListThread(list);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list.getSize());
        // END
    }
}

