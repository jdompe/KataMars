import java.util.ArrayList;
import java.util.Arrays;

public class DirectionTab {
    ArrayList<Character> directionTab;

    public DirectionTab() {
        directionTab = new ArrayList<Character>();
        directionTab.addAll(Arrays.asList('S','W','N','E'));
    }

    public char getDirectionDecr(Character d) {
        int index =  directionTab.indexOf(d);
        if(index == 0){
            return directionTab.get(3);
        }
        return directionTab.get(index - 1);
    }

    public char getDirectionIncr(Character d) {
        int index =  directionTab.indexOf(d);
        if(index == 3){
            return directionTab.get(0);
        }
        return directionTab.get(index + 1);
    }
}
