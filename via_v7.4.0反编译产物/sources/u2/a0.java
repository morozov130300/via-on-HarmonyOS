package u2;

import u2.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a0 extends d0.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f12574a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12575b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12576c;

    public a0(String str, String str2, boolean z10) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f12574a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f12575b = str2;
        this.f12576c = z10;
    }

    @Override // u2.d0.c
    public boolean b() {
        return this.f12576c;
    }

    @Override // u2.d0.c
    public String c() {
        return this.f12575b;
    }

    @Override // u2.d0.c
    public String d() {
        return this.f12574a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0.c) {
            d0.c cVar = (d0.c) obj;
            if (this.f12574a.equals(cVar.d()) && this.f12575b.equals(cVar.c()) && this.f12576c == cVar.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f12574a.hashCode() ^ 1000003) * 1000003) ^ this.f12575b.hashCode()) * 1000003) ^ (this.f12576c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.f12574a + ", osCodeName=" + this.f12575b + ", isRooted=" + this.f12576c + "}";
    }
}
