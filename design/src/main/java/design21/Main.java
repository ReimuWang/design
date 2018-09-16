package design21;

public class Main {

    public static void main(String[] args) {
        Workable worker = new WorkerProxy("水暖工");
        System.out.println(worker.getType());
        worker.work();
    }
}