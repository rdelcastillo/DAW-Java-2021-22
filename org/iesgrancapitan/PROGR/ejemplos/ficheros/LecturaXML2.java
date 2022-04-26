package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Ejemplo de lectura de un fichero XML de artículos.
 * 
 * El formato de un archivo será:
 * 
 * <Almacén>
 *  <Artículo código = 'valor numérico'>
 *      <Descripción>
 *          ...
 *      </Descripción>
 *      <Precio>
 *          ...
 *      </Precio>
 *      <Unidades>
 *          ...
 *      </Unidades>
 *      ...
 *  </Artículo>
 * </Almacén>
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class LecturaXML2 {

  public static void main(String[] args) {

    try {
      Document document = DocumentBuilderFactory.newInstance()  // factory
          .newDocumentBuilder()                                 // builder
          .parse(new File("almacen.xml"));
      
      Element root = document.getDocumentElement();
      root.normalize();

      // Accedemos a la lista de nodos Artículo
      NodeList nodes = root.getChildNodes();

      // Recorremos los nodos Artículo 
      for (int i = 0; i < nodes.getLength(); i++) {
        Node node = nodes.item(i);  // Nodo Artículo

        if (node.getNodeType() == Node.ELEMENT_NODE) { // Compruebo si el nodo es un elemento
          printNode(node);

          // Obtengo sus hijos
          NodeList childs = node.getChildNodes();
          
          for (int j = 0; j < childs.getLength(); j++) { // Recorro sus hijos
            Node child = childs.item(j);  // Obtengo al hijo actual

            if (child.getNodeType() == Node.ELEMENT_NODE) {
              printElement(child);
            }

          }
          System.out.println("------");
        }

      }

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void printNode(Node node) {
    System.out.print(node.getNodeName());
    if (node.hasAttributes()) {
      for (int i = 0; i < node.getAttributes().getLength(); i++) {
        System.out.println(" " + node.getAttributes().item(i));
      }
    }
    System.out.println();
  }

  private static void printElement(Node node) {
    Element e = (Element) node; // Lo transformo a Element
    System.out.println(e.getTagName() + ": " + e.getTextContent());
  }
}