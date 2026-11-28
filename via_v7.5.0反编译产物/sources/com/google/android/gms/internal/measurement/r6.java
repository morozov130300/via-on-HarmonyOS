package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f3026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3030e;

    public r6(String str, Uri uri, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, z6 z6Var) {
        this.f3026a = uri;
        this.f3027b = "";
        this.f3028c = "";
        this.f3029d = z10;
        this.f3030e = z12;
    }

    public final r6 a() {
        return new r6(null, this.f3026a, this.f3027b, this.f3028c, this.f3029d, false, true, false, null);
    }

    public final r6 b() {
        if (this.f3027b.isEmpty()) {
            return new r6(null, this.f3026a, this.f3027b, this.f3028c, true, false, this.f3030e, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final v6 c(String str, double d10) {
        return new p6(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final v6 d(String str, long j10) {
        return new n6(this, str, Long.valueOf(j10), true);
    }

    public final v6 e(String str, String str2) {
        return new q6(this, str, str2, true);
    }

    public final v6 f(String str, boolean z10) {
        return new o6(this, str, Boolean.valueOf(z10), true);
    }

    public r6(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }
}
