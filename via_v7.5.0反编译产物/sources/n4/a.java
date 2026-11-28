package n4;

import javax.xml.namespace.QName;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static Element a(InputNode inputNode) {
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
