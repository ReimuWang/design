package design14;

/**
 * 只处理编号小于特定值的问题
 */
public class LimitHandler extends Handler {

    private int limit;

    public LimitHandler(int limit) {
        super("LimitHandler-" + limit);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < this.limit) return true;
        return false;
    }
}