package o3;

import android.content.Context;
import m2.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        String a(Object obj);
    }

    public static m2.c b(String str, String str2) {
        return m2.c.l(f.a(str, str2), f.class);
    }

    public static m2.c c(final String str, final a aVar) {
        return m2.c.m(f.class).b(r.i(Context.class)).e(new m2.h() { // from class: o3.g
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return f.a(str, aVar.a((Context) eVar.a(Context.class)));
            }
        }).c();
    }
}
