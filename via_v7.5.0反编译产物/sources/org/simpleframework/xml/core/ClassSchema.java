package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class ClassSchema implements Schema {
    private final Caller caller;
    private final Decorator decorator;
    private final Instantiator factory;
    private final boolean primitive;
    private final Version revision;
    private final Section section;
    private final Label text;
    private final Class type;
    private final Label version;

    public ClassSchema(Scanner scanner, Context context) {
        this.caller = scanner.getCaller(context);
        this.factory = scanner.getInstantiator();
        this.revision = scanner.getRevision();
        this.decorator = scanner.getDecorator();
        this.primitive = scanner.isPrimitive();
        this.version = scanner.getVersion();
        this.section = scanner.getSection();
        this.text = scanner.getText();
        this.type = scanner.getType();
    }

    @Override // org.simpleframework.xml.core.Schema
    public Caller getCaller() {
        return this.caller;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Decorator getDecorator() {
        return this.decorator;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Instantiator getInstantiator() {
        return this.factory;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Version getRevision() {
        return this.revision;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Section getSection() {
        return this.section;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Label getText() {
        return this.text;
    }

    @Override // org.simpleframework.xml.core.Schema
    public Label getVersion() {
        return this.version;
    }

    @Override // org.simpleframework.xml.core.Schema
    public boolean isPrimitive() {
        return this.primitive;
    }

    public String toString() {
        return String.format("schema for %s", this.type);
    }
}
