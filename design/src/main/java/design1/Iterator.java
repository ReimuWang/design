package design1;

public interface Iterator<T> {

    /**
     * 若iterator游标当前所指向的位置还有元素则返回true，反之返回false
     * 若在本方法返回false时继续调用next()方法，则next()方法会抛出异常
     * @return boolean, true - 存在下一个元素
     *                  false - 不存在下一个元素
     */
    boolean hasNext();

    /**
     * 返回iterator游标当前所指向的元素，随后游标后移一位
     * 
     * @throws NoSuchElementException iterator游标当前所指向的位置已无元素
     */
    T next();
}