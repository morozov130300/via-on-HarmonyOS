package org.simpleframework.xml.stream;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface NamespaceMap extends Iterable<String> {
    String getPrefix();

    String getPrefix(String str);

    String getReference(String str);

    @Override // java.lang.Iterable
    Iterator<String> iterator();

    String setReference(String str);

    String setReference(String str, String str2);
}
