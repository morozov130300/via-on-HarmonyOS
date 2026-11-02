package com.tuyafeng.scanner.camera;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class CameraSettings {

    /* renamed from: a, reason: collision with root package name */
    public int f4244a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4245b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4246c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4247d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4248e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4249f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4250g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4251h = false;

    /* renamed from: i, reason: collision with root package name */
    public FocusMode f4252i = FocusMode.AUTO;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum FocusMode {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public FocusMode a() {
        return this.f4252i;
    }

    public int b() {
        return this.f4244a;
    }

    public boolean c() {
        return this.f4248e;
    }

    public boolean d() {
        return this.f4251h;
    }

    public boolean e() {
        return this.f4246c;
    }

    public boolean f() {
        return this.f4250g;
    }

    public boolean g() {
        return this.f4247d;
    }

    public boolean h() {
        return this.f4245b;
    }
}
