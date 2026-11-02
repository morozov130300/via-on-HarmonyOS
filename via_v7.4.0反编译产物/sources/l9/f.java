package l9;

import android.util.Base64;
import java.nio.charset.Charset;
import org.json.JSONObject;
import w9.l;
import w9.n;
import z8.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    public final l f8454a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8455b;

    public f(l lVar, boolean z10) {
        this.f8454a = lVar;
        this.f8455b = z10;
    }

    @Override // l9.c
    public String a() {
        try {
            String strTrim = this.f8454a.L2(this.f8455b).toString().trim();
            Charset charset = m8.a.f8676a;
            return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
        } catch (Exception e10) {
            pc.a.d(e10);
            return "";
        }
    }

    @Override // l9.c
    public boolean b(String str) {
        if (d0.a(str)) {
            return false;
        }
        try {
            String str2 = new String(Base64.decode(str, 0), m8.a.f8676a);
            if (str2.isEmpty()) {
                return false;
            }
            this.f8454a.j1(new JSONObject(str2));
            n.e().p(true).q(true);
            return true;
        } catch (Exception e10) {
            pc.a.d(e10);
            return false;
        }
    }

    @Override // l9.c
    public String getKey() {
        return "settings";
    }
}
