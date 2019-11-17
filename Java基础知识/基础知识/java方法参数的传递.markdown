#### Java传参
#### 结论
  1. 如果参数是<Strong>基本类型</Strong>，Java方法参数传递的是基本类型值的拷贝。
  2. 如果参数是<Strong>引用类型</Strong>，Java传递的是所引用的对象在堆中地址值的拷贝

#### 什么是基本类型和引用类型
1. 基本类型：JAVA八种基本类型：byte、short、int、long、float、double、boolean、char
2. 引用类型:对象(包括String)和数组

#### 典型的实例代码
```
public class Person {
    public Person() {}

    private String name = "小亮";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


```
```
public class Costom {

    public static void main(String[] arg) {
        int originValue = 1;
        String originString = "最初的值";

        Costom costom = new Costom();
        //--------------------------类型1----------------------------------------
        costom.methodA(originValue);
        System.out.println("在方法中更改了形参的值后，实参的值:" + originValue);
        //--------------------------类型2----------------------------------------
        costom.methodB(originString);
        System.out.println("调用完methodB方法后，originString的值---:" + originString);
        //--------------------------类型3----------------------------------------
        Person person = new Person();
        System.out.println("-----C前------hashcode-----:" + person.hashCode()
                + "--------C后----------name值：" + person.getName());
        costom.methodC(person);
        System.out.println("-------C后--------hashcode-----:" + person.hashCode()
                + "name值----:" + person.getName());
        //--------------------------类型4----------------------------------------
        System.out.println("-----D前-------" + person.hashCode() + "------" + person.getName());
        costom.methodD(person);
        System.out.println("-----D后-------" + person.hashCode() + "------" + person.getName());

    }


    private void methodA(int formalP) {
        formalP = 2;
        System.out.println("------A后------:" + formalP);

    }

    private void methodB(String formalP) {
        System.out.println("-----B-------前------:" + formalP.hashCode()
                + "----值：---：" + formalP);
        formalP = "methodB";
        System.out.println("-----B-------后------:" + formalP.hashCode()
                + "----值：---:" + formalP);
    }

    private void methodC(Person person) {
        System.out.println("---------C--------前---------hashCode值----:" + person.hashCode()
                + "------name------" + person.getName());
        person = new Person();
        person.setName("小明");
        System.out.println("---------C--------后----------hashCode值----:" + person.hashCode()
                + "------name------" + person.getName());
    }

    private void methodD(Person person) {
        System.out.println("------D-----前-------person的hashCode:"
                + person.hashCode() + "---------name-------------:"
                + person.getName());
        person.setName("小明");
        System.out.println("------D-----后-------person的hashCode:"
                + person.hashCode() + "--------name--------------" + person.getName());
    }
}

```

#### 输出结果
```
------A后------:2
在方法中更改了形参的值后，实参的值:1
-----B-------前------:806691349----值：---：最初的值
-----B-------后------:955534209----值：---:methodB
调用完methodB方法后，originString的值---:最初的值
-----C前------hashcode-----:1637070917--------C后----------name值：小亮
---------C--------前---------hashCode值----:1637070917------name------小亮
---------C--------后----------hashCode值----:780237624------name------小明
-------C后--------hashcode-----:1637070917name值----:小亮
-----D前-------1637070917------小亮
------D-----前-------person的hashCode:1637070917---------name-------------:小亮
------D-----后-------person的hashCode:1637070917--------name--------------小明
-----D后-------1637070917------小明
```
#### 其他概念的个人理解：
1. 堆（Heap）:用于存放Java对象的内存区域。（new Object() 和数组）
2. 栈（Stack）：存放一些基本数据类型的变量（八种基本数据类型）和对象的引用（Obeject a=new Object()中的a）
3. 形参：方法中的参数。如:method(A a) 中A a 就是形参。
4. 实参：调用方法传入的参数。如：xx.method(new A()) 这里:new A()是实参。
#### 具体理解
 <Strong>类型1</Strong>：实参(originValue)是基本数据类型，形参(formalP)仅仅是实参的copy的副本。在方法中改变形参的值，并不会改变实参(originValue)的值。</br>
原因：我们都知道定义基本数据类型（originValue）存放到栈中，调用methodA(int formalP)方法，传递过来的copy副本（形参formalP）相当于在栈中心新开辟的一块内存。随着methodA()方法的结束 ，这块内存会被销毁。</br>
<Strong>类型2</Strong>:本质讲：类型2和类型3是同一种类型。为什么囊 ？
就是因为formalP="xxx"这种赋值方式其实是分两步:

 1. new String("xxx")  创建一个对象;
 2. formalP= 指向这个新String对象.

 这和类型3中person=new Person()没有本质的区别。</br>
 原因：类型2和类型3 就是上面说的传引用类型。String originString = "最初的值";中"最初的值"相当于新new 了一个String()对象，所以它应该存储在堆中；而String originString 指向堆中的这个对象，存储了它的地址，我们知道originstring应该存放到栈内存中。那么调用methodB(String formalP)方法，其实就是将指向堆中的对象的地址值copy一份副本传给形参。方法methodB(String formalP)中，形参originstring接受到值后，在栈中从新开辟一块，存放这个地址。此时，栈中有两块内存，同时指向堆中的对象(前提是方法的生命周期仍在)。我们看methodB(String formalP)方法中，formalP = "methodB"这代码，不就是相当于，将形参的创建的临时栈的指向，指向了在堆中新创建的对象:"methodB"这个对象吗。我们所做的修改仅仅是在新的对象中进行的，在methodB(String formalP)生命周期结束的时候，形参创建的临时栈的销毁。所以，由于原来originString的指向未被修改，所以其指向的堆中的对象的值不改变。</br>
 <Strong>类型3</Strong>:同上，原理相同,仅仅多了set方法。</br>
 <Strong>类型4</Strong>: 这种情况， 如果你搞懂了类型2和类型3自然而然你也就懂了。形参中存放了在堆中对象的地址，通过这个地址我们可以访问堆中的对象，并对他进行修改。随着methodD()的生命周期的结束 ，栈中临时开辟的空间被收回，但是堆中的对象的数值已经被修改了。
