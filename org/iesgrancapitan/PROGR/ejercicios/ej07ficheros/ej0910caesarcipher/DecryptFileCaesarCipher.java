package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej0910caesarcipher;

import static org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej0910caesarcipher.CommonEncryptDecryptFileCaesarCipher.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Programa que desencripta un fichero que le pasamos como parámetro y almacena el resultado en otro, 
 * que también pasamos como parámetro, de manera que:
 * 
 * - Si el programa no recibe uno o dos parámetros termina con un error 1.
 * - Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo 
 *   del que lee, pero antes advertirá al usuario de que machacará el archivo origen, dando opción a
 *   que la operación no se haga.
 * - Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina con un mensaje
 *   de error y código 2.
 * - Si en el fichero destino no se puede escribir (da error al abrirlo como escritura) el programa termina
 *   con un mensaje de error y código 3.
 *   
 * Para desencriptar usamos el método César, necesitaremos una clave que hay que pedir al usuario.
 * 
 */

public class DecryptFileCaesarCipher {

  public static void main(String[] args) {
    exitIfWrongArguments(args);

    String encryptedFileName = args[0];
    String decryptedFileName = getNameTargetFile(args);
    int key = readKey();

    try {
      CaesarCipher.decrypt(encryptedFileName, decryptedFileName, key);
      System.out.println("Creado " + decryptedFileName);
    } 
    catch (NoSuchFileException e) {
      exitWithError("No puedo abrir " + encryptedFileName, READING_ERROR);
    } 
    catch (FileNotFoundException e) {
      exitWithError("Error al escribir en " + decryptedFileName, WRITING_ERROR);
    } 
    catch (IOException e) {
      exitWithError("Error de E/S -> " + e.getMessage(), IO_ERROR);
    }
  }
}

