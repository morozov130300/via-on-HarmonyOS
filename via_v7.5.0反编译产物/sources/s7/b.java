package s7;

import e7.y;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12220c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12221e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12223n;

    public b(int i10, int i11, int i12) {
        this.f12220c = i12;
        this.f12221e = i11;
        boolean z10 = false;
        if (i12 <= 0 ? i10 >= i11 : i10 <= i11) {
            z10 = true;
        }
        this.f12222m = z10;
        this.f12223n = z10 ? i10 : i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12222m;
    }

    @Override // e7.y
    public int nextInt() {
        int i10 = this.f12223n;
        if (i10 != this.f12221e) {
            this.f12223n = this.f12220c + i10;
            return i10;
        }
        if (!this.f12222m) {
            throw new NoSuchElementException();
        }
        this.f12222m = false;
        return i10;
    }
}
