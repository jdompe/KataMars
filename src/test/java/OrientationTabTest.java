import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OrientationTabTest {
    @Test
    public void getDirectionDecr() throws Exception {
        OrientationTab orientationTab = new OrientationTab();

        char newDirection = orientationTab.getDirectionTurnLeft('W');

        assertThat(newDirection).isEqualTo('S');
    }

    @Test
    public void getDirectionIncr() throws Exception {
        OrientationTab orientationTab = new OrientationTab();

        char newDirection = orientationTab.getDirectionTurnRight('W');

        assertThat(newDirection).isEqualTo('N');
    }

    @Test
    public void getDirectionDecr_limite() throws Exception {
        OrientationTab orientationTab = new OrientationTab();

        char newDirection = orientationTab.getDirectionTurnLeft('S');

        assertThat(newDirection).isEqualTo('E');
    }

    @Test
    public void getDirectionIncr_limite() throws Exception {
        OrientationTab orientationTab = new OrientationTab();

        char newDirection = orientationTab.getDirectionTurnRight('E');

        assertThat(newDirection).isEqualTo('S');
    }

}