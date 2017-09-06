import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsTest {
    @Test
    public void isThereObstacle_returns_true_on_X6_Y3() throws Exception {
        // GIVEN
        Mars mars = new Mars();

        // WHEN
        boolean thereIsObstacle = mars.isThereObstacle(6,3);

        // THEN
        assertThat(thereIsObstacle).isTrue();
    }

    @Test
    public void isThereObstacle_returns_true_on_X8_Y0() throws Exception {
        // GIVEN
        Mars mars = new Mars();

        // WHEN
        boolean thereIsObstacle = mars.isThereObstacle(8,0);

        // THEN
        assertThat(thereIsObstacle).isTrue();
    }

    @Test
    public void isThereObstacle_returns_false_on_X3_Y5() throws Exception {
        // GIVEN
        Mars mars = new Mars();

        // WHEN
        boolean thereIsObstacle = mars.isThereObstacle(3,5);

        // THEN
        assertThat(thereIsObstacle).isFalse();
    }


}