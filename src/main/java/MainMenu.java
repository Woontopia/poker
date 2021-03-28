import gameFactory.PokerFactory;
import gameTypes.SupportedTypes;

import java.util.Scanner;

public class MainMenu {

    public MainMenu() {
        printWelcomeMessage();
        printGameTypes();
        startGame(getUserInput());
    }

    private void printWelcomeMessage() {
        System.out.println(" Welcome to Poker ");
        System.out.println("------------------");
        System.out.println();
    }

    private void printGameTypes() {
        System.out.println("AVAILABLE GAMETYPES");
        for (SupportedTypes type: SupportedTypes.values()) {
            type.printType();
        }
        System.out.println();
    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput;
        String input;
        do {
            System.out.print("Select a gameType: ");
            input = scanner.nextLine();
            validInput = validateInput(input);
            if (!validInput) {
                printInvalidInput();
            }
        }while (!validInput);
        return Integer.parseInt(input);
    }

    private boolean validateInput(String input) {
        try {
            int intInput = Integer.parseInt(input);
            return intInput >= 1 && intInput <= SupportedTypes.values().length;
        } catch (Exception e) {
            return false;
        }
    }

    private void printInvalidInput() {
        System.out.println("Invalid choice: Pls select again!");
    }

    private void startGame(int userInput) {
        new PokerFactory().startGame(getSelectedType(userInput)).play();
    }

    private SupportedTypes getSelectedType(int userInput) {
        for (SupportedTypes type: SupportedTypes.values()) {
            if (userInput == type.getId()) {
                return type;
            }
        }
        return null;
    }
}
