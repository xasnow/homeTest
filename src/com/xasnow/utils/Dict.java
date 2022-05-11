package utils;

/**
 * @author wucheng
 * @Date 2020/8/30
 */
public class Dict {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
