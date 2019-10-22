#### Builder模式
##### 定义
- product产品类（抽象类，下面的实例未使用抽象类）
- Builder构建类（抽象构建类，制定构建的一些方法）
- ConcreateBuilder(具体构建类,实例化产品类，重写构建方法，新建一个方法：返回产品类)
- Director (具体构造)

##### uml类图
![](https://github.com/ArthurTom/-Notes/raw/master/Java%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86/%E5%9B%BE%E7%89%87%E4%BB%93%E5%BA%93/%E6%9E%84%E5%BB%BA%E8%80%85Builder%E6%A8%A1%E5%BC%8F.png)

##### 代码
- product类


```
/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:24
 * 功能：产品类--电脑一些组成属性
 */
public class Computer {
	private String host; // 主机
	private String display; // 显示器
	private String OS; // 系统

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String OS) {
		this.OS = OS;
	}

	@Override
	public String toString() {
		return "Computer{" +
				"host='" + host + '\'' +
				", display='" + display + '\'' +
				", OS='" + OS + '\'' +
				'}';
	}
}
```

- Builder 抽象类

```
/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:16
 * 功能：抽象类--声明组装电脑的一些方法，由子类实现
 */
public abstract class ComputerBuilder {
	public abstract void buildHost(); // 组装主机

	public abstract void buildDisplay();// 组装显示器

	public abstract void buildOS();// 安装系统

	public abstract Computer build();
}

```
- 具体builder类

```
/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:26
 * 功能：window类型的电脑--继承ComputerBuilder实现组装电脑的方法
 */
public class WindowComputerBuilder extends ComputerBuilder {

	private Computer computer;

	public WindowComputerBuilder() {
		computer = new Computer();
	}

	@Override
	public void buildHost() {
		computer.setHost("组装个联想主机");
	}

	@Override
	public void buildDisplay() {
		computer.setDisplay("组装个联想显示器");
	}

	@Override
	public void buildOS() {
		computer.setOS("组装个联想的操作系统");
	}

	@Override
	public Computer build() {
		return computer;
	}
}
```
- Director 指挥者类

```
/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:32
 * 功能：统一组装电脑
 */
public class Director {
	private ComputerBuilder builder;

	public Director(ComputerBuilder builder) {
		this.builder = builder;
	}

	/**
	 * 组装电脑的步骤
	 */
	public Computer constract() {
		builder.buildHost();
		builder.buildDisplay();
		builder.buildOS();
		return builder.build();
	}
}

```
- 程序入口，构建

```
/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:37
 * 功能：程序的入口
 */
public class StartMain {
	public static void main(String[] args) {
		ComputerBuilder builder = new WindowComputerBuilder();
		Director director = new Director(builder);
		Computer computer = director.constract();
		System.out.println("打印初始化的computer的信息:" + computer.toString());
	}
}

```
##### 源码
[Builder模式源码demo](https://github.com/ArthurTom/-Notes/tree/master/%E5%AD%A6%E4%B9%A0%E6%BA%90%E7%A0%81/BuilderMode)
