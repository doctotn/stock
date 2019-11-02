package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.stock.entities.Produit;

import repository.ProduitRepository;

@RestController
@RequestMapping("/api")

public class ProduitService {
	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/produit",method=RequestMethod.GET)
	public List <Produit> getproducts(){
		return produitRepository.findAll();
	}
	@RequestMapping(value="/produit/{ref}",method=RequestMethod.GET)
	public Produit getContacts(@PathVariable Long ref){
		return produitRepository.findOne(ref);
	}
	@RequestMapping(value="/produit",method=RequestMethod.POST)
	public Produit save(@RequestBody Produit p){
		return produitRepository.save(p);
	}

	@RequestMapping(value="/produit/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id){
		produitRepository.delete(id);
		return true;
	}
	@RequestMapping(value="/produit/{id}",method=RequestMethod.PUT)
	public Produit save(@PathVariable Long ref,@RequestBody Produit p){
		p.setRef(ref);
		return produitRepository.save(p);
	}

	
	
	
}
