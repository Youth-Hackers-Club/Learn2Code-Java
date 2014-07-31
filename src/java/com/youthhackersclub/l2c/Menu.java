/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youthhackersclub.l2c;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author scott ramsay
 */
@ServerEndpoint("/menu")
public class Menu extends HttpServlet {
    
    private ArrayList<MenuItem> menuItems;
    
    public Menu() {
        this(new MenuItem[]{new MenuItem("Home", "home", Color.darkGray, Color.yellow)});
    }
    
    public Menu(MenuItem[] menuItems) {
        this.menuItems = new ArrayList<MenuItem>();
        this.menuItems.addAll(Arrays.asList(menuItems));
    }
    
    public Menu(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param menuItems 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, ArrayList<MenuItem> menuItems)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table><tbody><tr>");
            for (int i = 0; i < menuItems.size(); i++) {
                out.println(menuItems.get(i).getHTMLCode());
            }
            out.println("</tr></tbody></table>");
            out.println("</menu>");
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
        processRequest(request, response, menuItems);
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
        
        processRequest(request, response, menuItems);
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
    
    public static class MenuItem {
        String name;
        String link;
        Color backgroundColour;
        Color textColour;

        public MenuItem(String name, String link, Color backgroundColour, Color textColour) {
            this.name = name;
            this.link = link;
            this.backgroundColour = backgroundColour;
            this.textColour = textColour;
        }
        
        public String getHTMLCode() {
            String s = "";
            s += "<td bgcolor=\"rgb(";
            s += backgroundColour.getRed();
            s += ", ";
            s += backgroundColour.getGreen();
            s += ", ";
            s += backgroundColour.getBlue();
            s += ")\"><a style=\"color:rgb(";
            s += textColour.getRed();
            s += ", ";
            s += textColour.getGreen();
            s += ", ";
            s += textColour.getBlue();
            s += ")\">";
            s += name;
            s += "</a></td>";
            return s;
        }
    }
}