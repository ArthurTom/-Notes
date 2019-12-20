
#### 同步线程锁Synchronized的两种类型（一）
##### 一、同步方法

 格式：
 1. public synchronized void method()
 2. synchronized public void method()

作用:
 解决实例变量非线程安全问题(啥意识:我也不懂这特么的名词)

  - 线程安全:多个线程共同操作一个"对象"中的实例变量（加个链接，解释实例变量），都可以获取正确的结果。
  - 非线程安全：就是获取不到正确的结果呗。


通俗的讲：在没有发明火车购票系统之前每个城市有多个车票购置窗口（假设窗口之间通过电话进行通知票的剩余情况），某天的同一时刻不同地点的购票窗口，A、B、C三人同时要购买上海站-北京站的车票，不巧的是当天只剩一张车票。但结果是三人都买到了同一张票。显然不符合正常的结果，显然属于非线程安全。
  - 车票： 仅剩的这张上海站-北京站的火车票就是具体的对象
  - A、B、C: 三人购票相当于三个线程
  - 车票的数量一张：就是一个实例变量


假设代码：
```
/*
 * 多个火车票售卖窗口都是一样的
 * */
public class TrainTicketSellingWindow {
    private int i = 1;

    public void sellTicket() throws InterruptedException {
        System.out.println("开始售卖车票仅存的这张车票:"+i);
        i--;
    }
}

```
```
public class Run {
    public static void main(String[] args) {
        TrainTicketSellingWindow window = new TrainTicketSellingWindow();
        PersonA personA = new PersonA(window);
        PersonB personB = new PersonB(window);
        PersonC personC = new PersonC(window);

        Thread personAThread = new Thread(personA);
        Thread personBThread = new Thread(personB);
        Thread personCThread = new Thread(personC);

        personAThread.start();
        personBThread.start();
        personCThread.start();
    }
}

```
```
public class PersonC implements Runnable {
    private TrainTicketSellingWindow window;

    public PersonC(TrainTicketSellingWindow window) {
        this.window = window;
    }

    @Override
    public void run() {
        try {
            window.sellTicket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

```
```
public class PersonB implements Runnable {
    private TrainTicketSellingWindow window;

    public PersonB(TrainTicketSellingWindow window) {
        this.window = window;
    }

    @Override
    public void run() {
        try {
            window.sellTicket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
```
public class PersonA implements Runnable {
    private TrainTicketSellingWindow window;

    public PersonA(TrainTicketSellingWindow window) {
        this.window = window;
    }

