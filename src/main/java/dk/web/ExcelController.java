package dk.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.sql.ast.SQLStructDataType.Field;

@Controller
@RequestMapping("/excel")
public class ExcelController {
	
//	@GetMapping("/export")
//	public void doExport(HttpServletResponse response) {
//		OutputStream output = null;
//		BufferedOutputStream buf = null;
//		BufferedInputStream bis = null;
//		try {
//			String fileName = "template.xlsx";
//			ClassPathResource resource = new ClassPathResource(fileName);
//			File file = resource.getFile();
//			System.out.println(file.getTotalSpace());
//			System.out.println(file.getAbsolutePath());
//			output = response.getOutputStream();
//			buf = new BufferedOutputStream(output);
//			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//			response.setCharacterEncoding("utf-8");
//			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//			byte[] bys = new byte[1024];
//			
//			bis = new BufferedInputStream(new FileInputStream(file));
//			int i = -1;
//			while((i = bis.read(bys)) != -1) {
//				buf.write(bys, 0, i);
//				buf.flush();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(bis != null) {
//					bis.close();
//				}
//				if(buf != null) {
//					buf.close();
//				}
//				if(output != null) {
//					output.close();
//				}
//			}
//			catch (Exception e) {
//				
//			}
//		}
//		
//	}
	
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

}
