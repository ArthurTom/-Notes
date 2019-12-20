import java.util.LinkedList;
import java.util.Map;

public class CustomLinkList<E> {
    class Node {
        Node preNode; // 上一个节点
        Node nextNode; // 下一个节点
        E element; // 节点内容

        public Node(E obj) {
            this.element = obj;
        }

        public Node(Node preNode, Node nextNode, E element) {
            this.preNode = preNode;
            this.nextNode = nextNode;
            this.element = element;
        }
    }

    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    /*
     * 在尾巴新增node
     * */
    public void add(E obj) {
        Node node = new Node(obj);
        if (firstNode == null) { // 首次添加
            firstNode = node;
            lastNode = node;
        } else {
            node.preNode = lastNode;
            node.nextNode = null;

            lastNode.nextNode = node;
            lastNode = node;
        }
        size++;
    }

    /*
     * 返回指定索引的对象
     * */
    public E get(int index) {
        if (index < -1 || index > size) {
            throw new IndexOutOfBoundsException("输入的下标越界");
        }
        Node temp = null;
        if (index < (size >> 1)) {
            temp = firstNode;
            for (int i = 0; i < index; i++) {
                temp = temp.nextNode;
            }
        } else {
            temp = lastNode;
            for (int i = size - 1; i > index; i--) {
                temp = temp.preNode;
            }
        }


        return (E) temp.element;
    }

    /*
     * 删除指定索引
     * */

    public void remove(int index) {
        Node node = getNode(index);

        if (index == 0) {
            firstNode = node.nextNode;
            firstNode.preNode = null;
        } else if (index == size - 1) {
            lastNode = node.preNode;
            lastNode.nextNode = null;
        } else {
            node.nextNode.preNode = node.preNode;
            node.preNode.nextNode = node.nextNode;
        }
        size--;
    }

    /*
     * 获取指定索引位置的对象
     * */
    private Node getNode(int index) {
        if (index < -1 || index > size) {
            throw new IndexOutOfBoundsException("输入的下标越界");
        }
        Node temp = null;
        if (index < size >> 1) {
            temp = firstNode;
            for (int i = 0; i < index; i++) {
                temp = temp.nextNode;
            }
        } else {
            temp = lastNode;
            for (int i = size - 1; i > index; i--) {
                temp = temp.preNode;
            }
        }


        return temp;
    }

    /*
     * 在指定的位置插入元素
     * */
    public void insert(int index, E element) {
        Node node = new Node(element);
        Node indexNode = getNode(index);

        if (index == 0) {
            firstNode = node;
            firstNode.nextNode = indexNode;
            indexNode.preNode = node;
            firstNode.preNode = null;
        } else if (index == size - 1) {
            lastNode = node;
            lastNode.nextNode = null;
            lastNode.preNode = indexNode;
            indexNode.nextNode = node;
        } else {
            node.preNode = indexNode.preNode;
            node.nextNode = indexNode.preNode.nextNode;
            indexNode.preNode.nextNode = node;
            indexNode.preNode = node;
        }
        size++;
    }

    /*
     * 打印数据
     * */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
//        builder.append("[");
        Node temp = firstNode;
        while (temp != null) {
            sb.append(temp.element + ",");
            temp = temp.nextNode;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomLinkList<String> customLinkList = new CustomLinkList<String>();
        customLinkList.add("a");
        customLinkList.add("b");
        customLinkList.add("c");
        customLinkList.add("d");
        customLinkList.add("e");
        customLinkList.add("f");
        customLinkList.add("g");
        System.out.println(customLinkList);

        System.out.println(customLinkList.get(1));

//        customLinkList.remove(0);
//        customLinkList.remove(6);
//        System.out.println(customLinkList.toString());

        customLinkList.insert(2, "1");
        System.out.println(customLinkList.toString());
    }
}
