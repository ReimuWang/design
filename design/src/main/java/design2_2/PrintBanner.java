package design2_2;

public class PrintBanner extends Print {

    private Banner banner;

    public PrintBanner(String str) {
        this.banner = new Banner(str);
    }

    @Override
    public void printWeak() {
        this.banner.showWithParen();
    }

    @Override
    public void printStrong() {
        this.banner.showWithAster();
    }
}