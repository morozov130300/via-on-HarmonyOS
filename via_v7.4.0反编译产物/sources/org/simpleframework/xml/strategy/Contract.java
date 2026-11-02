package org.simpleframework.xml.strategy;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Contract {
    private String label;
    private String length;

    /* renamed from: mark, reason: collision with root package name */
    private String f10887mark;
    private String refer;

    public Contract(String str, String str2, String str3, String str4) {
        this.length = str4;
        this.label = str3;
        this.refer = str2;
        this.f10887mark = str;
    }

    public String getIdentity() {
        return this.f10887mark;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLength() {
        return this.length;
    }

    public String getReference() {
        return this.refer;
    }
}
