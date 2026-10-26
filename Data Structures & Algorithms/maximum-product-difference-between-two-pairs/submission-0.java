class Solution {
    public int maxProductDifference(int[] nums) {
        
        int a = Arrays.stream(nums)
                      .boxed()
                      .sorted(Comparator.reverseOrder())
                      .findFirst()
                      .orElse(-1);

        int b = Arrays.stream(nums)
                      .boxed()
                      .sorted(Comparator.reverseOrder())
                      .skip(1)
                      .findFirst()
                      .orElse(-1);

        int c = Arrays.stream(nums)
                      .boxed()
                      .sorted()
                      .findFirst()
                      .orElse(-1);

        int d = Arrays.stream(nums)
                      .boxed()
                      .sorted()
                      .skip(1)
                      .findFirst()
                      .orElse(-1);

        return (a*b) - (c*d);
    }
}