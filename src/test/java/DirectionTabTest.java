import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class DirectionTabTest {
    @Test
    public void getDirectionDecr() throws Exception {
        DirectionTab directionTab = new DirectionTab();

        char newDirection = directionTab.getDirectionDecr('W');

        assertThat(newDirection).isEqualTo('S');
    }

    @Test
    public void getDirectionIncr() throws Exception {
        DirectionTab directionTab = new DirectionTab();

        char newDirection = directionTab.getDirectionIncr('W');

        assertThat(newDirection).isEqualTo('N');
    }

    @Test
    public void getDirectionDecr_limite() throws Exception {
        DirectionTab directionTab = new DirectionTab();

        char newDirection = directionTab.getDirectionDecr('S');

        assertThat(newDirection).isEqualTo('E');
    }

    @Test
    public void getDirectionIncr_limite() throws Exception {
        DirectionTab directionTab = new DirectionTab();

        char newDirection = directionTab.getDirectionIncr('E');

        assertThat(newDirection).isEqualTo('S');
    }

}