package design1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookShelf<E> implements Aggregate<E> {

    private List<Book> books;

    public BookShelf(int initsize) {
        if (initsize < 0)
            throw new IllegalArgumentException("bookShelf 's initsize < 0");
        this.books = new ArrayList<Book>(initsize);
    }

    public void appendBook(Book book) {
        if (null == book)
            throw new NullPointerException("book is null");
        this.books.add(book);
    }

    @Override
    public Iterator<E> iterator() {
        return new BookShelfIterator<E>(this);
    }

    int getLength() {
        return this.books.size();
    }

    Book getBookAt(int index) {
        if (index < 0 || index >= books.size())
            throw new IllegalArgumentException("index < 0 || index >= bookShelf 's size");
        return this.books.get(index);
    }
}

class BookShelfIterator<E> implements Iterator<E> {

    private BookShelf<E> bookShelf;

    /**
     * int, 迭代器当前游标指向的位置，即下一次调用next()方法时返回的元素的索引
     */
    private int index;

    BookShelfIterator(BookShelf<E> bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public boolean hasNext() {
        return this.bookShelf.getLength() > this.index;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E next() {
        if (!this.hasNext())
            throw new NoSuchElementException("no more element for bookShelf");
        return (E)this.bookShelf.getBookAt(index++);
    }
}