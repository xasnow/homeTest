package Steam;

import java.math.BigDecimal;

/**
 * @author wucheng
 * @Date 2020/7/25
 */

public class Student {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student(String id, String name, BigDecimal scor) {
        this.id = id;
        this.name = name;
        this.scor = scor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String id;
    private String name;

    public BigDecimal getScor() {
        return scor;
    }

    public void setScor(BigDecimal scor) {
        this.scor = scor;
    }

    private BigDecimal scor;
}
