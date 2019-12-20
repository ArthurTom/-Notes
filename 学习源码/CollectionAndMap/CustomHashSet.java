import java.util.HashMap;

public class CustomHashSet<T> {

    HashMap map;

    private static final Object PRESENT = new Object();

    public CustomHashSet() {
        map = new HashMap();
    }

    public int size() {
        return map.size();
    }

    public void add(T o) {
        map.put(o, PRESENT);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object key : map.keySet()) {
            builder.append("key:" + key);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        CustomHashSet<String> hashSet = new CustomHashSet<>();
        hashSet.add("张三");
        hashSet.add("李四");
        hashSet.add("王五");

        System.out.println(hashSet.toString());
    }
}
