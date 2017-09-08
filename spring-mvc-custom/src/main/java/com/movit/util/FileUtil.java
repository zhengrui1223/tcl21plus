package com.movit.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class FileUtil {

    public static Set<Class<?>> readClassFiles(File rootFile, Set<Class<?>> fileList) {

        if (!rootFile.exists()) {
            return null;
        }

        File[] files = rootFile.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().endsWith(".class");
            }
        });

        if (files != null && files.length>0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    readClassFiles(file, fileList);
                }else {
                    String className = file.getPath().substring(0,file.getPath().length() - 6);
                    try {
                        Class<?> aClass = Thread.currentThread().getContextClassLoader().loadClass(className);
                        fileList.add(aClass);
                    } catch (ClassNotFoundException e) {
                        continue;
                    }
                }
            }
        }

        return fileList;
    }

    public static Set<Class<?>> getClasses(String pack) {
        if (pack != null) {
            pack = pack.replace(".", "/");
        }

        Set<Class<?>> fileList = new HashSet<Class<?>>();
        Enumeration<URL> resources = null;
        try {
            resources = Thread.currentThread().getContextClassLoader().getResources(pack);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String filePath = URLDecoder.decode(url.getPath(), "utf-8");
                File rootFile = new File(filePath);
                readClassFiles(rootFile, fileList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileList;
    }

    public static void main(String[] args) throws IOException {
        Set<Class<?>> classes = getClasses("com.movit");
        for (Class<?> clazz : classes) {

            System.out.println("className= " + clazz.getName());

        }
    }

}
