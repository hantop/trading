package com.jinhui.common.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * xml解析
 *
 * @autor wsc
 * @create 2018-02-01 9:58
 **/
public class XmlParseUtils {
    private static Logger logger = LoggerFactory.getLogger(XmlParseUtils.class);

    /**
     * @description 将xml字符串转换成map
     * @param xml
     * @return Map
     */
    public static Map xmlToMap(String xml) {
        Map map = new HashMap();
        Document doc = null;
        try {
            // 将字符串转为XML
            doc = DocumentHelper.parseText(xml);
            // 获取根节点
            Element rootElt = doc.getRootElement();
            // 获取根节点下的子节点head
            Iterator iter = rootElt.elementIterator();
            // 遍历head节点
            while (iter.hasNext()) {
                Element recordEle = (Element) iter.next();
                map.put(recordEle.getName(),recordEle.getStringValue());
            }
        } catch (DocumentException e) {
            logger.info(e.getMessage());
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return map;
    }



    public static void main(String[] args) {
        // 下面是需要解析的xml字符串例子
        String xmlString = "<ZLRT><verNum>1.0</verNum><sysDateTime>20180201100700</sysDateTime>"+
                           "<instuId>9000009</instuId><transType>101</transType><encMsg>@#SSDFDSD#@</encMsg>"+
                           "<checkValue>fdffDfd</checkValue><listData>+++++</listData></ZLRT>";

        System.out.println(XmlParseUtils.xmlToMap(xmlString).get("encMsg"));
    }


}
