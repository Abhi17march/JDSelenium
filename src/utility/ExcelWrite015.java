package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    public class ExcelWrite015 {
                private static XSSFSheet ExcelWSheet;
                private static XSSFWorkbook ExcelWBook;
                private static XSSFCell Cell;
                private static XSSFRow Row;
                public static Map<String, Object[]> data = new TreeMap<String, Object[]>();

            //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
            public static void setExcelFile(String Path,String SheetName) throws Exception {
                   try {
                       // Open the Excel file
                    FileInputStream ExcelFile = new FileInputStream(Path);
                    // Access the required test data sheet
                    ExcelWBook = new XSSFWorkbook(ExcelFile);
                    ExcelWSheet = ExcelWBook.getSheet(SheetName);
                    Log.info("Excel sheet opened");
                    } catch (Exception e){
                        throw (e);
                    }
            }
            //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
            public static String getCellData(int RowNum, int ColNum) throws Exception{
                   try{
                	  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                      String CellData = Cell.getStringCellValue();
                      return CellData;
                      }catch (Exception e){
                        return"";
                      }
            }
            
           
			public static void setCellData() throws Exception{
                   
            	{
            		
            	XSSFWorkbook workbook = new XSSFWorkbook();
                   XSSFSheet sheet = workbook.createSheet("006");
                	Set<String> keyset = data.keySet();
            		int rownum = 0;
            		for (String key : keyset) {
            			XSSFRow row = sheet.createRow(rownum++);
            			Object[] objArr = data.get(key);
            			int cellnum = 0;
            			for (Object obj : objArr) {
            				Cell cell = row.createCell(cellnum++);
            				if (obj instanceof String)
            					cell.setCellValue((String) obj);
            				else if (obj instanceof Integer)
            					cell.setCellValue((Integer) obj);
            			}
            		}
            		try {
            			FileOutputStream Out = new FileOutputStream(new File("D:\\JDLinks\\015.xlsx"));
            			workbook.write(Out);
                        System.out.println("Framwork004 data written successfully on disk.");
                        workbook.close();
                        Out.close();
            		}

            		catch (Exception e) {
            			e.printStackTrace();
            		}

            		
            	}
            		}
            
        	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
        		int i;
        		try {
        			int rowCount = ExcelWrite004.getRowUsed();
        			for ( i=0 ; i<rowCount; i++){
        				if  (ExcelWrite004.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){
        					break;
        				}
        			}
        			return i;
        				}catch (Exception e){
        			Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
        			throw(e);
        			}
        		}
        	
        	public static int getRowUsed() throws Exception {
        		try{
        			int RowCount = ExcelWSheet.getLastRowNum();
        			Log.info("Total number of Row used return as < " + RowCount + " >.");		
        			return RowCount;
        		}catch (Exception e){
        			Log.error("Class ExcelUtil | Method getRowUsed | Exception desc : "+e.getMessage());
        			System.out.println(e.getMessage());
        			throw (e);
        		}

        	}
    }