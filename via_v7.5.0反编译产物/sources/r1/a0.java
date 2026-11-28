package r1;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Callable f11926f;

    public /* synthetic */ a0(Callable callable, z zVar) {
        super();
        this.f11926f = callable;
    }

    @Override // r1.c0
    public final String a() {
        try {
            return (String) this.f11926f.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
