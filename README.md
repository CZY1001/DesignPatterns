# 设计模式学习

> 设计模式是内功，不是看一遍就能会的，需要不断大量的去写，大量的去实践，才能彻底理解透他的思想

## 设计模式原则

> **1、开闭原则（Open Close Principle）**
>
> 开闭原则的意思是：**对扩展开放，对修改关闭**。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简言之，是为了使程序的扩展性好，易于维护和升级。想要达到这样的效果，我们需要使用接口和抽象类，后面的具体设计中我们会提到这点。
>
> **2、里氏代换原则（Liskov Substitution Principle）**
>
> 里氏代换原则是面向对象设计的基本原则之一。 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。LSP 是继承复用的基石，只有当派生类可以替换掉基类，且软件单位的功能不受到影响时，基类才能真正被复用，而派生类也能够在基类的基础上增加新的行为。里氏代换原则是对开闭原则的补充。实现开闭原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。
>
> **3、依赖倒转原则（Dependence Inversion Principle）**
>
> 这个原则是开闭原则的基础，具体内容：针对接口编程，依赖于抽象而不依赖于具体。
>
> **4、接口隔离原则（Interface Segregation Principle）**
>
> 这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。它还有另外一个意思是：降低类之间的耦合度。由此可见，其实设计模式就是从大型软件架构出发、便于升级和维护的软件设计思想，它强调降低依赖，降低耦合。
>
> **5、迪米特法则，又称最少知道原则（Demeter Principle）**
>
> 最少知道原则是指：一个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立。
>
> 只与你直接的朋友通信，而避免和陌生人通信
>
> **6、合成复用原则（Composite Reuse Principle）**
>
> 合成复用原则是指：尽量使用合成/聚合的方式，而不是使用继承。



![image-20230506094333159](C:\Users\18750\AppData\Roaming\Typora\typora-user-images\image-20230506094333159.png)

## 创建者模式

> 这些设计模式提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象。这使得程序在判断针对某个给定实例需要创建哪些对象时更加灵活。

### *1.单例模式

> 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
>
> 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象
>
> 说人话就是，不要自己new对象



#### 1.饿汉式

```java
/**
 * mgr01
 *  饿汉式
 *  类加载到内存之后，就直接实例化一个单例对象，jvm可以保证线程安全
 *  简单、没有加锁，执行效率会提高
 *  缺点：不管是否用到这个，类加载的时候就直接实例化这个对象
 * @author czy
 * @date 2023/5/2
 */
public class mgr01 {

    private static final mgr01 INSTANCE = new mgr01();

    private mgr01() {}

    public static mgr01 getInstance(){
        return INSTANCE;
    }
}
```

#### 2.懒汉式-线程不安全的

```java
/**
 * mgr02
 * 懒汉式
 * 因为没有加锁，会有线程安全问题
 * @author czy
 * @date 2023/5/2
 */
public class mgr02 {
    private static  mgr02 INSTANCE;
    private mgr02(){}
    public static  mgr02 getInstance (){
        if (INSTANCE == null) {
            INSTANCE= new mgr02();
        }
        return INSTANCE;
    }
}
```

#### 3.懒汉式-线程安全

```java
/**
 * mgr02
 * 懒汉式
 * 加了锁，但是加在了方法上面，导致效率非常垃圾
 * @author czy
 * @date 2023/5/2
 */
public class mgr02 {
    private static  mgr02 INSTANCE;
    private mgr02(){}
    public static synchronized mgr02 getInstance (){
        if (INSTANCE == null) {
            INSTANCE= new mgr02();
        }
        return INSTANCE;
    }
}
```

#### 4.双重检索DCL

```java
/**
 * mgr03
 * 双重检索DCL 线程安全，在多线程下可以保持性能良好 因为锁的是对象不是方法
 * @author czy
 * @date 2023/5/2
 */
public class mgr03 {
    private volatile static mgr03  INSTANCE;

    private mgr03() {}

    public static mgr03 getInstance() {
        if (INSTANCE == null) {
            synchronized (mgr03.class) {
                if (INSTANCE == null) {
                    INSTANCE = new mgr03();
                }
            }

        }
        return INSTANCE;
    }
}
```

#### 5.静态内部类

```java
/**
 * mgr04
 * 静态内部类的方式
 *
 * 这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，
 * 应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 *
 *
 * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，它跟饿汉式不同的是：
 * 饿汉式只要 Singleton 类被装载了，那么 instance 就会被实例化（没有达到 lazy loading 效果），
 * 而这种方式是 Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，
 * 只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。想象一下，
 * 如果实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，
 * 因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，
 * 那么这个时候实例化 instance 显然是不合适的。这个时候，这种方式相比饿汉式就显得很合理。
 *
 * @author czy
 * @date 2023/5/2
 */
public class mgr04 {
    private static class Singleton{
        private static final Singleton INSTANCE = new Singleton();
    }
    private mgr04() {}
    public static Singleton getInstance(){
        return Singleton.INSTANCE;
    }
}
```

#### 6.枚举式

```java
/**
 * mgr05
 *枚举式
 *
 * 这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
 * 这种方式是 Effective Java 作者提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，
 * 防止反序列化重新创建新的对象，绝对防止多次实例化。不过，由于 JDK1.5 之后才加入 enum 特性，用这种方式写不免让人感觉生疏，在实际工作中，也很少用。
 * 不能通过 reflection attack 来调用私有构造方法。
 * @author czy
 * @date 2023/5/2
 */
public enum mgr05 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(mgr05.INSTANCE.hashCode());
            }).start();
        }
    }
}
```

### *2.工厂模式

> 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
>
> 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象
>
> 实例化对象不使用new，用工厂方法代替、
>
> 简单来说就是 创建者 和使用者分离、调用者和实现类解耦

#### 1.简单工厂模式

