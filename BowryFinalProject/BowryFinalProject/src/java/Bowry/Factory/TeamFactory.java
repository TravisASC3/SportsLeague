/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bowry.Factory;

import Bowry.Classes.Players;
import Bowry.Classes.Teams;
import static Bowry.Factory.TeamFactory.generateJerseyNumber;
import static Bowry.Factory.TeamFactory.generateTeamName;
import static Bowry.Factory.TeamFactory.playerNames;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author travi
 */
public class TeamFactory {
    
     public static String[] Cities = {"New York","Dallas","Los Angeles","London","New Jeresy","Houston","Miami",
         "Kansas"};
     public static String[] teamName = {"Wolves","Thunder","Kickers","Knights","Thieves","Kings","Bears","Magicans"};
     public static String[] playerNames = {"Kevin Durant", "RJ Barrett","Anthony Davis","Russell Westbrook","Lebron James",
     "Patrick Mahomes","Julius Randle","Stephen Curry","Jalen Hurts","Leo Messi","Michael Jordan", "Tom Brady", "Damien Lillard", "Eli Manning", "Devin Booker",
    "Ja Morant", "Ben Chilwell", "Cristiano Ronaldo", "Klay Thompson", "Alophonse Davies",
    "Luka Doncic", "Mo Salah", "Kobe Bryant", "Joel Embiid", "Reece James",
    "Lamar Jackson", "Peyton Manning", "Kyrie Irving", "Zinedine Zidane", "David Beckham","Mbappe","Jude Bellignham"
             , "Christian Pulusic","Jalen Brunson","Jayson Tatum","Jalyen Brown","Trae Young",
             "Anthony Edwards","Carmelo Anthony","Neymar Jr","Giannis Antetokounmpo","Nikola Jokić","Jamal Murray",
     "James Harden","Travis Kelce"};
     
     
     public static String dir = "C:\\Users\\travi\\OneDrive\\Documents\\NetBeansProjects"
             + "\\BowryFinalProject\\src\\java\\Bowry\\Data\\i";
     
     
      public static String generateTeamLocation() {
        Random random = new Random();
        return Cities[random.nextInt(Cities.length)];
    }

    public static String generateTeamName() {
        Random random = new Random();
        return teamName[random.nextInt(teamName.length)];
    }   
    
    public static int generateJerseyNumber() {
        Random random = new Random();
        return random.nextInt(99) + 1;
    }
    
   // public static List<Players> generatePlayers(int numberofplayers)
   public static ArrayList<Players> generatePlayers(int numberofplayers) {
    ArrayList<Players> players = new ArrayList<>();
    Random random = new Random();

    Set<String> uniquePlayerNames = new HashSet<>();

    while (uniquePlayerNames.size() < numberofplayers) {
        String playerName = playerNames[random.nextInt(playerNames.length)];
        uniquePlayerNames.add(playerName);
    }

    for (String playerName : uniquePlayerNames) {
        int jerseyNumber = generateJerseyNumber();  // Include this line
        String team = generateTeamName();
        Players player = new Players(playerName, jerseyNumber);
        players.add(player);
    }

    return players;
}

     public static Teams generateTeams() {
            Random random = new Random();
            String teamName = generateTeamName();  
            String cities = generateTeamLocation(); 
            List<Players> players = generatePlayers(5); 
            Teams team = new Teams();
            
            team.setTeamName(teamName);
            team.setLocation(cities);
            team.setPlayers(players);
            return team;
        }


    public static void writeTeamToFile(ArrayList<Teams> teams, String fn) throws IOException 
 {
            FileWriter FW = new FileWriter(dir + fn);
             BufferedWriter BW = new BufferedWriter(FW); 

            for (Teams team : teams) {
                BW.write(team.toFile());
                BW.write("\n");
            }
            BW.close();
    }

    public static void writePlayerToFile(ArrayList<Players> players, String fn) throws IOException {
        try (FileWriter FW = new FileWriter(dir+fn);
             BufferedWriter BW = new BufferedWriter(FW)) {

             for (Players player : players) {
                BW.write(player.toFile());
                BW.write("\n");
            }
        }

}
    /*
      public static void writePlayertoDBFile(ArrayList<Players> players, String fn) throws IOException {
        try (FileWriter FW = new FileWriter(dir+fn);
             BufferedWriter BW = new BufferedWriter(FW)) {

             for (Players player : players) {
                BW.write(player.toFile());
                BW.write("\n");
            }
        }

}
*/
    public static void writeTeamToDBFile(ArrayList<Teams> teams, String fn) throws IOException 
 {
            try (FileWriter FW = new FileWriter(dir+fn);
             BufferedWriter BW = new BufferedWriter(FW)) {

             for (Teams team : teams) {
                BW.write(team.toDBFile());
                BW.write("\n");
                
                for (Players player : team.getPlayers()) {
                BW.write(player.toDBFile(team.getTeamName()));
                BW.write("\n");
            }
        }
    }
}
}
/*
       public static ArrayList<Players> generatePlayers(int numberofplayers) {
    ArrayList<Players> players = new ArrayList<>();
    Random random = new Random();

    Set<String> uniquePlayerNames = new HashSet<>();

    while (uniquePlayerNames.size() < numberofplayers) {
        String playerName = playerNames[random.nextInt(playerNames.length)];
        uniquePlayerNames.add(playerName);
    }

    for (String playerName : uniquePlayerNames) {
        int jerseyNumber = generateJerseyNumber();
        String team = generateTeamName();
        Players player = new Players(playerName, jerseyNumber);
        players.add(player);
    }

    return players;
}

  */