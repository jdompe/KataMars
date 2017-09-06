import java.util.ArrayList;
import java.util.List;

public class Mars {

    final static int SIZE = 10;

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    private ArrayList<Obstacle> obstacles;

    public Mars() {

        obstacles = new ArrayList<>();
        Obstacle o1 = new Obstacle(1, 1);
        Obstacle o2 = new Obstacle(6, 3);
        Obstacle o3 = new Obstacle(8, 0);
        obstacles.add(o1);
        obstacles.add(o2);
        obstacles.add(o3);
    }

    public boolean isThereObstacle(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (y == obstacle.getY() && x == obstacle.getX()) {
                return true;
            }
        }
        return false;
    }

    public int getNewPositionChecked(int position) {
        if (position == SIZE) {
            position = 0;
        }
        if (position == -1) {
            position = SIZE - 1;
        }
        return position;
    }
}
