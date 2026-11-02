package e8;

import android.webkit.HttpAuthHandler;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public a f4845a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(HttpAuthHandler httpAuthHandler, String str, String str2);
    }

    public void G(a aVar) {
        this.f4845a = aVar;
    }

    @Override // p4.a
    public boolean s(t4.b bVar, HttpAuthHandler httpAuthHandler, String str, String str2) {
        a aVar;
        if (!bVar.isShown() || (aVar = this.f4845a) == null) {
            httpAuthHandler.cancel();
            return true;
        }
        aVar.a(httpAuthHandler, str, str2);
        return true;
    }
}
