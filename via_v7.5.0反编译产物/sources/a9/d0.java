package a9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d0 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f209b;

    public d0(String str, CharSequence charSequence) {
        this.f208a = str;
        this.f209b = charSequence;
    }

    @Override // a9.a0
    public CharSequence a() {
        return this.f209b;
    }

    @Override // a9.a0
    public String getId() {
        return this.f208a;
    }
}
