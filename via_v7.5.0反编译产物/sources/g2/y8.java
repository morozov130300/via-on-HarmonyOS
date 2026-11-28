package g2;

import android.content.ComponentName;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class y8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ComponentName f5472c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c9 f5473e;

    public y8(c9 c9Var, ComponentName componentName) {
        this.f5473e = c9Var;
        this.f5472c = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d9.M(this.f5473e.f4691c, this.f5472c);
    }
}
