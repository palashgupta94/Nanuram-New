package com.projectNanuram.helper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
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
    public static String getFilePath(String fileName , List<String> list){

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

    public static String getHostUrl(String fileName , List<String> list){   //http://localhost:8887/family/xPXcS_1440_796.jpg

        String[] str = fileName.split("\\.");
        str[1] = "."+str[1];
        String hostUrl = PropertiesResolver.getInstance().getHostUrl();
        String url = hostUrl+list.get(0)+"/"+str[0]+"_"+list.get(1)+"_"+list.get(2)+str[1];
        return url;
    }

    public static CommonsMultipartFile fileT0CommonsMultipartFile(String path){

        File file = new File(path);

        CommonsMultipartFile multipart_File = null;
        try{
            FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());

            InputStream is = new FileInputStream(file);
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(is , os);

            multipart_File = new CommonsMultipartFile(fileItem);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return multipart_File;
    }


}
