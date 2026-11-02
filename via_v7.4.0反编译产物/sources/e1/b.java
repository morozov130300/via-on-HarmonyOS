package e1;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4702a;

    /* renamed from: b, reason: collision with root package name */
    public final n1.a f4703b;

    /* renamed from: c, reason: collision with root package name */
    public final n1.a f4704c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4705d;

    public b(Context context, n1.a aVar, n1.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f4702a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f4703b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f4704c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f4705d = str;
    }

    @Override // e1.f
    public Context b() {
        return this.f4702a;
    }

    @Override // e1.f
    public String c() {
        return this.f4705d;
    }

    @Override // e1.f
    public n1.a d() {
        return this.f4704c;
    }

    @Override // e1.f
    public n1.a e() {
        return this.f4703b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f4702a.equals(fVar.b()) && this.f4703b.equals(fVar.e()) && this.f4704c.equals(fVar.d()) && this.f4705d.equals(fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f4702a.hashCode() ^ 1000003) * 1000003) ^ this.f4703b.hashCode()) * 1000003) ^ this.f4704c.hashCode()) * 1000003) ^ this.f4705d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f4702a + ", wallClock=" + this.f4703b + ", monotonicClock=" + this.f4704c + ", backendName=" + this.f4705d + "}";
    }
}
