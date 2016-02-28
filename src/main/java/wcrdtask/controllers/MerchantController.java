package wcrdtask.controllers;

import wcrdtask.entities.*;
import wcrdtask.repositories.*;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@RestController
public class MerchantController {
	@Autowired
	private MerchantRepository repository;
	
	@Autowired
	private ElasticsearchTemplate template;


    @RequestMapping(value = "/merchant", method = RequestMethod.GET)
    public List<Merchant> getAll() {
		Iterable<Merchant> merchants = repository.findAll();
    
        ArrayList<Merchant> list = new ArrayList<Merchant>();
		if(merchants != null) {
		  for(Merchant m: merchants) {
			list.add(m);
		  }
		}
		return list;
    }
    
    @RequestMapping(value = "/merchant", method = RequestMethod.POST)
    public void createMerchant(@RequestBody Merchant merchant) {
		repository.save(merchant);
    }

    @RequestMapping(value = "/merchant/{id}", method = RequestMethod.GET)
    public Merchant readMerchantById(@PathVariable("id") String id) {
        return repository.findMerchantById(id);
    }
    
    @RequestMapping(value = "/merchant", method = RequestMethod.PUT)
    public void updateMerchant(@RequestBody Merchant merchant) {
		repository.save(merchant);
    }

    @RequestMapping(value = "/merchant/{id}", method = RequestMethod.DELETE)
    public void deleteMerchant(@PathVariable("id") String id) {
		repository.delete(id);
    }

    @RequestMapping(value = "/merchant/name/{name}", method = RequestMethod.GET)
    public List<Merchant> getMerchantByName(@PathVariable("name") String name) {
		return repository.findMerchantsByNameLike(name);
    }

    @RequestMapping(value = "/merchant/description/{desc}", method = RequestMethod.GET)
    public List<Merchant> getMerchantByDescription(@PathVariable("desc") String desc) {
		return repository.findMerchantsByDescriptionLike(desc);
    }
    
    @RequestMapping(value = "/merchant/lat/{lat}/lon/{lon}/dist/{dist}", method = RequestMethod.GET)
    public List<Merchant> getMerchantByLocation(@PathVariable Double lat, @PathVariable Double lon, @PathVariable String dist) {
		//return repository.findByLocationNear(new GeoPoint(lat,lon), dist, new PageRequest(0, 10));
		CriteriaQuery geoLocationCriteriaQuery = new CriteriaQuery(
                new Criteria("location").within(new GeoPoint(lat, lon), dist));
		return template.queryForList(geoLocationCriteriaQuery, Merchant.class);
    }
}