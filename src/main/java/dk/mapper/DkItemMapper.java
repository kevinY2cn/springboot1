package dk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import dk.pojo.DkItem;

@Mapper
@Repository
public interface DkItemMapper {
	
	
	public void addItem(DkItem item) throws Exception;
	
	public void addItemList(List<DkItem> itemList) throws Exception;
	

}
