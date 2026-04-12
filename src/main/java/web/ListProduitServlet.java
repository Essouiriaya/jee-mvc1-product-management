package web;

import java.io. IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao. Produit;
import services.ProduitMetier;
import services.ProduitMetierImpl;

public class ListProduitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Produit> liste = metier.getAllProduits();

        req.setAttribute("listeProduits", liste);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}