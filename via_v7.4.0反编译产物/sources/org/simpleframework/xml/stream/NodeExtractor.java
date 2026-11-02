package org.simpleframework.xml.stream;

import java.util.LinkedList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class NodeExtractor extends LinkedList<org.w3c.dom.Node> {
    public NodeExtractor(Document document) {
        extract(document);
    }

    private void extract(Document document) {
        Element documentElement = document.getDocumentElement();
        if (documentElement != null) {
            offer(documentElement);
            extract(documentElement);
        }
    }

    private void extract(org.w3c.dom.Node node) {
        NodeList childNodes = node.getChildNodes();
        int length = childNodes.getLength();
        for (int i10 = 0; i10 < length; i10++) {
            org.w3c.dom.Node nodeItem = childNodes.item(i10);
            if (nodeItem.getNodeType() != 8) {
                offer(nodeItem);
                extract(nodeItem);
            }
        }
    }
}
