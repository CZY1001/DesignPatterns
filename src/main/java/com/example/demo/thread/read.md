这个是多线程联系的小demo

### 1 、 抢红包

假设 100块 分成了三个红包，现在有五个人去抢

其中、红包是共享数据

五个人是5条线程

打印结果需要如下

```text

xxx抢到了xxx元
xxx抢到了xxx元
xxx抢到了xxx元
xxx没有抢到
xxx没有抢到
```

### 2、抽奖

有一个抽奖池 里面存放了奖励金额，奖项为

{1,0，5,20,50,100,200,500,800,2,80,300,700}

创建两个抽奖箱（线程)，名字分别叫抽奖箱1，抽奖箱2 随机从抽奖池中获取元素并打印到控制台上，格式如下

```text
每抽出一个奖项就需要打印出（随机）
需要把所有的奖项都抽完，而且奖项是不能重复的

抽奖箱1产生了一个100元大奖
抽奖箱2产生了一个20元大奖
。。。。
```










