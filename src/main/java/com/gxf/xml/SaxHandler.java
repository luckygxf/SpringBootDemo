package com.gxf.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SaxHandler extends DefaultHandler {

    @Override
    public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
        System.out.print(new String(arg0, arg1, arg2));
        super.characters(arg0, arg1, arg2);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\n结束解析");
        super.endDocument();
    }

    @Override
    public void endElement(String arg0, String arg1, String arg2)
            throws SAXException {
        System.out.print("</");
        System.out.print(arg2);
        System.out.print(">");
        super.endElement(arg0, arg1, arg2);
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始解析");
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        System.out.println(s);
        super.startDocument();
    }

    @Override
    public void startElement(String arg0, String arg1, String arg2,
                             Attributes arg3) throws SAXException {

        System.out.print("<");
        System.out.print(arg2);

        if (arg3 != null) {
            for (int i = 0; i < arg3.getLength(); i++) {
                System.out.print(" " + arg3.getQName(i) + "=\"" + arg3.getValue(i) + "\"");
            }
        }
        System.out.print(">");
        super.startElement(arg0, arg1, arg2, arg3);
    }

}