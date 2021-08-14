import java.util.ArrayList;

public class FixtureGenerator {

    public ArrayList<ArrayList<Game>> generateFixture(ArrayList<String> teams){

        ArrayList <ArrayList<Game>> rounds = new ArrayList<>();

        String constantTeam = teams.get(teams.size()-1);
        teams.remove(constantTeam);

        int numberOfTeams = teams.size();
        int howManyRounds = numberOfTeams-1;
        int gamesEachRound = numberOfTeams/2;

        ArrayList<String> tempTeams = new ArrayList<>(teams);

        // Circle Algorithm
        for (int i=0;i<=howManyRounds;i++){

            ArrayList<Game> round = new ArrayList<>();

            for (int j=0;j<=gamesEachRound;j++){

                if (j==0){

                    round.add(new Game(tempTeams.get(0),constantTeam));

                }else{

                    round.add(new Game(tempTeams.get(j),tempTeams.get(tempTeams.size()-j)));

                }

            }

            rounds.add(round);

            String last = tempTeams.get(tempTeams.size()-1);
            tempTeams.remove(last);
            ArrayList<String> subList = new ArrayList<>(tempTeams);
            tempTeams.clear();
            tempTeams.add(last);
            tempTeams.addAll(subList);


        }


        return rounds;


    }

}
