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

public class ListProduitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final ProduitMetier metier = ProduitMetierImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("idProduit");

        List<Produit> liste = new ArrayList<>();

        if (idStr != null && !idStr.isEmpty()) {
            try {
                Long id = Long.parseLong(idStr);

                Produit p = metier.getProduitById(id);

                if (p != null) {
                    liste.add(p);
                }

            } catch (NumberFormatException e) {
                liste = metier.getAllProduits();
            }
        } else {
            liste = metier.getAllProduits();
        }

        req.setAttribute("listeProduits", liste);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}