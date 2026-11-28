package org.simpleframework.xml.core;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.stream.OutputNode;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class Qualifier implements Decorator {
    private NamespaceDecorator decorator = new NamespaceDecorator();

    public Qualifier(Contact contact) {
        scan(contact);
    }

    private void namespace(Contact contact) {
        Namespace namespace = (Namespace) contact.getAnnotation(Namespace.class);
        if (namespace != null) {
            this.decorator.set(namespace);
            this.decorator.add(namespace);
        }
    }

    private void scan(Contact contact) {
        namespace(contact);
        scope(contact);
    }

    private void scope(Contact contact) {
        NamespaceList namespaceList = (NamespaceList) contact.getAnnotation(NamespaceList.class);
        if (namespaceList != null) {
            for (Namespace namespace : namespaceList.value()) {
                this.decorator.add(namespace);
            }
        }
    }

    @Override // org.simpleframework.xml.core.Decorator
    public void decorate(OutputNode outputNode) {
        this.decorator.decorate(outputNode);
    }

    @Override // org.simpleframework.xml.core.Decorator
    public void decorate(OutputNode outputNode, Decorator decorator) {
        this.decorator.decorate(outputNode, decorator);
    }
}
