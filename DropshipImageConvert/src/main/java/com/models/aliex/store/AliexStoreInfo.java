/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models.aliex.store;

import com.config.Configs;
import com.utils.StringUtils;
import java.io.File;

/**
 *
 * @author PhanDuy
 */
public class AliexStoreInfo extends BaseStoreInfo{
    public String main_key;
    public String tip;
    public String reasons;
    public String description;
    public String storeSign;
    public String accNo;
    public String vpsIp;
    public boolean isOnlyUS;
    
    public String getStoreSign() {
        return storeSign;
    }

    public void setStoreSign(String storeSign) {
        this.storeSign = storeSign;
    }

    public void setVpsIp(String vpsIp) {
        this.vpsIp = vpsIp;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getMain_key() {
        return main_key;
    }

    public void setMain_key(String main_key) {
        this.main_key = main_key;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsOnlyUS() {
        return isOnlyUS;
    }

    public void setIsOnlyUS(boolean isOnlyUS) {
        this.isOnlyUS = isOnlyUS;
    }
    
    public String prefix;
    public String getPrefix() {

        if (prefix != null) {
            return prefix;
        }

        String brandBrief = StringUtils.getStringBrief(brandName);
        if (brandBrief.length() > 2) {
            brandBrief = brandBrief.substring(0, 2);
        }
        prefix = brandBrief.toUpperCase();
        return prefix;
    }
    
    public String genExcelFileNameWithPage(int pageIndex, boolean isError) {
        if (pageIndex == 0) {
            pageIndex = 1;
        }

        File file = new File(Configs.PRODUCT_DATA_PATH + accNo);

        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(file.getPath() + Configs.pathChar + "Aliex");
        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(file.getPath() + Configs.pathChar + storeSign);

        if (!file.exists()) {
            file.mkdir();
        }

        return file.getPath() + Configs.pathChar + accNo + "_" + storeSign + (isError ? "_error" : "") + "_page" + pageIndex + ".xlsx";
    }
    
    public String getLocalImageFolder() {
        File file = new File(Configs.IMAGE_DATA_PATH + accNo + Configs.pathChar + storeSign);
        if (file.exists()) {
            return file.getPath() + Configs.pathChar;
        }
        file = new File(Configs.IMAGE_DATA_PATH + accNo);
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(file.getPath() + Configs.pathChar + storeSign);
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getPath() + Configs.pathChar;
    }
    
    public String getImageVpsFolder() {
        return "http://" + Configs.vpsIp + "/" + accNo + "/" + storeSign + "/";
    }
    
    public String genExcelFileNameForStore(boolean isError) {
        File file = new File(Configs.PRODUCT_DATA_PATH + accNo);

        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(file.getPath() + Configs.pathChar + (isError ? "Errors" : "Aliex"));
        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(file.getPath() + Configs.pathChar + storeSign);

        if (!file.exists()) {
            file.mkdir();
        }
        return file.getPath() + Configs.pathChar + accNo + "_" + storeSign + ".xlsx";
    }
    
    public String getFolderPath() {
        File file = new File(Configs.PRODUCT_DATA_PATH + accNo);

        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(file.getPath() + Configs.pathChar + "Aliex");
        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(file.getPath() + Configs.pathChar + storeSign);

        if (!file.exists()) {
            file.mkdir();
        }
        
        return file.getPath();
    }
    
    public String getStoreFolderPath() {
        File file = new File(Configs.PRODUCT_DATA_PATH + accNo);

        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(file.getPath() + Configs.pathChar + "Aliex");
        if (!file.exists()) {
            file.mkdir();
        }

        return file.getPath();
    }
    
}
