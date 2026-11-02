package mark.via.download;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y1 {

    /* renamed from: a, reason: collision with root package name */
    public String f9979a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f9980b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f9981c;

    /* renamed from: d, reason: collision with root package name */
    public String f9982d;

    public y1(String str) {
        this(str, (String[]) null, (String[]) null, (String) null);
    }

    public y1(String str, String str2, String str3, String str4) {
        this(str, str2 == null ? null : new String[]{str2}, str3 != null ? new String[]{str3} : null, str4);
    }

    public y1(String str, String str2, String[] strArr, String str3) {
        this(str, str2 == null ? null : new String[]{str2}, strArr, str3);
    }

    public y1(String str, String[] strArr, String[] strArr2, String str2) {
        this.f9979a = str;
        this.f9980b = strArr;
        this.f9981c = strArr2;
        this.f9982d = str2;
    }

    public String[] a() {
        return this.f9981c;
    }

    public String[] b() {
        return this.f9980b;
    }

    public String c() {
        return this.f9979a;
    }

    public String d() {
        return this.f9982d;
    }
}
