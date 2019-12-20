import java.util.ArrayList;

public class CustomHashMap<K, V> {
    /*
     * hashMap中的节点
     * hash: 哈希值
     * key：键值
     * value:具体值
     * */
    class HashMapNode<K, V> {
        private int hash;
        private K key;
        private V value;
        private HashMapNode<K, V> nextNode;

        public HashMapNode() {
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public HashMapNode<K, V> getNextNode() {
            return nextNode;
        }

        public void setNextNode(HashMapNode<K, V> nextNode) {
            this.nextNode = nextNode;
        }
    }

    /*-------------------------------------------------------------------------------------------------------------------*/
    HashMapNode[] table; // 数组
    int size; // 存放的键值对的个数
    static final int defaultTableLength = 16; // 数组的默认的长度

    public CustomHashMap() {
        table = new HashMapNode[defaultTableLength];
    }

    /*
     * 存入数据
     * */
    public void put(K key, V value) {
        HashMapNode node = new HashMapNode();
        int hash = getHashCode(key, table.length); // 0--15 之间
        node.setHash(hash);
        node.setKey(key);
        node.setValue(value);
        node.setNextNode(null);

        HashMapNode temp = table[hash];
        HashMapNode lastNode = null; // 保存最后一个节点
        if (temp == null) { // 数组table[i]为空的时候，直接将数据放入
            table[hash] = node;
        } else { // 数组table[i]不为空的时候，将数据拼接到上一个node后面


            while (temp != null) {
                // Key相同，覆盖
                if (temp.getKey().equals(node.getKey())) {
//                    System.out.println("key重复了");
                    temp.setValue(node.getValue());
                    return;
                } else {
                    // key不同，拼接在后面
//                    System.out.println("key不重复，拼接在最后面");
                    lastNode = temp; // 更新最后一个节点
                    temp = temp.getNextNode();
                }
            }
            lastNode.nextNode = node;
        }
        size++;
    }

    /*
     * 获取key的hashCode值，与运算，返回值在数组中的位置
     * */
    public int getHashCode(K key, int tableLength) {
//        System.out.println(key.hashCode() & (tableLength - 1));
        return key.hashCode() & (tableLength - 1);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
//            HashMapNode node = table[i];
//            if (node != null) {
//                builder.append(node.getKey() + "" + node
//                        .getValue() + ",");
//                HashMapNode temp = node.getNextNode();
//                while (temp != null) {
//                    builder.append(temp.getKey() + ":" + temp.getValue() + ",");
//                    temp = temp.getNextNode();
//                }
//            }

            HashMapNode temp = table[i];
            while (temp != null) {
                builder.append("数字组：" + i + ":" + temp.getKey() + "" + temp
                        .getValue() + ",");
                temp = temp.getNextNode();
            }
        }
        return builder.toString();
    }

    /*
     *  根据key值返回具体的value值
     * */
    public V get(K key) {
        int hashValue = getHashCode(key, table.length);
        HashMapNode node = table[hashValue];
        while (node != null) {
            if (node.getKey() == key) {
                return (V) node.getValue();
            } else {
                node = node.nextNode;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CustomHashMap<Integer, String> hashMap = new CustomHashMap<>();
        hashMap.put(1, "数字1");
        hashMap.put(2, "数字2");
        hashMap.put(3, "数字3");
        hashMap.put(2, "新数字2");
        hashMap.put(4, "数字4");
        hashMap.put(16, "数字16");
        hashMap.put(17, "数字17");
        hashMap.put(18, "数字18");
        hashMap.put(19, "数字19");

        System.out.println(hashMap.toString());

        System.out.println(hashMap.get(18));
        System.out.println(hashMap.size);

    }
}
