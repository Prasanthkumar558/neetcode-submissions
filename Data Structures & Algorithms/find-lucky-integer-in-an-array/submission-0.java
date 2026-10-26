class Solution {
    public int findLucky(int[] arr) {
        
        return 
                                    Arrays.stream(arr)
                                    .boxed()
                                    .collect(Collectors.groupingBy(
                                        java.util.function.Function.identity(),
                                        Collectors.counting()
                                    ))
                                    .entrySet()
                                    .stream()
                                    .filter(entry -> entry.getKey().longValue() == 
                                            entry.getValue())
                                    .mapToInt(Map.Entry::getKey)
                                    .max()
                                    .orElse(-1);
    }
}