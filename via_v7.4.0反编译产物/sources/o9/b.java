package o9;

import g6.p;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f10476a;

    /* renamed from: b, reason: collision with root package name */
    public String f10477b;

    /* renamed from: c, reason: collision with root package name */
    public String f10478c;

    /* renamed from: d, reason: collision with root package name */
    public String f10479d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f10480e;

    /* renamed from: f, reason: collision with root package name */
    public long f10481f;

    /* renamed from: g, reason: collision with root package name */
    public long f10482g;

    public long a() {
        return this.f10481f;
    }

    public String b() {
        return this.f10479d;
    }

    public String c() {
        return this.f10476a;
    }

    public int d() {
        return this.f10480e;
    }

    public String e() {
        return this.f10478c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f10480e == bVar.f10480e && this.f10481f == bVar.f10481f && this.f10482g == bVar.f10482g && u1.a(this.f10476a, bVar.f10476a) && u1.a(this.f10477b, bVar.f10477b) && u1.a(this.f10478c, bVar.f10478c) && u1.a(this.f10479d, bVar.f10479d)) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.f10482g;
    }

    public String g() {
        return this.f10477b;
    }

    public void h(long j10) {
        this.f10481f = j10;
    }

    public int hashCode() {
        return u1.b(this.f10476a, this.f10477b, this.f10478c, this.f10479d, Integer.valueOf(this.f10480e), Long.valueOf(this.f10481f), Long.valueOf(this.f10482g));
    }

    public void i(String str) {
        this.f10479d = str;
    }

    public void j(String str) {
        this.f10476a = str;
    }

    public void k(int i10) {
        this.f10480e = i10;
    }

    public void l(String str) {
        this.f10478c = p.l(str);
    }

    public void m(long j10) {
        this.f10482g = j10;
    }

    public void n(String str) {
        this.f10477b = str;
    }

    public String toString() {
        return "BookmarkItem{id='" + this.f10476a + "', url='" + this.f10477b + "', title='" + this.f10478c + "', folderId='" + this.f10479d + "', order=" + this.f10480e + ", createdAt=" + this.f10481f + ", updatedAt=" + this.f10482g + '}';
    }
}
