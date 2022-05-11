package sql;

/**
 * @author xasnow
 * @Date 2020/5/12
 */
public class StringSub2 {
    public static void main(String[] args) {
        int itemLength = 3;
        String msg = "0123456789abcdf";
        convertClobMsg(itemLength, msg);

    }

    private static void convertClobMsg(int itemLength, String msg) {
        int i = msg.length() / itemLength;
        System.out.println(msg.length());
        StringBuilder sb = new StringBuilder(); //不能给初始值，报文可能超长未知。
        for (int j = 0; j < 1 + i; j++) {
            int starSize = j * itemLength;
            int endSize = (j + 1) * itemLength;
            if (endSize <= msg.length()) { //  前面的分批截取
                String substring = msg.substring(starSize, endSize);
                sb.append("to_clob('").append(substring).append("')||");
            } else if (starSize != msg.length()) { // 最后一个批次，本次截取至结尾，如果startSize与字符串长度相等，就不再截取
                String substring = msg.substring(starSize);
                sb.append("to_clob('").append(substring).append("')||");
            }
        }
        String s = sb.append("to_clob('')").toString();
        System.out.println(s);
    }
}
