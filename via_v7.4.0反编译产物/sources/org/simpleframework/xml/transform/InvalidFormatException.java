package org.simpleframework.xml.transform;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class InvalidFormatException extends TransformException {
    public InvalidFormatException(String str, Object... objArr) {
        super(String.format(str, objArr), new Object[0]);
    }

    public InvalidFormatException(Throwable th, String str, Object... objArr) {
        super(String.format(str, objArr), th);
    }
}
