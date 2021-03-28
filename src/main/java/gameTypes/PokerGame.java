package gameTypes;

import gameEntity.Dealer;
import gameEntity.player.Computer;
import gameEntity.player.Human;
import gameEntity.player.Player;
import utilities.TieSettler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class PokerGame {
    int MAXPLAYERS;
    int MINPLAYERS;
    int nbPlayers;
    int playerNumberOfCards;
    List<Player> players = new ArrayList<>();
    Dealer dealer;
    TieSettler settler;
    boolean playing = true;

    public abstract void play();

    public abstract void newRound();

    public void askNumberOfPlayers() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("How many players: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid Input");
                sc.next();
            }
            nbPlayers = sc.nextInt();
        }while (nbPlayers < MINPLAYERS || nbPlayers > MAXPLAYERS);
    }

    public void printNotAvailable() {
        System.out.println("This type of poker is not supported yet.");
    }

    public void addPlayers() {
        players.add(new Human(playerNumberOfCards, "P1"));
        for (int i = 1; i < nbPlayers; i++) {
            players.add(new Computer(playerNumberOfCards, "AI-" + i));
        }
        System.out.println(players.size());
    }

    public void askForNewRound() {
        Scanner sc = new Scanner(System.in);
        String response;
        do {
            System.out.println();
            System.out.print("Do you want to play a new round? (yes / no): ");
            response = sc.nextLine();
            if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
                System.out.println("Invalid Input: Why do you hate me?");
            }
        }while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no"));
        if (response.equalsIgnoreCase("no")) {
            playing = false;
        }
        newRound();
    }
}
