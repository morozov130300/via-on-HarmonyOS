package e5;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f4217a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f4218b = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f4219c = new h();

    @Override // e5.g
    public Executor a() {
        return this.f4219c;
    }

    @Override // e5.g
    public f b() {
        return this.f4217a;
    }
}
