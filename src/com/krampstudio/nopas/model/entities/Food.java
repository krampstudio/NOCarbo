package com.krampstudio.nopas.model.entities;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Food {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String key;

	@Persistent
	@Extension(vendorName="datanucleus", key="gae.pk-name", value="true")
	private String keyName;
	
	@Persistent
	private String name;
	
	@Persistent
	private String description;
	
	@Persistent
	private String brand;
	
	@Persistent
	private FoodCategory category;
	
	public String getKey(){
		return key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(this.key == null && this.keyName == null){
			this.keyName = name;
		}
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public FoodCategory getCategory() {
		return category;
	}

	public void setCategory(FoodCategory category) {
		this.category = category;
	}
	
}
