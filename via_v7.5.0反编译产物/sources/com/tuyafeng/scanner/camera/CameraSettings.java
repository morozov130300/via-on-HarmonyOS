package com.tuyafeng.scanner.camera;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class CameraSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3537a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3538b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3539c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3540d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3541e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3542f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3543g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3544h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FocusMode f3545i = FocusMode.AUTO;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum FocusMode {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public FocusMode a() {
        return this.f3545i;
    }

    public int b() {
        return this.f3537a;
    }

    public boolean c() {
        return this.f3541e;
    }

    public boolean d() {
        return this.f3544h;
    }

    public boolean e() {
        return this.f3539c;
    }

    public boolean f() {
        return this.f3543g;
    }

    public boolean g() {
        return this.f3540d;
    }

    public boolean h() {
        return this.f3538b;
    }
}
