package m4;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import com.thegrizzlylabs.sardineandroid.model.Multistatus;
import java.io.InputStream;
import okhttp3.y;
import okhttp3.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends f {
    public Multistatus c(InputStream inputStream) {
        return (Multistatus) n4.d.h(Multistatus.class, inputStream);
    }

    @Override // m4.e
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Multistatus a(y yVar) throws SardineException {
        super.b(yVar);
        z zVarA = yVar.a();
        if (zVarA == null) {
            throw new SardineException("No entity found in response", yVar.c(), yVar.k());
        }
        Multistatus multistatusC = c(zVarA.a());
        zVarA.close();
        return multistatusC;
    }
}
