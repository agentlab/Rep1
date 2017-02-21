/**
 *
 */
package ru.agentlab.opencorpora.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * Instance of this class represents paragraph.
 *
 * @author Kranc
 *
 */
public class Paragraph {

    private int id;
    private Collection<Sentence> sentences;

    /**
     * Default constructor.
     */
    public Paragraph() {
        sentences = new ArrayList<>();
    }

    /**
     * @return the id.
     */
    public int getId() {
        return id;
    }

    /**
     *
     * Adds sentences.
     *
     * @param sentences - sentences to add. Can't be <code>null</code>.
     */
    public void addSentences(Collection<Sentence> sentences) {
        this.sentences.addAll(sentences);
    }

    /**
     * @return the sentences. Can't return <code>null</code>.
     */
    public Collection<Sentence> getSentences() {
        return sentences;
    }
}
