package com.example.demo.test.reviewTest.chuangjian.danli;

/**
 * @author czy
 * @summary 经典的双重检索单例DCL
 * 基于懒汉式的单例，保证了线程安全的同时，考虑到了性能问题
 * 理解: 相对于锁方法来说，synchronized (demo04.class)这种锁实例对象更适合单例模式
 * 他会锁整个类的实例，其他线程想访问demo04的任何一个实例时，都会被阻塞，直到锁释放。对于其他场景来说可能不太合适
 * 但是单例模式刚好需要这个场景，当首次创建时，多个线程进入，第一个线程拿到了进入的创建实例，这个实例锁就会生效
 * 后面的线程就要等待了，但是后续访问的时候，因为已经有了实例不为null了，所以没必要再去考虑线程安全问题了
 *
 * 对于sy锁方法，锁的是当前实例对象的这个方法，他是针对方法的，
 * 首次创建实例的时候确实没问题，会锁住整个方法，其他线程等待，但是后续访问的时候，因为已经有了实例，但是这个方法锁的存在
 * 后面每次访问这个获取实例的方法，同一时间都只有一个线程能来访问，所以说性能不太好
 *
 * @date 2025-01-11 16:43
 */
public class demo04 {
    private static volatile demo04 instance;
    private demo04() {
    }
    public static demo04 getInstance() {
        if (instance == null) {
            synchronized (demo04.class) {
                if (instance == null) {
                    instance = new demo04();
                }
            }
        }
        return instance;
    }

}
