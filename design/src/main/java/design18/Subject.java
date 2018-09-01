package design18;

public class Subject {

    private int score;

    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Memento createSnapshot() {
        return new Memento(this.score);
    }

    public void recovery(Memento memento) {
        this.score = memento.getScore();
    }
}