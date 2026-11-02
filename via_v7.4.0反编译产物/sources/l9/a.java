package l9;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import z8.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final u4.a f8450a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8451b;

    public a(u4.a aVar, int i10) {
        this.f8450a = aVar;
        this.f8451b = i10;
    }

    @Override // l9.c
    public String a() throws JSONException {
        u4.a aVar = this.f8450a;
        if (aVar == null) {
            return null;
        }
        JSONObject jSONObjectC = aVar.c(this.f8451b);
        if (jSONObjectC.length() <= 0) {
            return null;
        }
        String strTrim = jSONObjectC.toString().trim();
        Charset charset = m8.a.f8676a;
        return new String(Base64.encode(strTrim.getBytes(charset), 0), charset);
    }

    @Override // l9.c
    public boolean b(String str) {
        if (d0.a(str)) {
            return false;
        }
        try {
            String str2 = new String(Base64.decode(str, 0), m8.a.f8676a);
            if (!TextUtils.isEmpty(str2)) {
                if (this.f8450a.h(str2)) {
                    return true;
                }
            }
        } catch (Exception e10) {
            pc.a.d(e10);
        }
        return false;
    }

    @Override // l9.c
    public String getKey() {
        return "adrules";
    }
}
