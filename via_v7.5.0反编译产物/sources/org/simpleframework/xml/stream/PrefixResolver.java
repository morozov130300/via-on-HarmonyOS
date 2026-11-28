package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class PrefixResolver extends LinkedHashMap<String, String> implements NamespaceMap {
    private final OutputNode source;

    public PrefixResolver(OutputNode outputNode) {
        this.source = outputNode;
    }

    private String resolvePrefix(String str) {
        NamespaceMap namespaces = this.source.getNamespaces();
        if (namespaces == null) {
            return null;
        }
        String prefix = namespaces.getPrefix(str);
        if (containsValue(prefix)) {
            return null;
        }
        return prefix;
    }

    private String resolveReference(String str) {
        NamespaceMap namespaces = this.source.getNamespaces();
        if (namespaces != null) {
            return namespaces.getReference(str);
        }
        return null;
    }

    @Override // org.simpleframework.xml.stream.NamespaceMap
    public String getPrefix() {
        return this.source.getPrefix();
    }

    @Override // org.simpleframework.xml.stream.NamespaceMap
    public String getReference(String str) {
        if (containsValue(str)) {
            for (String str2 : this) {
                String str3 = (String) get(str2);
                if (str3 != null && str3.equals(str)) {
                    return str2;
                }
            }
        }
        return resolveReference(str);
    }

    @Override // org.simpleframework.xml.stream.NamespaceMap, java.lang.Iterable
    public Iterator<String> iterator() {
        return keySet().iterator();
    }

    @Override // org.simpleframework.xml.stream.NamespaceMap
    public String setReference(String str) {
        return setReference(str, "");
    }

    @Override // org.simpleframework.xml.stream.NamespaceMap
    public String getPrefix(String str) {
        String str2;
        return (size() <= 0 || (str2 = get(str)) == null) ? resolvePrefix(str) : str2;
    }

    @Override // org.simpleframework.xml.stream.NamespaceMap
    public String setReference(String str, String str2) {
        if (resolvePrefix(str) != null) {
            return null;
        }
        return put(str, str2);
    }
}
