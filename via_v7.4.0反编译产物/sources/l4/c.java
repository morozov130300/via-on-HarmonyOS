package l4;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import com.thegrizzlylabs.sardineandroid.model.Multistatus;
import java.io.InputStream;
import okhttp3.y;
import okhttp3.z;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends f {
    public Multistatus c(InputStream inputStream) {
        return (Multistatus) m4.d.h(Multistatus.class, inputStream);
    }

    @Override // l4.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Multistatus a(y yVar) throws SardineException {
        super.b(yVar);
        z zVarA = yVar.a();
        if (zVarA == null) {
            throw new SardineException("No entity found in response", yVar.d(), yVar.k());
        }
        Multistatus multistatusC = c(zVarA.a());
        zVarA.close();
        return multistatusC;
    }
}
