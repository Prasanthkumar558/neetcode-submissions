class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        return Arrays.stream(nums)
                                  .boxed()
                                  .collect(Collectors.groupingBy(java.util.function.Function.identity(),Collectors.counting()))
                                  .entrySet()
                                  .stream()
                                  .filter(entry -> entry.getValue() > nums.length / 3)
                                  .map(Map.Entry::getKey)
                                  .toList();
    }
}