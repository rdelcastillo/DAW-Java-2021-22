package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Ejemplo de creación de un fichero XML de artículos.
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

public class EscrituraXML {

  public static void main(String[] args) {
    List<Article> articles = new ArrayList<>();

    // Artículos de muestra
    for (int i = 1; i <= 10; i++) {
      articles.add(new Article(i, "Artículo " + i,           // código y descripción
          Math.random() * 100,          // precio aleatorio
          (int) (Math.random() * 11))); // unidades aleatorias
    }

    try {
      // Creación del documento XML 
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.newDocument(); // este objeto hará todo el trabajo

      // Nodo raíz 
      Element root = document.createElement("Almacén");
      document.appendChild(root);

      // Recorremos lista de artículos
      for (Article article : articles) {
        // Nodo Artículo (contiene los elementos)
        Element elementArt = document.createElement("Artículo");
        root.appendChild(elementArt);

        // El código es un atributo del nodo Artículo
        Attr attrCod = document.createAttribute("código");
        attrCod.setValue(Integer.toString(article.getCode()));
        elementArt.setAttributeNode(attrCod);

        // Nodo Descripción
        Element elementDes = document.createElement("Descripción");
        elementDes.appendChild(document.createTextNode(article.getDescription()));
        elementArt.appendChild(elementDes);

        // Nodo PrecioCompra
        Element elementPrecio = document.createElement("Precio");
        elementPrecio.appendChild(document.createTextNode(Double.toString(article.getPrice())));
        elementArt.appendChild(elementPrecio);

        // Nodo Unidades
        Element elementUni = document.createElement("Unidades");
        elementUni.appendChild(document.createTextNode(Integer.toString(article.getUnits())));
        elementArt.appendChild(elementUni);
      }

      // Guardar XML en fichero
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult(new FileWriter("almacen.xml"));
      transformer.transform(source, result);

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    }

  }

}
