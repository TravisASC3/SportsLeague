/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bowry.Classes;

import Bowry.Factory.TeamFactory;

/**
 *
 * @author travi
 */
public class Players {
    private String playerName;
    private int jeresyNum;
   // private String team;

    public Players(String playerName, int jeresyNum) {
        this.playerName = playerName;
          this.jeresyNum = jeresyNum;
        //    this.team = team;
       // this.playerName = playerName = TeamFactory.generatePlayers(7);
       // this.jeresyNum = jeresyNum = TeamFactory.generateJerseyNumber();
       // this.team = team = TeamFactory.generateTeamName();
        
        
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getJeresyNum() {
        return jeresyNum;
    }

    public void setJeresyNum(int jeresyNum) {
        this.jeresyNum = jeresyNum;
    }
/*
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
*/
    @Override
    public String toString() {
        return "Players{" + "playerName=" + playerName + ", jeresyNum=" + jeresyNum +  '}';
    }

    public String toHTML() {
       return "Players{" + "playerName=" + playerName + ", jeresyNum=" + jeresyNum +  '}';
    }

    public String toFile() {
      return "Players{" + "playerName= " + playerName + ", jeresyNum= " + jeresyNum + '}';
    }
       
     public String toDBFile(String teamName) {
       String s=  "INSERT INTO players (playername, jerseynumber, teamname) VALUES ('" +
            playerName + "', " + jeresyNum + ", '" + teamName + "');";
       return s;
    }
      
   
    
}
    