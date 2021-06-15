package com.projectNanuram.helper;

import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class ImageHelper {


    public static String imageCopy(String path){

        String[] splitPath = path.split("\\.");
        splitPath[0]+="copy";
        splitPath[1] = "."+splitPath[1];
        String newFileName = splitPath[0]+splitPath[1];

        try{
            File src = new File("H:\\uploads\\"+path);
            File dest = new File("H:\\uploads\\"+newFileName);
            FileUtils.copyFile(src , dest);


        }catch (Exception e){
            e.printStackTrace();
        }
        return "H:\\uploads\\"+newFileName;

    }

    public static void resizeImage(String filename ){

        Map<String , List<String>> map = new HashMap<>();

        PropertiesResolver resolver = PropertiesResolver.getInstance();
        if(resolver!=null){
            map = resolver.getImageProperties();
        }

        for(List<String> str : map.values()) {

            int width = Integer.parseInt(str.get(1));
            int height = Integer.parseInt(str.get(2));

            BufferedImage image = null;
            String baseDirPath = PropertiesResolver.getInstance().getBaseFilePath();
            try {
                InputStream is = new FileInputStream(baseDirPath+filename);
                image = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String newFilePath = getFilePath(filename , str);

            resize(image, width, height, newFilePath, filename);
        }

    }

    private static void resize(BufferedImage image, int width, int height ,String newFilePath  , String fileName) {

        try{

//            InputStream is = new FileInputStream(source.toFile());
//            BufferedImage bi = ImageIO.read(is);
            image = Scalr.resize(image , Scalr.Method.ULTRA_QUALITY , Scalr.Mode.FIT_EXACT , width , height , Scalr.OP_ANTIALIAS);


            String[] arr = fileName.split("\\.");
            String extension = arr[1];
            arr[1]= "."+arr[1];
            File output = new File(newFilePath);
            ImageIO.write(image , extension , output);

        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
    private static String getFilePath(String fileName , List<String> list){

        String[] str = fileName.split("\\.");
        str[1] = "."+str[1];
        String baseDirPath = PropertiesResolver.getInstance().getBaseFilePath();
        int width = Integer.parseInt(list.get(1));
        int height = Integer.parseInt(list.get(2));
        checkDirectory(baseDirPath+list.get(0));
        String path = baseDirPath+list.get(0)+"\\"+str[0]+"_"+width+"_"+height+str[1];
        return path;
    }

    private static void checkDirectory(String directoryPath) {

        File dir = new File(directoryPath);

        if(!(dir.exists() && dir.isDirectory())){
            dir.mkdir();
        }
    }


}
