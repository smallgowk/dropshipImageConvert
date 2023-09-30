/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import com.config.Configs;
import static com.config.Configs.CACHE_PATH;
import com.google.gson.Gson;
import static com.config.Configs.COOKIE_PATH;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Admin
 */
public class CookieUtil {

//    public static final String COOKIE_CACHE_FILE = "Cookies/Cookie.txt";
//    public static final String COOKIE_CACHE_FOLDER = "Cookie.txt";
    public static final String JSESSIONID = "JSESSIONID";
    public static final String COOKIE_MERCHANT = "CookieMerchant.txt";

    public static String cachePath;

    public static HashMap<String, String> getCookiesFromDriver(WebDriver driver) {

        if (driver == null || driver.manage() == null || driver.manage().getCookies() == null) {
            return null;
        }

        HashMap<String, String> cookies = new HashMap<>();

//        System.out.println("======================");
        for (Cookie ck : driver.manage().getCookies()) {
//            String strCookie = (ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure());
//            String strCookie = (ck.getName() + ";" + ck.getValue() + ";");
//            if (ck.getName().equals(JSESSIONID)) {
//                System.out.println("JSESSIONID: " + ck.getValue());
//            }
//            System.out.println("" + strCookie);
            cookies.put(ck.getName(), ck.getValue());
        }
//        System.out.println("======================");

        return cookies;
    }

    public static Map<String, String> getCookies(WebDriver driver, boolean checkFromLocal) {
        String cookiesData = null;

        if (checkFromLocal) {
            try {
                cookiesData = readCookies(COOKIE_PATH);
            } catch (Exception ex) {
                Logger.getLogger(CookieUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (cookiesData != null) {
            Gson gson = new Gson();
            return gson.fromJson(cookiesData, HashMap.class);
        }

        System.out.println("No Cookies cache");

        if (driver == null || driver.manage() == null || driver.manage().getCookies() == null || driver.manage().getCookies().isEmpty()) {
            return null;
        }

        Map<String, String> cookies = new HashMap<>();

//        System.out.println("======================");
        for (Cookie ck : driver.manage().getCookies()) {
//            String strCookie = (ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure());
//            String strCookie = (ck.getName() + ";" + ck.getValue() + ";");
//            if (ck.getName().equals(JSESSIONID)) {
//                System.out.println("JSESSIONID: " + ck.getValue());
//            }
//            System.out.println("" + strCookie);
            cookies.put(ck.getName(), ck.getValue());
        }
//        System.out.println("======================");

        saveCookies(cookies);
        return cookies;
    }

//    public static String getCookiesFileName() {
//        return Configs.CONFIG_FOLDER_PATH + Configs.pathChar + "Cookie.txt";
//    }
//    public static String getCookiesFilePath(String fileName) {
//        return Configs.CONFIG_FOLDER_PATH + Configs.pathChar + fileName;
//    }
    public static Map<String, String> getCookiesFromCache() {
        String cookiesData = null;
        try {
            cookiesData = readCookies(COOKIE_PATH);
        } catch (Exception ex) {
            Logger.getLogger(CookieUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (cookiesData != null && !cookiesData.isEmpty()) {
            Gson gson = new Gson();
            return gson.fromJson(cookiesData, HashMap.class);
        }

        return null;
    }
    
    public static Map<String, String> getCookiesFromCache(String path) {
        String cookiesData = null;
        try {
            cookiesData = readCookies(path);
        } catch (Exception ex) {
            Logger.getLogger(CookieUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (cookiesData != null && !cookiesData.isEmpty()) {
            Gson gson = new Gson();
            return gson.fromJson(cookiesData, HashMap.class);
        }

        return null;
    }

    public static void saveCookies(Map<String, String> cookies) {
//        System.out.println("Cookie path " + filePath);
        Gson gson = new Gson();

        String cacheData = gson.toJson(cookies);

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
//            String fileName = getCookiesFileName();

//            ClassLoader classLoader = NewMainUI.class.;
//            URL location = CookieUtil.class.getProtectionDomain().getCodeSource().getLocation();
//            String pathStr = location.getFile() + COOKIE_CACHE_FILE;
//            System.out.println(pathStr);
//            PrintWriter pw = new PrintWriter(fileName);
//            pw.close();
            fw = new FileWriter(COOKIE_PATH);
            bw = new BufferedWriter(fw);
            bw.write(cacheData);

//            fw.close();
//            bw.close();
//            fw = new FileWriter(pathStr.replace("target/classes", "src/main/resources"));
//            bw = new BufferedWriter(fw);
//            bw.write(cacheData);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }
    
    public static void saveCookies(Map<String, String> cookies,String fileName) {
//        System.out.println("Cookie path " + filePath);
        Gson gson = new Gson();

        String cacheData = gson.toJson(cookies);

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
//            String fileName = getCookiesFileName();

//            ClassLoader classLoader = NewMainUI.class.;
//            URL location = CookieUtil.class.getProtectionDomain().getCodeSource().getLocation();
//            String pathStr = location.getFile() + COOKIE_CACHE_FILE;
//            System.out.println(pathStr);
//            PrintWriter pw = new PrintWriter(fileName);
//            pw.close();
            fw = new FileWriter(CACHE_PATH + Configs.pathChar + fileName);
            bw = new BufferedWriter(fw);
            bw.write(cacheData);

//            fw.close();
//            bw.close();
//            fw = new FileWriter(pathStr.replace("target/classes", "src/main/resources"));
//            bw = new BufferedWriter(fw);
//            bw.write(cacheData);
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    public static String readCookies(String filePath) throws FileNotFoundException, IOException {

//        InputStream inputStream = CookieUtil.class.getResourceAsStream(fileName);
//        if (inputStream != null) {
//            return IOUtils.toString(inputStream);
//        } else {
//            return null;
//        }
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            return IOUtils.toString(inputStream);
            // do something with everything string
        } catch (Exception ex) {
            return null;
        }
    }

    public static void deleteCookies() {

//        ClassLoader classLoader = NewMainUI.class.getClassLoader();
//        URL url = classLoader.getResource(COOKIE_CACHE_FILE);
//        if(url == null) {
//            return;
//        }
//        String pathStr = url.getFile();
        File file = new File(COOKIE_PATH);
        file.delete();

//        File fileLocal = new File(pathStr.replace("target/classes", "src/main/resources"));
//        fileLocal.delete();
    }
    
    public static boolean isValidCookie(Map<String, String> cookies) {
        return cookies != null && cookies.containsKey("JSESSIONID");
    }
}
