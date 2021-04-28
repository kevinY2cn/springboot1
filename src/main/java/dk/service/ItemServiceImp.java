package dk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dk.bean.PageBean;
import dk.mapper.DkItemMapper;
import dk.pojo.DkItem;


@Service
@Transactional(rollbackFor = Exception.class)
public class ItemServiceImp implements ItemService {
	
	@Autowired
	private DkItemMapper mapper;
	

	@Override
	public void addItem(DkItem item) throws Exception {
		mapper.addItem(item);;
	}


	@Override
	public void addItemList(List<DkItem> itemList) throws Exception {
		mapper.addItemList(itemList);
	}



	@Override
	public List<DkItem> getListByPage(PageBean page) throws Exception {
		return mapper.getListByPage(page);
	}

}
