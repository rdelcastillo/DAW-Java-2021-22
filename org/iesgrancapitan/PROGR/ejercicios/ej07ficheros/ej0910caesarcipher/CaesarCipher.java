package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej0910caesarcipher;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CaesarCipher {

  private static final String LETTERS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

  public static void encrypt(String fileNameToEncrypt, String encryptedFileName, int key) throws IOException {
    List<String> linesFile = Files.readAllLines(Paths.get(fileNameToEncrypt));
    PrintWriter file = new PrintWriter(encryptedFileName);
    for (String line: linesFile) {
      file.println(encrypt(line, key));
    }
    file.close();
  }

  public static void decrypt(String fileNameToEncrypt, String encryptedFileName, int key) throws IOException {
    encrypt(fileNameToEncrypt, encryptedFileName, -key);
  }
  
  public static String encrypt(String str, int key) {
    String encryptedStr = "";
    for (char ch: str.toCharArray()) {
      encryptedStr += encrypt(ch, key);
    }
    return encryptedStr;
  }

  public static String decrypt(String strToEncrypt, int key) {
    return encrypt(strToEncrypt, -key);
  }

  private static char encrypt(char ch, int key) {
    if (!LETTERS.contains(String.valueOf(ch).toUpperCase())) {
      return ch;
    }
    String letters = (Character.isUpperCase(ch)) ? LETTERS : LETTERS.toLowerCase();
    int indexChar = letters.indexOf(ch);
    int indexEncryptedChar = (indexChar + key) % letters.length();
    if (indexEncryptedChar < 0) {
      indexEncryptedChar = LETTERS.length() + indexEncryptedChar;
    }
    return letters.charAt(indexEncryptedChar);
  }

}
