package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.OutputNode;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class NamespaceDecorator implements Decorator {
    private Namespace primary;
    private List<Namespace> scope = new ArrayList();

    private void namespace(OutputNode outputNode) {
        Namespace namespace = this.primary;
        if (namespace != null) {
            outputNode.setReference(namespace.reference());
        }
    }

    private void scope(OutputNode outputNode) {
        NamespaceMap namespaces = outputNode.getNamespaces();
        for (Namespace namespace : this.scope) {
            namespaces.setReference(namespace.reference(), namespace.prefix());
        }
    }

    public void add(Namespace namespace) {
        this.scope.add(namespace);
    }

    @Override // org.simpleframework.xml.core.Decorator
    public void decorate(OutputNode outputNode) {
        decorate(outputNode, null);
    }

    @Override // org.simpleframework.xml.core.Decorator
    public void decorate(OutputNode outputNode, Decorator decorator) {
        if (decorator != null) {
            decorator.decorate(outputNode);
        }
        scope(outputNode);
        namespace(outputNode);
    }

    public void set(Namespace namespace) {
        if (namespace != null) {
            add(namespace);
        }
        this.primary = namespace;
    }
}
