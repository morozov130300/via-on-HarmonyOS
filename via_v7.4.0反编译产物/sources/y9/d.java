package y9;

import java.util.HashMap;
import pa.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements e {

    /* renamed from: c, reason: collision with root package name */
    public static d f14516c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f14517a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ja.d f14518b = r.f().z();

    public static e c() {
        if (f14516c == null) {
            synchronized (d.class) {
                try {
                    if (f14516c == null) {
                        f14516c = new d();
                    }
                } finally {
                }
            }
        }
        return f14516c;
    }

    @Override // y9.e
    public boolean a(int i10) {
        this.f14517a.remove(Integer.valueOf(i10));
        return true;
    }

    @Override // y9.e
    public String b(int i10) {
        String strA = (String) this.f14517a.get(Integer.valueOf(i10));
        if (strA == null) {
            ja.c cVarD = this.f14518b.d(i10);
            if (cVarD == null || cVarD.h() != 1) {
                this.f14517a.put(Integer.valueOf(i10), "");
            } else {
                strA = cVarD.a();
                this.f14517a.put(Integer.valueOf(i10), strA);
            }
        }
        if (strA == null || strA.isEmpty()) {
            return null;
        }
        return strA;
    }
}
