package org.simpleframework.xml.stream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class IdentityStyle implements Style {
    @Override // org.simpleframework.xml.stream.Style
    public String getAttribute(String str) {
        return str;
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getElement(String str) {
        return str;
    }
}
