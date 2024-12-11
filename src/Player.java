public class Player {
    String name;
    int position;

    public Player(String name) {
        this.name = name;
        this.position = 1;
    }

    public void move(int steps) {
        this.position += steps;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}