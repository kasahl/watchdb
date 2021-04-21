package serverproject.watchdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Watch {

	   @Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    private String brand;
	    private String model;
	    private int year;
	    private String picture;
	    
		public Watch() {}
		
		public Watch(String brand, String model, int year, String picture) {
			super();
			this.id = id;
			this.brand = brand;
			this.model = model;
			this.year = year;
			this.picture = picture;
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

		public String getPicture() {
			return picture;
		}

		public void setPicture(String picture) {
			this.picture = picture;
		}

		@Override
		public String toString() {
			return "Watch [id=" + id + ", brand=" + brand + ", model=" + model + ", year=" + year + ", picture="
					+ picture + "]";
		}
}
