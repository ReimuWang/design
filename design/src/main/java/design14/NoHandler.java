package design14;

/**
 * 不处理任何问题
 */
public class NoHandler extends Handler {

    public NoHandler() {
        super("NoHandler");
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}