package com.bob.smalltool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class FileUtil {

    public  Properties p = new Properties();
    public  String path = "data.properties";
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    /**
     * 通过类装载器 初始化Properties
     */
    public  void init() {
        //转换成流
        InputStream inputStream =
                FileUtil.class.getClassLoader().getResourceAsStream(path);
        try {
            //从输入流中读取属性列表（键和元素对）
            p.load(inputStream);
           } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 通过key获取value
     * @param key
     */
    public  String get(String key) {
        init();
        return p.getProperty(key);
    }
    /**
     * 修改或者新增key
     * @param key
     * @param value
     */
    public  void update(String key, String value) {
        init();
        p.setProperty(key, value);
        FileOutputStream oFile = null;
        try {
            oFile = new FileOutputStream("src\\"+path);
            //将Properties中的属性列表（键和元素对）写入输出流
            p.store(oFile, "save data");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//         FileUtil fileUtil= new FileUtil();fileUtil. init();
//          System.out.println(fileUtil.get("ipBegain"));
//        fileUtil.update("ipBegain","");
//          System.out.println("=="+fileUtil.get("ipBegain"));
//    }
    }
