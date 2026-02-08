package number;

import java.util.*;

public class _05_divisorOfNaturalNumber {
    public static void main(String[] args) {
        System.out.println(findDivisors(100));
    }
    //Every divisor below sqrt has a partner above sqrt.
    static List<Integer> findDivisors(int n){
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i*i <= n ; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }
}
