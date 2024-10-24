package core;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class CellTest {
    @Test
    void defaultCellHoldsProperlyMade() {
        Cell cell = new Cell();
        assertEquals(true, cell.isEmpty());
        assertEquals(false, cell.hasBeenShot());
        assertEquals(false, cell.cellIsHit());
        assertEquals(false, cell.cellIsMiss());
    }

    @Test
    void cellCanBeMadeWithATrueSHipValue() {
        Cell cell = new Cell(true);
        assertEquals(false, cell.isEmpty());
        assertEquals(false, cell.hasBeenShot());
        assertEquals(false, cell.cellIsHit());
        assertEquals(false, cell.cellIsMiss());
    }

    @Test
    void canAddShipToEmptyCell() {
        Cell cell = new Cell();
        cell.setAsShip();
        assertEquals(false, cell.isEmpty());
        assertEquals(false, cell.hasBeenShot());
        assertEquals(false, cell.cellIsHit());
        assertEquals(false, cell.cellIsMiss());
    }

    @Test
    void canMarkShipAsShot() {
        Cell cell = new Cell();
        cell.setAsShot();
        assertEquals(true, cell.isEmpty());
        assertEquals(true, cell.hasBeenShot());
        assertEquals(false, cell.cellIsHit());
        assertEquals(false, cell.cellIsMiss());
    }

    @Test
    void canMarkShipAsHit() {
        Cell cell = new Cell(true);
        cell.setAsShot();
        cell.setAsHit();
        assertEquals(false, cell.isEmpty());
        assertEquals(true, cell.hasBeenShot());
        assertEquals(true, cell.cellIsHit());
        assertEquals(false, cell.cellIsMiss());
    }

    @Test
    void canMarkShipAsMiss() {
        Cell cell = new Cell();
        cell.setAsShot();
        cell.setAsMiss();
        assertEquals(true, cell.isEmpty());
        assertEquals(true, cell.hasBeenShot());
        assertEquals(false, cell.cellIsHit());
        assertEquals(true, cell.cellIsMiss());
    }

    @Test
    void cantMarkAnEmptyCellAsHit() {
        Cell cell = new Cell();
        cell.setAsShot();
        cell.hit();
        assertEquals(false, cell.cellIsHit());
    }

    @Test
    void cantMarkAShipCellSpaceAsMiss() {
        Cell cell = new Cell(true);
        cell.setAsShot();
        cell.miss();
        assertEquals(false, cell.cellIsMiss());
    }

    @Test
    void cellWithShipReturnsFalseForIsEmpty() {
        Cell cell = new Cell(true);
        assertFalse(cell.isEmpty());
    }

    @Test
    void hittingWithoutBeingShotDoesNotMarkAsHit() {
        Cell cell = new Cell(true);
        cell.hit();
        assertFalse(cell.cellIsHit());
    }
    @Test
    void missingWithoutBeingShotDoesNotMarkAsMiss() {
        Cell cell = new Cell();
        cell.miss();
        assertFalse(cell.cellIsMiss());
    }

    @Test
    void settingAsShotMultipleTimesDoesNotChangeState() {
        Cell cell = new Cell();
        cell.setAsShot();
        cell.setAsShot();
        assertTrue(cell.hasBeenShot());
        assertFalse(cell.cellIsHit());
        assertFalse(cell.cellIsMiss());
    }

    @Test
    void settingAsHitThenMissDoesNotChangeStateToMiss() {
        Cell cell = new Cell(true);
        cell.setAsShot();
        cell.setAsHit();
        cell.miss();
        assertTrue(cell.cellIsHit());
        assertFalse(cell.cellIsMiss());
    }

    @Test
    void settingAsMissThenHitDoesNotChangeStateToHit() {
        Cell cell = new Cell();
        cell.setAsShot();
        cell.setAsMiss();
        cell.hit();
        assertFalse(cell.cellIsHit());
        assertTrue(cell.cellIsMiss());
    }
}