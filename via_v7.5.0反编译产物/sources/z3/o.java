package z3;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15169c;

    public o(int i10, int i11, int i12) throws FormatException {
        super(i10);
        if (i11 < 0 || i11 > 10 || i12 < 0 || i12 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f15168b = i11;
        this.f15169c = i12;
    }

    public int b() {
        return this.f15168b;
    }

    public int c() {
        return this.f15169c;
    }

    public boolean d() {
        return this.f15168b == 10;
    }

    public boolean e() {
        return this.f15169c == 10;
    }
}
