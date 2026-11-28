package m4;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import okhttp3.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements e {
    public void b(y yVar) throws SardineException {
        if (yVar.j()) {
            return;
        }
        throw new SardineException("Error contacting " + yVar.o().h(), yVar.c(), yVar.k());
    }
}
