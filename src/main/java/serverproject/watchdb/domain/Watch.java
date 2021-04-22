package serverproject.watchdb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;

@Entity
public class Watch {

	//watch setit ja getit, konstruktorit ja tostring
	
	   @Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    private String brand;
	    private String model;
	    private int year;
	    private String material;
	    
	    
	    //kuvan upload get ja set
	    @Column(nullable = true, length = 64)
	    private String photos;
	    
	    @Transient
	    public String getPhotosImagePath() {
	        if (photos == null || id == null) return null;
	         
	        return "/watch-photos/" + id + "/" + photos;
	    }
	    
		public String getPhotos() {
			return photos;
		}

		public void setPhotos(String photos) {
			this.photos = photos;
		}

		public Watch() {}
		
		public Watch(String brand, String model, int year, String material) {
			super();
			this.id = id;
			this.brand = brand;
			this.model = model;
			this.year = year;
			this.material = material;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}

		@Override
		public String toString() {
			return "Watch [id=" + id + ", brand=" + brand + ", model=" + model + ", year=" + year + ", material="
					+ material + "]";
		}

}
