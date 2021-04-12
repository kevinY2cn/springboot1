package dk.web;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dk.pojo.City;
import dk.pojo.DkUser;
import dk.pojo.Province;
import dk.pojo.TestObject;
import dk.service.CityService;
import dk.service.ProvinceService;

@Controller
@RequestMapping("/province")
public class ProvinceController {
	
	@Autowired
	ProvinceService provinceServiceImp;
	
	@Autowired
	CityService cityServiceImp;
	
	@ResponseBody
	@GetMapping(path = "/{id}")
	public Province getJsonData(@PathVariable Integer id) {
		System.out.println("你get到了数据");
		System.out.println("this id is "+ id);
		Province province = provinceServiceImp.queryById(id);
		return province;
	}
	
	@ResponseBody
	@GetMapping(path = "/{id}/city")
	public List<City> getCitysByProvince(@PathVariable("id") Integer provinceId) {
		List<City> citys = cityServiceImp.queryCityByProvince(provinceId);
		return citys;
	}
	
	@ResponseBody
	@GetMapping(path = "/all")
	public List<Province> getAllProvince() {
		List<Province> provinces = provinceServiceImp.queryAll();
		return provinces;
	}
	
	@ResponseBody
	@PostMapping
	public TestObject postJsonData(
			@RequestBody(required = false) DkUser user) {
		System.out.println("你post到了数据");
		
	
		if(user!=null) { 
			System.out.println(user.getUsername());
		}
		 
		return new TestObject("test","123");
	}
	

}
