package l4;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import okhttp3.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class f implements e {
    public void b(y yVar) throws SardineException {
        if (yVar.j()) {
            return;
        }
        throw new SardineException("Error contacting " + yVar.o().h(), yVar.d(), yVar.k());
    }
}
