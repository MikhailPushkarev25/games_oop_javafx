package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        Cell cell = Cell.A1;
        BishopBlack black = new BishopBlack(cell);
        assertThat( black.position(), is(cell));
    }

    @Test
    public void whenCopy() {
        Cell cell = Cell.A1;
        BishopBlack black = new BishopBlack(Cell.A2);
        assertThat(black.copy(cell).position(), is(cell));
    }

    @Test
    public void whenWay() {
        BishopBlack black = new BishopBlack(Cell.C1);
        Cell[] cells = black.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cells, is(expected));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenIsDiagonal() {
        boolean rsl = false;
        BishopBlack black = new BishopBlack(Cell.C1);
        Cell[] cells = black.way(Cell.G6);

        assertThat(cells, is(true));
    }
}