package wcrdtask.repositories;

import wcrdtask.entities.Merchant;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MerchantRepository extends ElasticsearchRepository<Merchant,String> {
	Merchant findMerchantById(String id); 
	List<Merchant> findMerchantsByNameLike(String name); 
	List<Merchant> findMerchantsByDescriptionLike(String description);
	List<Merchant> findByLocationNear(GeoPoint point, String distance, Pageable pageable);
}
