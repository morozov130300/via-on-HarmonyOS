package v9;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.m f13447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f13448b;

    public h(u9.m mVar, u9.l lVar) {
        this.f13447a = mVar;
        this.f13448b = lVar;
    }

    @Override // v9.g
    public void a() {
        int[] iArr;
        int i10 = this.f13447a.getInt("searchweb", -1);
        if (i10 == -1) {
            return;
        }
        String country = Locale.getDefault().getCountry();
        Locale locale = Locale.ROOT;
        String upperCase = country.toUpperCase(locale);
        String upperCase2 = Locale.getDefault().getLanguage().toUpperCase(locale);
        if ("CN".equalsIgnoreCase(upperCase)) {
            iArr = new int[]{-999, -2, -1, -3, -4, -5, -6};
        } else {
            iArr = "RU".equalsIgnoreCase(upperCase2) ? new int[]{-999, -2, -1, -3, -7, -9, -10} : new int[]{-999, -2, -1, -3, -8, -9, -10};
        }
        if (i10 < 0 || i10 >= iArr.length) {
            return;
        }
        this.f13448b.s(iArr[i10]);
    }

    @Override // v9.g
    public int b() {
        return 7;
    }
}
