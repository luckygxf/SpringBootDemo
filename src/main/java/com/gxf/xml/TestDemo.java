package com.gxf.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class TestDemo {

    public static void main(String[] args) throws Exception {
        // 1.实例化SAXParserFactory对象
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2.创建解析器
        SAXParser parser = factory.newSAXParser();
        // 3.获取需要解析的文档，生成解析器,最后解析文档
        File f = new File("/Users/gxf/IdeaProjects/demos/SpringBootDemo/src/main/resources/books.xml");
        SaxHandler dh = new SaxHandler();
        parser.parse(f, dh);
    }
}