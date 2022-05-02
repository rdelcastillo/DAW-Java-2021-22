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
 * La versión anterior tiene problemas cuando los comentarios se encuentran entrecomillados
 * o cuando hay comillas literales.
 * 
 * En esta versión lo corregiremos y la orientaremos a objetos.
 * 
 * Para arreglar el problema de los comentarios entre comillas y las comillas literales crearemos
 * una copia del programa con el contenido entre comillas en blanco y sin las comillas literales.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */
public class RemoveCommentsV2 {

  private static final String BLOCK_COMMENT_START = "/*";
  private static final String BLOCK_COMMENT_END = "*/";
  private static final String BLOCK_LINE_START = "//";
  
  private StringBuilder program;
  private StringBuilder programNoContentInQuotes;
  private String fileWithComments;
  private String fileWithoutComments;
  

  public static void main(String[] args) {
    exitIfWrongArguments(args);
    
    RemoveCommentsV2 eraser = null;
    try {
      eraser = new RemoveCommentsV2(args[0], args[1]);
      eraser.deleteComments();
      eraser.save();
      System.out.println("Proceso terminado.");
    } 
    catch (NoSuchFileException e) {
      System.err.println("No puedo abrir " + eraser.fileWithComments);
    } 
    catch (FileNotFoundException e) {
      System.err.println("No puedo escribir en " + eraser.fileWithoutComments);
    } 
    catch (IOException e) {
      System.err.println("Error de E/S -> " + e.getMessage());
    }
    catch (StringIndexOutOfBoundsException e) { 
      System.err.println("Comentario sin cierre, el programa debe tener errores sintácticos.");
    }
  }

  private static void exitIfWrongArguments(String[] args) {
    if (args.length != 2) {  
      System.err.println("Número de argumentos erróneo.");
      System.exit(1); 
    }
  }

  public RemoveCommentsV2(String fileWithComments, String fileWithoutComments) throws IOException {
    this.fileWithComments = fileWithComments;
    this.fileWithoutComments = fileWithoutComments;
    program = new StringBuilder(Files.readString(Paths.get(fileWithComments)));
    programNoContentInQuotes = new StringBuilder(program.toString().replace("\\\"", "QQ"));
    deleteContentQuotes();
  }
  
  private void deleteContentQuotes() {
    int indexStart = 0;
    while ((indexStart = programNoContentInQuotes.indexOf("\"", indexStart)) != -1) {
      int indexEnd = programNoContentInQuotes.indexOf("\"", indexStart+1);
      programNoContentInQuotes.replace(indexStart+1, indexEnd, " ".repeat(indexEnd-indexStart-1));
      indexStart = indexEnd + 1;
    }
  }

  private void deleteComments() {
    deleteBlockComments();
    deleteLineComments();
  }
  
  private void deleteBlockComments() {
    int indexCommentStart;
    while ((indexCommentStart = programNoContentInQuotes.indexOf(BLOCK_COMMENT_START)) != -1) {
      int indexBlockCommentEnd = programNoContentInQuotes.indexOf(BLOCK_COMMENT_END, indexCommentStart);
      programNoContentInQuotes.delete(indexCommentStart, indexBlockCommentEnd + BLOCK_COMMENT_END.length());
      program.delete(indexCommentStart, indexBlockCommentEnd + BLOCK_COMMENT_END.length());
    }
  }
  
  private void deleteLineComments() {
    int indexLineCommentStart;
    while ((indexLineCommentStart = programNoContentInQuotes.indexOf(BLOCK_LINE_START)) != -1) {
      int indexLineCommentEnd = programNoContentInQuotes.indexOf("\n", indexLineCommentStart);
      programNoContentInQuotes.delete(indexLineCommentStart, indexLineCommentEnd);
      program.delete(indexLineCommentStart, indexLineCommentEnd);
    }
  }
  
  private void save() throws IOException {
    Files.writeString(Paths.get(fileWithoutComments), program, Charset.defaultCharset());
  }

}
