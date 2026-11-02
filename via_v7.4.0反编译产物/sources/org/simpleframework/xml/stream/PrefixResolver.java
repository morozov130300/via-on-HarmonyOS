package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
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
    public String getPrefix(String str) {
        String str2;
        return (size() <= 0 || (str2 = get(str)) == null) ? resolvePrefix(str) : str2;
    }

    @Override // org.simpleframework.xml.stream.NamespaceMap
    public String getReference(String str) {
        if (containsValue(str)) {
            Iterator<String> it = iterator();
            while (it.hasNext()) {
                String next = it.next();
                String str2 = (String) get(next);
                if (str2 != null && str2.equals(str)) {
                    return next;
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
    public String setReference(String str, String str2) {
        if (resolvePrefix(str) != null) {
            return null;
        }
        return put(str, str2);
    }
}
