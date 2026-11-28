package org.simpleframework.xml.transform;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class StringTransform implements Transform<String> {
    @Override // org.simpleframework.xml.transform.Transform
    public String read(String str) {
        return str;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(String str) {
        return str;
    }
}
