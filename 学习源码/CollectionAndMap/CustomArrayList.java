import java.util.Arrays;

public class CustomArrayList<E> {

    private static final int ARRAY_LENGTH = 10;
    private int size = 0;
    Object[] obj;

    public CustomArrayList() {
        obj = new Object[ARRAY_LENGTH];
    }

    public CustomArrayList(int length) {
        if (length <= -1) {
            throw new ArrayIndexOutOfBoundsException("定义时范围越界");
        }
        obj = new Object[length];
    }

    public void add(E element) {
        if (size >= obj.length) {
            Object[] newObj = new Object[obj.length + (ARRAY_LENGTH >> 2)];
            System.arraycopy(obj, 0, newObj, 0, obj.length);
            obj = newObj;
        }
        obj[size++] = element;
    }

    public E get(int index) {
        if (index < -1 || index > obj.length) {
            throw new ArrayIndexOutOfBoundsException("获取的下标超过了数组的下标");
        }
        return (E) obj[index];
    }

    public String toStringOne() {
        StringBuffer builder = new StringBuffer();
        builder.append("[");
        for (int i = 0; i < obj.length; i++) {
            builder.append(obj[i] + ",");
        }
        builder.setCharAt(builder.length() - 1, ']');
        return builder.toString();
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int size() {
        return size;
    }

    public void remove(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(obj[i])) {
                remove(i);
            }
        }

    }

    public String remove(int index) {
        int end = obj.length - 1 - index;
        System.arraycopy(obj, index + 1, obj, index, end);
        obj[--size] = null;
       return Arrays.toString(obj);
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        for (int i = 0; i < 20; i++) {
            customArrayList.add(i);
        }
        System.out.println(customArrayList.toStringOne());
//        customArrayList.remove(2);

//        System.out.println(customArrayList.size());
//        System.out.println();
        customArrayList.remove(19);
        System.out.println(customArrayList.toStringOne());

    }
}