```java
/**
 * CarFactory
 * 工厂模式，创建对象
 弊端 新加一个类的时候， 工厂方法也必须要跟着一起改
 无法满足开闭原则
 * @author czy
 * @date 2023/5/9
 */
public class CarFactory {
    public static Car getCarFactory(String car){
        if (StringUtils.isNotBlank(car)){
            if (car.equals("wulin")){
                return new wuling();
            }else if (car.equals("tesila")) {
                return new tesila();
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
```

####  2.工厂方法模式

符合设计原则，但是实现起来过于繁琐

有抽象类提取对象公共的属性，有抽象工厂提供抽象的构建方法，每个对象有自己对应的抽象工厂实现类

使用的时候，根据不同情况来new 目标类的工厂对象 并调取工厂对象的  目标类构建方法来进行目标类的构建

根据实际业务，一般会选择简单工厂模式

![image-20230509164135084](C:\Users\18750\AppData\Roaming\Typora\typora-user-images\image-20230509164135084.png)

#### 3.抽象工厂模式

每个产品     有自己横向的抽象类 ，和纵向的系列产品   ，例如，小米手机  既属于  手机的抽象类，  也属于小米系列

提供抽象工厂     每个系列有自己的工厂实现类

调用者在调用的时候，只需要new出对应系列的工厂实现类，调用目标对象的生产方法，就可以获取到目标对象

![image-20230518163206794](C:\Users\18750\AppData\Roaming\Typora\typora-user-images\image-20230518163206794.png)

![image-20230518171819946](C:\Users\18750\AppData\Roaming\Typora\typora-user-images\image-20230518171819946.png)

### *3.建造者模式

使用多个简单的对象一步一步构建成一个复杂的对象。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。



#### 1.builder模式的常规用法

领导类在这个模式里有很重要的作用，用于指导构建者如何去构建产品，控制调用先后顺序，返回完整的产品类

个人理解，提供抽象类 来决定有哪些属性需要构造，工人实现类提供实际的属性构造方法，领导类来决定  工人类各属性的执行顺序

我可以放入不同的工人类来构造不同的属性，也可以修改领导类来改变具体的属性构造

初始目标类

```java
/**
 * Product
 *
 * @author czy
 * @date 2023/5/18
 */
public   class Product {
    private  String buildA;
    private  String buildB;
    private  String buildC;

    @Override
    public String toString() {
        return "Product{" +
                "buildA='" + buildA + '\'' +
                ", buildB='" + buildB + '\'' +
                ", buildC='" + buildC + '\'' +
                ", buildD='" + buildD + '\'' +
                '}';
    }

    public String getBuildA() {
        return buildA;
    }

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public String getBuildB() {
        return buildB;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public String getBuildC() {
        return buildC;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public String getBuildD() {
        return buildD;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }

    private  String buildD;

}
```



建造者抽象类

```java
/**
 * Builder
 *抽象的建造者方法
 * @author czy
 * @date 2023/5/18
 */

public abstract class Builder {
    abstract void buildA();
    abstract void buildB();
    abstract void buildC();
    abstract void buildD();

    abstract Product getProduct();
}
```



建造者抽象实现类  --工人

```java
/**
 * worker
 *  工人
 * @author czy
 * @date 2023/5/18
 */
public class worker extends Builder{
    private  Product product;
    public worker(){
        this.product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("地基");
        System.out.println("地基");
    }

    @Override
    void buildB() {
        product.setBuildB("钢筋");
        System.out.println("钢筋");
    }

    @Override
    void buildC() {
        product.setBuildC("电线");
        System.out.println("电线");
    }

    @Override
    void buildD() {
        product.setBuildD("刷墙");
        System.out.println("刷墙");
    }

    @Override
    Product getProduct() {
        return this.product;
    }
}
```



建造者指挥类  领导者

```java
/**
 * leader
 *  领导负责智慧构建 工程  如何构建 他来决定
 * @author czy
 * @date 2023/5/18
 */
public class leader {

    public  Product build(Builder builder){
        builder.buildA();
        builder.buildC();
        builder.buildB();

        builder.buildD();
        return builder.getProduct();
    }
}
```

实际调用者

```java
/**
 * test
 *
 * @author czy
 * @date 2023/5/21
 */
public class test {

    public static void main(String[] args) {
        //领导
        leader leader = new leader();
        //指挥工人完成产品
        Product build = leader.build(new worker());
        System.out.println(build.toString());
    }
}
```



#### 2.第二种方式

个人理解，目标类 属性提供了默认值，  抽象工人类抽象出需要构建的属性方法，

工人实现类负责在构造方法里new出目标类，并提供目标类get方法，还需要实现抽象工人类定义的各属性构建方法

调用者可以new 工人实现类 ，调用目标类的get方法来获取目标对象，也可以在new出工人实现类之后 调用属性的构建方法来对需要的属性进行自定义的构建并调用get方法来获取对象

可以使用对象的默认参数进行构建，也可以调用方法区自定义参数来进行构建

抽象的工人类

```java
/**
 * Builder
 *   我是一个抽象的工人
 * @author czy
 * @date 2023/5/21
 */
public abstract class Builder {
    abstract Builder buildA(String msg);
    abstract Builder buildB(String msg);
    abstract Builder buildC(String msg);
    abstract Builder buildD(String msg);
    abstract product getProduct();
}
```



工人类的实现类

```java
/**
 * work
 *  我是一个具体的工人
 * @author czy
 * @date 2023/5/21
 */
public class work extends Builder{

    private product product;

    public work() {
        product = new product();
    }

    @Override
    Builder buildA(String msg) {
        product.setBuildA(msg);
        return this;
    }

    @Override
    Builder buildB(String msg) {
        product.setBuildB(msg);
        return this;
    }

    @Override
    Builder buildC(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    Builder buildD(String msg) {
        product.setBuildD(msg);
        return this;
    }

    @Override
    product getProduct() {
        return product;
    }
}
```



