package exercise;

class SafetyList {
    // BEGIN
    private int[] nums;
    private int size = 0;
    private int startCapacity = 10;

    public SafetyList() {
        this.nums = new int[startCapacity];
    }

    public synchronized void add(int num) {
        ensureCapacity(size + 1);
        nums[size++] = num;
    }

    public int get(int index) {
        return nums[index];
    }

    public int getSize() {
        return nums.length;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= nums.length) {
            var newCapacity = startCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            var elementData = new int[newCapacity];
            System.arraycopy(nums, 0, elementData, 0, size);
            nums = elementData;
        }
    }
    // END
}
