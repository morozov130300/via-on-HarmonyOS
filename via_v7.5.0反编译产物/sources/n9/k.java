package n9;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10762c;

    public static k a(JSONObject jSONObject) {
        k kVar = new k();
        kVar.c(jSONObject.optInt("prompt_tokens", 0));
        kVar.b(jSONObject.optInt("completion_tokens", 0));
        kVar.d(jSONObject.optInt("total_tokens", 0));
        return kVar;
    }

    public void b(int i10) {
        this.f10761b = i10;
    }

    public void c(int i10) {
        this.f10760a = i10;
    }

    public void d(int i10) {
        this.f10762c = i10;
    }

    public String toString() {
        return "ChatUsage{promptTokens=" + this.f10760a + ", completeTokens=" + this.f10761b + ", totalTokens=" + this.f10762c + '}';
    }
}
