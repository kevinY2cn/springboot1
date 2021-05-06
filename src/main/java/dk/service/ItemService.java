package dk.service;

import java.util.List;

import dk.bean.PageBean;
import dk.pojo.DkItem;

public interface ItemService {
	
	public void addItem(DkItem item) throws Exception;
	
	public void addItemList(List<DkItem> itemList) throws Exception;
	
	public List<DkItem> getListByPage(PageBean page) throws Exception;
	
	public int getRowCount() throws Exception;
	
	public void updateList(List<DkItem> itemList) throws Exception;
	
	public void deleteItem(int itemId) throws Exception;
	
	public void batchDelete(List<DkItem> itemList) throws Exception;
	

}
