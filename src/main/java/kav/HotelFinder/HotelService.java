package kav.HotelFinder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

	@Autowired
	private HotelRepository repo;
	
	public Hotel newAdd(Hotel hotel) {
		return repo.save(hotel);
	}
	 public List<Hotel> every(){
		 return repo.findAll();
	 }
	 public Hotel single(int id) {
		 return repo.findById(id).orElse(new Hotel());
	 }
	 public Hotel alter(Hotel hotel) {
		 return repo.save(hotel);
	 }
	 public String remove(Hotel hotel) {
		 String name=hotel.getName();
		 repo.delete(hotel);
		 return name;
	 }
	 public List<String> getByPrice(double price){
		 return repo.readByPrice(price);
	 }	 
}
