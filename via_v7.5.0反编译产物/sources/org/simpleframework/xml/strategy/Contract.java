package org.simpleframework.xml.strategy;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class Contract {
    private String label;
    private String length;

    /* JADX INFO: renamed from: mark, reason: collision with root package name */
    private String f11509mark;
    private String refer;

    public Contract(String str, String str2, String str3, String str4) {
        this.length = str4;
        this.label = str3;
        this.refer = str2;
        this.f11509mark = str;
    }

    public String getIdentity() {
        return this.f11509mark;
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
