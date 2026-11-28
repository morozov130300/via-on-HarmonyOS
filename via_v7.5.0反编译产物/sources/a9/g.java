package a9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f222b;

    public g(String str, CharSequence charSequence) {
        this.f221a = str;
        this.f222b = charSequence;
    }

    @Override // a9.a0
    public CharSequence a() {
        return this.f222b;
    }

    public void b(CharSequence charSequence) {
        this.f222b = charSequence;
    }

    @Override // a9.a0
    public String getId() {
        return this.f221a;
    }
}
