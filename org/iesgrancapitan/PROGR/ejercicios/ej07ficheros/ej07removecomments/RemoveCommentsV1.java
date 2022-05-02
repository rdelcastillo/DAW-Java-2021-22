package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej07removecomments;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 * Programa que quita los comentarios de un programa de Java.
 * 
 * Se utilizaría de la siguiente manera:
 * 
 * java QuitaComentarios <PROGRAMA_ORIGINAL> <PROGRAMA_LIMPIO>
 * 
 * Por ejemplo:
 * 
 * java QuitaComentarios Hola.java HolaSinComentarios.java
 * 
 * Crea un fichero con nombre HolaSinComentarios.java que contiene el código de Hola.java pero sin 
 * los comentarios.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */
public class RemoveCommentsV1 {

  private static final String BLOCK_COMMENT_START = "/*";
  private static final String BLOCK_COMMENT_END = "*/";
  private static final String BLOCK_LINE_START = "//";

  public static void main(String[] args) {
    if (args.length != 2) {  
      System.err.println("Número de argumentos erróneo.");
      System.exit(1); // fin con error
    }

    String fileWithComments = args[0];
    String fileWithoutComments = args[1];

    try {
      StringBuilder program = new StringBuilder(Files.readString(Paths.get(fileWithComments)));
      
      // Buscamos y borramos /*...*/ 
      int indexCommentStart;
      while ((indexCommentStart = program.indexOf(BLOCK_COMMENT_START)) != -1) {
        int indexBlockCommentEnd = program.indexOf(BLOCK_COMMENT_END, indexCommentStart);
        program.delete(indexCommentStart, indexBlockCommentEnd + BLOCK_COMMENT_END.length());
      }
      
      // Buscamos y borramos //...
      int indexLineCommentStart;
      while ((indexLineCommentStart = program.indexOf(BLOCK_LINE_START)) != -1) {
        int indexLineCommentEnd = program.indexOf("\n", indexLineCommentStart);
        program.delete(indexLineCommentStart, indexLineCommentEnd);
      }
      
      // Guardamos
      Files.writeString(Paths.get(fileWithoutComments), program, Charset.defaultCharset());
      
      System.out.println("Proceso terminado.");
    } 
    catch (NoSuchFileException e) {
      System.err.println("No puedo abrir " + fileWithComments);
    } 
    catch (FileNotFoundException e) {
      System.err.println("No puedo escribir en " + fileWithoutComments);
    } 
    catch (IOException e) {
      System.err.println("Error de E/S -> " + e.getMessage());
    }
    catch (StringIndexOutOfBoundsException e) { // comentario sin cierre 
      System.err.println("Comentario sin cierre, el programa debe tener errores sintácticos.");
    }

  }

}
