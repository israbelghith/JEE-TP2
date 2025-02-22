package tn.itbs.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.itbs.bean.Livre;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn; // Attribut privé pour la connexion BD
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		   try {
	            // Charger le driver JDBC
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Connexion à la base de données (modifie les infos selon ton setup)
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authDB", "root", "");

	        } catch (Exception e) {
	        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// Récupération de l'action
        String action = request.getParameter("action");
    	System.out.println("Action reçue : " + action);
    	response.getWriter().println("Action reçue : " + action);
        
		 if (action== null || action.isEmpty()) {
	            response.sendRedirect("Home.jsp"); 
	            return;
	        }
	

        if (action.equals("AjoutLivre")) {
         
        


             String idStr = request.getParameter("id");
             String titre = request.getParameter("titre");
             String prix = request.getParameter("prix");
             String idmagasin = request.getParameter("idmagasin");

             if (idStr == null || idmagasin == null || prix == null || idStr.isEmpty() || prix.isEmpty() || idmagasin.isEmpty()) {
                 response.sendRedirect("Ajout.jsp?error=1");
                 return;
             }

             try {
                 int id = Integer.parseInt(idStr);
                 double prix_send = Double.parseDouble(prix);
                 int idm = Integer.parseInt(idmagasin);
                 

                 String sql = "INSERT INTO livre (id, titre,prix,idmagasin) VALUES (?, ?, ?, ?)";
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 stmt.setInt(1, id);
                 stmt.setString(2, titre);
                 stmt.setDouble(3, prix_send);
                 stmt.setInt(4, idm);

                 int rowsInserted = stmt.executeUpdate();
                 if (rowsInserted > 0) {
                     response.sendRedirect("Home.jsp?success=1");
                 } else {
                     response.sendRedirect("AjoutLivre.jsp?error=1");
                 }

             } catch (Exception e) {
                 response.sendRedirect("AjoutLivre.jsp?error=1");
             }
             
        	
        }
         if (action.equals("AjoutMagasin")) {
            
            


            String idStr = request.getParameter("id");
            String nom = request.getParameter("nom");
            String adr = request.getParameter("adresse");

            if (idStr == null || nom == null || adr == null || idStr.isEmpty() || nom.isEmpty() || adr.isEmpty()) {
                response.sendRedirect("AjoutMagasin.jsp?error=1");
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                

                String sql = "INSERT INTO magasin (id, nom,adresse) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.setString(2, nom);
                stmt.setString(3, adr);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    response.sendRedirect("Home.jsp?success=1");
                } else {
                    response.sendRedirect("AjoutMagasin.jsp?error=1");
                }

            } catch (Exception e) {
                response.sendRedirect("AjoutMagasin.jsp?error=1");
            }
            
       	
       }
         if (action.equals("ChercherLivre")) {
        	    String idStr = request.getParameter("id");

        	    try {
        	        int id = Integer.parseInt(idStr);

        	        String sql = "SELECT * FROM livre WHERE id=?";
        	        PreparedStatement stmt = conn.prepareStatement(sql);
        	        stmt.setInt(1, id);
        	        ResultSet rs = stmt.executeQuery();

        	        if (rs.next()) {
        	            String titre = rs.getString("titre");
        	            double prix = rs.getDouble("prix");
        	            int idMagasin = rs.getInt("idmagasin");
        	            Livre livre = new Livre(id, titre, prix, idMagasin);

        	            request.setAttribute("livre", livre);

        	            request.getRequestDispatcher("SearchResultLivre.jsp").forward(request, response);
        	        } else {
        	            request.setAttribute("erreur", "Livre non trouvé.");
        	            request.getRequestDispatcher("ChercherLivre.jsp").forward(request, response);
        	        }

        	    } catch (Exception e) {
        	        request.setAttribute("erreur", "Erreur lors de la recherche.");
        	        request.getRequestDispatcher("ChercherLivre.jsp").forward(request, response);
        	    }
        	}
else {	
            response.getWriter().println("Aucune action spécifiée");
        }
	}

}
