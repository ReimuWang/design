package design21;

public class WorkerProxy implements Workable {

    private Worker worker;

    private String type;

    public WorkerProxy(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void work() {
        if (null == worker) this.worker = new Worker(this.type);
        this.worker.work();
    }
}