package l4;

import com.thegrizzlylabs.sardineandroid.model.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8398a = "d";

    @Override // l4.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List a(y yVar) {
        List<Response> response = new c().a(yVar).getResponse();
        ArrayList arrayList = new ArrayList(response.size());
        for (Response response2 : response) {
            try {
                arrayList.add(new j4.a(response2));
            } catch (URISyntaxException unused) {
                m4.c.a(f8398a, "Ignore resource with invalid URI " + response2.getHref());
            }
        }
        yVar.close();
        return arrayList;
    }
}
