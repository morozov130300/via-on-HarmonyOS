package q9;

import x8.c1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11842b;

    public a(String str) {
        this.f11842b = str;
        c(c1.w(str));
    }

    public String a() {
        return this.f11841a;
    }

    public String b() {
        return this.f11842b;
    }

    public void c(String str) {
        if (str == null) {
            str = "";
        }
        this.f11841a = str;
    }
}
