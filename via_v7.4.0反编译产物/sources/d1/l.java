package d1;

import com.google.android.datatransport.Priority;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l {
    public static void a(a1.e eVar, Priority priority) {
        if (!(eVar instanceof r)) {
            h1.a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", eVar);
        } else {
            t.c().e().l(((r) eVar).b().f(priority), 1);
        }
    }
}
