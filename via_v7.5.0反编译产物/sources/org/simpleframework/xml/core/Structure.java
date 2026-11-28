package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class Structure {
    private final Instantiator factory;
    private final Model model;
    private final boolean primitive;
    private final Label text;
    private final Label version;

    public Structure(Instantiator instantiator, Model model, Label label, Label label2, boolean z10) {
        this.primitive = z10;
        this.factory = instantiator;
        this.version = label;
        this.model = model;
        this.text = label2;
    }

    public Instantiator getInstantiator() {
        return this.factory;
    }

    public Version getRevision() {
        Label label = this.version;
        if (label != null) {
            return (Version) label.getContact().getAnnotation(Version.class);
        }
        return null;
    }

    public Section getSection() {
        return new ModelSection(this.model);
    }

    public Label getText() {
        return this.text;
    }

    public Label getVersion() {
        return this.version;
    }

    public boolean isPrimitive() {
        return this.primitive;
    }
}
