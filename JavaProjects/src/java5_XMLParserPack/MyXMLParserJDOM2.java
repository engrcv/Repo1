package java5_XMLParserPack;

import java.io.IOException;
 
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class MyXMLParserJDOM2 
{
	public static void main(String[] args) 
    {
        String xmlFile = "employees1.xml";
        Document document = getSAXParsedDocument(xmlFile);
         
        /**Read Document Content*/
        Element rootNode = document.getRootElement();
        System.out.println("Root Element :: " + rootNode.getName());
        System.out.println("\n=================================\n");
        
        /**Read Employee Content*/
        rootNode.getChildren("employee").forEach( MyXMLParserJDOM2::readEmployeeNode );
        System.out.println("\n=================================\n");
       
        /**Print Parent node count*/
        System.out.println("Parent Count:" +rootNode.getChildren().size()); 
    }
     
    private static void readEmployeeNode(Element employeeNode) 
    {
    	//Employee Id
        System.out.println("Id : " + employeeNode.getAttributeValue("id"));
         
        //First Name
        System.out.println("FirstName : " + employeeNode.getChildText("firstName"));
         
        //Last Name
        System.out.println("LastName : " + employeeNode.getChildText("lastName"));
         
        //Country
        System.out.println("country : " + employeeNode.getChild("country").getText());
        
        /**Print Child node count*/
    	int children = employeeNode.getChildren().size(); 
        System.out.println("Child Count for 'employee' tag:" +children);
    
        /**Read Department Content*/
        employeeNode.getChildren("department").forEach( MyXMLParserJDOM2::readDepartmentNode );
        //System.out.println(employeeNode.indexOf(employeeNode));
    }
     
    private static void readDepartmentNode(Element deptNode) 
    {
        //Department Id
        System.out.println("Department Id : " + deptNode.getAttributeValue("id"));
         
        //Department Name
        System.out.println("Department Name : " + deptNode.getChildText("name"));
    }
     
    private static Document getSAXParsedDocument(final String fileName) 
    {
        SAXBuilder builder = new SAXBuilder(); 
        Document document = null;
        try
        {
            document = builder.build(fileName);
        } 
        catch (JDOMException | IOException e) 
        {
            e.printStackTrace();
        }
        return document;
    }
     
}