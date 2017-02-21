/**
 *
 */
package ru.agentlab.opencorpora.ds.host;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import ru.agentlab.opencorpora.IOpenCorporaService;
import ru.agentlab.opencorpora.model.IntegerCollectionRequest;
import ru.agentlab.opencorpora.model.IntegerRequest;
import ru.agentlab.opencorpora.model.Paragraph;
import ru.agentlab.opencorpora.model.Sentence;
import ru.agentlab.opencorpora.model.Text;
import ru.agentlab.opencorpora.model.Token;

/**
 *
 * Oomph component realisation.
 *
 * @author Kranc
 *
 */
@Component(enabled = true, immediate = true,
    property = { "service.exported.interfaces=*", "service.exported.configs=ecf.jaxrs.jersey.server",
        "ecf.jaxrs.jersey.server.urlContext=http://localhost:8080", "ecf.jaxrs.jersey.server.alias=/opencorpora",
        "service.pid=ru.agentlab.genmymodel.ds.host.GenMyModelComponent" })
public class OpenCorporaComponent
    implements IOpenCorporaService, ManagedService {

    private Collection<Text> texts;

    @Override
    public String hello() {
        return "Hello from OpenCorpora";
    }

    @Override
    public void addText(Text text) {
        if (!texts.contains(text))
        {
            texts.add(text);
        }
    }

    @Override
    public void addParagraph(IntegerCollectionRequest<Paragraph> request) {
        texts.stream().forEach((text) -> {
            if (text.getId() == request.getInteger())
            {
                text.addParagraphs(request.getCollection());
            }
        });
    }

    @Override
    public void addSentences(IntegerCollectionRequest<Sentence> request) {
        texts.stream().forEach((text) -> {
            text.getParagraphs().forEach((paragraph) -> {
                if (paragraph.getId() == request.getInteger())
                {
                    paragraph.addSentences(request.getCollection());
                }
            });
        });
    }

    @Override
    public void addTokens(IntegerCollectionRequest<Token> request) {
        texts.stream().forEach((text) -> {
            text.getParagraphs().forEach((paragraph) -> {
                paragraph.getSentences().forEach((sentence) -> {
                    if (sentence.getId() == request.getInteger())
                    {
                        sentence.addTokens(request.getCollection());
                    }
                });
            });
        });
    }

    @Override
    public Text getText(IntegerRequest id) {
        for (Text text : texts)
        {
            if (text.getId() == id.getValue())
            {
                return text;
            }
        }

        return null;
    }

    @Override
    public Collection<Paragraph> getParagraphs(IntegerRequest textId) {
        for (Text text : texts)
        {
            if (text.getId() == textId.getValue())
            {
                return text.getParagraphs();
            }
        }

        return new ArrayList<>();
    }

    @Override
    public Collection<Sentence> getSentences(IntegerRequest paragraphId) {
        for (Text text : texts)
        {
            for (Paragraph paragraph : text.getParagraphs())
            {
                if (paragraph.getId() == paragraphId.getValue())
                {
                    return paragraph.getSentences();
                }
            }
        }

        return new ArrayList<>();
    }

    @Override
    public Collection<Token> getTokens(IntegerRequest sentenceId) {
        for (Text text : texts)
        {
            for (Paragraph paragraph : text.getParagraphs())
            {
                for (Sentence sentence : paragraph.getSentences())
                {
                    if (sentence.getId() == sentenceId.getValue())
                    {
                        return sentence.getTokens();
                    }
                }
            }
        }

        return new ArrayList<>();
    }

    @Activate
    public void activate(ComponentContext context) throws IOException {
        texts = new ArrayList<>();
        System.out.println("OpenCorpora service started"); //$NON-NLS-1$
    }

    @Deactivate
    public void deactivate(ComponentContext context) {
        System.out.println("OpenCorpora service stopped"); //$NON-NLS-1$
    }

    @Modified
    public void modify() {
        System.out.println("OpenCorpora service modified"); //$NON-NLS-1$
    }

    @Override
    public void updated(Dictionary<String, ?> properties) throws ConfigurationException {
        // Does nothing
    }

}
