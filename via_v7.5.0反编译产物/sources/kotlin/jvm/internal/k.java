package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public t7.c b(Class cls) {
        return new d(cls);
    }

    public t7.d c(Class cls, String str) {
        return new i(cls, str);
    }

    public String d(g gVar) {
        String string = gVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String e(Lambda lambda) {
        return d(lambda);
    }

    public t7.e a(FunctionReference functionReference) {
        return functionReference;
    }
}
