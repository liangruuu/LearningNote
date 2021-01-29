package com.paul.register;

import com.paul.framework.URL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Register {

    private static Map<String, Map<URL,String>> registry = new HashMap<>();

    public static void regist(URL url,String className,String impl){
        Map<URL,String> map = new HashMap<>();
        map.put(url,impl);
        registry.put(className,map);
        saveFile();
    }

    private static void saveFile(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/Wangshuai/temp.pages");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(registry);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public static String get(URL  url,String interfaceName){
        registry = getFile();
        return registry.get(interfaceName).get(url);
    }

    public static List<Map<URL, String>> getAll(){
        registry = getFile();
        List<Map<URL, String>> result = new ArrayList<>();
        for(String interfaces:registry.keySet()){
            result.add(registry.get(interfaces));
        }
        return result;
    }

    private static Map<String,Map<URL,String>> getFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream("/Users/Wangshuai/temp.pages");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String,Map<URL,String>>) objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static  URL random(String interfaceName){
        registry = getFile();
        return registry.get(interfaceName).keySet().iterator().next();
    }
}
