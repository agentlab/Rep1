/**
 *
 */
package ru.agentlab.opencorpora;

import java.util.Collection;

import ru.agentlab.opencorpora.model.IntegerCollectionRequest;
import ru.agentlab.opencorpora.model.IntegerRequest;
import ru.agentlab.opencorpora.model.Paragraph;
import ru.agentlab.opencorpora.model.Sentence;
import ru.agentlab.opencorpora.model.Text;
import ru.agentlab.opencorpora.model.Token;

/**
 *
 * OpenCorpora service.
 *
 * @author Kranc
 *
 */
public interface IOpenCorporaService {

    /**
     *
     * Says hello to user.
     *
     * @return hello message. Can't return <code>null</code>.
     */
    String hello();

    /**
     *
     * Adds text to texts collection. Returns message to user.
     *
     * @param text - text to add. Can't be <code>null</code>.
     */
    void addText(Text text);

    /**
     *
     * Adds given paragraphs to given text.
     *
     * @param request - request containing text id and paragraphs to add.
     */
    void addParagraph(IntegerCollectionRequest<Paragraph> request);

    /**
     *
     * Adds given sentences to given paragraph.
     *
     * @param request - request containing paragraph id and sentences to add.
     */
    void addSentences(IntegerCollectionRequest<Sentence> request);

    /**
     *
     * Adds given tokens to given sentence.
     *
     * @param request - request containing sentence id and tokens to add.
     */
    void addTokens(IntegerCollectionRequest<Token> request);

    /**
     *
     * Returns text with given id.
     *
     * @param id - id.
     *
     * @return text with given id. If there is no text with given id, returns <code>null</code>.
     */
    Text getText(IntegerRequest id);

    /**
     *
     * Returns given text's paragraphs.
     *
     * @param textId - text id.
     *
     * @return text's paragraphs. Can't return <code>null</code>.
     */
    Collection<Paragraph> getParagraphs(IntegerRequest textId);

    /**
     *
     * Returns given paragraph sentences.
     *
     * @param paragraphId - paragraph id.
     *
     * @return given paragraph sentences. Can't return <code>null</code>.
     */
    Collection<Sentence> getSentences(IntegerRequest paragraphId);

    /**
    *
    * Returns given sentence tokens.
    *
    * @param sentenceId - sentence id.
    *
    * @return given sentence tokens. Can't return <code>null</code>.
    */
    Collection<Token> getTokens(IntegerRequest sentenceId);
}
