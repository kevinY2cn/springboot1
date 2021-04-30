package dk.web;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dk.bean.PageBean;
import dk.pojo.DkItem;
import dk.pojo.PagedResult;
import dk.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemServiceImp;
	
	@GetMapping("/list")
	public PagedResult<DkItem> getList(Integer page,Integer pageSize) throws Exception{
		PageBean pageBean = new PageBean();
		if(page != null) {
			pageBean.setOffset((page-1)*10);
		}else {
			pageBean.setOffset(0);
		}
		
		if(pageSize != null) {
			pageBean.setLimit(pageSize);
		}else {
			pageBean.setLimit(10);
		}
		List<DkItem> list = itemServiceImp.getListByPage(pageBean);
		int totalSize = itemServiceImp.getRowCount();
		PagedResult<DkItem> pageResult = new PagedResult<DkItem>();
		pageResult.setRows(list);
		pageResult.setTotalSize(totalSize);
		return pageResult;
	}
	

	@PostMapping("/update")
	public void updateItemList(@RequestBody List<DkItem> list) throws Exception{
		if(list != null && list.size() > 0) itemServiceImp.updateList(list);
	}

}
