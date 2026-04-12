package services;

import dao.*;
import java.util.List;

public class ProduitMetierImpl implements ProduitMetier {

    private static ProduitMetierImpl instance;
    private ProduitDAO dao;

    private ProduitMetierImpl() {
        dao = new ProduitImpl();
        ((ProduitImpl) dao).init();
    }

    public static ProduitMetierImpl getInstance() {
        if(instance == null) instance = new ProduitMetierImpl();
        return instance;
    }

    public void addProduit(Produit p){ 
    	dao.addProduit(p); 
    }
    public void deleteProduit(Long id){ 
    	dao.deleteProduit(id); 
    }
    public List<Produit> getAllProduits(){ 
    	return dao.getAllProduits(); 
    }
    public Produit getProduitById(Long id){ 
    	return dao.getProduitById(id); 
    }
    public void updateProduit(Produit p){ 
    	dao.updateProduit(p); 
    }
}