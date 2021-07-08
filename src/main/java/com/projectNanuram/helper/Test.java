package com.projectNanuram.helper;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void resiseImage(String filename ){

        Map<String , List<String>> map = new HashMap<>();

        PropertiesResolver resolver = PropertiesResolver.getInstance();
        if(resolver!=null){
            map = resolver.getImageProperties();
        }



//            int width = Integer.parseInt(str.get(1));
//            int height = Integer.parseInt(str.get(2));

            int width = 1440;
            int height = 796;

            BufferedImage image = null;
//            String baseDirPath = PropertiesResolver.getInstance().getBaseFilePath();
            String baseDirPath = "H:\\uploads\\";
            try {
                image = ImageIO.read(new File(baseDirPath+ filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
//            String newFilePath = getFilePath(filename , str);
            String newFilePath="H:\\uploads\\family\\"+filename;

            resize(image, width, height, newFilePath, filename);


    }

    private static void resize(BufferedImage image, int width, int height ,String newFilePath  , String fileName) {

        try{
            System.out.println("resize method called");
            Image resultImage = image.getScaledInstance(width , height , Image.SCALE_DEFAULT);
            BufferedImage oi = new BufferedImage(width , height , BufferedImage.TYPE_INT_RGB);
            oi.getGraphics().drawImage(resultImage , 0 , 0 , null);

            String[] arr = fileName.split("\\.");
            arr[1]= "."+arr[1];
            File output = new File(newFilePath);
            ImageIO.write(oi , arr[1] , output);

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
        String path = baseDirPath+list.get(0)+"\\"+str[0]+"_"+width+"_"+height+str[1];
        return path;
    }


    private static final int IMG_WIDTH = 1440;
    private static final int IMG_HEIGHT = 796;

    public static void resize1() throws IOException {



        Path source = Paths.get("C:\\Users\\HOME\\Downloads\\Elf-girl.jpg");
        Path target = Paths.get("H:\\uploads\\family\\Elf-girl1.jpg");

        try (InputStream is = new FileInputStream(source.toFile())) {
            imgresize(is, target, IMG_WIDTH, IMG_HEIGHT);
        }

    }

    private static void imgresize(InputStream input, Path target,
                               int width, int height) throws IOException {

        BufferedImage originalImage = ImageIO.read(input);

        /**
         * SCALE_AREA_AVERAGING
         * SCALE_DEFAULT
         * SCALE_FAST
         * SCALE_REPLICATE
         * SCALE_SMOOTH
         */
        Image newResizedImage = originalImage
                .getScaledInstance(width, height, Image.SCALE_SMOOTH);

        String s = target.getFileName().toString();
        String fileExtension = s.substring(s.lastIndexOf(".") + 1);

        // we want image in png format
        ImageIO.write(convertToBufferedImage(newResizedImage),
                fileExtension, target.toFile());

    }

    public static BufferedImage convertToBufferedImage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = bi.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        graphics2D.dispose();

        return bi;
    }

    public static void resize2(){
        Path source = Paths.get("H:\\uploads\\Elf-girl.jpg");
        Path target = Paths.get("C:\\test\\resize2.jpg");

        try (InputStream is = new FileInputStream(source.toFile())) {
            resize(is, target, IMG_WIDTH, IMG_HEIGHT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void resize(InputStream input, Path target,
                               int width, int height) throws IOException {

        // read an image to BufferedImage for processing
        BufferedImage originalImage = ImageIO.read(input);

        // create a new BufferedImage for drawing
        BufferedImage newResizedImage
                = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newResizedImage.createGraphics();

        //g.setBackground(Color.WHITE);
        //g.setPaint(Color.WHITE);

        // background transparent
        g.setComposite(AlphaComposite.Src);
        g.fillRect(0, 0, width, height);

        /* try addRenderingHints()
        // VALUE_RENDER_DEFAULT = good tradeoff of performance vs quality
        // VALUE_RENDER_SPEED   = prefer speed
        // VALUE_RENDER_QUALITY = prefer quality
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                              RenderingHints.VALUE_RENDER_QUALITY);

        // controls how image pixels are filtered or resampled
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                              RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // antialiasing, on
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON);*/

        Map<RenderingHints.Key,Object> hints = new HashMap<>();
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.addRenderingHints(hints);

        // puts the original image into the newResizedImage
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        // get file extension
        String s = target.getFileName().toString();
        String fileExtension = s.substring(s.lastIndexOf(".") + 1);

        // we want image in png format
        ImageIO.write(newResizedImage, fileExtension, target.toFile());

    }

    public static void resize3(){
        Path source = Paths.get("H:\\uploads\\Elf-girl.jpg");
        Path target = Paths.get("H:\\uploads\\family\\elf-girl2.bmp");

        try{

            InputStream is = new FileInputStream(source.toFile());
            BufferedImage bi = ImageIO.read(is);

            bi = Scalr.resize(bi , Scalr.Method.ULTRA_QUALITY , Scalr.Mode.FIT_EXACT , 1440 , 796 , Scalr.OP_ANTIALIAS);

            File targetFile = new File(target.toString());
            ImageIO.write(bi ,"bmp" , targetFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFile(){

        String[] testDeletes = {"test1.jpg","test2.jpg","test3.jpg","test4.jpg","test5.jpg","test6.jpg"};
        for(String str : testDeletes){
            Processor.deleteFile(str);
            System.out.println("deleted file " +str );
        }
    }



    public static void main(String[] args) {

//        resiseImage("UzpQC.png");

        //            resize1();
//        resize2();

//        resize3();

        deleteFile();
    }
}
