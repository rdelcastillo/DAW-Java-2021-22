package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej0910caesarcipher;

import org.iesgrancapitan.PROGR.ejercicios.util.Util;

/**
 * Métodos y constantes comunes para la encriptación/desencriptación usando César.
 */

public class CommonEncryptDecryptFileCaesarCipher {

  static final int ARGUMENTS_ERROR = 1;
  static final int READING_ERROR = 2;
  static final int WRITING_ERROR = 3;
  static final int IO_ERROR = 99;
  
  static void exitIfWrongArguments(String[] args) {
    if (args.length == 0 || args.length > 2) {
      exitWithError("Número de argumentos erróneo.", ARGUMENTS_ERROR);
    }
  }
  
  static String getNameTargetFile(String[] args) {
    if (args.length == 2) {
      return args[1];
    }
    confirmFileOverwriting(args[0]);
    return args[0];
  }

  static void confirmFileOverwriting(String nameFile) {
    System.out.println("Tenga en cuenta que este proceso sobreescribirá " + nameFile 
        + " y perderá la información contenida en el mismo.\n");   
    if (!Util.confirm()) {
      System.out.println("Proceso cancelado.");
      System.exit(0);
    }
  }
  
  static int readKey() {
    int key;
    do {
      key = Util.readInt("Clave (positiva) de la encriptación César");
    } while (key <= 0); 
    return key;
  }

  static void exitWithError(String message, int codeError) {
    System.err.println(message);
    System.exit(codeError);
  }
  
}
