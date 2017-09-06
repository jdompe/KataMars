import java.util.List;

class Rover {
    private static final int STEP_FORWARD = 1;
    private static final int STEP_BACKWARD = -1;
    private static final int DONT_MOVE = 0;
    private int positionY;
    private int positionX;
    private char direction;
    private OrientationTab orientationTab;
    private MPS mps;


    Rover(int positionX, int positionY, char direction) {
        this.positionY = positionY;
        this.positionX = positionX;
        this.direction = direction;
        orientationTab = new OrientationTab();
        mps = new MPS();
    }

    int[] getPosition() {
        return new int[]{positionX, positionY};
    }

    char getDirection() {
        return direction;
    }

    void travel(List<Commandes> arrayAction) throws ObstacleException {
        for (Commandes command : arrayAction) {
            turn(command);
            move(command);
        }
    }

    private void move(Commandes move) throws ObstacleException {
        int nextStep = nextStep(move);
        int orientationFactor = orientationTab.treatDirection(direction);
        Position nextPosition = mps.nextPosition(currentPosition(), nextStep, orientationFactor, direction);
        setPosition(nextPosition);
    }

    private void setPosition(Position nextPosition) {
        positionX = nextPosition.getX();
        positionY = nextPosition.getY();
    }

    private Position currentPosition() {
        return new Position(positionX, positionY);
    }

    private void turn(Commandes move) {
        if (move == Commandes.L) {
            direction = orientationTab.getDirectionTurnLeft(direction);
        } else if (move == Commandes.R) {
            direction = orientationTab.getDirectionTurnRight(direction);
        }
    }

    private int nextStep(Commandes move) {
        switch (move) {
            case F:
                return STEP_FORWARD;
            case B:
                return STEP_BACKWARD;
            default:
                return DONT_MOVE;
        }
    }
}
