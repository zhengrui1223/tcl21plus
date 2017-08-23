package com.movit.study.base_of_java.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.*;
import java.util.Iterator;

/**
 * Created by admin on 2017/3/6.
 */
public class DomParse {

    public static String readXml() {
        File file = new File("E:/dom4j.xml");

        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            int len;
            byte[] b = new byte[1024];
            StringBuffer sb = new StringBuffer();
            while ((len = inputStream.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }

            return sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void parseXml(String xml) {

        try {
            Document document = DocumentHelper.parseText(xml);

            Element rootElement = document.getRootElement();
            iteratorXml(rootElement);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void iteratorXml(Element element){
        Iterator iterator = element.elementIterator();
        while (iterator.hasNext()){
            Element next = (Element)iterator.next();
            if (next.getName().equals("IV_MESSAGE")) {
                System.out.println(next.getText());

            }

            iteratorXml(next);
        }
    }

    public static void main(String[] args) {
        //System.out.println(readXml());
        parseXml(readXml());
    }
}
