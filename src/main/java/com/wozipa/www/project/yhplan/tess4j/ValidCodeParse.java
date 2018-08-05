package com.wozipa.www.project.yhplan.tess4j;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by wozipa on 18-7-1.
 */
public class ValidCodeParse {

    private static final Logger LOGGER = Logger.getLogger(ValidCodeParse.class);

    private static final String TESS4J_LANGUAGE_PATH = "src/main/resources/tessdata";
    private String imageDirPath = null;
    private String imageName = null;
    private String validCode = null;

    public ValidCodeParse(String imageDirPath,String imageName){
        this.imageDirPath = imageDirPath;
        this.imageName = imageName;
    }

    /**
     * 进行验证码解析
     */
    public void parse(){
        File img = new File(this.imageDirPath,this.imageName);
        Tesseract instance = new Tesseract();
        instance.setDatapath(this.imageDirPath);
        instance.setDatapath(TESS4J_LANGUAGE_PATH);
        instance.setLanguage("eng");
        try {
            this.validCode = instance.doOCR(img);
        } catch (TesseractException e) {
            this.validCode = null;
            e.printStackTrace();
        }
    }

    public String getValidCode(){
        return this.validCode;
    }
}
