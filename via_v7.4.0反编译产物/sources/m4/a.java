package m4;

import javax.xml.namespace.QName;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static Element a(InputNode inputNode) throws DOMException {
        Element elementB = d.b(new QName(inputNode.getReference(), inputNode.getName(), inputNode.getPrefix()));
        elementB.setTextContent(inputNode.getValue());
        return elementB;
    }

    public static void b(OutputNode outputNode, Element element) {
        OutputNode child = outputNode.getChild(element.getNodeName());
        child.getNamespaces().setReference(element.getNamespaceURI(), element.getPrefix());
        child.setValue(element.getTextContent());
        child.commit();
    }
}
