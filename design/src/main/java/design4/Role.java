package design4;

public abstract class Role {

    private String name;

    protected Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "我叫" + this.name + "，我的种族是" + this.race();
    }

    protected abstract String race();
}