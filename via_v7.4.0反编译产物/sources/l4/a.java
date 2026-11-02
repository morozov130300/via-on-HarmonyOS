package l4;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import okhttp3.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends f {
    @Override // l4.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean a(y yVar) throws SardineException {
        if (!yVar.j() && (yVar.d() == 404 || yVar.d() == 403)) {
            yVar.close();
            return Boolean.valueOf(yVar.d() == 403);
        }
        b(yVar);
        yVar.close();
        return Boolean.TRUE;
    }
}
