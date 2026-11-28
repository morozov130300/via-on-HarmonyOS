package lc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7647b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f7646a = new StringBuilder();

    public void a(CharSequence charSequence) {
        if (this.f7647b != 0) {
            this.f7646a.append('\n');
        }
        this.f7646a.append(charSequence);
        this.f7647b++;
    }

    public String b() {
        return this.f7646a.toString();
    }
}
