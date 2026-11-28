package n9;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f10767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f10769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10770h;

    public long a() {
        return this.f10769g;
    }

    public String b() {
        List list = this.f10767e;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) this.f10767e.get(0);
    }

    public int c() {
        return this.f10768f;
    }

    public String d() {
        return this.f10763a;
    }

    public String e() {
        return this.f10766d;
    }

    public List f() {
        return this.f10767e;
    }

    public String g() {
        return this.f10764b;
    }

    public long h() {
        return this.f10770h;
    }

    public String i() {
        return this.f10765c;
    }

    public void j(long j10) {
        this.f10769g = j10;
    }

    public void k(int i10) {
        this.f10768f = i10;
    }

    public void l(String str) {
        this.f10763a = str;
    }

    public void m(String str) {
        this.f10766d = str;
    }

    public void n(String str) {
        this.f10767e = com.tuyafeng.support.utils.p.o(str, ',');
    }

    public void o(List list) {
        this.f10767e = list;
    }

    public void p(String str) {
        this.f10764b = str;
    }

    public void q(long j10) {
        this.f10770h = j10;
    }

    public void r(String str) {
        this.f10765c = str;
    }
}
