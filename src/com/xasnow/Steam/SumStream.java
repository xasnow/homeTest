package Steam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author wucheng
 * @Date 2020/7/25
 */
public class SumStream {
    public static void main(String[] args) {
        ArrayList<Student> objects = new ArrayList<>();
        Student zhang = new Student("1", "zhang", new BigDecimal(10));
        Student li = new Student("1", "li", new BigDecimal(20));
        Student wang = new Student("1", "wang", null);
        Student wang1 = new Student("", "wang1", new BigDecimal(21));
        objects.add(zhang);
        objects.add(li);
        objects.add(wang);
        objects.add(wang1);
//        Optional<Student> reduce = objects.stream().map(x -> x.getScor()).reduce();

        // BigDecimal reduce = objects.stream().map(x -> x.getScor()).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal reduce1 = objects.stream().filter(x -> x.getScor() != null).map(x -> x.getScor()).reduce(BigDecimal.ZERO, BigDecimal::add);
        // System.out.println(reduce);
        System.out.println(reduce1);
//        System.out.println(reduce2);
//        objects.stream().map(x -> fbProd.getEarnestMoney()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
