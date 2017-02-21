/**
 *
 */
package ru.agentlab.opencorpora.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * Instance of this class represents sentence.
 *
 * @author Kranc
 *
 */
public class Sentence {

    private int id;
    private Collection<Token> tokens;

    /**
     * Default constructor.
     */
    public Sentence() {
        tokens = new ArrayList<>();
    }

    /**
     * @return the id.
     */
    public int getId() {
        return id;
    }

    /**
     * @return the tokens. Can't return <code>null</code>.
     */
    public Collection<Token> getTokens() {
        return tokens;
    }

    /**
     *
     * Adds tokens.
     *
     * @param tokens - tokens to add. Can't be <code>null</code>.
     */
    public void addTokens(Collection<Token> tokens) {
        this.tokens.addAll(tokens);
    }

}
