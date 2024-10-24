package core;

public class Cell {
    private boolean shot;
    private boolean ship;
    private boolean hit;
    private boolean miss;

    Cell() {
        shot = false;
        ship = false;
        hit = false;
        miss = false;
    }

    Cell(boolean ship) {
        this.ship = ship;
        this.shot = false;
        this.hit = false;
        this.miss = false;
    }

    public boolean isEmpty() {
        return !this.hasShip();
    }

    public boolean hasBeenShot() {
        return this.shot;
    }

    public boolean hasShip() {
        return this.ship;
    }

    public boolean cellIsHit() {
        return this.hit;
    }

    public boolean cellIsMiss() {
        return this.miss;
    }

    public void hit() {
        if ((hasBeenShot()) && (hasShip())) {
            setAsHit();
        }
    }

    public void miss() {
        if ((hasBeenShot()) && (!hasShip())) {
            setAsMiss();
        }
    }

    public void setAsShot() {
        this.shot = true;
    }

    public void setAsShip() {
        this.ship = true;
    }

    public void setAsMiss() {
        this.miss = true;
    }

    public void setAsHit() {
        this.hit = true;
    }
}
