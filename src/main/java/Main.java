import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        Rover rover = new Rover(5, 5, 'S');

        displayMars(rover);

        List<Character> arrayMove = new ArrayList<Character>();

        arrayMove.add('L');
        arrayMove.add('F');
        arrayMove.add('F');
        arrayMove.add('R');
        arrayMove.add('F');
        arrayMove.add('R');

        System.out.println(' ');

        rover.move(arrayMove);

        displayMars(rover);

    }

    public static void displayMars(Rover rover) {

        for (int i = 0; i < Mars.SIZE; i++) {
            for (int j = 0; j < Mars.SIZE; j++) {
                boolean isO = false;

                for (Obstacle obstacle : rover.getMarsObstacles()) {
                    if (j == obstacle.getX() && i == obstacle.getY()) {
                        System.out.print(" O ");
                        isO = true;
                    }
                }
                if (i == rover.getPosition()[1] && j == rover.getPosition()[0]) {
                    if (rover.getDirection() == 'E') {
                        System.out.print(" R-");
                    }
                    if (rover.getDirection() == 'W') {
                        System.out.print("-R ");
                    }
                    if (rover.getDirection() == 'N') {
                        System.out.print("|R ");
                    }
                    if (rover.getDirection() == 'S') {
                        System.out.print(" R|");
                    }
                } else {
                    if (!isO) {
                        System.out.print(" . ");
                    }
                }
            }
            System.out.println(' ');

        }
        System.out.println("Direction : "+rover.getDirection());
    }
}
