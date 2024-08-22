/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bowry.Classes;

import Bowry.Factory.TeamFactory;
import java.util.List;

/**
 *
 * @author travi
 */
public class Teams {
    
    private String teamName;
    private String Location;
    private List<Players> players;

    public Teams() {
      //  this.teamName = teamName;
        //this.Location = Location;
        //this.players = players;
        this.Location = TeamFactory.generateTeamLocation();
        this.teamName = TeamFactory.generateTeamName();
        this.players = TeamFactory.generatePlayers(5);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    @Override
    public String toString() {
         return "Teams{" +
            "teamName='" + teamName + '\'' +
            ", Location='" + Location + '\'' +
            ", players=" + players +
            '}';
    }
    
    public String toHTML() {
         return "Teams{" +
            "teamName='" + teamName + '\'' +
            ", Location='" + Location + '\'' +
            ", players=" + players +
            '}';
    }
    
    public String toFile() {
    return "Teams{" +
            "teamName='" + teamName + '\'' +
            ", Location='" + Location + '\'' +
            ", players=" + players +
            '}';
    }
    
      public String toDBFile() {
    String s = "INSERT INTO teams (teamname, location) VALUES ('" +
            teamName + "', '" + Location + "');";
    return s;
}
    
  
}
