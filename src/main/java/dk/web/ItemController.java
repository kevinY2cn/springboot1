package dk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.bean.PageBean;
import dk.pojo.DkItem;
import dk.service.ItemService;

@RestController
@RequestMapping("/list")
public class ItemController {
	
	@Autowired
	ItemService itemServiceImp;
	
	@RequestMapping("/all")
	public List<DkItem> getList(Integer page) throws Exception{
		PageBean pageBean = new PageBean();
		if(page != null) {
			pageBean.setOffset((page-1)*10);
		}else {
			pageBean.setOffset(0);
		}
		return itemServiceImp.getListByPage(pageBean);
	}

}
