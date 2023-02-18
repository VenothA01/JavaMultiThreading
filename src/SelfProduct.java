import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SelfProduct {

    public static int[] selfProduct(int[] nums) {

        int n = nums.length, prod = 1;
        int[] result = new int[n];
        result[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            result[i] = nums[i]*result[i + 1];
        }

        for (int i = 0; i < n - 1; i++) {
            result[i] = result[i + 1]*prod;
            prod *= nums[i];
        }
        result[n - 1] = prod;

        return result;

    }

    public static List<Integer> getTopFrequent(List<Integer> list,int k){

        Map<Integer, Long> map =  list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        PriorityQueue<Map.Entry<Integer, Long>> pq = new PriorityQueue<>((a, b) -> (int) (b.getValue() - a.getValue()));

        List<Integer> result = new ArrayList<>();

        map.forEach((key, value) -> pq.add(new AbstractMap.SimpleEntry<>(key, value)));

        for (int i = 0; i < k; i++) {
            result.add(pq.poll().getKey());
        }



        return result;

    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(selfProduct(nums)));


        List<Integer> list = Arrays.asList(1,1,1,2,2,3);
        System.out.println(getTopFrequent(list,2));;

    }
}
