package g6;

import e6.q;
import e6.s;
import io.noties.markwon.core.CoreProps;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g implements s {
    @Override // e6.s
    public Object a(e6.g gVar, q qVar) {
        if (CoreProps.ListItemType.BULLET == CoreProps.f6421a.c(qVar)) {
            return new h6.b(gVar.e(), ((Integer) CoreProps.f6422b.c(qVar)).intValue());
        }
        return new h6.h(gVar.e(), String.valueOf(CoreProps.f6423c.c(qVar)) + ". ");
    }
}
