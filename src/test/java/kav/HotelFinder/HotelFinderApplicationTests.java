package kav.HotelFinder;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Vector;


@SpringBootTest
@RunWith(SpringRunner.class)
class HotelFinderApplicationTests {

	@MockBean
	HotelRepository repo;
	@Autowired
	HotelService ser;
	
	
	@Test
	public void testAdd() {
		Hotel hot=new Hotel(1,"Ayathana",45,"A/c","Coorg",25000.0,"0807253766");
		Hotel h =null;
		when(repo.save(hot)).thenReturn(hot);
		assertEquals(hot,ser.newAdd(hot));
		assertNotNull(ser.newAdd(hot));
		h=new Hotel(2,"Ibni",25,"A/C","Coorg",10000.0,"0801273712");
		assertFalse(ser.newAdd(h).getId()==10);
	}
	@Test
	public void testIterate() {
		List<Hotel> storage=new Vector<Hotel>();
		Hotel h1=new Hotel(3,"sagara",10,"NON A/C","Bangalore",3000.0,"sagar@gmail.com");
		Hotel h2=new Hotel(4,"rastha",15,"A/C","Bangalore",6000.0,"rastha@gmail.com");
		Hotel h3=new Hotel(5,"DreamHotel",19," A/C","Ramanagar",15000.0,"dreamhotel@gmail.com");
		storage.add(h1);
		storage.add(h2);
		storage.add(h3);
		when(repo.findAll()).thenReturn(storage);
		assertTrue(ser.every().get(0).getPrice()<=10000.0);
		assertNotNull(ser.every().get(2));
	}
	@Test
	public void testUpdate() {
		Hotel h1=new Hotel(6,"sagara",10,"NON A/C","Bangalore",3000.0,"sagar@gmail.com");
		Hotel h2=new Hotel(7,"rastha",15,"A/C","Bangalore",6000.0,"rastha@gmail.com");
		when(repo.save(h1)).thenReturn(h1);
		assertEquals(h1,ser.alter(h1));
		assertTrue(ser.alter(h1).getPrice()<=h2.getPrice());
	}
	@Test
	public void testDelete() {
		//Hotel h1=new Hotel("sagara",10,"NON A/C","Bangalore",3000.0,"sagar@gmail.com");
		Hotel h2=new Hotel(8,"rastha",15,"A/C","Bangalore",6000.0,"rastha@gmail.com");
		assertSame(h2.getName(),ser.remove(h2));
	}
	

}
