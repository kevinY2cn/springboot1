package dk.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import dk.bean.PageBean;
import dk.pojo.DkItem;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceImpTest {
	
	@Autowired
	ItemService itemServiceImp;

	@Test
	@Transactional
	@Rollback(true)
	public void testAddItem() throws Exception {
		DkItem item = new DkItem();
		item.setName("鹿肉");
		item.setCount(1111);
		//item.setItemId(UUID.randomUUID().getLeastSignificantBits());
		item.setOrigin("湖南");
		item.setUnit("斤");
		item.setCategory("肉制品");
		item.setDate(new Date());
		itemServiceImp.addItem(item);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddItemList() throws Exception {
		DkItem item = new DkItem();
		item.setName("猪肉");
		item.setCount(1);
		//item.setItemId(UUID.randomUUID().getLeastSignificantBits());
		item.setOrigin("湖南");
		item.setUnit("斤");
		item.setCategory("肉制品");
		item.setDate(new Date());
		List<DkItem> itemList = new ArrayList<DkItem>();
		itemList.add(item);
		itemServiceImp.addItemList(itemList);
	}
	
	@Test
	public void testGetListByPage() throws Exception {
		PageBean pageBean = new PageBean();
		List<DkItem> list = itemServiceImp.getListByPage(pageBean);
		assertTrue(list.size() == 10);
	}

}
