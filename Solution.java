class Solution {
    private int[] sort(int[] nums) {
        int offset = 10000;
        int size = 20001;

        int[] count = new int[size];

        for (int x : nums) {
            count[x + offset]++;
        }

        int[] result = new int[nums.length];
        int idx = 0;

        for (int i = 0; i < size; i++) {
            while (count[i] > 0) {
                result[idx++] = i - offset;
                count[i]--;
            }
        }

        return result;
    }

    public int arrayPairSum(int[] nums) {
        int[] ns = sort(nums);
        int sum = 0;
        for(int i = 0; i < ns.length; i += 2){
            sum += Math.min(ns[i], ns[i + 1]);
        }

        return(sum);
    }
}
