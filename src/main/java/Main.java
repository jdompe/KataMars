import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        Rover rover = new Rover(5, 5, 'S');
        Mars mars = new Mars();
        Printer printer = new Printer(rover, mars);

        printer.displayMars();

        List<Commandes> arrayMove = new ArrayList<>();

        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.R);
        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.R);

        System.out.println(' ');

        try {
            rover.travel(arrayMove);
        } catch (ObstacleException e) {
            e.printStackTrace();
        }

        printer.displayMars();

    }

}
