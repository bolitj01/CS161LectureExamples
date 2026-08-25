package gridescape_solutions;

public class GridEntity_Solution {
    private int x;
    private int y;

    public GridEntity_Solution(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

    public void moveTo(int newX, int newY) {
        x = newX;
        y = newY;
    }

    //Calculates the Manhattan distance between another GridEntity
    public int distanceFrom(GridEntity_Solution other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }
}
