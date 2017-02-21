/**
 *
 */
package ru.agentlab.opencorpora.model;

/**
 *
 * Instance of this class represents tag.
 *
 * @author Kranc
 *
 */
public class Tag {

    private String value;

    /**
     * Default constructor.
     */
    public Tag() {
        value = "";
    }

    /**
     * @return the value. Can't return <code>null</code>.
     */
    public String getValue() {
        return value;
    }
}
