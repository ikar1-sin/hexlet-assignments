package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] nums;
    private int min;

    MinThread(int[] nums) {
        this.nums = nums;
    }

    @Override
    public void run() {
        findMin(nums);
    }

    public void findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        this.min = min;
    }

    public int getMin() {
        return min;
    }
}
// END
