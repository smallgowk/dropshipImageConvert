/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import com.config.Configs;
import com.controller.DownloadManager;
import com.models.amazon.DataStore;
import com.models.amazon.ProductAmz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author PhanDuy
 */
public class TransformImageUtil {
    
    public static ArrayList<ProductAmz> transformImageInProduct(String filePath) throws FileNotFoundException, IOException, InvalidFormatException {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        String name = file.getName().split(Pattern.quote("."))[0];
        System.out.println("Name: " + name);
//        if (true) return;

        String parent = file.getParent();
        System.out.println("Parent: " + parent);
        file = new File(parent + "/" + name);
        if (!file.exists()) {
            file.mkdir();
        }
        
        String localImageFolder = file.getPath() + "/";
        System.out.println("LocalFodler: " + localImageFolder);
        String vpsImageFolder = "http://" + Configs.vpsIp + "/" + name + "/";
        System.out.println("vpsImageFolder: " + vpsImageFolder);
        
//        if (true) return;
        ArrayList<ProductAmz> listResults = new ArrayList<>();

        FileInputStream fis = new FileInputStream(filePath);

        /* CreationHelper helps us create instances of various things like DataFormat,
        Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        try (Workbook workbook = WorkbookFactory.create(fis)) {

            /* CreationHelper helps us create instances of various things like DataFormat,
            Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
            CreationHelper createHelper = workbook.getCreationHelper();
            //        Sheet btgSheet = workbook.createSheet("Employee");

            Sheet sheet = null;
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            while (sheetIterator.hasNext()) {
                Sheet sh = sheetIterator.next();

                if (sh.getSheetName().equals("Template")) {
                    sheet = sh;
                    break;
                }
            }
            if (sheet == null) {
                return null;
            }   // Create a Sheet

            Row fieldnameRow = sheet.getRow(2);
            int cellMax = fieldnameRow.getLastCellNum();

            int i = 3;
            Row fieldRow = sheet.getRow(i);

            while (fieldRow != null) {
                ProductAmz productAmz = new ProductAmz();

                DataFormatter formatter = new DataFormatter();
                productAmz.setExternal_product_id(CodeUtils.genRandomProductId());

                for (int j = 1; j < cellMax; j++) {
                    String value = formatter.formatCellValue(fieldRow.getCell(j));
                    productAmz.setValueForAFiled(formatter.formatCellValue(fieldnameRow.getCell(j)), value);
                    
                }
                
                if (vpsImageFolder != null) {
                    productAmz.updateImageUrl(vpsImageFolder);
                    DownloadManager.getInstance().downloadImageAndUpdate(productAmz, localImageFolder);
                }

                listResults.add(productAmz);
                
                for (int j = 0; j < cellMax; j++) {
                    Cell fieldCell = fieldnameRow.getCell(j);
                    String fieldName = fieldCell.getStringCellValue().trim();
                    if (fieldName.contains("image_url")) {
                        Cell cell = fieldRow.getCell(j);
                        cell.setCellValue(productAmz.getValueForCell(fieldName));
                    }
                }

                i++;
                fieldRow = sheet.getRow(i);
            }

            fis.close();
            
            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream(localImageFolder + name + "_new.xlsx");
                workbook.write(fileOut);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ExcelUtils.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            } catch (IOException ex) {
                Logger.getLogger(ExcelUtils.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            } finally {
                try {
                    if (fileOut != null) {
                        fileOut.close();
                    }

                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExcelUtils.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            
            workbook.close();
        }
        return listResults;
    }
}
