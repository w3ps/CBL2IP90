/**
 * Class for the movement and logic of the playable in-game character.
 */
public class Player implements Movement {
    int x;
    int y;
    int step;

    /**
     * Constructor for the player class.
     */
    Player() {
        this.x = 0;
        this.y = 0;
        this.step = 10;
    }

    public void moveR() {
        this.x += this.step;
    }

    public void moveL() {
        this.x -= this.step;
    }

    public void moveU() {
        this.y += this.step;
    }

    public void moveD() {
        this.y -= this.step;
    }
}
