### 多线程

#### 进程和线程的联系和区别

* 进程是程序的一次执行过程，是系统运行程序的基本单位

* 线程是进程划分成的更小的执行单位。多个线程可以共享进程的堆和方法区内存资源，每个线程都有自己的程序计数器、虚拟机栈和本地方法栈
* 进程是独立的，而各线程则不一定独立，因为同一进程中的多个线程极有可能会相互影响

#### 线程的状态

* 初始状态（NEW）：线程已经构建，尚未启动
* 运行状态（RUNNABLE）：包括就绪（READY）和运行中（RUNNING）两种状态，统称为运行状态
* 阻塞状态（BLOCKED）：线程被锁阻塞
* 等待状态（WAITING）：线程需要等待其他线程做出特定动作（通知或中断）
* 超时等待状态（TIME_WAITING）：不同于等待状态，超时等待状态可以在指定的时间自行返回
* 终止状态（TERMINATED）：当前线程已经执行完毕

#### 多线程可能存在的问题

* 内存泄漏
* 上下文切换
* 死锁
* 受限于硬件和软件的资源限制问题

#### 关键字 synchronized

> 解决多个线程之间访问资源的同步性

* 修饰实例方法：给当前对象实例加锁，进入同步代码之前需要获得当前对象实例的锁
* 修饰静态方法：给当前类加锁，进入同步代码之前需要获得当前类的锁
* 修饰代码块：指定加锁对象，给指定对象加锁，进入同步代码块之前需要获得指定对象的锁

#### 关键字 volatile

> 解决变量在多个线程之间的可见性；确保代码的执行顺序不变，可以禁止指令进行重排序

**同synchronized区别**

1. volatile是线程同步的轻量级实现，不需要加锁，故性能优于synchronized
1. synchronized可以修饰方法和代码块，volatile只能修饰变量
1. synchronized 可能发生阻塞，volatile 不会发生阻塞
1. synchronized 可以保证数据的可见性和原子性，volatile 只能保证数据的可见性，不能保证数据的原子性
1. synchronized 解决的是多个线程之间访问资源的同步性，volatile 解决的是变量在多个线程之间的可见性

#### sleep() 、join()、yield() 区别 obj.wait()

* sleep()：使当前线程暂停执行一段时间，让其他优先级的线程有机会继续执行，但它并不释放对象锁。 (要捕捉异常)，若有synchronized同步块，其他线程仍然不能访问共享数据
* join()：作用是阻塞调用该方法的线程，直到当前线程执行完毕之后，调用该方法的线程再继续执行
* yield()：暂停当前正在执行的线程对象，类似sleep()，也不会释放“锁标志”，区别在于，它没有参数，即yield()方法只是使当前线程重新回到可执行状态，只能使同优先级或者高优先级的线程得到执行机会
* wait()：用于协调多个线程对共享数据的存取，故必须在synchronized语句块内使用。与sleep()方法的不同之处在于，wait()方法会释放对象的“锁标志”，让其他线程可以运行

#### 线程池参数

> 线程池是一种线程的使用模式
>
> 好处：降低资源消耗；提高响应速度；提高线程的可管理性

```java
public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
```

* corePoolSize：核心线程数，定义了最少可以同时运行的线程数量，当有新的任务时就会创建一个线程执行任务，当线程池中的线程数量达到corePoolSize之后，再到达的任务进入阻塞队列

* maximumPoolSize：最大线程数，定义了线程池中最多能创建的线程数量

* keepAliveTime：等待时间，当线程池中的线程数量大于corePoolSize 时，如果一个线程的空闲时间达到 keepAliveTime 时则会终止，直到线程池中的线程数不超过corePoolSize

* unit：参数keepAliveTime 的单位

* workQueue：阻塞队列，用来存储等待执行的任务

* threadFactory：创建线程的工厂

* handler：当拒绝处理任务时的策略

**核心线程和非核心线程的区别**

1. 向线程池提交任务时，首先创建核心线程运行任务，直到核心线程数到达上限，然后将任务放入阻塞队列
1. 只有在核心线程数到达上限，且阻塞队列满的情况下，才会创建非核心线程运行任务

