class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length >= nums2.length) {
            return solve(nums1, nums2);
        }
        return solve(nums2, nums1);
    }

    private int[] solve(int[] big, int[] small) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : big) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();

        for (int num : small) {
            if (map.containsKey(num)) {
                intersection.add(num);

                map.put(num, map.get(num) - 1);

                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] ans = new int[intersection.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = intersection.get(i);
        }

        return ans;
    }
}