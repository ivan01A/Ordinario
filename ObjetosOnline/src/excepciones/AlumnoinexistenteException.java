/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Ivan
 */
public class AlumnoinexistenteException extends Exception {

    /**
     * Creates a new instance of <code>AlumnoinexistenteException</code> without
     * detail message.
     */
    public AlumnoinexistenteException() {
    }

    /**
     * Constructs an instance of <code>AlumnoinexistenteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public AlumnoinexistenteException(String msg) {
        super(msg);
    }
}
