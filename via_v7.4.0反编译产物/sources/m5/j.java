package m5;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f8672a;

    /* renamed from: b, reason: collision with root package name */
    public final h f8673b;

    public j(int i10) {
        this(i10, null);
    }

    public j(int i10, h hVar) {
        this.f8672a = i10;
        this.f8673b = hVar;
    }

    public static j c(h hVar) {
        return new j(2, hVar);
    }

    public static j d() {
        return new j(1);
    }

    public h a() {
        return this.f8673b;
    }

    public boolean b() {
        return this.f8672a == 1;
    }

    public String toString() {
        return "DownloadResult{code=" + this.f8672a + ", error=" + this.f8673b + '}';
    }
}
