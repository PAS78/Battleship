package battleship;

public class Ship {
    private String shipType;
    private int cells;
    private int[][] firstPosition;
    private boolean vertical;
    private final boolean[] status = new boolean [cells];
    private int count = 0;

//    public Ship(int size, int[][] firstPosition, boolean vertical) {
//        this.size = size;
//        this.firstPosition = firstPosition;
//        this.vertical = vertical;
//        count++;
//    }

    public Ship(String start, String end) {
        this.cells = cells;
        this.firstPosition = firstPosition;
        this.vertical = vertical;
        count++;
    }

    public int getCount() {
        return count;
    }

}
