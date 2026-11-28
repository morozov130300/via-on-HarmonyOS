package p3;

import android.content.Context;
import n2.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        String a(Object obj);
    }

    public static n2.c b(String str, String str2) {
        return n2.c.l(f.a(str, str2), f.class);
    }

    public static n2.c c(final String str, final a aVar) {
        return n2.c.m(f.class).b(r.i(Context.class)).e(new n2.h() { // from class: p3.g
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return f.a(str, aVar.a((Context) eVar.a(Context.class)));
            }
        }).c();
    }
}
