package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        Cell cell = Cell.A7;
        BishopBlack black = new BishopBlack(cell);
        Cell cells = black.position();
        assertThat(cells, is(cell));
    }

    @Test
    public void whenCopy() {
        Cell cell = Cell.A1;
        BishopBlack black = new BishopBlack(Cell.A1);
        Cell cells = black.copy(cell).position();
        assertThat(cells, is(cell));
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
        BishopBlack black = new BishopBlack(Cell.C1);
        Cell[] cells = black.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.B3, Cell.H4, Cell.G5};
        assertThat(cells, is(expected));
    }
}