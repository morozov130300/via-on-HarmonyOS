package mark.via.download;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f10219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f10220c;

    public i2(String str) {
        this(str, (String[]) null, (String[]) null);
    }

    public String[] a() {
        return this.f10220c;
    }

    public String[] b() {
        return this.f10219b;
    }

    public String c() {
        return this.f10218a;
    }

    public i2(String str, String str2, String str3) {
        this(str, str2 == null ? null : new String[]{str2}, str3 != null ? new String[]{str3} : null);
    }

    public i2(String str, String str2, String[] strArr) {
        this(str, str2 == null ? null : new String[]{str2}, strArr);
    }

    public i2(String str, String[] strArr, String[] strArr2) {
        this.f10218a = str;
        this.f10219b = strArr;
        this.f10220c = strArr2;
    }
}
