package com.projectNanuram.helper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class PropertiesResolver {

    private static Properties props =  null;
    private static PropertiesResolver instance = null;
    private static final String propertyPath ="H:\\IdeaProjects\\ProjectNanuram\\src\\main\\resources\\imageHelper.properties";

    private static Properties getProperties(){

       try {
           if (props == null){
               InputStream stream = new FileInputStream(propertyPath);
               props = new Properties();
               props.load(stream);
           }
           return props;

       }
       catch(Exception e){
           e.printStackTrace();
       }
       return null;
    }

    public static PropertiesResolver getInstance(){
        props = getProperties();
        if(props != null && !props.isEmpty()){
            if(instance == null){
                instance = new PropertiesResolver(props);

            }
        }
        return instance;
    }


    private String hostUrl;
    private String baseFilePath;
    private Map<String , List<String>> imageProperties;

    private PropertiesResolver(Properties _props){


        hostUrl = (String)_props.get("hostUrl");
        baseFilePath = (String)_props.get("baseFilePath");
        processResolutions((String)_props.get("imageProperties"));


    }

    private void processResolutions(String property) {

        imageProperties = new HashMap<>();
        String[] arr = property.split(",");
        for(String str : arr){
            String[] strArr = str.split(":");
            List<String> list = new ArrayList<>();
            list.add(strArr[1]);
            list.add(strArr[2]);
            list.add(strArr[3]);
            imageProperties.put(strArr[0] , list);
        }

    }

    public String getHostUrl() {
        return hostUrl;
    }

    public String getBaseFilePath() {
        return baseFilePath;
    }

    public Map<String, List<String>> getImageProperties() {
        return imageProperties;
    }
}
