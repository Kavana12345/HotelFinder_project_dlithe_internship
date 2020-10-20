package kav.HotelFinder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	
	@Query("select name from Hotel where price<= :price")
	public List<String> readByPrice(double price);

}
