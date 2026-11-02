package org.simpleframework.xml.core;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Revision {
    private boolean equal = true;

    public boolean compare(Object obj, Object obj2) {
        if (obj2 != null) {
            this.equal = obj2.equals(obj);
        } else if (obj != null) {
            this.equal = obj.equals(Double.valueOf(1.0d));
        }
        return this.equal;
    }

    public double getDefault() {
        return 1.0d;
    }

    public boolean isEqual() {
        return this.equal;
    }
}
