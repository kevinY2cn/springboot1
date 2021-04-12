package dk.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.pojo.City;
import dk.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	CityService cityServiceImp;
	
	@GetMapping("/all")
	public List<City> getAllCity(){
		return cityServiceImp.queryAll();
	}

}
