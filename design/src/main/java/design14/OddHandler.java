package design14;

/**
 * 只处理编号为奇数的问题
 */
public class OddHandler extends Handler {

    public OddHandler() {
        super("OddHandler");
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) return true;
        return false;
    }
}