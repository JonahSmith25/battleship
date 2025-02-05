// Raihan and Jonah
package core;

/**
 * objects used as spaces on grid
 * ref# 73 https://github.com/skiadas/battleship/issues/73#issue-2824091429
 * Raihan
 */
public class Cell {
    /**
     * denotes if a cell has been shot.
     * ref# 81 https://github.com/skiadas/battleship/issues/81#issue-2828172112
     * @author Jonah Smith
     */
    private boolean shot;
    /**
     * denotes if a cell houses part of a ship.
     * ref# 81 https://github.com/skiadas/battleship/issues/81#issue-2828172112
     * @author Jonah Smith
     */
    private boolean ship;

    /**
     * Creates a default cell object that has not been shot and does not contain a ship
     * ref# 94 https://github.com/skiadas/battleship/issues/94#issue-2833525080
     * @author Jonah
     */
    public Cell() {
        this.shot = false;
        this.ship = false;
    }
    /**
     * Creates a cell with the specified ship presence.
     *  @param ship {@code true} if the cell contains a ship, {@code false} otherwise.
     * ref #94   https://github.com/skiadas/battleship/issues/94#issue-2833525080
     * @author mdhamimraihan
     */
    public Cell(boolean ship) {
        this.ship = ship;
        this.shot = false;
    }
    /**
     *returns true if cell does not contain a ship
     * ref# 94 https://github.com/skiadas/battleship/issues/94#issue-2833525080
     * @author Jonah
     */
    public boolean isEmpty() {
        return !this.hasShip();
    }

    /**
     * Checks if the cell has been shot.
     *
     * @return {@code true} if the cell has been shot, {@code false} otherwise.
     * * ref #94   https://github.com/skiadas/battleship/issues/94#issue-2833525080
     * @author mdhamimraihan
     */
    public boolean hasBeenShot() {
        return this.shot;
    }

    /**
     *returns true if cell contains a ship
     * ref# 94 https://github.com/skiadas/battleship/issues/94#issue-2833525080
     * @author Jonah
     */
    public boolean hasShip() {
        return this.ship;
    }

    /**
     * Determines if the shot on this cell resulted in a hit.
     *
     * @return {@code true} if the cell has been shot and contains a ship, {@code false} otherwise.
     * ref #94   https://github.com/skiadas/battleship/issues/94#issue-2833525080
     *@author mdhamimraihan
     */
    public boolean cellIsHit() {
        return this.hasBeenShot() && this.hasShip();
    }

    /**
     *shot on cell resulted in a miss
     * ref# 94 https://github.com/skiadas/battleship/issues/94#issue-2833525080
     * @author Jonah
     */
    public boolean cellIsMiss() {
        return this.hasBeenShot() && !this.hasShip();
    }

    /** Mark the cell as shot

     * ref #94   https://github.com/skiadas/battleship/issues/94#issue-2833525080
     *@author mdhamimraihan
     */
    public void setAsShot() {
        this.shot = true;
    }

    /**
     *place a ship in a cell
     * ref# 94 https://github.com/skiadas/battleship/issues/94#issue-2833525080
     * @author Jonah
     */
    public void setAsShip() {
        this.ship = true;
    }
    /**
     *Marks the cell as a hit, meaning it has been shot and contains a ship.
     * * * * ref #94   https://github.com/skiadas/battleship/issues/94#issue-2833525080
     *      ** @author mdhamimraihan
     */
    public void setAsHit() {
        this.ship = true;
        this.shot = true;
    }
    /**
     * Marks cell as a missed shot
     * ref# 94 https://github.com/skiadas/battleship/issues/94#issue-2833525080
     * @author Jonah
     */
    public void setAsMiss() {
        this.shot = true;
        this.ship = false;
    }

    /**
     * Resets the cell to its initial state (no ship, not shot).
     * * * ref #94   https://github.com/skiadas/battleship/issues/94#issue-2833525080
     ** @author mdhamimraihan
     */
    public void reset() {
        this.shot = false;
        this.ship = false;
    }
}
