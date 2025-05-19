package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] nums) {
        var maxThread = new MaxThread(nums);
        var minThread = new MinThread(nums);
        maxThread.start();
        minThread.start();
        var max = maxThread.getMax();
        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var min = minThread.getMin();
        return Map.of(
                "max", max,
                "min", min
        );
    }
    // END
}
