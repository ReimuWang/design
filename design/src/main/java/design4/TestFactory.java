package design4;

public class TestFactory {

    public TestProduct create() {
        return this.createTest();
    }

    protected TestProduct createTest() {
        return new TestProduct();
    }
}