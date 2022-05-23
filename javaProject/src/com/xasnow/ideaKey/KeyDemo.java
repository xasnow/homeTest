package ideaKey;

import org.junit.Test;
import sun.misc.Unsafe;

import java.util.Arrays;
import java.util.List;

public class KeyDemo<list> {

    public static void main(String[] args) {
        String name = "name";
        // name.nn
        if (name != null) {

        }
        // Jack.var
        String jack = "Jack";


    }

    // object.cast
    @Test
    public void testCast() {
        Object object = null;
        String object1 = (String) object;
//        Unsafe unsafe = new Unsafe();
    }

    // object.if
    @Test
    public void testIf() {
        boolean flag = false;
        if (flag) {

        }
    }

    // new Exception().throw
    @Test
    public void testThrow() throws Exception {
        throw new Exception();
    }

    // list.for 迭代遍历  list.fori  i递增   list，forr i递减
    @Test
    public void testFor() {
        List<String> list = Arrays.asList("a", "b", "c");
        for (String o : list) {
            System.out.println("o = " + o);
        }

        for (int i = 0; i < list.size(); i++) {

        }

        for (int i = list.size() - 1; i >= 0; i--) {

        }
    }

    // object.sout
    @Test
    public void testSout() {
        String object = "name";
        System.out.println(object); // object.sout
        System.out.println("object = " + object); // object.soutv

        testReturn();
    }


    // name.return
    private String testReturn() {
        String name = "age";
        return name;
    }

}
