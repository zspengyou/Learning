package xmlTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XML_JDOM_test {

	public static void main(String[] args) throws JDOMException, IOException {		
		createCar();			
		carFile();
		modifyCar();
	}
	public static void carFile() throws JDOMException, IOException{
        File inputFile = new File("src/resource/car.txt");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        System.out.println("Root element :" + document.getRootElement().getName());
        Element classElement = document.getRootElement();
        List<Element> supercarList = classElement.getChildren("supercars");
        System.out.println("----------------------------");
        for (int temp = 0; temp < supercarList.size(); temp++) {    
           Element supercarElement = supercarList.get(temp);
           System.out.println("\nCurrent Element :" + supercarElement.getName());
           Attribute attribute =  supercarElement.getAttribute("company");
           System.out.println("company : " + attribute.getValue() );
           List<Element> carNameList = supercarElement.getChildren("carname");
           for (int count = 0; count < carNameList.size(); count++) {	 
              Element carElement = carNameList.get(count);
              System.out.print("car name : "+ carElement.getText() + " ");
              System.out.print("car type : ");
              Attribute typeAttribute = carElement.getAttribute("type");
              if(typeAttribute !=null)
                 System.out.println(typeAttribute.getValue());
              else{
                 System.out.println("");
              }
           }	            
        }
	}
	public static void createCar() throws IOException{
        Element carsElement = new Element("cars");
        Document doc = new Document(carsElement);			
        //supercars element
        Element supercarElement = new Element("supercars");
        supercarElement.setAttribute(new Attribute("company","Ferrari"));
        //supercars element
        Element carElement1 = new Element("carname");
        carElement1.setAttribute(new Attribute("type","formula one"));
        carElement1.setText("Ferrari 101");
        Element carElement2 = new Element("carname");
        carElement2.setAttribute(new Attribute("type","sports"));
        carElement2.setText("Ferrari 202");
        supercarElement.addContent(carElement1);
        supercarElement.addContent(carElement2);
        doc.getRootElement().addContent(supercarElement);
        XMLOutputter xmlOutput = new XMLOutputter();
        // display ml
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, System.out); 
	}
	public static void modifyCar() throws IOException, JDOMException{
        File inputFile = new File("src/resource/car.txt");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        Element rootElement = document.getRootElement();

        //get first supercar
        Element supercarElement = rootElement.getChild("supercars");

        // update supercar attribute
        Attribute attribute = supercarElement.getAttribute("company");
        attribute.setValue("Lamborigini");

        // loop the supercar child node
        List<Element> list = supercarElement.getChildren();
        for (int temp = 0; temp < list.size(); temp++) {
           Element carElement = list.get(temp);
           if("Ferrari 101".equals(carElement.getText())){
              carElement.setText("Lamborigini 001");
           }
           if("Ferrari 201".equals(carElement.getText())){
              carElement.setText("Lamborigini 002");
           }
        }

        //get all supercars element
        List<Element> supercarslist = rootElement.getChildren();
        for (int temp = 0; temp < supercarslist.size(); temp++) {
           Element tempElement = supercarslist.get(temp);
           if("luxurycars".equals(tempElement.getName())){
              rootElement.removeContent(tempElement);
           }        	 
        }

        XMLOutputter xmlOutput = new XMLOutputter();
  
        // display xml
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(document, System.out); 
	}

}
