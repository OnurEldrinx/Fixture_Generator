import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FixtureGenerator generator = new FixtureGenerator();
        ArrayList<String> teams = new ArrayList<>();

        System.out.print("How many teams are there in the league : ");
        int howManyTeams = scanner.nextInt();
        scanner.nextLine(); // dummy

        for (int i=0;i<howManyTeams;i++){

            System.out.print((i+1) + ".Team : ");
            teams.add(scanner.nextLine().toUpperCase().trim());

        }

        if (howManyTeams %2 != 0){

            teams.add("BAY");

        }

        System.out.println();

        ArrayList<ArrayList<Game>> rounds = new ArrayList<>(generator.generateFixture(teams));

        int counter = 1;

        for (ArrayList<Game> round:rounds){

            System.out.println("Round-"+counter);
            System.out.println("--------------------------------------------------");
            for (Game game:round) {

                System.out.println(game.getHomeTeam() + " vs " + game.getAwayTeam());

            }
            System.out.println("--------------------------------------------------");

            counter++;

        }

        for (ArrayList<Game> round:rounds){

            System.out.println("Round-"+counter);
            System.out.println("--------------------------------------------------");
            for (Game game:round) {

                System.out.println(game.getAwayTeam() + " vs " + game.getHomeTeam());

            }
            System.out.println("--------------------------------------------------");

            counter++;

        }

    }
}
