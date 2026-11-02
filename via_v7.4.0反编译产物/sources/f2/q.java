package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final String f5613a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5614b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5615c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5616d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5617e;

    /* renamed from: f, reason: collision with root package name */
    public final long f5618f;

    /* renamed from: g, reason: collision with root package name */
    public final long f5619g;

    /* renamed from: h, reason: collision with root package name */
    public final Long f5620h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f5621i;

    /* renamed from: j, reason: collision with root package name */
    public final Long f5622j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f5623k;

    public q(String str, String str2, long j10, long j11, long j12, long j13, long j14, Long l10, Long l11, Long l12, Boolean bool) {
        t1.f.d(str);
        t1.f.d(str2);
        t1.f.a(j10 >= 0);
        t1.f.a(j11 >= 0);
        t1.f.a(j12 >= 0);
        t1.f.a(j14 >= 0);
        this.f5613a = str;
        this.f5614b = str2;
        this.f5615c = j10;
        this.f5616d = j11;
        this.f5617e = j12;
        this.f5618f = j13;
        this.f5619g = j14;
        this.f5620h = l10;
        this.f5621i = l11;
        this.f5622j = l12;
        this.f5623k = bool;
    }

    public final q a(Long l10, Long l11, Boolean bool) {
        return new q(this.f5613a, this.f5614b, this.f5615c, this.f5616d, this.f5617e, this.f5618f, this.f5619g, this.f5620h, l10, l11, bool);
    }

    public final q b(long j10, long j11) {
        return new q(this.f5613a, this.f5614b, this.f5615c, this.f5616d, this.f5617e, this.f5618f, j10, Long.valueOf(j11), this.f5621i, this.f5622j, this.f5623k);
    }

    public final q c(long j10) {
        return new q(this.f5613a, this.f5614b, this.f5615c, this.f5616d, this.f5617e, j10, this.f5619g, this.f5620h, this.f5621i, this.f5622j, this.f5623k);
    }
}
