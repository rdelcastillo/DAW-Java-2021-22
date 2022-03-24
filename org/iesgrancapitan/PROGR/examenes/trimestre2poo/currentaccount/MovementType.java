package org.iesgrancapitan.PROGR.examenes.trimestre2poo.currentaccount;

/**
 * Tipos de movimientos para la cuenta corriente.
 * 
 * Examen Programación 2º trimestre curso 2021/22.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public enum MovementType {
  INGRESO, CARGO, TRANSFERENCIA_ENVIADA, TRANSFERENCIA_RECIBIDA;
  
  private String[] codes = {"INGR", "CARG", "TENV", "TREC"};
  
  public String code() {
    return codes[this.ordinal()];
  }
}
