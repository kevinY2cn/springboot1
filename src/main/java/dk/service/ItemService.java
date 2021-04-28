package dk.service;

import java.util.List;


import dk.pojo.DkItem;

public interface ItemService {
	
	public void addItem(DkItem item) throws Exception;
	
	public void addItemList(List<DkItem> itemList) throws Exception;

}
