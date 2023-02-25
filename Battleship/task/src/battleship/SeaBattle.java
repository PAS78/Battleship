package battleship;

import java.util.Arrays;
import java.util.Objects;

public class SeaBattle {
    private final char[][] seaBattle = new char[10][10];
    private int countShip = 0;

    public SeaBattle() {
        for (char[] chars : seaBattle) {
            Arrays.fill(chars, '~');
        }
    }

    public void createShip(int startX, int startY, int endX, int endY) {

        for (int i = startX - 1; i < endX; i++) {
            for (int j = startY - 1; j < endY; j++) {
                seaBattle[i][j] = 'O';
            }
        }

        countShip++;
        printSeaBattle("all");
    }

    public boolean isCreateShip(int startX, int startY, int endX, int endY) {

        if (startX == 1) {
            startX++;
        }
        if (startY == 1) {
            startY++;
        }
        if (endX == 10) {
            endX--;
        }
        if (endY == 10) {
            endY--;
        }

        for (int i = startX - 2; i < endX + 1; i++) {
            for (int j = startY - 2; j < endY + 1; j++) {
                if (seaBattle[i][j] == 'O') {
                    return false;
                }
            }
        }

        return true;
    }

    public void printSeaBattle(String filter) {
        char[] abc = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < seaBattle.length; i++) {
            System.out.print(abc[i] + " ");
            for (int j = 0; j < seaBattle[i].length; j++) {

                switch (filter) {
                    case "clear" -> System.out.print("~");
                    case "shot" -> {
                        if (Objects.equals(seaBattle[i][j], 'O')) {
                            System.out.print("~");
                        } else {
                            System.out.print(seaBattle[i][j]);
                        }
                    }
                    default -> System.out.print(seaBattle[i][j]);
                }
                if (j != seaBattle[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

    }

    public int getCountShip() {
        return countShip;
    }

    public void setCountShip(int countShip) {
        this.countShip = countShip;
    }

    public int getFieldStatus(int x, int y) {
        int status = 0; // 0 - missed; 1 - hit; 2 - sank; 3 - win

        if (seaBattle[x][y] == '~' || seaBattle[x][y] == 'M') {
            seaBattle[x][y] = 'M';
        } else {
            seaBattle[x][y] = 'X';
            if (isWin()) {
                status = 3;
            } else if (isSankShip(x, y)) {
                status = 2;
            } else {
                status = 1;
            }
        }

//        printSeaBattle("shot");

        return status;

    }

    private boolean isWin() {
        boolean result = true;

        for (char[] chars : seaBattle) {
            for (char aChar : chars) {
                if (Objects.equals(aChar, 'O')) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    private boolean isSankShip(int x, int y) {

        boolean sank = false;

        for (int i = x + 1; i < seaBattle.length; i++) {
//            System.out.println("1 DEBUG: " + seaBattle[i][y] + " x: " + i + " y: " + y);

            if (seaBattle[i][y] == 'O') {
                return sank;
            } else if (seaBattle[i][y] == '~' || seaBattle[i][y] == 'M') {
                break;
            }
        }

        for (int i = x - 1; i > 0; i--) {
//            System.out.println("2 DEBUG: " + seaBattle[i][y] + " x: " + i + " y: " + y);
            if (seaBattle[i][y] == 'O') {
                return sank;
            } else if (seaBattle[i][y] == '~' || seaBattle[i][y] == 'M') {
                break;
            }
        }

        for (int i = y + 1; i < seaBattle.length; i++) {
//            System.out.println("3 DEBUG: " + seaBattle[i][y] + " x: " + x + " y: " + i);
            if (seaBattle[x][i] == 'O') {
                return sank;
            } else if (seaBattle[x][i] == '~' || seaBattle[x][i] == 'M') {
                break;
            }
        }

        for (int i = y - 1; i > 0; i--) {
//            System.out.println("4 DEBUG: " + seaBattle[i][y] + " x: " + x + " y: " + i);
            if (seaBattle[x][i] == 'O') {
                return sank;
            } else if (seaBattle[x][i] == '~' || seaBattle[x][i] == 'M') {
                break;
            }
        }

        return true;

    }

}
