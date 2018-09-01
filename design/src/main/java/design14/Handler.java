package design14;

public abstract class Handler {

    private String name;

    private Handler next;

    public Handler(String name) {
        this.name = name;
    }

    public Handler setNext(Handler next) {
        this.next = next;
        return this.next;
    }

    public static final Handler init() {
        Handler result = new NoHandler();
        result.setNext(new SpecialHandler(5)).setNext(new LimitHandler(20)).setNext(new OddHandler());
        return result;
    }

    public final void handle(Trouble trouble) {
        if (this.resolve(trouble))
            System.out.println(trouble + "is resolved by" + this);
        else if (null != this.next) {
            System.out.println(this + " can't resolve " + trouble + ",pass to next handler:" + this.next);
            this.next.handle(trouble);
        } else
            System.out.println("all handler can't resolve " + trouble);
    }

    protected abstract boolean resolve(Trouble trouble);

    @Override
    public String toString() {
        return "[Handler " + this.name + "]";
    }
}