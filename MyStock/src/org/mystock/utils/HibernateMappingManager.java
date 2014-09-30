/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：HibernateMappingManager
 * 
 * 创建日期：2014-09-30
 */
package org.mystock.utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * 通过DOM修改映射文件的类
 * @author tt
 * @version 14.9.16
 */
public class HibernateMappingManager {

	 /**
     * 更新映射文件
     * @param mappingName            映射文件名
     * @param propertiesList        映射文件的数据
     */
    public static void updateClassMapping(String mappingName,List<Map<String,String>> propertiesList){
        try {
            String file=HibernateMappingManager.class.getResource(mappingName).getPath();
            
            Document document=XMLUtil.loadDocument(file);
            NodeList componentTags=document.getElementsByTagName("dynamic-component");
            Node node=componentTags.item(0);
            XMLUtil.removeChildren(node);
            
            for(Map<String,String> map:propertiesList){
                Element element=creatPropertyElement(document,map);
                node.appendChild(element);
            }        
            
            //XMLUtil.saveDocument(document, file);
            XMLUtil.saveDocument(null, null);
        } catch (DOMException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(TransformerException e){
            e.printStackTrace();
        }
    }
    private static Element creatPropertyElement(Document document,Map<String,String> map){
        Element element=document.createElement("property");
        
        element.setAttribute("name", map.get("name"));
        element.setAttribute("column", map.get("column"));
        element.setAttribute("type", map.get("type"));
        element.setAttribute("not-null", String.valueOf(false));
        
        return element;
    }
    /**
     * 修改映射文件的实体名和表名
     * @param mappingName
     * @param entityName
     */
    public static void updateEntityName(String mappingName,String entityName){
        String file=HibernateMappingManager.class.getResource(mappingName).getPath();
        try {
            Document document=XMLUtil.loadDocument(file);
            NodeList nodeList=document.getElementsByTagName("class");
            Element element=(Element)nodeList.item(0);
            element.setAttribute("entity-name",entityName);
            element.setAttribute("table", entityName);
            nodeList=document.getElementsByTagName("param");
            Element elementParam=(Element)nodeList.item(0);
            XMLUtil.removeChildren(elementParam);
            Text text=document.createTextNode(entityName+"_SEQ");
            elementParam.appendChild(text);    
            XMLUtil.saveDocument(document, file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e){
            e.printStackTrace();
        }
        
    }
    /**
     * 更新hibernate的配置文件
     * @param args
     */
    public static void updateHibernateConfig(String configName,String mappingName){
        String file=Thread.currentThread().getContextClassLoader().getResource(configName).getPath();
        String resource=HibernateMappingManager.class.getResource(mappingName).toString();
        String classPath=Thread.currentThread().getContextClassLoader().getResource("").toString();
        resource=resource.substring(classPath.length());
        try {
            Document document=XMLUtil.loadDocument(file);
            NodeList nodeList=document.getElementsByTagName("session-factory");
            Element element=(Element)nodeList.item(0);
            Element elementNew=document.createElement("mapping");
            elementNew.setAttribute("resource",resource);
            Text text=document.createTextNode("");
            element.appendChild(text);
            element.appendChild(elementNew);
            XMLUtil.saveDocument(document, file);
            //XMLUtil.saveDocument(null, null);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e){
            e.printStackTrace();
        }
    }
    
    /**
     * 更新hibernate的配置文件
     * @param args
     */
    public static boolean updateHibernateConfig(String configName,String mappingName,String value){
    	 String file=Thread.currentThread().getContextClassLoader().getResource(configName).getPath();
         String resource=HibernateMappingManager.class.getResource(mappingName).toString();
         String classPath=Thread.currentThread().getContextClassLoader().getResource("").toString();
         resource=resource.substring(classPath.length());
         try {
             Document document=XMLUtil.loadDocument(file);
             NodeList nodeList=document.getElementsByTagName("session-factory");
             for (int i=0;i < nodeList.getLength(); ++i){
            	 Node node = nodeList.item(i);
            	 if (node.getNodeName().equalsIgnoreCase(mappingName)){
            		 node.setNodeValue(value);
            		 return true;
            	 }
             }
         } catch (ParserConfigurationException e) {
             e.printStackTrace();
         } catch (SAXException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return false;
    }
}
