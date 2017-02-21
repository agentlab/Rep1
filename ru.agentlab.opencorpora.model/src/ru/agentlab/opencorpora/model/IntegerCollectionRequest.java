/**
 *
 */
package ru.agentlab.opencorpora.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * Contains integer and collection.
 *
 * @author Kranc
 *
 */
public class IntegerCollectionRequest<R> {

    private int integer;
    private Collection<R> collection;

    /**
     * Default constructor.
     */
    public IntegerCollectionRequest() {
        collection = new ArrayList<>();
    }

    /**
     * @return the integer.
     */
    public int getInteger() {
        return integer;
    }

    /**
     * @return the collection. Can't return <code>null</code>;
     */
    public Collection<R> getCollection() {
        return collection;
    }

}
