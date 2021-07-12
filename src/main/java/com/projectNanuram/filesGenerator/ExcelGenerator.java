package com.projectNanuram.filesGenerator;

import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.Person;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ExcelGenerator {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Family> familyList;
    private Row row;
    private int rowNum = 0;


    public ExcelGenerator(String fileName){
        this.workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Family"+fileName);
    }

    public Row createNewRow(int rowNo){
        row = sheet.createRow(rowNo);
        return row;
    }

    private  CellStyle createHeaderStyle(){
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(false);
        font.setFontName("Times New Roman");
        font.setFontHeight(16);

        font.setColor(IndexedColors.DARK_RED.getIndex());
        style.setFont(font);
//        style.setFillForegroundColor(IndexedColors.WHITE1.getIndex());
//        style.setFillBackgroundColor(IndexedColors.WHITE1.getIndex());
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);


//        createCell(row , 0 , "First Name" , style);
        return style;
    }

    private CellStyle createMainHeaderStyle(){
        CellStyle mainHeaderStyle = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(false);
        font.setFontName("Times New Romon");
        font.setFontHeight(18);
        font.setItalic(true);
        font.setColor(IndexedColors.DARK_RED.getIndex());
        mainHeaderStyle.setFont(font);
        mainHeaderStyle.setWrapText(false);

//        mainHeaderStyle.setBorderTop(BorderStyle.THIN);
//        mainHeaderStyle.setBorderBottom(BorderStyle.THIN);
//        mainHeaderStyle.setBorderLeft(BorderStyle.THIN);
//        mainHeaderStyle.setBorderRight(BorderStyle.THIN);
//        mainHeaderStyle.setTopBorderColor(IndexedColors.DARK_RED.getIndex());
//        mainHeaderStyle.setBottomBorderColor(IndexedColors.DARK_RED.getIndex());
//        mainHeaderStyle.setLeftBorderColor(IndexedColors.DARK_RED.getIndex());
//        mainHeaderStyle.setRightBorderColor(IndexedColors.DARK_RED.getIndex());
        mainHeaderStyle.setAlignment(HorizontalAlignment.CENTER);

        return mainHeaderStyle;
    }

    public CellStyle generalStyle(){
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        font.setItalic(false);
        font.setColor(IndexedColors.BLACK1.getIndex());
        style.setFont(font);
        return style;
    }

    private void createMainHeader(Object value , int length , int col , List<String> headerLines) {

        row = createNewRow(rowNum);
//        Cell cell = row.createCell(0);
        CellRangeAddress cra = new CellRangeAddress(rowNum , rowNum , col , col+(length-1));
        sheet.addMergedRegion(cra);
        Cell cell = CellUtil.createCell(row , col , (String) value);

//        RegionUtil.setBorderTop(BorderStyle.THIN , cra , sheet);
//        RegionUtil.setBorderBottom(BorderStyle.THIN , cra , sheet);
//        RegionUtil.setBorderLeft(BorderStyle.THIN , cra , sheet);
//        RegionUtil.setBorderRight(BorderStyle.THIN , cra , sheet);

//        RegionUtil.setTopBorderColor(IndexedColors.DARK_RED.getIndex() , cra , sheet);
//        RegionUtil.setBottomBorderColor(IndexedColors.DARK_RED.getIndex() , cra , sheet);
//        RegionUtil.setLeftBorderColor(IndexedColors.DARK_RED.getIndex() , cra , sheet);
//        RegionUtil.setRightBorderColor(IndexedColors.DARK_RED.getIndex() , cra , sheet);
//        cell.setCellValue((String) value);
        cell.setCellStyle(createMainHeaderStyle());

        createHeader(headerLines , rowNum+=2);
    }

    private void createHeader(List<String> headerLines , int rowNum){
        row = createNewRow(rowNum);
        CellStyle style = createHeaderStyle();

        for(int i = 0; i < headerLines.size(); i++){
            writeLine(row , i , headerLines.get(i) , style);
        }

    }
    private void writeLine(Row row , int columnCount , Object value , CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);

        if(value instanceof String){
        cell.setCellValue((String)value);
        }
        else if(value instanceof Boolean){
            cell.setCellValue((boolean)value);
        }


        cell.setCellStyle(style);
    }

    private void writeDataLines(Person person){
        List<String>headerLine = new LinkedList<>();
        headerLine.add("First Name");
        headerLine.add("Middle Name");
        headerLine.add("Last Name");
        headerLine.add("Gender");
        headerLine.add("Date Of Birth");
        headerLine.add("Age");
        headerLine.add("Family Gotra");
        headerLine.add("Mother Gotra");
        headerLine.add("Education");
        headerLine.add("Occupation");
        headerLine.add("Marital Status");
        headerLine.add("Special Ability");

        List<String> mobileNumberHeaders = new LinkedList<>();
        mobileNumberHeaders.add("Type");
        mobileNumberHeaders.add("Number");
        mobileNumberHeaders.add("Is-Personal");

//        row = createNewRow(0);
        createMainHeader("Person" , headerLine.size() , 0 , headerLine);


        rowNum+=2;
         row = createNewRow(rowNum);
        CellStyle style = generalStyle();
        writeLine(row , 0 , person.getFirstName() , style);
        writeLine(row , 1 , person.getMiddleName() , style);
        writeLine(row , 2 , person.getLastName() , style);
        writeLine(row , 3 , person.getGender() , style);
        writeLine(row , 4 , person.getDOB() , style);
        writeLine(row , 5 , String.valueOf(person.getAge()) , style);
        writeLine(row , 6 , person.getFamilyGotra() , style);
        writeLine(row , 7 , person.getMotherGotra() , style);
        writeLine(row , 8 , person.getEducationalStatus() , style);
        writeLine(row , 9 , person.getOccupation() , style);
        writeLine(row , 10 , person.getMaritalStatus() , style);
        writeLine(row , 11 , person.getSpecialAbility() , style);

        row = createNewRow(rowNum+=3);
        createMainHeader("Mobile Number" , headerLine.size() , 0 , mobileNumberHeaders);

//        createHeader(mobileNumberHeaders , rowNum);
        rowNum+=2;

        for(int i = 0; i < person.getMobileNumbers().size(); i++) {
            row = createNewRow(rowNum);
            writeLine(row , 0 , person.getMobileNumbers().get(i).getType().toString() , style);
            writeLine(row , 1 , person.getMobileNumbers().get(i).getMobileNumber() , style);
            writeLine(row , 2 , person.getMobileNumbers().get(i).isPrimary() , style);
            rowNum++;
        }

    }
    public void export(HttpServletResponse response , Person person){

        writeDataLines(person);
        try {
            ServletOutputStream sos = response.getOutputStream();
            workbook.write(sos);
            workbook.close();
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
