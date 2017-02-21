/**
 *
 */
package ru.agentlab.opencorpora.model;

/**
 *
 * Instance of this class represents token.
 *
 * @author Kranc
 *
 */
public class Token {

    private int id;
    private String text;

    /**
     * Default constructor.
     */
    public Token() {
        text = "";
    }

    /**
     * @return the text. Can't return <code>null</code>.
     */
    public String getText() {
        return text;
    }

    /**
     * @return the id.
     */
    public int getId() {
        return id;
    }

}
