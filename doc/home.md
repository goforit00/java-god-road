# JAVA-GOD-ROAD Home Page

## 模块介绍
### 1. 任务超时回调 模块
* 待续

### 2. 线程池监控 核心 模块（thread-pool-monitor）
#### 2.1 功能：
* 记录线程池核心数据：coreSize(核心线程数),maxSize(最大线程数),threadNum(当前线程数),queueLength(队列长度)；,并提供查询接口。

#### 2.2 使用说明：
##### 2.2.1 注解方式：
* 注解类：ThreadPoolMonitorAnnotation(threadPoolName = "your.threadpool.name")
* 此方式适合于把ThreadPool的实例交给spring托管的bean

```
@ThreadPoolMonitorAnnotation(threadPoolName = "myThreadPool")
@Service
public class MyThreadPool {
...
}

注意： 要求MyThreadPool 为spring的bean,并具有如下方法：
    public int getActiveCount();
    public int getCorePoolSize();
    public int getCompletedTaskCount();
    public int getMaximumPoolSize();
    public int getPoolSize();
    public Queue getQueue();
    public int getLargestPoolSize();
    
```
 
##### 2.2.2 实现类方式：
* Abstract类： AbstractThreadPoolMonitorRegister 实现Map<String, Object> addThreadPool()方法
* 此方式适合于：ThreadPool的实例未被spring托管

```
@Service
public class MyThreadPoolRegister extends AbstractThreadPoolMonitorRegister{
    @Override
    protected Map<String, Object> addThreadPool() {
        Map<String,Object> threadPoolMap=new HashMap<String, Object>();
        threadPoolMap.put("myThreadPool",MyThreadPool.getInstance());
        return threadPoolMap;
    }
}

注意： 继承AbstractThreadPoolMonitorRegister的实现类必须是spring的bean
```


[test](https://github.com/goforit00/java-god-road/blob/master/doc/home.md)

### 3. 线程池监控 展示mvc 模块


### 4. 线程池监控 中心master 模块