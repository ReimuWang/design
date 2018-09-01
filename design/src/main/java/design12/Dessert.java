package design12;

public abstract class Dessert {

    /**
     * 饱腹感
     */
    protected abstract int getSatiety();

    /**
     * 幸福度
     */
    protected abstract int getHappiness();

    protected abstract String name();

    @Override
    public String toString() {
        return "成分：" + this.name() + "\n饱腹感：" + this.getSatiety() + "，幸福度：" + this.getHappiness();
    }
}