目标对象  ，给定默认属性

```java
/**
 * product
 *  我是肯德基的套餐类
 * @author czy
 * @date 2023/5/21
 */
public class product {
    private String buildA = "我们现在是默认配置";
    private String buildB = "可乐";
    private String buildC = "炸鸡";
    private String buildD = "薯条";

    @Override
    public String toString() {
        return "product{" +
                "buildA='" + buildA + '\'' +
                ", buildB='" + buildB + '\'' +
                ", buildC='" + buildC + '\'' +
                ", buildD='" + buildD + '\'' +
                '}';
    }

    public String getBuildA() {
        return buildA;
    }

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public String getBuildB() {
        return buildB;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public String getBuildC() {
        return buildC;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public String getBuildD() {
        return buildD;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }
}
```

实际使用对象者

左边是默认构建的使用，右边是需要自定义的构建  

![image-20230521192845712](C:\Users\18750\AppData\Roaming\Typora\typora-user-images\image-20230521192845712.png)



### 4.原型模式

本质上就是深拷贝和浅拷贝

浅拷贝实现起来非常的简单，只需要这个类实现Cloneable接口，重写一下clone方法

####   1.浅克隆

```java
/**
 * Video
 *
 *
 * 原型模式    ----- 浅克隆
 * @author czy
 * @date 2023/5/23
 */
public class Video implements Cloneable{
    private String name;
    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }
    public Video(){
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
```



#### 2.深克隆

深克隆的实现方式有很多种，例如反序列化 、改造克隆方法(最简单的)  讲其引用类型的属性进行再次clone

```java
public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
        }
```



说白了其实就是对象的clone

```text
spring里面bean  的创建一般是单例模式创建，或者是由原型模式进行创建，减少资源开销
原型模式+工程模式    把原本工厂模式里面的new创建对象换成原型模式的方法创建对象
```



## 结构型模式

> 从程序的结构上实现松耦合，从而可以扩大正义的类结构，用来解决更大的问题



### *1.适配器模式

> 将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。



被适配的类

```java
/**
 * adaptee
 *  适配器模式    ----要被适配的类  网线
 * @author czy
 * @date 2023/5/23
 */
public class adaptee {

    public  void request(){
        System.out.println("连接网线上网");
    }
}
```





```java
/**
 * netToUsb
 *  转接器  抽象
 * @author czy
 * @date 2023/5/23
 */
public interface netToUsb {

    //处理请求
    void handleRequest();
}
```

适配器   对象适配器   组合实现

```java
/**
 * adapter
 *  真正的转接器
 *
 *	1 继承 （类适配器、单继承）  不推荐
 *  2 组合（对象适配器、常用）
 * @author czy
 * @date 2023/5/23
 */
public class adapter2  implements netToUsb{

    private  adaptee adaptee;
    public adapter2(adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void handleRequest() {
        adaptee.request();//可以上网了
    }
}
```



类适配器，继承实现 不推荐

```java
/**
 * adapter
 *  真正的转接器
 *
 *  1 继承 （类适配器、单继承）
 *  2 组合（对象适配器、常用）
 * @author czy
 * @date 2023/5/23
 */
public class adapter extends adaptee implements netToUsb{
    @Override
    public void handleRequest() {
        super.request();//可以上网了
    }
}
```



使用者

```java
/**
 * computer
 电脑类，我现在想要上网的功能
 * 适配器模式    ---- 客户端类
 * @author czy
 * @date 2023/5/23
 */
public class computer {
    public void  net(netToUsb adapter){
        //上网的具体实现，  需要一个转接
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        //电脑、适配器、网线----
        computer computer = new computer();//使用者   电脑
        adaptee adaptee = new adaptee();//网线

        adapter adapter = new adapter(adaptee);//转接器  类适配器的时候
        adapter2 adapter = new adapter2(adaptee);//转接器  对象适配器、常用


        computer.net(adapter);
    }
}
```



### *2.代理模式

> 和适配器模式的区别：适配器模式主要改变所考虑对象的接口，而代理模式不能改变所代理类的接口。 2、和装饰器模式的区别：装饰器模式为了增强功能，而代理模式是为了加以控制

#### 静态代理

抽象角色： 一般使用抽象类或者接口解决

真实角色：被代理的角色

代理角色：  代理真实角色额， 代理真实角色后、我们一般会坐一些附属操作

客户：实际访问对象的人



个人理解 ---- 房东和中介都实现了租房抽象类，因为我们两个都有一个目标，租房

房东实现了了租房子的具体方法，中介将房东当做属性，调用房东的租房方法，并执行一些自己的附加内容，进行租房子代理

我们想要实现租房，只需要去找中介就可以了



优点：可以使真实角色的操作更加纯粹、不用去关注一些公共的业务

公共也就代理、实现了业务的分工

公共业务发生扩展的时候、方便集中管理

缺点，一个房东就需要对应一个中介类，双倍代码

租房抽象类

```java
/**
 * Rent
 *  我现在是一个租房接口
 * @author czy
 * @date 2023/5/25
 */
public interface Rent {
    void rent();
}
```

房东， 接口实现类

```java
/**
 * fangdong
 *   我现在是一个房东
 * @author czy
 * @date 2023/5/25
 */
public class fangdong implements Rent{
    @Override
    public void rent() {
        System.out.println("我是房东    ------      我房子租出去了");
    }
}
```

中介，租房实现类，并代理房东类

