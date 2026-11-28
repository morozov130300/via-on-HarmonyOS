package z0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f15118a = new c();

    public void a(StringBuilder sb2, String str, boolean z10) {
        if (!z10) {
            for (int i10 = 0; i10 < str.length() && !z10; i10++) {
                z10 = c(str.charAt(i10));
            }
        }
        if (z10) {
            sb2.append('\"');
        }
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (d(cCharAt)) {
                sb2.append('\\');
            }
            sb2.append(cCharAt);
        }
        if (z10) {
            sb2.append('\"');
        }
    }

    public StringBuilder b(StringBuilder sb2, j jVar, boolean z10) {
        sb2.append(jVar.getName());
        String value = jVar.getValue();
        if (value != null) {
            sb2.append('=');
            a(sb2, value, z10);
        }
        return sb2;
    }

    public boolean c(char c10) {
        return " ;,:@()<>\\\"/[]?={}\t".indexOf(c10) >= 0;
    }

    public boolean d(char c10) {
        return "\"\\".indexOf(c10) >= 0;
    }
}
