import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void getPosition_returns1_whenRoverIn0MoveForwardDirectSouth() {
        //Given
        Rover rover = new Rover(0, 0, 'S');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('F');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void getPosition_returns0_whenRoverIn1MoveForwardDirectionNorth() {
        //Given
        Rover rover = new Rover(0, 1, 'N');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('F');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(0);
    }

    @Test
    public void getPosition_returns0_whenRoverIn1MoveBackwardDirectionSouth() {
        //Given
        Rover rover = new Rover(0, 1, 'S');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('B');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(0);
    }

    @Test
    public void getPosition_returns1_whenRoverIn1MoveBackwardDirectionSouth() {
        //Given
        Rover rover = new Rover(0, 1, 'S');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('B');
        arrayMove.add('F');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void getPosition_returns2_whenRoverIn1MoveBackwardDirectionNorth() {
        //Given
        Rover rover = new Rover(0, 1, 'N');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('B');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(2);
    }

 @Test
    public void getDirection_returnsE_whenDirectionSouthMoveLeft() {
        //Given
        Rover rover = new Rover(0, 0, 'S');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('L');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        char direction = rover.getDirection();
        assertThat(position[1]).isEqualTo(0);
        assertThat(position[0]).isEqualTo(0);
        assertThat(direction).isEqualTo('E');
    }

    @Test
    public void returns_N_and_3_1_whenRoverIn1_1DirectionSouthMove_L_F_F_L() {
        //Given
        Rover rover = new Rover(3, 7, 'S');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('L');
        arrayMove.add('F');
        arrayMove.add('F');
        arrayMove.add('L');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        char direction = rover.getDirection();
        assertThat(direction).isEqualTo('N');
        assertThat(position[0]).isEqualTo(5);
        assertThat(position[1]).isEqualTo(7);
    }
 @Test
    public void returns0_whenYSupSizeMax() {
        //Given
        Rover rover = new Rover(0, 9, 'S');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('F');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[1]).isEqualTo(0);
    }
@Test
    public void returns0and9_whenYSupSizeMax() {
        //Given
        Rover rover = new Rover(9, 9, 'E');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('F');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(0);
        assertThat(position[1]).isEqualTo(9);
    }
@Test
    public void returns0and9_whenYInf0() {
        //Given
        Rover rover = new Rover(0, 0, 'E');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('B');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(9);
        assertThat(position[1]).isEqualTo(0);
    }
@Test
    public void obstacle_whenYInf0() {
        //Given
        Rover rover = new Rover(0, 1, 'E');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('F');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(0);
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void obstacle_2() {
        //Given
        Rover rover = new Rover(6, 2, 'S');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('F');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(6);
        assertThat(position[1]).isEqualTo(2);
    }

    @Test
    public void obstacle_3() {
        //Given
        Rover rover = new Rover(8, 1, 'S');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('B');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(8);
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void obstacle_withListActions() {
        //Given
        Rover rover = new Rover(8, 1, 'S');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('B');
        arrayMove.add('F');
        arrayMove.add('F');
        arrayMove.add('B');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(8);
        assertThat(position[1]).isEqualTo(1);
    }

    @Test
    public void obstacle_2_withActions() {
        //Given
        Rover rover = new Rover(7, 3, 'E');
        List<Character> arrayMove = new ArrayList<Character>();
        arrayMove.add('B');
        arrayMove.add('F');
        arrayMove.add('F');
        arrayMove.add('R');
        arrayMove.add('F');

        //When
        rover.move(arrayMove);

        //Then
        int[] position = rover.getPosition();
        assertThat(position[0]).isEqualTo(7);
        assertThat(position[1]).isEqualTo(3);
    }


}