```java
/**
 * prox
 *  我是一个中介
 * @author czy
 * @date 2023/5/25
 */
public class prox  implements Rent{
    private  fangdong from;
    public prox() {
    }
    public prox(fangdong from) {
        this.from = from;
    }

    @Override
    public void rent() {
        kanfang();
        hetong();
        from.rent();
        tuifang();
    }

    //看房的
    public void  kanfang(){
        System.out.println("中介来带我看房了");
    }
    //签合同的
    public void hetong(){
        System.out.println("找中介签合同");
    }
    //退房的
    public void tuifang(){
        System.out.println("找中介推房子");
    }
}
```

客户端  -  实际使用者

```java
/**
 * clint
 *  我是客户端使用者
 * @author czy
 * @date 2023/5/25
 */
public class clint {

    public static void main(String[] args) {
        //代理   帮房东租房子，  然后可能会有一些自己的附属操作，例如收中介费，看房等
        prox prox = new prox(new fangdong());
        //我想要租房，就不用找房东了，直接找中介就可以了
        prox.rent();
    }
}
```



#### 动态代理

底层---反射

动态代理和静态代理的角色一样

动态代理的代理类是动态生成的，不是我们直接写好的

实现方式大概分为

基于接口----jdk动态代理

基于类----cglib

java字节码实现，javasist   (适用于jboss服务器)

需要了解两个类，Proxy:代理， InvocationHandler 调用处理程序

好处：

- 可以使真实角色的操作更加纯粹，不用去关注一些公共的业务
- 公共也就交给了代理角色，实现了业务的分工
- 公共业务发送扩展的时候，方便集中管理，
- 一个动态代理类代理的是一个接口，一般就是对应的一类业务





基于jdk的动态代理

> 动态生成的代理类 会去默认继承Proxy这个类  ，同时 还会去实现我们被代理的接口
>
> 因为单继承的特性，所以动态代理只能代理有接口的类



租房抽象类

```java
/**
 * Rent
 *  我现在是一个租房接口
 * @author czy
 * @date 2023/5/25
 */
public interface Rent {
    void rent();
    void rent2();
    void rent3();
    void rent4();
}
```



房东， 接口实现类

```java
/**
 * fangdong
 *   我现在是一个房东
 * @author czy
 * @date 2023/5/25
 */
public class fangdong implements Rent {
    @Override
    public void rent() {
        System.out.println("我是房东    ------      我房子租出去了");
    }

    @Override
    public void rent2() {
        System.out.println("rent2");
    }

    @Override
    public void rent3() {
        System.out.println("rent3");
    }

    @Override
    public void rent4() {
        System.out.println("rent4");
    }
}
```



代理生成类

```java
/**
 * proxInvocationHandler
 *
 * @author czy
 * @date 2023/5/28
 */
public class proxInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Object test;

    public void setObject(Object rent) {
        this.test = rent;
    }

    //生成得到的代理类
    public Object getProxy(){
        System.out.println("getProxy被调用了");
        /**Proxy提供了创建动态代理类和实例的静态方法
         * newProxyInstance(ClassLoader loader, 类<?>[] interfaces, InvocationHandler h)
         * loader - 类加载器来定义代理类
         * interfaces - 代理类实现的接口列表
         * h - 调度方法调用的调用处理函数
         * 返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序。
         */
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),test.getClass().getInterfaces(),this);
    }

    /**
     *
     * @param proxy  调用的对象
     * @param method   调用的方法信息，例如方法名、返回类型等等
     * @param args
     * @return
     * @throws Throwable
     */
    //处理代理类实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke被调用了");
        //通过反射调用方法
        Object invoke = method.invoke(test);
        return invoke;
    }
}
```

客户端 实际调用者

```java
/**
 * clint
 *
 * @author czy
 * @date 2023/5/28
 */
public class clint {
    public static void main(String[] args) {
        //真实角色
        fangdong fangdong = new fangdong();
        //实例化代理生成类
        proxInvocationHandler proxInvocationHandler = new proxInvocationHandler();
        //设置被代理的接口 ，个人感觉在实例代理类的时候可以加一个构造来设置被代理的接口
        proxInvocationHandler.setObject(fangdong);
        //获取生成的代理类
        Rent proxy = (Rent)proxInvocationHandler.getProxy();
        //通过invoke 方法执行 我们想要执行的方法，会吧我们实例出来的真实类和 需要调用方法的方法信息传给invoke
        proxy.rent();
        proxy.rent3();
        proxy.rent2();
        proxy.rent4();
    }
}
```

执行结果

```text
getProxy被调用了
invoke被调用了
我是房东    ------      我房子租出去了
invoke被调用了
rent3
invoke被调用了
rent2
invoke被调用了
rent4
```

### *3.装饰器模式



在不改变现有对象结构的情况下，动态的给该对象增加额外职责的模式

有一个快餐积累，有价格和名称属性，两个主食来继承他，   配菜抽象类继承快餐类获取基础属性，并添加主食变量，配菜实现类实现了具体的配菜以及价格，在构造时传入主食类，进行关联



在io流的  装饰器里有用到

快餐类，基类

```java
/**
 * FastFood
 * 装饰器模式-------- 快餐类   抽象构建角色
 * @author czy
 * @date 2023/5/29
 */
public abstract class FastFood {
    private float price;//价格
    private String desc;//描述

    public FastFood() {
    }

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract  float cost();//价格计算
}
```





炒面类和炒饭类，两大主食类

```java
/**
 * FriedNoodles
 *  炒面类  具体的构建角色
 * @author czy
 * @date 2023/5/29
 */
public class FriedNoodles  extends FastFood{

    public FriedNoodles() {
        //炒面15块钱一份
        super(15,"炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}

/**
 * FriedRice
 *  炒饭类 具体构建角色
 * @author czy
 * @date 2023/5/29
 */
public class FriedRice  extends FastFood{

    public FriedRice() {
        //炒饭10块钱一份
        super(10,"炒饭");
    }
    @Override
    public float cost() {
        return getPrice();
    }
}
```





