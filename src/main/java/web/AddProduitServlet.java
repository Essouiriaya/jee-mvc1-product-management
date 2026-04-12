package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Produit;
import services.ProduitMetier;
import services.ProduitMetierImpl;


public class AddProduitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();
	
	List<Produit> produits = new ArrayList<Produit>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        Double prix = Double.parseDouble(req.getParameter("prix"));

        Produit p = new Produit(nom, description, prix);
        metier.addProduit(p);
        produits.add(p);

        req.setAttribute("listeProduits", metier.getAllProduits());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}