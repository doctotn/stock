package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stock.entities.Produit;

public interface ProduitRepository extends JpaRepository <Produit,Long> {

	
}
