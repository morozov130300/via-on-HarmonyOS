package g2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f5234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f5235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f5236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f5237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f5238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f5239k;

    public q(String str, String str2, long j10, long j11, long j12, long j13, long j14, Long l10, Long l11, Long l12, Boolean bool) {
        u1.f.d(str);
        u1.f.d(str2);
        u1.f.a(j10 >= 0);
        u1.f.a(j11 >= 0);
        u1.f.a(j12 >= 0);
        u1.f.a(j14 >= 0);
        this.f5229a = str;
        this.f5230b = str2;
        this.f5231c = j10;
        this.f5232d = j11;
        this.f5233e = j12;
        this.f5234f = j13;
        this.f5235g = j14;
        this.f5236h = l10;
        this.f5237i = l11;
        this.f5238j = l12;
        this.f5239k = bool;
    }

    public final q a(Long l10, Long l11, Boolean bool) {
        return new q(this.f5229a, this.f5230b, this.f5231c, this.f5232d, this.f5233e, this.f5234f, this.f5235g, this.f5236h, l10, l11, bool);
    }

    public final q b(long j10, long j11) {
        return new q(this.f5229a, this.f5230b, this.f5231c, this.f5232d, this.f5233e, this.f5234f, j10, Long.valueOf(j11), this.f5237i, this.f5238j, this.f5239k);
    }

    public final q c(long j10) {
        return new q(this.f5229a, this.f5230b, this.f5231c, this.f5232d, this.f5233e, j10, this.f5235g, this.f5236h, this.f5237i, this.f5238j, this.f5239k);
    }
}
