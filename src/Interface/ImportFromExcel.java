package Interface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Algorithm.Algorithm;
import Algorithm.HostHome;
import Algorithm.Student;

public class ImportFromExcel {
	
	ArrayList<Student> studentList = new ArrayList<Student>();
	ArrayList<HostHome> hostHomeList = new ArrayList<HostHome>();
	
	public void runAlgorithm(String group, String studentLocation, String hostLocation, String outputLocation, boolean genNewFile) {
		try {
			this.studentList = grabStudentListExcel(studentList, studentLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.hostHomeList = grabHostListExcel(hostHomeList, hostLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Student> unscheduledStudents = new ArrayList<Student>();
		switch(group)
		{
		case("UCO"):
			unscheduledStudents = Algorithm.scheduleUCO(this.studentList, this.hostHomeList);
//			Algorithm.print(this.hostHomeList,  unscheduledStudents);
			printOutputExcel(this.hostHomeList, unscheduledStudents, outputLocation, genNewFile);
			break;
		case("Women's Choir"):
			unscheduledStudents = Algorithm.scheduleUCO(this.studentList, this.hostHomeList);
			printOutputExcel(this.hostHomeList, unscheduledStudents, outputLocation, genNewFile);
			break;
		case("Male Choral"):
			unscheduledStudents = Algorithm.scheduleUCO(this.studentList, this.hostHomeList);
			printOutputExcel(this.hostHomeList, unscheduledStudents, outputLocation, genNewFile);
			break;
		case("New Song"):
			unscheduledStudents = Algorithm.scheduleUCO(this.studentList, this.hostHomeList);
			printOutputExcel(this.hostHomeList, unscheduledStudents, outputLocation, genNewFile);
			break;
		case(""):
			unscheduledStudents = Algorithm.scheduleUCO(this.studentList, this.hostHomeList);
			printOutputExcel(this.hostHomeList, unscheduledStudents, outputLocation, genNewFile);
			break;
		} 
	}
	
	public ArrayList<HostHome> grabHostListExcel(ArrayList<HostHome> hostHome, String fileName) throws FileNotFoundException {
		InputStream inp = null;
		Workbook inputWorkbook = null;
		
		try {
			inp = new FileInputStream(fileName);
			inputWorkbook = WorkbookFactory.create(inp);
		} catch (InvalidFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Sheet sheet = inputWorkbook.getSheetAt(0);
	    for (Row row : sheet) {
	    	ArrayList<String> info = new ArrayList<String>();
	      for (Cell cell : row) {
	    	  try {
	        info.add(cell.getStringCellValue());
	    	  } catch (Exception e){
	        info.add(Integer.toString((int)cell.getNumericCellValue()));
	    	  }
	      }
	      hostHome.add(new HostHome(info.get(0), Integer.parseInt(info.get(3)), info.get(2).charAt(0), info.get(1).charAt(0)));
	    }
		
		return hostHome;
	}
	
	public ArrayList<Student> grabStudentListExcel(ArrayList<Student> student, String fileName) throws FileNotFoundException {		
		InputStream inp = null;
		Workbook inputWorkbook = null;
		
		try {
			inp = new FileInputStream(fileName);
			inputWorkbook = WorkbookFactory.create(inp);
		} catch (InvalidFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Sheet sheet = inputWorkbook.getSheetAt(0);
	    for (Row row : sheet) {
	    	ArrayList<String> info = new ArrayList<String>();
	      for (Cell cell : row) {
	    	  try {
	        info.add(cell.getStringCellValue());
	    	  } catch (Exception e){
	        info.add(Integer.toString((int)cell.getNumericCellValue()));
	    	  }
	      }
	      if(info.size() == 6)
	    	  student.add(new Student(info.get(0), info.get(1), Integer.parseInt(info.get(3)), info.get(2).charAt(0), info.get(4).charAt(0), info.get(5)));
	      else student.add(new Student(info.get(0), info.get(1), Integer.parseInt(info.get(3)), info.get(2).charAt(0), info.get(4).charAt(0)));
	    }
		
		return student;
	}
	
	public void printOutputExcel(ArrayList<HostHome> hostHomeList, ArrayList<Student> unscheduledStudents, String fileName, boolean genNewFile) {
		try {
			Workbook wb = new XSSFWorkbook();
		    Sheet sheet = wb.createSheet("housing list");
		    sheet.setDefaultColumnWidth(20);
		    sheet.setZoom(3,4);
		    
		    CellStyle style = wb.createCellStyle();
		    style.setBorderBottom(CellStyle.BORDER_MEDIUM);
		    style.setBorderLeft(CellStyle.BORDER_MEDIUM);
		    style.setBorderRight(CellStyle.BORDER_MEDIUM);
		    style.setBorderTop(CellStyle.BORDER_MEDIUM);
		    
		    CellStyle centered = wb.createCellStyle();
		    centered.setAlignment(CellStyle.ALIGN_CENTER);
		    
		    CellStyle leftJustified = wb.createCellStyle();
		    leftJustified.setAlignment(CellStyle.ALIGN_LEFT);
		    
		    int currentRow = 0;
		    int currentCell = 0;
		    
		    Row row = sheet.createRow(currentRow);
		    
		    Cell cell = row.createCell(currentCell);
		    cell.setCellStyle(style);
		    cell.setCellValue("Host Homes");
		    currentCell += 2;
		    cell = row.createCell(currentCell);
		    cell.setCellStyle(style);
		    cell.setCellValue("Students");
		    int studentNum = 0;
		    boolean doubleRow = false;
		    int hostRow = 1;
		    currentRow++;
		    for (HostHome currentHome : hostHomeList) {
		    	row = sheet.createRow(currentRow);
		    	currentCell = 0;
		    	row.createCell(currentCell).setCellValue(currentHome.getLastName());
		    	currentCell += 2;
		    	row.createCell(1);
		    	for (Student currentStudent : currentHome.getStudentsTaking()) {
		    		row.createCell(currentCell).setCellValue(currentStudent.getName());
		    		studentNum++;
		    		if (currentCell > 5) {
		    			currentRow++;
		    			row = sheet.createRow(currentRow);
		    			currentCell = 1;
		    			doubleRow = true;
		    		}
		    		currentCell++;
		    	}
		    	
		    	cell = sheet.getRow(hostRow).getCell(1);
		    	cell.setCellValue(Integer.toString(studentNum) + " of " + Integer.toString(currentHome.getMaxStudents()));
		    	cell.setCellStyle(centered);
		    	
		    	if (doubleRow) {
		    		hostRow++;
		    		doubleRow = false;
		    	}
		    	
		    	currentRow++;
		    	hostRow++;
		    	studentNum = 0;
		    }
		    
		    Sheet sheet1 = wb.createSheet("Unscheduled Students");
		    sheet1.setDefaultColumnWidth(20);
		    sheet1.setZoom(3,4);
		    
		    currentRow = 0;
		    currentCell = 1;
		    studentNum = 0;
		    row = sheet1.createRow(currentRow);
		    cell = row.createCell(currentCell);
		    cell.setCellStyle(style);
		    cell.setCellValue("Unscheduled Students");
		    currentRow++;
		    
		    for (Student currentStudent : unscheduledStudents) {
		    	row = sheet1.createRow(currentRow);
		    	cell = row.createCell(0);
		    	cell.setCellValue(studentNum);
		    	cell = row.createCell(currentCell);
		    	cell.setCellValue(currentStudent.getFirstName());
		    	currentCell++;
		    	cell = row.createCell(currentCell);
		    	cell.setCellValue(currentStudent.getLastName());
		    	currentCell++;
		    	cell = row.createCell(currentCell);
		    	cell.setCellValue(String.valueOf(currentStudent.getGender()));
		    	currentCell++;
		    	cell = row.createCell(currentCell);
		    	cell.setCellValue(currentStudent.getYearsInChoir());
		    	cell.setCellStyle(leftJustified);
		    	currentCell++;
		    	cell = row.createCell(currentCell);
		    	cell.setCellValue(String.valueOf(currentStudent.getAlergies()));
		    	currentCell = 1;
		    	studentNum++;
		    	
		    	currentRow++;
		    }
		    

		    FileOutputStream fileOut;
		    // Write the output to a file
		    if (genNewFile) {
		    	fileOut = new FileOutputStream(new File("Output.xlsx"));
		    }
		    else if (!genNewFile) {
		    	fileOut = new FileOutputStream("Output.xlsx");
		    }
		    else {
		    	fileOut = new FileOutputStream(new File("Errors.xlsx"));
		    }
		    wb.write(fileOut);
		    fileOut.close();
		    wb.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
}