配菜抽象类，  就是装饰角色的抽象

```java
/**
 * Garnish
 *  抽象的装饰角色
 * @author czy
 * @date 2023/5/29
 */
public abstract class Garnish extends FastFood{
    //声明快餐类的变量---个人理解是用来存炒饭炒面的变量
    private FastFood fastFood;

    public Garnish(FastFood fastFood,float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
```



火腿类和鸡蛋类，配菜的实现类  实际的装饰者

```java
/**
 * huotui
 *  我现在是具体的快餐装饰类   火腿类
 * @author czy
 * @date 2023/5/29
 */
public class huotui extends Garnish{


    public huotui(FastFood fastFood) {
        //加火腿肠额外加8块钱
        super(fastFood, 8, "火腿肠");
    }

    @Override
    public float cost() {
        return getPrice()+getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return getFastFood().getDesc()+"加"+super.getDesc();
    }
}

/**
 * Egg
 *  鸡蛋类   具体的装饰者角色
 * @author czy
 * @date 2023/5/29
 */
public class Egg extends Garnish{

    //这里的传过来的FastFood  实际上是炒饭，炒面
    public Egg(FastFood fastFood) {
        //加鸡蛋额外加5块钱
        super(fastFood,5,"鸡蛋");
    }

    @Override
    public float cost() {
        return getPrice()+ getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return getFastFood().getDesc()+"加"+super.getDesc();
    }
}
```



客户端  ，调用者  使用者

```java
/**
 * client
 *  客户端    实际调用者  测试类
 * @author czy
 * @date 2023/5/29
 */
public class client {
    public static void main(String[] args) {
        //点一份炒饭  10快钱
        FastFood friedRice = new FriedRice();

        System.out.println(friedRice.getDesc()+"------->"+friedRice.cost()+"块钱");

        System.out.println("---------------我是一个分割线--------------------");
        //现在想加个鸡蛋
        friedRice= new Egg(friedRice);
        System.out.println(friedRice.getDesc()+"------->"+friedRice.cost()+"块钱");
        System.out.println("---------------我是一个分割线--------------------");
        friedRice =  new huotui(friedRice);
        System.out.println(friedRice.getDesc()+"------->"+friedRice.cost()+"块钱");
    }
}
```



输出结果

```text
炒饭------->10.0块钱
---------------我是一个分割线--------------------
炒饭加鸡蛋------->15.0块钱
---------------我是一个分割线--------------------
炒饭加鸡蛋加火腿肠------->23.0块钱
```

### 4.外观模式

我们将创建一个 Shape 接口和实现了 Shape 接口的实体类。下一步是定义一个外观类 ShapeMaker。

ShapeMaker 类使用实体类来代表用户对这些类的调用。FacadePatternDemo 类使用 ShapeMaker 类来显示结果。


首先有个抽象类来抽象需要被外观访问的方法

```java

package com.example.demo.test.jiegou.appearance;

/**
 * @author czy
 * @description 抽象的接口，定义了哪些方法需要被外观访问
 * @date 2023/7/24
 */
public interface shape {
    /**
     * 说话
     */
    void say();
}

```

各个需要被外观访问的子类，实现抽象接口，根据自身业务实现被外观访问方法

```java
/**
 * @author czy
 * @description 根据自身业务实现了接口里面的需要外观访问的方法
 * @date 2023/7/24
 */
public class cow implements shape{
    @Override
    public void say() {
        System.out.println("我是牛，我说话：哞！！！哞！！！牟！！！");
    }
}

/**
 * @author czy
 * @description 根据自身业务实现了接口里面的需要外观访问的说话方法
 * @date 2023/7/24
 */
public class human implements shape{
    @Override
    public void say() {
        System.out.println("我是人，我说话是：哈！！！哈！！！哈！！");
    }
}

/**
 * @author czy
 * @description 根据自身业务实现了接口里面的需要外观访问的方法
 * @date 2023/7/24
 */
public class pig implements shape{
    @Override
    public void say() {
        System.out.println("我是猪，我说话是，哼哧！！哼哧！！！");
    }
}

```

外观类 对外提供需要被访问方法的入口

```java

/**
 * @author czy
 * @description 我是外观类，对外提供各种动物叫声的方法
 * @date 2023/7/24
 */
public class shapeMake {
    public void haha(shape shape){
        shape.say();
    }
}
```

测试类

```java
/**
 * @author czy
 * @description 客户端调用者
 * @date 2023/7/24
 */
public class clint {

    public static void main(String[] args) {
        shapeMake shapeMake = new shapeMake();
        shapeMake.haha(new human());
        shapeMake.haha(new cow());
        shapeMake.haha(new pig());
    }
}

```
测试结果

```text
我是人，我说话是：哈！！！哈！！！哈！！
我是牛，我说话：哞！！！哞！！！牟！！！
我是猪，我说话是，哼哧！！哼哧！！！
```


## 行为型模式

### 1.模板方法模式

一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。这种类型的设计模式属于行为型模式

个人理解，抽象类来定义抽象的步骤，以及将固定的顺序和步骤写成模板方法，提供具体方法的抽闲类或实现类

具体实现类继承后  重写固定的具体方法，以及根据自身需要重写倒油或热油方法

调用者只需要 实例化具体方法  和抽象类    ，调用模板方法即可。



抽象类 定义了模板方法 不可重写    和 基本方法 以及具体的抽象方法

```java
/**
 * AbstractClass
 *  抽象类  定义模板方法和基本方法
 * @author czy
 * @date 2023/5/31
 */
public abstract class AbstractClass {

    //模板方法定义
    public final void pengreng(){
        daoyou();
        reyou();
        daocai();
        tiaoliao();
        fanchao();
    }
    //倒油
    public void  daoyou(){
        System.out.println("倒油");
    }
    //热油
    public void reyou(){
        System.out.println("热油");
    }
    //倒菜
    public abstract void daocai();
    //加调料
    public abstract void tiaoliao();
    //翻炒
    public void fanchao(){
        System.out.println("抄啊抄啊抄熟了");
    }
}
```



