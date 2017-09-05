import java.util.ArrayList;
import java.util.List;

public class Rover {
    private int positionY;
    private int positionX;
    private char direction;
    private DirectionTab directionTab;
    private Mars mars;


    public Rover(int positionX, int positionY, char direction) {
        this.positionY = positionY;
        this.positionX = positionX;
        this.direction = direction;
        directionTab = new DirectionTab();
        mars = new Mars();
    }

    public int[] getPosition() {
        return new int[]{positionX, positionY};
    }

    public char getDirection() {
        return direction;
    }

    public boolean move(List<Character> arrayAction) {
        for (Character move : arrayAction) {
            int moveIncr = treatMove(move);
            int directionIncr = treatDirection();
            if (!verificationObstaclesAndSize(moveIncr, directionIncr)) return false;
        }
        return true;
    }

    private boolean verificationObstaclesAndSize(int moveIncr, int directionIncr) {
        if (direction == 'S' || direction == 'N') {
            int positionYTmp = positionY + (moveIncr * directionIncr);
            positionYTmp = getLimiteSize(positionYTmp);

            if (findObstacleY(positionYTmp)) {
                return false;
            }

            positionY = positionYTmp;
        } else {

            int positionXTmp = positionX + (moveIncr * directionIncr);
            positionXTmp = getLimiteSize(positionXTmp);

            if (findObstacleX(positionXTmp)){
                return false;
            }

            positionX = positionXTmp;
        }
        return true;
    }


    private boolean findObstacleX(int positionXTmp) {
        for (Obstacle obstacle : mars.getObstacles()) {
            if (positionXTmp == obstacle.getX() && positionY == obstacle.getY()) {
                System.out.println("Found obstacle, no more moving");
                return true;
            }
        }
        return false;
    }

    private boolean findObstacleY(int positionYTmp) {
        for (Obstacle obstacle : mars.getObstacles()) {
            if (positionYTmp == obstacle.getY() && positionX == obstacle.getX()) {
                System.out.println("Found obstacle, no more moving");
                return true;
            }
        }
        return false;
    }

    private int getLimiteSize(int positionYTmp) {
        if (positionYTmp == mars.SIZE) {
            positionYTmp = 0;
        } else if (positionYTmp == -1) {
            positionYTmp = mars.SIZE - 1;
        }
        return positionYTmp;
    }


    private int treatMove(Character move) {
        switch (move) {
            case 'F':
                return 1;
            case 'B':
                return -1;
            case 'L':
                direction = directionTab.getDirectionDecr(direction);
                return 0;
            case 'R':
                direction = directionTab.getDirectionIncr(direction);
                return 0;
            default:
                return 0;
        }
    }

    private int treatDirection() {
        switch (direction) {
            case 'S':
            case 'E':
                return 1;
            case 'N':
            case 'W':
                return -1;

            default:
                return 0;

        }
    }

    public ArrayList<Obstacle> getMarsObstacles() {
        return mars.getObstacles();
    }

}
