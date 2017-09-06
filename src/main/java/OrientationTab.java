import java.util.ArrayList;

public class OrientationTab {
    private ArrayList<Character> orientationTab;

    public OrientationTab() {
        orientationTab = new ArrayList<>();
        orientationTab.add('S');
        orientationTab.add('W');
        orientationTab.add('N');
        orientationTab.add('E');
    }

    public char getDirectionTurnLeft(Character d) {
        int index = orientationTab.indexOf(d);
        if (index == 0) {
            return orientationTab.get(3);
        }
        return orientationTab.get(index - 1);
    }

    public char getDirectionTurnRight(Character d) {
        int index = orientationTab.indexOf(d);
        if (index == 3) {
            return orientationTab.get(0);
        }
        return orientationTab.get(index + 1);
    }

    public int treatDirection(char orientation) {
        switch (orientation) {
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
}