两个具体的炒菜实现类  根据自身业务实现具体的倒菜和加调料方法，根据需要决定是否要重写倒油方法

```java
/**
 * baoCai
 *          抄包菜的类
 * @author czy
 * @date 2023/5/31
 */
public class baoCai extends AbstractClass{
    @Override
    public void daocai() {
        System.out.println("包菜下锅");
    }

    @Override
    public void daoyou() {
        System.out.println("倒入菜籽油");
    }

    @Override
    public void tiaoliao() {
        System.out.println("加入辣椒大蒜调味");
    }
}
/**
 * rousi
 *   玉米炒肉类
 * @author czy
 * @date 2023/5/31
 */
public class rousi  extends AbstractClass{
    @Override
    public void daocai() {
        System.out.println("倒入肉丝");
    }

    @Override
    public void tiaoliao() {
        System.out.println("加入玉米调味");
    }
}
```

测试者，实际调用者

```java
/**
 * client
 *  测试类，实际调用者
 * @author czy
 * @date 2023/5/31
 */
public class client {

    public static void main(String[] args) {
        //我现在要炒包菜
        AbstractClass baocai = new baoCai();
        baocai.pengreng();
        System.out.println("----------------------------------");
        //我现在要做玉米炒肉
        AbstractClass rousi = new rousi();
        rousi.pengreng();
    }
}
```



结果打印

```text
倒入菜籽油
热油
包菜下锅
加入辣椒大蒜调味
抄啊抄啊抄熟了
----------------------------------
倒油
热油
倒入肉丝
加入玉米调味
抄啊抄啊抄熟了
```

### 2.策略模式



将类似的不同情况下 执行的不同业务  抽象到策略类里  然后每个执行实现去实现这个策略类，环境类提供了调用方式

实际调用者可以根据不同的情况 传入策略实现类对象就能调用到想要 的业务执行



抽象的策略类



```java
/**
 * Strategy
 *  抽象的策略类
 * @author czy
 * @date 2023/6/1
 */
public interface Strategy {
    void show();
}
```





具体的策略类

```java
/**
 * strateA
 *     具体策略类
 * @author czy
 * @date 2023/6/1
 */
public class strateA implements Strategy{
    @Override
    public void show() {
        System.out.println("买一送一");
    }
}

/**
 * strateB
 *   具体策略实现类
 * @author czy
 * @date 2023/6/1
 */
public class strateB implements Strategy{
    @Override
    public void show() {
        System.out.println("全场八折");
    }
}

/**
 * strateC
 *
 * @author czy
 * @date 2023/6/1
 */
public class strateC implements Strategy{
    @Override
    public void show() {
        System.out.println("满500减100");
    }
}
```



环境类  提供一个

```java
/**
 * strateMan
 *  促销员     环境类
 * @author czy
 * @date 2023/6/1
 */
public class strateMan {
    //聚合一下策略对象
    private Strategy strategy;

    public strateMan(Strategy strategy) {
        this.strategy = strategy;
    }

    //促销员根据环境来展示不同的促销活动（调用不同的策略）
    public void salesMan(){
        strategy.show();
    }
}
```



调用者

```java
/**
 * clint
 *   测试类   实际调用者
 * @author czy
 * @date 2023/6/1
 */
public class clint {
    public static void main(String[] args) {
        //现在是春节   执行A活动
        strateMan strateMan = new strateMan(new strateA());
        strateMan.salesMan();
        //现在国庆节   执行B活动
        strateMan = new strateMan(new strateB());
        strateMan.salesMan();
        //现在是圣诞节   执行C活动
        strateMan = new strateMan(new strateC());
        strateMan.salesMan();
    }
}
```

打印结果

```text
买一送一
全场八折
满500减100
```



### 3.命令模式



将一个请求封装成一个对象，使发出请求的责任和执行请求的责任分隔开，这样两者之间通过命令对象进行沟通，方便讲命令对象进行存储，传递，调用，增加和管理

请求以命令的形式包裹在对象中，并传给调用对象。调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令

抽象命令类：定义命令的接口，声明执行的方法

具体命令类：具体的命令方法，实现命令接口，通常会持有接受者，并调用接受者的功能来完成命令要执行的操作

接受者：真正去执行命令的对象，任何类都可能成为一个接受者，只要它能够实现命令要求实现的相应功能

调用者 ：要求命令对象执行请求，通常会持有命令对象，可以持有多个命令对象，这个是 客户端实际需要调用的地方，相当于是命令对象的入口





抽象命令类

```java
/**
 * 抽象命令类
 */
public interface mingling {
    void execute();
}
```



具体的命令类

```java
/**
 * 具体的命令类
 */
public class dingdanOrder implements mingling{

    //持有接受者对象
    private chushi chushi;

    //持有订单对象
    private Order Order;

    public dingdanOrder(com.example.demo.test.xingwei.command.chushi chushi, com.example.demo.test.xingwei.command.Order order) {
        this.chushi = chushi;
        Order = order;
    }

    @Override
    public void execute() {
        System.out.println("-----------"+Order.getDingingTable() + "桌的订单----------");
        Map<String, Integer> foodDir = Order.getFoodDir();
        foodDir.forEach((key,value)->{
            chushi.makeFood(key,value);
        });
        System.out.println(Order.getDingingTable() + "桌的饭搞好了，上菜！！！！！！！！！！！！！！！！！");

    }
}
```



命令接受者

```java
/**
 * 命令模式   厨师类  命令执行者
 */
public class chushi {
    public void makeFood(String name , int num){
        System.out.println(num+"份"+name);
    }
}
```

