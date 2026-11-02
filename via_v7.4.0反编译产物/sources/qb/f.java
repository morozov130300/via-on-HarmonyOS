package qb;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;
import z8.w0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f11452a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11453b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11454c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11455d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11456e;

    public f() {
        this(null, null, null, false, null);
    }

    public f(String str, String str2, String str3, boolean z10, String str4) {
        if (str == null || str.isEmpty()) {
            this.f11452a = null;
        } else {
            if (str.charAt(str.length() - 1) != '/') {
                str = str + "/";
            }
            this.f11452a = str;
        }
        this.f11453b = str2;
        this.f11454c = str3;
        this.f11455d = z10;
        this.f11456e = str4;
    }

    public static f b(JSONObject jSONObject, String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("user");
        String strOptString3 = jSONObject.optString("pass");
        String strOptString4 = jSONObject.optString("path");
        boolean zOptBoolean = jSONObject.optBoolean("digestAuth", false);
        if (!strOptString2.isEmpty()) {
            strOptString2 = w0.a(str, str2, strOptString2);
        }
        String str3 = strOptString2;
        if (!strOptString3.isEmpty()) {
            strOptString3 = w0.a(str, str2, strOptString3);
        }
        return new f(strOptString, str3, strOptString3, zOptBoolean, strOptString4);
    }

    @Override // qb.e
    public boolean a() {
        String str;
        String str2;
        String str3 = this.f11452a;
        return str3 == null || str3.isEmpty() || (str = this.f11453b) == null || str.isEmpty() || (str2 = this.f11454c) == null || str2.isEmpty();
    }

    public String c() {
        return this.f11452a;
    }

    public String d() {
        return this.f11454c;
    }

    public String e() {
        return this.f11456e;
    }

    public String f() {
        return this.f11453b;
    }

    public boolean g() {
        return this.f11455d;
    }

    public JSONObject h(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str3 = this.f11452a;
        if (str3 != null && !str3.isEmpty()) {
            jSONObject.put("url", this.f11452a);
        }
        String str4 = this.f11453b;
        if (str4 != null && !str4.isEmpty()) {
            jSONObject.put("user", w0.f(str, str2, this.f11453b));
        }
        String str5 = this.f11454c;
        if (str5 != null && !str5.isEmpty()) {
            jSONObject.put("pass", w0.f(str, str2, this.f11454c));
        }
        jSONObject.put("digestAuth", this.f11455d);
        jSONObject.put("path", this.f11456e);
        return jSONObject;
    }
}
