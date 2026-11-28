package org.simpleframework.xml.core;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
interface Section extends Iterable<String> {
    String getAttribute(String str);

    LabelMap getAttributes();

    Label getElement(String str);

    LabelMap getElements();

    String getName();

    String getPath(String str);

    String getPrefix();

    Section getSection(String str);

    Label getText();

    boolean isSection(String str);
}
