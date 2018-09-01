package design18;

public class Memento {

    private int score;

    Memento(int score) {
        this.score = score;
    }

    int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Memento [score=" + score + "]";
    }
}