class Printer {

    private Rover rover;
    private Mars mars;

    Printer(Rover rover, Mars mars){
        this.rover = rover;
        this.mars = mars;
    }

    void displayMars() {

        for (int i = 0; i < Mars.SIZE; i++) {
            for (int j = 0; j < Mars.SIZE; j++) {
                boolean isO = false;

                for (Obstacle obstacle : mars.getObstacles()) {
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
