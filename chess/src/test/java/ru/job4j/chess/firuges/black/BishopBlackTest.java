package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BishopBlackTest {

    @Test
    public void position() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Cell result = bishopBlack.position();
        assertThat(result, is(Cell.C8));
    }

    @Test
    public void copy() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Figure copy = bishopBlack.copy(Cell.F5);
        Cell result = copy.position();
        assertThat(result, is(Cell.F5));
    }

    @Test
    public void way() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.E6);
        bishopBlack.way(Cell.E4);
    }
}