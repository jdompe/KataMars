public class MPS {

    private Mars mars;

    public MPS() {
        mars = new Mars();
    }

    public Position nextPosition(Position currentPosition, int nextStep, int orientationFactor, char currentDirection) throws ObstacleException {
        int nextX = currentPosition.getX();
        int nextY = currentPosition.getY();
        if (isOrientedVertically(currentDirection)) {
            nextY = nextCoordinate(nextStep, orientationFactor, currentPosition.getY());
        } else {
            nextX = nextCoordinate(nextStep, orientationFactor, currentPosition.getX());
        }
        if (mars.isThereObstacle(nextX, nextY)) {
            throw new ObstacleException();
        }
        return new Position(nextX, nextY);
    }

    private int nextCoordinate(int nextStep, int orientationFactor, int coordinate) {
        int nextCoordinate;
        nextCoordinate = coordinate + (nextStep * orientationFactor);
        nextCoordinate = mars.getNewPositionChecked(nextCoordinate);
        return nextCoordinate;
    }

    private boolean isOrientedVertically(char currentDirection) {
        return currentDirection == 'S' || currentDirection == 'N';
    }
}
