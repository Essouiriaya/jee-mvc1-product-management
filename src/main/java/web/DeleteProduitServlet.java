package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ProduitMetier;
import services.ProduitMetierImpl;

public class DeleteProduitServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final ProduitMetier metier = ProduitMetierImpl.getInstance();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		Long id = Long.parseLong(req.getParameter("id"));
		metier.deleteProduit(id);
		resp.sendRedirect("listProduits");
	}
}