订单实体类

```java
/**
 * 命令者模式  订单类
 */
public class Order {

    //餐桌号码
    private int dingingTable;

    private Map<String,Integer> foodDir = new HashMap<>();

    public int getDingingTable() {
        return dingingTable;
    }

    public void setDingingTable(int dingingTable) {
        this.dingingTable = dingingTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFood(String name, Integer num) {
        this.foodDir.put(name, num);
    }
}
```

命令的调用者

```java
/**
 * 服 务员类  请求者 调用者角色
 */
public class waitor {
    //持有多个命令对象
    private List<mingling> commands = new ArrayList<>();

    public void setCommand(mingling commands) {
        this.commands.add(commands);
    }

    //发起命令的方法 喊订单来了   厨师就开始干活

    public  void orderUp(){
        System.out.println("服务员：来活咯，厨师快干活");
        this.commands.forEach(item->{
            if (item!=null){
                item.execute();
            }
        });
    }
}
```

客户端类  测试类

```java
/**
 * 客户端，实际调用者   来吃饭的     命令者模式
 */
public class clint {
    public static void main(String[] args) {
        //第一个来吃饭的
        Order o1 = new Order();
        o1.setFood("大盘鸡",2);
        o1.setFood("宫保鸡丁",1);
        o1.setDingingTable(1);
        //第二个来吃饭的

        Order o2 = new Order();
        o2.setFood("葱爆羊肉",2);
        o2.setFood("油焖大虾",1);
        o2.setFood("大窑",5);
        o2.setDingingTable(3);

        //创建厨师
        chushi chushi = new chushi();
        //创建命令对象
        mingling dingdanOrder1 = new dingdanOrder(chushi,o1);
        mingling dingdanOrder2 = new dingdanOrder(chushi,o2);
        //创建服务员
        waitor waitor = new waitor();
        waitor.setCommand(dingdanOrder1);
        waitor.setCommand(dingdanOrder2);
        waitor.orderUp();
    }
}
```

输出结果

```text
服务员：来活咯，厨师快干活
-----------1桌的订单----------
1份宫保鸡丁
2份大盘鸡
1桌的饭搞好了，上菜！！！！！！！！！！！！！！！！！
-----------3桌的订单----------
5份大窑
2份葱爆羊肉
1份油焖大虾
3桌的饭搞好了，上菜！！！！！！！！！！！！！！！！！
```



### 4.责任链模式

filter过滤器就是用到了这个设计模式，还有java异常类的处理

现有一个需求  ，开发一个请假的流程控制系统，请假一天以下，只需要小组长同意即可，请假一天到三天需要部门经理同意，请假3-7天需要总经理同意，超过七天直接打回





满足开闭原则，后续如果增加审批节点，我只需要再加个类 去继承那个抽象类，然后构造里定义自己的审批规则，重写审批类就行了



请假条实体类

```java
/**
 * 责任链模式
 * 请假条类
 */
public class LeaveRequest {
    //请假人姓名
    private String name;
    //请假天数
    private Integer number;
    //请假内容
    private String content;

    public LeaveRequest(String name, Integer number, String content) {
        this.name = name;
        this.number = number;
        this.content = content;
    }
    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }
}
```



核心类

抽象的处理者抽象类

定义了请假的规则常量，定义了抽象的处理请假的方法，提供了请假提交类，进行请假条处理，以及递归层层往上抛

各个领导实现这个抽象类只需要集成构造，并指定自己需要审批的时间区间



```java
/**
 * 责任链模式
 *
 * 抽象处理者类
 */
public abstract class Handler {
    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVER = 7;

    //该领导处理的请假区间
    private int numStart;
    private int numEnd;

    //声明后继者
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }
    //设置后继者对象
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    //各领导处理请求条的方法
    protected abstract void handleLeave(LeaveRequest leave);

    //提交请假条
    public final void submit(LeaveRequest leave){
        //判断请假时间是否符合规定
        if(leave.getNumber()> NUM_SEVER){
            System.out.println("请假时间过长，不允许");
            return;
        }
        //该领导先进行审批
        this.handleLeave(leave);
        //判断有没有上级领导，并且需不需要上级领导审批、
        if (nextHandler != null && leave.getNumber() > this.numEnd) {
            //提交给上级领导进行审批
            this.nextHandler.submit(leave);
        } else {
            System.out.println("审批结束！！！！放假去吧");
        }
    }
}
```





组长类

```java
/**
 * 我是小组长
 * 我可以审批0到一天的调休
 */
public class groupLeader extends Handler {

    public groupLeader(){
        super(0,NUM_ONE);
    }
    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName()+"请假"+leave.getNumber()+"天-----"+leave.getContent());
        System.out.println("小组长审批，同意");
    }
}
```

部门经理类

```java
/**
 * 部门经理类
 * 我可以审批1-3天的请假
 */
public class manager extends Handler{

    public manager(){
        super(NUM_ONE,NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName()+"请假"+leave.getNumber()+"天-----"+leave.getContent());
        System.out.println("部门经理审批，同意");
    }
}
```



总经理类

```java
/**
 * 总经理类
 * 我可以审批
 */
public class GeneralManager extends Handler{

    public GeneralManager(){
        super(NUM_THREE,NUM_SEVER);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName()+"请假"+leave.getNumber()+"天-----"+leave.getContent());
        System.out.println("总经理审批，同意");
    }
}
```



实际调用者

测试类

```java
/**
 * 测试类  实际调用者
 */
public class clint {
    public static void main(String[] args) {
        //创建一个请假对象
        LeaveRequest leaveRequest = new LeaveRequest("小明",7,"出去玩");
        //创建各级领导对象
        groupLeader groupLeader = new groupLeader();
        manager manager = new manager();
        GeneralManager generalManager = new GeneralManager();
        //设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        //提交请假申请
        groupLeader.submit(leaveRequest);
    }
}
```



