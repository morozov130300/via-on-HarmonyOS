package c1;

import e1.g;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f1909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f1910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f1911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f1912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f1913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f1914h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1916b;

    static {
        String strA = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f1909c = strA;
        String strA2 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f1910d = strA2;
        String strA3 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f1911e = strA3;
        f1912f = Collections.unmodifiableSet(new HashSet(Arrays.asList(b1.b.b("proto"), b1.b.b("json"))));
        f1913g = new a(strA, null);
        f1914h = new a(strA2, strA3);
    }

    public a(String str, String str2) {
        this.f1915a = str;
        this.f1916b = str2;
    }

    public static a c(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    @Override // e1.g
    public Set a() {
        return f1912f;
    }

    public byte[] b() {
        String str = this.f1916b;
        if (str == null && this.f1915a == null) {
            return null;
        }
        String str2 = this.f1915a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f1916b;
    }

    public String e() {
        return this.f1915a;
    }

    @Override // e1.f
    public byte[] getExtras() {
        return b();
    }

    @Override // e1.f
    public String getName() {
        return "cct";
    }
}
