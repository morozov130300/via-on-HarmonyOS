package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r6 {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f3727a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3728b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3729c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3730d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3731e;

    public r6(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public r6(String str, Uri uri, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, z6 z6Var) {
        this.f3727a = uri;
        this.f3728b = "";
        this.f3729c = "";
        this.f3730d = z10;
        this.f3731e = z12;
    }

    public final r6 a() {
        return new r6(null, this.f3727a, this.f3728b, this.f3729c, this.f3730d, false, true, false, null);
    }

    public final r6 b() {
        if (this.f3728b.isEmpty()) {
            return new r6(null, this.f3727a, this.f3728b, this.f3729c, true, false, this.f3731e, false, null);
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
}
