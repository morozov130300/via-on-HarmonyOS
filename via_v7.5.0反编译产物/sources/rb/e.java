package rb;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements k9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qb.d f12123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12125c;

    public e(qb.d dVar, boolean z10) {
        this(dVar, z10, 0L);
    }

    @Override // k9.c
    public File a(String str) {
        if (!str.startsWith("bookmarks.html") && !str.startsWith("settings.txt") && !str.startsWith("favorites.txt")) {
            return null;
        }
        try {
            return this.f12123a.d(this.f12123a.getPath() + str, this.f12124b);
        } catch (IOException e10) {
            tc.a.j(e10);
            return null;
        }
    }

    @Override // k9.c
    public long b(String str) {
        return this.f12125c;
    }

    @Override // k9.c
    public boolean c() {
        return true;
    }

    public e(qb.d dVar, boolean z10, long j10) {
        this.f12123a = dVar;
        this.f12124b = z10;
        this.f12125c = j10;
    }
}
