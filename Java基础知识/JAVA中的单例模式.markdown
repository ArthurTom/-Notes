# JAVA的几种单例模式
## 懒汉式
  1. 线程不安全（未加锁,不支持多线程）

  ```
  public class Singleton{
    private static Sinleton instance;
    private Singleton(){}
    public static Sinleton getInstance(){
      if(instance==null){
        instance=new Sinleton();
      }
      return instance;
    }
  }
  ```

  2.线程安全（加锁，支持多线程，效率低）
  ```
  private class Singleton{
    private static Sinleton instance;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
     if(instance==null){
       instance=new Sinleton();
     }
     return instance;
    }
  }
  ```
## 饿汉式
1. 多线程安全（产生垃圾对象）
   ```
   public class Singeton{
     private static Singleton instance=new Singeton();
     privae Singeton(){}
       public static Singleton getInstance(){
         return instance;
       }
   }
   ```
2.双重校验锁（加双重锁）
```
public class Singeton{
  private volatile static Singeton Singeton;
  private Singeton(){}
  public static Singeton getInstance(){
    if(Singeton==null){
      synchronized(Singeton.class){
        if(Singeton==null){
          Singeton=new Singeton();
        }
      }
      return Singeton;
    }
  }
}
````
3.静态内部类（）
```
public class Singleton{
  private static class SingletonHolder{
    private static final Singleton  instance=new Singleton();
  }
  private Singleton(){}
  public static final Singleton getInstance(){
    return SingletonHolder.instance;
  }
}
```

总结：不建议使用第1种、第2种懒汉模式。建议使用第三种饿汉模式。
