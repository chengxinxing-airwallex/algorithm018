学习笔记
hashmap 总结:
根据key的hashCode值存储数据，
HashMap最多只允许一条记录的键为null，允许多条记录的值为null。
HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致。

hashmap是一个key value对的数据类型, 它是使用一个散列桶bucket来进行存储的，桶里是一个数组和链表. jdk 1.8以后 HashMap是数组+链表+红黑树（JDK1.8增加了红黑树部分）
1. jdk 1.8 以后数组类型是Node[] table，即哈希桶数组，是一个Node的数组. 所以存放的元素都是Node, 这是为了和红黑树对应起来
2. Node[] table的初始化长度length(默认值是16)，Load factor为负载因子(默认值是0.75).每次扩容都是*2.
3. put:
存: 获得key的hash值,根据此值获得数组中的下标.
    调用equals方法, 如果出现key equal的时候, 把新的value覆盖掉旧的value
                   如果key not equal的时候, 把新的node<Key, Value> 放到链表的头部 
4. 判断链表长度是否大于8，大于8的话把链表转换为红黑树，在红黑树中执行插入操作，否则进行链表的插入操作
6. 在jdk 1.8 以后是在第一次put的时候才会初始化数组
