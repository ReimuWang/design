package design1;

/**
 * Aggregate有"使聚合，集合"的意思
 * 顾名思义，实现了该接口的类将成为一个可以保存多个元素的集合
 */
public interface Aggregate<E> {

    /**
     * 生成并返回一个用于遍历集合的迭代器
     * @return Iterator<E>
     */
    Iterator<E> iterator();
}