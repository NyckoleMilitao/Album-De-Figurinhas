package ilab.projeto.up.ilab.up.service.impl;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ilab.projeto.up.ilab.up.service.ImportExcelService;

@Service
public class ImportExcelServiceImpl implements ImportExcelService {

	public int transform(String dado) {
		if (dado.isEmpty()) {
			dado = "0";
		}
		String string = dado.replaceAll(":", ".");
		float floot = Float.parseFloat(string);
		int inteiro = (int) floot;
		return inteiro;
	}

	@Override
	public XSSFWorkbook lerExcelArquivo(MultipartFile file) {
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workbook;
	}

	@Override
	public XSSFSheet lerExcelAba(MultipartFile file, int numSheet) {
		XSSFSheet worksheet = lerExcelArquivo(file).getSheetAt(numSheet);
		return worksheet;
	}

	@Override
	public String lerCell(XSSFSheet worksheet, int numCell, int index) {
		XSSFRow row = worksheet.getRow(index);
		Cell cell = row.getCell(numCell);
		return new DataFormatter().formatCellValue(cell);
	}

}