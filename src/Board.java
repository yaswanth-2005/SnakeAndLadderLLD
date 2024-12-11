public class Board {
    private final Snake[] snakes;
    private final Ladder[] ladders;
    private final int size;

    public Board(int size, Snake[] snakes, Ladder[] ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int checkSnakesAndLadders(int position) {
        for(Snake snake : snakes) {
            if(snake.getStart() == position) {
                System.out.println("Snake Bitten!!"+ snake.getEnd());
                return snake.getEnd();
            }
        }

        for(Ladder ladder : ladders) {
            if(ladder.getStart() == position) {
                System.out.println("Ladder Climbed!!"+ ladder.getEnd());
                return ladder.getEnd();
            }
        }

        return position;
    }

    public boolean isWinningPosition(int position) {
        return position == size;
    }

    public int getSize() {
        return size;
    }
}