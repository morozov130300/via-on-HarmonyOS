package m6;

import io.noties.markwon.core.CoreProps;
import k6.q;
import k6.s;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g implements s {
    @Override // k6.s
    public Object a(k6.g gVar, q qVar) {
        if (CoreProps.ListItemType.BULLET == CoreProps.f7190a.c(qVar)) {
            return new n6.b(gVar.e(), ((Integer) CoreProps.f7191b.c(qVar)).intValue());
        }
        return new n6.h(gVar.e(), String.valueOf(CoreProps.f7192c.c(qVar)) + ".\u00a0");
    }
}
