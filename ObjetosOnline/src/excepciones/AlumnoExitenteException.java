package excepciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan
 */
public class AlumnoExitenteException extends Exception {

    /**
     * Creates a new instance of <code>AlumnoExitenteException</code> without
     * detail message.
     */
    public AlumnoExitenteException() {
    }

    /**
     * Constructs an instance of <code>AlumnoExitenteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlumnoExitenteException(String msg) {
        super(msg);
    }
}
