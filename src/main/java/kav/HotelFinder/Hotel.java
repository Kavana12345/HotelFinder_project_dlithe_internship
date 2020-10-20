package kav.HotelFinder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="stock")
public class Hotel {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private Integer rooms;
	@NotNull
	private String type;
	@NotNull
	private String location;
	@NotNull
	private double price;
	@NotNull
	private String contact;
	
	public String getName() {
		return name;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRooms() {
		return rooms;
	}
	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", rooms=" + rooms + ", type=" + type + ", location=" + location
				+ ", price=" + price + ", contact=" + contact + "]";
	}
	public Hotel(Integer id,String name, Integer rooms, String type, String location, double price,String contact) {
		super();
		this.id=id;
		this.name = name;
		this.rooms = rooms;
		this.type = type;
		this.location = location;
		this.price = price;
		this.contact = contact;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
