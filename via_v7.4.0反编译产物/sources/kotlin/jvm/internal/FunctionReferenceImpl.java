package kotlin.jvm.internal;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i10, Class cls, String str, String str2, int i11) {
        super(i10, CallableReference.NO_RECEIVER, cls, str, str2, i11);
    }

    public FunctionReferenceImpl(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(i10, obj, cls, str, str2, i11);
    }

    public FunctionReferenceImpl(int i10, u7.d dVar, String str, String str2) {
        super(i10, CallableReference.NO_RECEIVER, ((c) dVar).a(), str, str2, !(dVar instanceof u7.c) ? 1 : 0);
    }
}
