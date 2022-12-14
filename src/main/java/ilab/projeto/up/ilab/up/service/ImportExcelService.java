package ilab.projeto.up.ilab.up.service;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public interface ImportExcelService {
	
	public int transform(String dado);
	
	public XSSFWorkbook lerExcelArquivo(MultipartFile file);
	
	public XSSFSheet lerExcelAba(MultipartFile file, int numSheet);
	
	public String lerCell(XSSFSheet worksheet, int numCell, int index);

}
