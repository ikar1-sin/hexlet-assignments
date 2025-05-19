package exercise;

// BEGIN
public class MaxThread extends Thread {
    private final int[] nums;
    private int max;

    MaxThread(int[] nums) {
        this.nums = nums;
    }

    @Override
    public void run() {
        findMax(nums);
    }

    public void findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        this.max = max;
    }

    public int getMax() {
        return max;
    }
}
// END
