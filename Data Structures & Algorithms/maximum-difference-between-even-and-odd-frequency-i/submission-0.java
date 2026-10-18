class Solution {
    public int maxDifference(String s) {
        
        Map<Character,Long> frequency = 
                                    s.chars()
                                    .mapToObj(c -> (char) c)
                                    .collect(Collectors.groupingBy(
                                        java.util.function.Function.identity(),
                                        Collectors.counting()
                                    ));

        int maxOddValue = getMaxOddValue(frequency);
        int lowEvenValue = getLowEvenValue(frequency);

        return maxOddValue-lowEvenValue;
    }

    private int getMaxOddValue(Map<Character, Long> map) {

        return (int) map.values()
                  .stream()
                  .filter(x -> x%2 != 0)
                  .max(Long::compareTo)
                  .orElseThrow()
                  .intValue();
    }

    private int getLowEvenValue(Map<Character, Long> map) {

        return  map.values()
                  .stream()
                  .filter(x -> x % 2 == 0)
                  .min(Long::compareTo)
                  .orElseThrow()
                  .intValue();
    }
}