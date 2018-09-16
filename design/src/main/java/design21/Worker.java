package design21;

public class Worker implements Workable {

    private String type;

    Worker(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void work() {
        System.out.println(this.type + "在工作");
    }
}