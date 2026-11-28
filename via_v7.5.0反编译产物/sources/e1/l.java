package e1;

import com.google.android.datatransport.Priority;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static void a(b1.e eVar, Priority priority) {
        if (!(eVar instanceof r)) {
            i1.a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", eVar);
        } else {
            t.c().e().l(((r) eVar).b().f(priority), 1);
        }
    }
}
