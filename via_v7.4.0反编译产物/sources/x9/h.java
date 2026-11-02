package x9;

import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final w9.m f14307a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f14308b;

    public h(w9.m mVar, w9.l lVar) {
        this.f14307a = mVar;
        this.f14308b = lVar;
    }

    @Override // x9.g
    public void a() {
        int i10 = this.f14307a.getInt("searchweb", -1);
        if (i10 == -1) {
            return;
        }
        String country = Locale.getDefault().getCountry();
        Locale locale = Locale.ROOT;
        int[] iArr = "CN".equalsIgnoreCase(country.toUpperCase(locale)) ? new int[]{-999, -2, -1, -3, -4, -5, -6} : "RU".equalsIgnoreCase(Locale.getDefault().getLanguage().toUpperCase(locale)) ? new int[]{-999, -2, -1, -3, -7, -9, -10} : new int[]{-999, -2, -1, -3, -8, -9, -10};
        if (i10 < 0 || i10 >= iArr.length) {
            return;
        }
        this.f14308b.q(iArr[i10]);
    }

    @Override // x9.g
    public int b() {
        return 7;
    }
}
