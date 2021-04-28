package dk.web;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import dk.pojo.DkItem;
import dk.pojo.Result;
import dk.pojo.Result.STATUS_CODE;
import dk.service.ItemService;


@Controller
@RequestMapping("/excel")
public class ExcelController {
	
	private static final Logger log = LoggerFactory.getLogger(ExcelController.class);
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/export")
	public ResponseEntity<FileSystemResource> doExport() {
		try {
			String fileName = "template.xlsx";
			ClassPathResource resource = new ClassPathResource("/excelTemplates/"+fileName);
			File file = resource.getFile();
			System.out.println(file.getAbsolutePath());
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=" + fileName);
			return org.springframework.http.ResponseEntity
			.ok()
			.headers(headers)
			.contentLength(file.length())
			.contentType(MediaType.APPLICATION_OCTET_STREAM)
			.body(new FileSystemResource(file));
		} catch(Exception e) {
			return new ResponseEntity<FileSystemResource>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/import/test")
	public ResponseEntity<Result> doImport(HttpServletRequest request){
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest)request;
		Map<String,MultipartFile> fileMap = multipart.getFileMap();
		int rowNum = 0;
		for(MultipartFile file: fileMap.values()) {
			try {
				String filename = file.getOriginalFilename();
				int pIndex = filename.lastIndexOf('.');
				String extension = filename.substring(pIndex+1);
				Workbook wb = null;
				if("xlsx".equals(extension)) {
					wb = new XSSFWorkbook(file.getInputStream()); //.xlsx文件
				}else if("xls".equals(extension)) {
					wb = new HSSFWorkbook(file.getInputStream()); //.xls文件
				}
				Sheet sh1 = wb.getSheetAt(0);
				//遍历excel的数据 保存在数据模型中
				List<DkItem> itemList = new ArrayList<DkItem>();
				for(int i=sh1.getFirstRowNum()+1; i<=sh1.getLastRowNum(); i++) {
					Row row= sh1.getRow(i);
					if(row == null) break;
					rowNum = (i+1);
					DkItem item = new DkItem();
					
					if(row.getCell(0) == null || row.getCell(0).getCellType() == CellType.BLANK) break;
					
					item.setName(row.getCell(0).getStringCellValue());
					item.setType(row.getCell(1).getStringCellValue());
					item.setCount((int)row.getCell(2).getNumericCellValue());
					item.setUnit(row.getCell(3).getStringCellValue());
					item.setOrigin(row.getCell(4).getStringCellValue());
					item.setDate(row.getCell(5).getDateCellValue());
					itemList.add(item);
				}
				itemService.addItemList(itemList);
				/*
				 * for(DkItem item: itemList) { itemService.addItem(item); }
				 */
			} catch (Exception e) {
				log.error(e.getMessage());
				StringBuffer buf = new StringBuffer();
				buf.append("第")
				.append(rowNum)
				.append("行 ").append("\n").append(e.getMessage());
				return new ResponseEntity<Result>(
						new Result(STATUS_CODE.FAILED,buf.toString(),null)
						,HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<Result>(
				new Result(STATUS_CODE.SUCCESS,"导入成功",null)
				,HttpStatus.OK);
	}

}
