package wcrdtask.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Document(indexName = "resource",type = "merchants")
public class Merchant {

	@Id
    private String id;
    private String name, description, address;
    private GeoPoint location;
    
    public Merchant(){}

    public Merchant(String id, String name, String description, String address, GeoPoint location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
		this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
		this.description = description;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
		this.address = address;
    }
    
    public GeoPoint getLocation() {
        return location;
    }
    
    public void setLocation(GeoPoint location) {
		this.location = location;
    }
    
    public String toString() {
		return "Merchant [(" + getId() + ", " + getName() + ", " + getDescription() + ", " + getAddress() + ", " + getLocation() + "]";
	}
}