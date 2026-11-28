package m4;

import com.thegrizzlylabs.sardineandroid.impl.SardineException;
import okhttp3.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends f {
    @Override // m4.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean a(y yVar) throws SardineException {
        if (!yVar.j() && (yVar.c() == 404 || yVar.c() == 403)) {
            yVar.close();
            return Boolean.valueOf(yVar.c() == 403);
        }
        b(yVar);
        yVar.close();
        return Boolean.TRUE;
    }
}
