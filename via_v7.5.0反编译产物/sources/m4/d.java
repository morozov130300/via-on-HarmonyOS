package m4;

import com.thegrizzlylabs.sardineandroid.model.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7872a = "d";

    @Override // m4.e
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a(y yVar) {
        List<Response> response = new c().a(yVar).getResponse();
        ArrayList arrayList = new ArrayList(response.size());
        for (Response response2 : response) {
            try {
                arrayList.add(new k4.a(response2));
            } catch (URISyntaxException unused) {
                n4.c.a(f7872a, "Ignore resource with invalid URI " + response2.getHref());
            }
        }
        yVar.close();
        return arrayList;
    }
}
