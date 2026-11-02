package rb;

import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements m9.c {

    /* renamed from: a, reason: collision with root package name */
    public final qb.d f11643a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11644b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11645c;

    public e(qb.d dVar, boolean z10) {
        this(dVar, z10, 0L);
    }

    public e(qb.d dVar, boolean z10, long j10) {
        this.f11643a = dVar;
        this.f11644b = z10;
        this.f11645c = j10;
    }

    @Override // m9.c
    public File a(String str) {
        if (!str.startsWith("bookmarks.html") && !str.startsWith("settings.txt") && !str.startsWith("favorites.txt")) {
            return null;
        }
        try {
            return this.f11643a.d(this.f11643a.getPath() + str, this.f11644b);
        } catch (IOException e10) {
            pc.a.i(e10);
            return null;
        }
    }

    @Override // m9.c
    public long b(String str) {
        return this.f11645c;
    }

    @Override // m9.c
    public boolean c() {
        return true;
    }
}
