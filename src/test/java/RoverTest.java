import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RoverTest {
    @Test
    public void getPositionY_Returns0_whenRoverPosition0() {
        //Given
        Rover rover = new Rover(0, 0, 'S');

        //When
        int[] position = rover.getPosition();

        //Then
        assertThat(position[1]).isEqualTo(0);
    }

    @Test
    public void getPosition_ReturnsS_whenRoverDirectionS() {
        //Given
        Rover rover = new Rover(0, 0, 'S');

        //When
        char direction = rover.getDirection();

        //Then
        assertThat(direction).isEqualTo('S');
    }


    @Test
    public void getPosition_returns1_whenRoverIn0MoveForwardDirectSouth() throws ObstacleException {
        //Given
        Rover rover = new Rover(0, 0, 'S');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.F);

        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void getPosition_returns0_whenRoverIn1MoveForwardDirectionNorth() throws ObstacleException {
        //Given
        Rover rover = new Rover(0, 1, 'N');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.F);
        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(0);
    }

    @Test
    public void getPosition_returns0_whenRoverIn1MoveBackwardDirectionSouth() throws ObstacleException {
        //Given
        Rover rover = new Rover(0, 1, 'S');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.B);

        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(0);
    }

    @Test
    public void getPosition_returns1_whenRoverIn1MoveBackwardDirectionSouth() throws ObstacleException {
        //Given
        Rover rover = new Rover(0, 1, 'S');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.B);
        arrayMove.add(Commandes.F);

        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void getPosition_returns2_whenRoverIn1MoveBackwardDirectionNorth() throws ObstacleException {
        //Given
        Rover rover = new Rover(0, 1, 'N');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.B);

        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(2);
    }

    @Test
    public void getDirection_returnsE_whenDirectionSouthMoveLeft() throws ObstacleException {
        //Given
        Rover rover = new Rover(0, 0, 'S');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.L);

        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        char direction = rover.getDirection();
        assertThat(position[1]).isEqualTo(0);
        assertThat(position[0]).isEqualTo(0);
        assertThat(direction).isEqualTo('E');
    }

    @Test
    public void returns_N_and_3_1_whenRoverIn1_1DirectionSouthMove_L_F_F_L() throws ObstacleException {
        //Given
        Rover rover = new Rover(3, 7, 'S');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.L);
        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.L);

        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        char direction = rover.getDirection();
        assertThat(direction).isEqualTo('N');
        assertThat(position[0]).isEqualTo(5);
        assertThat(position[1]).isEqualTo(7);
    }

    @Test
    public void returns0_whenYSupSizeMax() throws ObstacleException {
        //Given
        Rover rover = new Rover(0, 9, 'S');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.F);

        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(0);
    }

    @Test
    public void returns0and9_whenYSupSizeMax() throws ObstacleException {
        //Given
        Rover rover = new Rover(9, 9, 'E');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.F);

        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(0);
        assertThat(position[1]).isEqualTo(9);
    }

    @Test
    public void returns0and9_whenYInf0() throws ObstacleException {
        //Given
        Rover rover = new Rover(0, 0, 'E');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.B);

        //When
        rover.travel(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(9);
        assertThat(position[1]).isEqualTo(0);
    }

    @Test
    public void obstacle_whenYInf0() {
        //Given
        Rover rover = new Rover(0, 1, 'E');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.F);

        //When
        Throwable obstacle = catchThrowable(() -> {
            rover.travel(arrayMove);
        });

        // Then
        assertThat(obstacle).isInstanceOf(ObstacleException.class);
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(0);
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void obstacle_2() throws ObstacleException {
        //Given
        Rover rover = new Rover(6, 2, 'S');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.F);

        //When
        Throwable obstacle = catchThrowable(() -> {
            rover.travel(arrayMove);
        });

        // Then
        assertThat(obstacle).isInstanceOf(ObstacleException.class);
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(6);
        assertThat(position[1]).isEqualTo(2);
    }

    @Test
    public void obstacle_3() throws ObstacleException {
        //Given
        Rover rover = new Rover(8, 1, 'S');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.B);

        //When
        Throwable obstacle = catchThrowable(() -> {
            rover.travel(arrayMove);
        });

        // Then
        assertThat(obstacle).isInstanceOf(ObstacleException.class);
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(8);
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void obstacle_withListActions() throws ObstacleException {
        //Given
        Rover rover = new Rover(8, 1, 'S');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.B);
        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.B);

        //When
        Throwable obstacle = catchThrowable(() -> {
            rover.travel(arrayMove);
        });

        // Then
        assertThat(obstacle).isInstanceOf(ObstacleException.class);
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(8);
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void obstacle_2_withActions() throws ObstacleException {
        //Given
        Rover rover = new Rover(7, 3, 'E');
        List<Commandes> arrayMove = new ArrayList<Commandes>();
        arrayMove.add(Commandes.B);
        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.F);
        arrayMove.add(Commandes.R);
        arrayMove.add(Commandes.F);

        //When
        Throwable obstacle = catchThrowable(() -> {
            rover.travel(arrayMove);
        });

        // Then
        assertThat(obstacle).isInstanceOf(ObstacleException.class);
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(7);
        assertThat(position[1]).isEqualTo(3);
    }


}