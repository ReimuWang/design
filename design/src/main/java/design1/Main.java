package design1;

public class Main {

    public static void main(String[] args) {
        BookShelf<Book> bookShelf = new BookShelf<Book>(1);
        bookShelf.appendBook(new Book("秀逗魔导士"));
        bookShelf.appendBook(new Book("9S"));
        bookShelf.appendBook(new Book("为美好的世界献上祝福"));
        bookShelf.appendBook(new Book("犬神"));
        bookShelf.appendBook(new Book("钢铁白兔骑士团"));
        Iterator<Book> iterator = bookShelf.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next().getName());
    }
}