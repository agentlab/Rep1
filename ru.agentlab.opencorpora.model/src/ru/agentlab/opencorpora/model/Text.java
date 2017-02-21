/**
 *
 */
package ru.agentlab.opencorpora.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * Instance of this class represents text.
 *
 * @author Kranc
 *
 */
public class Text {

    private String parent;
    private String name;
    private int id;
    private Collection<Tag> tags;
    private Collection<Paragraph> paragraphs;

    /**
     * Default constructor.
     */
    public Text() {
        parent = "";
        name = "";
        tags = new ArrayList<>();
        paragraphs = new ArrayList<>();
    }

    /**
     * @return the parent. Can't return <code>null</code>.
     */
    public String getParent() {
        return parent;
    }

    /**
     * @return the name. Can't return <code>null</code>.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id.
     */
    public int getId() {
        return id;
    }

    /**
     * @return the tags. Can't return <code>null</code>.
     */
    public Collection<Tag> getTags() {
        return tags;
    }

    /**
     * @return the paragraphs. Can't return <code>null</code>.
     */
    public Collection<Paragraph> getParagraphs() {
        return paragraphs;
    }

    /**
     *
     * Adds paragraphs.
     *
     * @param paragraphs - paragraphs to add. Can't be <code>null</code>.
     */
    public void addParagraphs(Collection<Paragraph> paragraphs) {
        this.paragraphs.addAll(paragraphs);
    }

    @Override
    public int hashCode() {
        return 17 * 37 + id;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
        {
            return false;
        }
        if (object == this)
        {
            return true;
        }

        return (object instanceof Text) && ((Text)object).getId() == this.getId();
    }
}
