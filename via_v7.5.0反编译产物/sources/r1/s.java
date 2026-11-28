package r1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f11947e;

    public s(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f11947e = bArr;
    }

    @Override // r1.r
    public final byte[] b0() {
        return this.f11947e;
    }
}
