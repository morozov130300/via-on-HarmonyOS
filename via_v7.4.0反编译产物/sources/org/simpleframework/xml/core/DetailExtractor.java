package org.simpleframework.xml.core;

import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class DetailExtractor {
    private final Cache<Detail> details;
    private final Cache<ContactList> fields;
    private final Cache<ContactList> methods;
    private final DefaultType override;
    private final Support support;

    public DetailExtractor(Support support) {
        this(support, null);
    }

    public DetailExtractor(Support support, DefaultType defaultType) {
        this.methods = new ConcurrentCache();
        this.fields = new ConcurrentCache();
        this.details = new ConcurrentCache();
        this.override = defaultType;
        this.support = support;
    }

    private ContactList getFields(Class cls, Detail detail) {
        FieldScanner fieldScanner = new FieldScanner(detail, this.support);
        if (detail != null) {
            this.fields.cache(cls, fieldScanner);
        }
        return fieldScanner;
    }

    private ContactList getMethods(Class cls, Detail detail) {
        MethodScanner methodScanner = new MethodScanner(detail, this.support);
        if (detail != null) {
            this.methods.cache(cls, methodScanner);
        }
        return methodScanner;
    }

    public Detail getDetail(Class cls) {
        Detail detailFetch = this.details.fetch(cls);
        if (detailFetch != null) {
            return detailFetch;
        }
        DetailScanner detailScanner = new DetailScanner(cls, this.override);
        this.details.cache(cls, detailScanner);
        return detailScanner;
    }

    public ContactList getFields(Class cls) {
        Detail detail;
        ContactList contactListFetch = this.fields.fetch(cls);
        return (contactListFetch != null || (detail = getDetail(cls)) == null) ? contactListFetch : getFields(cls, detail);
    }

    public ContactList getMethods(Class cls) {
        Detail detail;
        ContactList contactListFetch = this.methods.fetch(cls);
        return (contactListFetch != null || (detail = getDetail(cls)) == null) ? contactListFetch : getMethods(cls, detail);
    }
}
