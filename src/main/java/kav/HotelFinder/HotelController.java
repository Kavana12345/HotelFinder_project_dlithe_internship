package kav.HotelFinder;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HotelController {

	@Autowired
	private HotelService ser;
	private List<Hotel> temp;
	
	HttpSession session;
	
	@RequestMapping(value="/")
	public ModelAndView begin() {
		return new ModelAndView("login");	
	}
	
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("user") String user , @RequestParam("pass") String pass , HttpServletRequest request) {
		if(user.equalsIgnoreCase("Hotel") && pass.equalsIgnoreCase("*****")) {
			session=request.getSession();
			session.setAttribute("authorised", user);
			return new ModelAndView("home");
		}
		else {
			return new ModelAndView("login").addObject("msg", "unauthorised login");
		}
	}
	 @RequestMapping(value="/add")
	 public ModelAndView addRequest() {
		 if(session.getAttribute("authorised")!=null) {
			 return new ModelAndView("adding");
		 }
		 else {
			 return new ModelAndView("login").addObject("msg", "unauthorised login");
		 }
	 }
	
	 @RequestMapping(value="/input" , method=RequestMethod.POST)
	 public ModelAndView addSubmit(@Valid Hotel hot, BindingResult bind) {
		 if(session.getAttribute("authorised")!=null) {
			 ModelAndView mod=new ModelAndView("adding");
			 if(bind.hasErrors()) {
				 return mod;
			 }
			 if(ser.newAdd(hot)!=null) {
				return mod.addObject("msg", "the hotel "+hot.getName()+" has added");
			 }
			 else {
				 return mod.addObject("msg", "the hotel "+hot.getName()+" has not added");
			 }
		 }
		 else {
			 return new ModelAndView("login");
		 }
	 }
	 @RequestMapping("/list")
	 public ModelAndView traverse() {
		 if(session.getAttribute("authorised")!=null) {
			 temp=ser.every();
			 return new ModelAndView("show").addObject("all", temp);
		 }
		 else {
			 return new ModelAndView("login");
		 }
	 }
	@RequestMapping(value="/editable" ,method=RequestMethod.GET)
	public ModelAndView editRequest(@RequestParam("id") int id) {
		if(session.getAttribute("authorised")!=null) {
			Hotel h=ser.single(id);
			return new ModelAndView("edit").addObject("one", h);
		}
		else {
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="/change",method=RequestMethod.POST)
	public ModelAndView editResponse(Hotel hotel) {
		if(session.getAttribute("authorised")!=null) {
			ser.alter(hotel);
			return traverse().addObject("msg", hotel.getName()+" has updated");
		}
		else {
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping("/deletable")
	public ModelAndView delete(@RequestParam("id") int id) {
		if(session.getAttribute("authorised")!=null) {
			Hotel h=ser.single(id);
			String s=ser.remove(h);
			return traverse().addObject("msg",s+" has deleted");
		}
		else {
			return new ModelAndView("login");
		}
	}
	@RequestMapping(value="/short",method=RequestMethod.GET)
	public ModelAndView shortRequest() {
		if(session.getAttribute("authorised")!=null) {
			return new ModelAndView("short");
		}
		else {
			return new ModelAndView("login");
		}
	}
	@RequestMapping(value="/shortlisting",method=RequestMethod.POST)
	public ModelAndView shortSubmit(@RequestParam("id") String id,@RequestParam("price") String price) {
		if(session.getAttribute("authorised")!=null) {
			if(id!="" && price=="") {
				Hotel h1=ser.single(Integer.parseInt(id));
				temp=new ArrayList<Hotel>();
				temp.add(h1);
				return new ModelAndView("show").addObject("all",temp);
			}
			else if(id=="" && price!="") {
				List<String> models=ser.getByPrice(Double.parseDouble(price));
				return new ModelAndView("models").addObject("all", models);
			}
			else {
				return null;
			}
		}
		else {
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView out()
	{
		session.removeAttribute("authorised");
		session.setAttribute("authorised", null);
		return new ModelAndView("login").addObject("msg", "Logged out successfully");
	}
	@RequestMapping(value="/back")
	public ModelAndView again()
	{
		if(session.getAttribute("authorised")!=null)
		{return new ModelAndView("home"); }
		else {return new ModelAndView("login");}
	}
	
	
	
}
