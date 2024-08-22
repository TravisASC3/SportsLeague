/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Bowry.Servlets;

import Bowry.Classes.Players;
import Bowry.Classes.Teams;
import Bowry.Factory.TeamFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author travi
 */
public class GenerateTeams extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //ArrayList<Players> players = new ArrayList<>(); 
            ArrayList<Players> players = TeamFactory.generatePlayers(5);
            ArrayList<Teams> teams = new ArrayList<>();
            //Teams team = TeamFactory.generateTeamName();
            
            
           /* for(int i = 0; i < 10; i++)
            {
                Teams team = TeamFactory.generateTeams();
                List<Players> playerName = TeamFactory.generatePlayers(7);
                int jerseyNumber = TeamFactory.generateJerseyNumber(); 
                Players player = new Players();
                players.add(player);
                teams.add(team);
            }*/
           for (int i = 0; i < 8; i++) {
                Teams team = TeamFactory.generateTeams();
                ArrayList<Players> playersList = TeamFactory.generatePlayers(5);

                
                for (Players player : playersList) {
                    player.setJeresyNum(TeamFactory.generateJerseyNumber());
                }

                players.addAll(playersList);
                teams.add(team);
            }

            TeamFactory.writeTeamToFile(teams,"Teams");
            TeamFactory.writePlayerToFile(players,"Players");
            //TeamFactory.writePlayertoDBFile(players, "Players");
            TeamFactory.writeTeamToDBFile(teams, "Teams");
       
           /* for (int i = 0; i < 3; i++) {
            Teams team = TeamFactory.generateTeamLocation();
            teams.add(team);
            
            */
            //TeamFactory.writePlayerToFile(players, fileName);
            //TeamFactory.writeTeamToFile(ArrayList<Teams> teams, String fileName);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Building Teams...</h1>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
