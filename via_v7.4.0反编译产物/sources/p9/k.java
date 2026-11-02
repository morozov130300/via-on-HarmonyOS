package p9;

import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public int f11031a;

    /* renamed from: b, reason: collision with root package name */
    public int f11032b;

    /* renamed from: c, reason: collision with root package name */
    public int f11033c;

    public static k a(JSONObject jSONObject) {
        k kVar = new k();
        kVar.c(jSONObject.optInt("prompt_tokens", 0));
        kVar.b(jSONObject.optInt("completion_tokens", 0));
        kVar.d(jSONObject.optInt("total_tokens", 0));
        return kVar;
    }

    public void b(int i10) {
        this.f11032b = i10;
    }

    public void c(int i10) {
        this.f11031a = i10;
    }

    public void d(int i10) {
        this.f11033c = i10;
    }

    public String toString() {
        return "ChatUsage{promptTokens=" + this.f11031a + ", completeTokens=" + this.f11032b + ", totalTokens=" + this.f11033c + '}';
    }
}
