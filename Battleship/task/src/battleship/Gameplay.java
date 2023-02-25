package battleship;

import java.util.Scanner;

public class Gameplay {

    public Gameplay() {
        SeaBattle seaBattle1 = new SeaBattle();
        SeaBattle seaBattle2 = new SeaBattle();

        String namePlayer1 = "Player 1";
        String namePlayer2 = "Player 2";

        placeShip(seaBattle1, namePlayer1);
        System.out.println("Press Enter and pass the move to another player");
        input();
        placeShip(seaBattle2, namePlayer2);
        System.out.println("Press Enter and pass the move to another player");
        input();

        battle(seaBattle1, seaBattle2, namePlayer1, namePlayer2);

    }

    private void battle(SeaBattle seaBattle1, SeaBattle seaBattle2, String namePlayer1, String namePlayer2) {

        boolean finish = false;
        while (!finish) {

            finish = shooting(seaBattle2, seaBattle1, namePlayer1);
            if (finish) {
                break;
            } else {
                finish = shooting(seaBattle1, seaBattle2, namePlayer2);
            }
        }

    }

    private boolean shooting(SeaBattle seaBattle, SeaBattle mySeaBattle, String playerName) {

        seaBattle.printSeaBattle("shot");
        System.out.println("---------------------");
        mySeaBattle.printSeaBattle("full");
        System.out.printf("%s, it's your turn:\n\n", playerName);

//        while (true) {
            String inputShot = input();
            System.out.println();
            int x = (int) inputShot.charAt(0) - 64;
            int y = Integer.parseInt(inputShot.substring(1));

            if (x > 10 || y > 10) {
                System.out.println("Error! You entered the wrong coordinates! Try again:\n");
            } else {
                switch (seaBattle.getFieldStatus(x - 1, y - 1)) {
                    case 0 -> System.out.println("You missed!");
                    case 1 -> System.out.println("You hit a ship!");
                    case 2 -> System.out.println("You sank a ship!");
                    case 3 -> {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        return true;
                    }
                }
                System.out.println("Press Enter and pass the move to another player");
                input();
            }
//        }
        return false;

    }

    private void placeShip(SeaBattle seaBattle, String playerName) {

        System.out.printf("%s, place your ships on the game field\n\n", playerName);

        seaBattle.printSeaBattle("all");

        String shipType = "";
        int cells = 0;

        while (seaBattle.getCountShip() < 5) {
            switch (seaBattle.getCountShip()) {
                case 0 -> {
                    shipType = "Aircraft Carrier";
                    cells = 5;
                }
                case 1 -> {
                    shipType = "Battleship";
                    cells = 4;
                }
                case 2 -> {
                    shipType = "Submarine";
                    cells = 3;
                }
                case 3 -> {
                    shipType = "Cruiser";
                    cells = 3;
                }
                case 4 -> {
                    shipType = "Destroyer";
                    cells = 2;
                }

            }
            System.out.printf("Enter the coordinates of the %s (%d cells):\n\n", shipType, cells);

            placeCheck(shipType, cells, seaBattle);
        }

    }

    private void placeCheck(String shipType, int cells, SeaBattle seaBattle) {

        while (true) {
            String[] input = input().split("\\s");

            System.out.println();
            int startX = (int) input[0].charAt(0) - 64;
            int startY = Integer.parseInt(input[0].substring(1));
            int endX = (int) input[1].charAt(0) - 64;
            int endY = Integer.parseInt(input[1].substring(1));

            int max = Math.max(startX, endX);
            int min = Math.min(startX, endX);
            startX = min;
            endX = max;
            max = Math.max(startY, endY);
            min = Math.min(startY, endY);
            startY = min;
            endY = max;

            if (endX - startX != 0 && endY - startY != 0) {
                System.out.println("Error! Wrong ship location! Try again:\n");
            } else if (endX - startX != cells - 1 && endY - startY != cells - 1) {
                System.out.printf("Error! Wrong length of the %s! Try again:\n\n", shipType);
            } else if (!seaBattle.isCreateShip(startX, startY, endX, endY)) {
                System.out.println("Error! You placed it too close to another one. Try again:\n");
            } else {
                seaBattle.createShip(startX, startY, endX, endY);
                break;
            }
        }
    }

    private String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
