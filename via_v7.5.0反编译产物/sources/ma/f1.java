package ma;

import androidx.lifecycle.LiveData;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f1 extends androidx.lifecycle.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.lifecycle.n f8004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveData f8005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.lifecycle.n f8006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveData f8007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.n f8008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LiveData f8009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.lifecycle.n f8010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveData f8011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8012l;

    public f1() {
        androidx.lifecycle.n nVar = new androidx.lifecycle.n();
        this.f8004d = nVar;
        this.f8005e = nVar;
        androidx.lifecycle.n nVar2 = new androidx.lifecycle.n();
        this.f8006f = nVar2;
        this.f8007g = nVar2;
        androidx.lifecycle.n nVar3 = new androidx.lifecycle.n();
        this.f8008h = nVar3;
        this.f8009i = nVar3;
        androidx.lifecycle.n nVar4 = new androidx.lifecycle.n();
        this.f8010j = nVar4;
        this.f8011k = nVar4;
        this.f8012l = 0;
    }

    public void j(boolean z10) {
        this.f8010j.m(Boolean.valueOf(z10));
    }

    public int k() {
        return this.f8012l;
    }

    public void l(int i10) {
        this.f8012l = i10;
    }

    public void m(l9.b bVar) {
        if (bVar != null) {
            this.f8006f.m(bVar);
        }
        this.f8004d.m(1);
    }

    public void n(l9.b bVar) {
        if (bVar != null) {
            this.f8008h.m(bVar);
        }
        this.f8004d.m(0);
    }
}