运行结果

```text
小明请假7天-----出去玩
小组长审批，同意
小明请假7天-----出去玩
部门经理审批，同意
小明请假7天-----出去玩
总经理审批，同意
审批结束！！！！放假去吧
```

### 5.观察者模式

又被称为 发布/订阅 模式 他定义了一种多对一的关系，让多个观察者对象同时监听某一主题对象，这个主题对象在状态变化的时候，会通知所有的观察者对象，使他们能够自动更新自己

使用场景： 对象间存在一对多关系时，一个对象的状态发生改变会影响其他对象

 当一个抽象模型有两个方面，其中一个方面依赖于另一个方面时

角色：

（抽象主题）抽象被观察者：吧所有观察者对象保存在一个集合里，每个主题都可以有任意数量的观察者，抽象主题提供一个接口，可以增加和删除观察者对象

（具体主题）具体被观察者：该橘色将有关状态存入具体观察者对象，在具体主题的内部状态发生改变时，给所有注册过的观察者发送通知

抽象观察者：是观察者的抽象类。他定义了一个更新接口，使得在得到主题更改通知时更新自己

具体被观察者：实现抽象观察者定义的更新接口，以使在得到主题更改通知时更新自身的状态

现有需求，在使用微信公众号时，当你关注的公众号中有更新内容的时候，他会推送给关注这个公众号的所有微信以及QQ客户端，使用观察者模式来模拟次场景

我认为就是被观察者用来存储以及通知 的载体

```java
/**
 * 抽象观察者类
 */
public interface Observe {

    //主题推送更新
    void update(String msg);
}
```

具体的观察者类 实现类 一般是需要对公众号进行观察监听的实例 QQ客户端

```java
/**
 * 具体的观察者类  qq客户端
 */
public class TengxunQQ implements Observe {
    private String name;

    public TengxunQQ(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(this.name + "---在QQ频道接收到了消息------=" + msg);
    }
}
```

微信客户端

```java
/**
 * 具体的观察者类
 */
public class weiXinUser implements Observe {
    private String name;

    public weiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(this.name + "-----在微信公众号接收到了消息------=" + msg);
    }
}
```

抽象的被观察者 （抽象主题类） 定义了被观察者 对观察者操作的一些抽象行为

```java
/**
 * 抽象主题角色类   被观察者
 */
public interface Subject {

    //添加订阅者  （添加观察者对象）
    void attach(Observe observe);

    //删除订阅者  （删除观察者对象）
    void detach(Observe observe);

    //通知订阅者  更新消息
    void notify(String msg);
}
```

具体主题角色类 （被观察者类） 公众号

定义了一个集合来存储关注了我这个公众号的客户端 然后notify对这个集合遍历，调用他们的推送更新方法，进行消息推送，但是我觉得这里的遍历会不会不太好？真实场景是不是应该多线程去发送这些消息？ 然后还可以保证消息的有序性，那就可以用队列来存

```java
/**
 * 具体主题角色类   （被观察者类）   公众号
 */
public class Subsciptionsubject implements Subject {
    //定义一个集合来存储多个观察者对象
    private List<Observe> list = new ArrayList<>();

    @Override
    public void attach(Observe observe) {
        list.add(observe);
    }

    @Override
    public void detach(Observe observe) {
        list.remove(observe);
    }

    //通知订阅者  更新消息
    @Override
    public void notify(String msg) {
        //当公证号里面内容发送变化时会执行
        list.forEach(item -> {
            //调用观察者对象中的更新方法
            item.update(msg);
        });
    }
}
```

测试类

我感觉这里的new 对象可以 想象成 从数据库查询订阅了公众号的数据 然后批量插入到集合里 最后调用他提供的消息推送方法,j将需要更新的消息推送过去

```java
/**
 * 测试类
 */
public class clint {
    public static void main(String[] args) {
        //创建公众号对象
        Subject subject = new Subsciptionsubject();
        //订阅公众号
        Observe observe = new TengxunQQ("czyyy");
        Observe observe2 = new weiXinUser("lsz");
        subject.attach(observe);
        subject.attach(observe2);
        //推送消息
        subject.notify("czyyyy中了五百万彩票");
    }
}
```

```text
czyyy---在QQ频道接收到了消息------=czyyyy中了五百万彩票
lsz-----在微信公众号接收到了消息------=czyyyy中了五百万彩票
```

### 6.中介模式

没啥好说的、这个还是比较简单的

中介类，提供被调用类的功能方法

```java
/**
 * @author czy
 * @description 中介类
 * @date 2023/7/26
 */
public class chatRom {
    public static void showMessage(User user, String message){
        System.out.println(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss") + "------>"+user.getName() + " : "+message);

    }
}
```

用户类、实际功能的载体
```java
/**
 * @author czy
 * @description 用户类
 * @date 2023/7/26
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }
    public void sendMessage(String message){
        chatRom.showMessage(this,message);
    }
}
```
客户类，实际调用者
```java
/**
 * @author czy
 * @description 客户类
 * @date 2023/7/27
 */
public class clint {
    public static void main(String[] args) {
        User czyy = new User("czyy");
        User zhangsan = new User("张三");

        czyy.sendMessage("开饭啦，快去干饭！！！！！！！！！！！！！！！！！！！！！！！！！");
        zhangsan.sendMessage("我是法外狂徒，法律不可能制裁我");
    }
}
```

实际输出结果
```text
2023-07-27 01:41:24------>czyy : 开饭啦，快去干饭！！！！！！！！！！！！！！！！！！！！！！！！！
2023-07-27 01:41:24------>张三 : 我是法外狂徒，法律不可能制裁我

```