    @Override
    public void run() {
        try {
            window.sellTicket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

```
输出结果：
```
Test03.PersonC购买到了仅存的这张车票:1
Test03.PersonA购买到了仅存的这张车票:1
Test03.PersonB购买到了仅存的这张车票:1
```
出现这种情况的两个个原因：
1. 同时购买 （多线程异步的执行操作）
2. 不同的地点购票窗口各自的工作互不交流(被动的听通知)，当某一个人正在购买时，没有办法查询此时是否有他人正在购买这张车票。（某一线程操作操作对象的实例变量的时候，系统未设置保护机制防止其他线程操作这个对象中实例变量）

改良后的代码：
```
/*
 * 多个火车票售卖窗口都是一样的
 * 普通方法改变成同步方法
 * */
public class TrainTicketSellingWindow {
    private int i = 1;

     public synchronized void sellTicket(String personName) throws InterruptedException {
        System.out.println(personName+"购买到了仅存的这张车票:" + i);
        i--;
    }
}


```
输出结果：
```
Test03.PersonA购买到了仅存的这张车票:1
Test03.PersonC购买到了仅存的这张车票:0
Test03.PersonB购买到了仅存的这张车票:-1
```
<Strong>总结一:</Strong> 多个线程访问同一个对象中的同一同步方法（方法加synchromized）时，一定是线程安全的（结果正确）。
##### 多线程访问同一对象的同步方法和普通方法
```
public class Run {
    public static void main(String[] args) {
        MultipleMethods multipleMethods = new MultipleMethods();
        DogA dogA = new DogA(multipleMethods);
        DogB dogB = new DogB(multipleMethods);

        Thread threadA = new Thread(dogA);
        Thread threadB = new Thread(dogB);

        threadA.start();
        threadB.start();
    }
}
```
```
/*
* methodA同步方法
* methodB普通方法
* */
public class MultipleMethods {

    public synchronized void methodA(String name) throws InterruptedException {
     System.out.println(name+"调用了methodA-"+System.currentTimeMillis());
     Thread.sleep(5000);
    }

    public  void methodB(String name) {
        System.out.println(name+"调用了methodB-"+System.currentTimeMillis());

    }
}

```
```
public class DogA implements Runnable {
    MultipleMethods methods;
    DogA(MultipleMethods methods){
        this.methods=methods;
    }
    @Override
    public void run() {
        try {
            methods.methodA(this.getClass().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
```
public class DogB implements Runnable {
    MultipleMethods methods;

    DogB(MultipleMethods methods) {
        this.methods = methods;
    }

    @Override
    public void run() {
        methods.methodB(this.getClass().getName());
    }
}
```
结果：
```
Test04.DogB调用了methodB-1574230545850
Test04.DogA调用了methodA-1574230545850
```
结果DogA和DogB顺序随机。代码中ThreadA 和ThreadB的start顺序，如果是同步访问，则ThreadA应该先打印，而这里相反，所以这里是异步的。

<Strong>结论2:</Strong> 多线程访问同一个对象的方法，同步方法被某个线程使用的，其他的线程可以异步的访问这个对象中普通的方法。


##### 多线程访问同一对象的多个同步方法
对上面代码做简单的修改:
```
/*
* methodA同步方法
* methodB同步方法
* */
public class MultipleMethods {

    public synchronized void methodA(String name) throws InterruptedException {
     System.out.println(name+"调用了methodA-"+System.currentTimeMillis());
     Thread.sleep(50000);
    }

    public  synchronized void methodB(String name) {
        System.out.println(name+"调用了methodB-"+System.currentTimeMillis());

    }
}

```
```

public class Run {
    public static void main(String[] args) {
        MultipleMethods multipleMethods = new MultipleMethods();
        DogA dogA = new DogA(multipleMethods);
        DogB dogB = new DogB(multipleMethods);

        Thread threadA = new Thread(dogA);
        Thread threadB = new Thread(dogB);

        threadA.start();
        threadB.start();
    }
}

```
结果：
```
Test04.DogA调用了methodA-1574231536128
Test04.DogB调用了methodB-1574231586151
```
methodA 休眠50秒，打印结果是先打印DogA 然后打印DodB，他们两个的时间差》50秒，所以他们肯定是同步的执行。

<Strong>结论3:</Strong> 多线程访问同一个对象的方法，假若此对象有多个同步方法，其种一个线程访问其同步方法，其他线程只有等这个线程执行完后释放锁后，才能按照顺序同步的访问其他的同步方法。

##### 锁重入和锁的不继承

<Strong>结论4：</Strong> 一个类中有多个同步方法，一个线程持有这个对象锁，synchronized方法内部可以调用这个对象的其他的synchronized方法。（避免了死锁）
<Strong>结论5:</Strong> 存在父子继承关系，子类同步方法可以调用父类的同步方法（锁重入）
<Strong>结论6：</Strong> 存在父子继承关系，父类的同步方法不会遗传给子类，除非子类重写之时使用synchronized，否者子类方法仍是普通的方法。



如果多个线程访问同一类的不同实例时，结果会是怎么样？

##### 多线程访问同一类的不同实例
    改良代码的基础上，我们仅需做如下改变:
```
public class Run {

    public static void main(String[] args) {
        TrainTicketSellingWindow windowA = new TrainTicketSellingWindow();
        TrainTicketSellingWindow windowB = new TrainTicketSellingWindow();
        TrainTicketSellingWindow windowC = new TrainTicketSellingWindow();

        PersonA personA = new PersonA(windowA);
        PersonB personB = new PersonB(windowB);
        PersonC personC = new PersonC(windowC);

        Thread personAThread = new Thread(personA);
        Thread personBThread = new Thread(personB);
        Thread personCThread = new Thread(personC);

        personAThread.start();
        personBThread.start();
        personCThread.start();
    }
}
```
输出结果
```
Test03.PersonB购买到了仅存的这张车票:1
Test03.PersonA购买到了仅存的这张车票:1
Test03.PersonC购买到了仅存的这张车票:1
```
尽管我们为sellTicket 方法加入了synchroized变成了同步方法，但是我们却得到错误的数据。why ?

主要原因是：synchronized 不是将一段代码或者一个方法作为一个锁，而是对对象的锁。

这里实例了多个TrainTicketSellingWindow()对象，多个线程访问这些对象，jvm会为每个对象创建一个锁，每个线程访问一个对象的同步方法获取的锁对象不同，所以他们是异步操作的。

<Strong>结论5：</Strong> 多个线程访问同一个类不同的实例的相同名称的同步方法，程序会以异步的方式运行。

##### 静态同步方法
格式：

1. public synchronized static void method(){}
2. synchronized public static void method(){}

此种方式是给静态方法所在的类上锁。

<Strong>结论5：</Strong> 一个类有多个静态同步方法，多个线程访问这些静态同步方法(Class.xx())，由于锁是对类进行加锁，所以多线程访问是同步的，必须一个线程访问完一个同步方法，才能开始下一个线程。
<Strong>结论6：</Strong>一个类有多个静态同步方法，静态同步方法的锁（类锁）可以对所有的实例起作用。也就是说：所有的实例对象，调用静态同步方法都是同步的。
