package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.RegisterBean;
import com.training.dao.RetailDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class RegisterDataProviders {

	@DataProvider(name = "db-inputs")
	public Object[][] getDBData() {

		List<RegisterBean> list = new RetailDAO().getRegister();

		Object[][] result = new Object[list.size()][];
		int count = 0;
		for (RegisterBean temp : list) {
			Object[] obj = new Object[12];
			obj[0] = temp.getfName();
			obj[1] = temp.getlName();
			obj[2] = temp.getEmail();
			obj[3] = temp.getTel();
			obj[4] = temp.getAdd1();
			obj[5] = temp.getAdd2();
			obj[6] = temp.getCity();
			obj[7] = temp.getPcode();
			obj[8] = temp.getCountry();
			obj[9] = temp.getRegion();
			obj[10] = temp.getPassword();
			obj[11] = temp.getConfirmPass();

			result[count++] = obj;
		}
		return result;
	}

	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData() {
		String fileName = "C://Users//SowmyaMP//eclipse-workspace//SeleniumProjectManipal//TestData//TestData1.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName);
	}

	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData1() {
		String fileName = "C://Users//SowmyaMP//eclipse-workspace//SeleniumProjectManipal//TestData//TestData2.xlsx";
		return new ApachePOIExcelRead().getExcelContent(fileName);
	}

	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData() {
		// ensure you will have the title as first line in the file
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1");
	}
}
