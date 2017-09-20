package com.movit.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-19 15:42
 ************************************************************/
public class ClassUtil {

    private static final Logger logger = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 获得类加载器
     *
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     *
     * @param className
     * @param isInitialized
     * @return
     */
    public static Class<?> loadClass(String className, boolean isInitialized) {
        try {
            Class<?> aClass = Class.forName(className, isInitialized, getClassLoader());
            return aClass;
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 获取指定包下所有类
     *
     * @param packageName
     * @return
     */
    public static Set<Class<?>> getClassSet(String packageName) {
        if (StringUtils.isBlank(packageName)) {
            return null;
        }
        packageName = packageName.replace(".", "/");
        Set<Class<?>> classes = new HashSet<Class<?>>();
        try {
            Enumeration<URL> resources = getClassLoader().getResources(packageName.replace(".", "/"));

            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();

                if (url != null) {
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")) {
                        String packagePath = url.getPath().replaceAll("%20", "");
                        addClass(classes, packagePath, packageName);
                    } else if (protocol.equals("jar")) {
                        //...
                    }
                }
            }

        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return classes;
    }

    private static void addClass(Set<Class<?>> classes, String packagePath, String packageName) {

        File file = new File(packagePath);
        File[] listFiles = file.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory() || (file.isFile() && file.getName().endsWith(".class"));
            }
        });

        if (listFiles != null && listFiles.length > 0) {
            for (File listFile : listFiles) {
                String fileName = listFile.getName();
                if (listFile.isDirectory()) {
                    String subPackageName = fileName;
                    if (StringUtils.isNotEmpty(packageName)) {
                        subPackageName = packageName + "/" + subPackageName;
                    }
                    addClass(classes, listFile.getPath(), subPackageName);
                }

                if (listFile.isFile()) {
                    String className = packageName + "/" + fileName.substring(0, fileName.lastIndexOf("."));
                    Class<?> aClass = loadClass(className.replace("/", "."), false);
                    classes.add(aClass);
                }
            }
        }
    }
}
