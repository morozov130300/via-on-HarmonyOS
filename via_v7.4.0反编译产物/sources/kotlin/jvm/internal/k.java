package kotlin.jvm.internal;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k {
    public u7.e a(FunctionReference functionReference) {
        return functionReference;
    }

    public u7.c b(Class cls) {
        return new d(cls);
    }

    public u7.d c(Class cls, String str) {
        return new i(cls, str);
    }

    public String d(g gVar) {
        String string = gVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String e(Lambda lambda) {
        return d(lambda);
    }
}
