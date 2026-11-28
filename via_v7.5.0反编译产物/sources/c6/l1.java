package c6;

import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2068b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2067a = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2069c = 4194304;

    public final void a() {
        this.f2067a.clear();
        this.f2068b = 0;
    }

    public final String b(String key) {
        kotlin.jvm.internal.h.f(key, "key");
        String str = (String) this.f2067a.remove(key);
        if (str == null) {
            return null;
        }
        this.f2067a.put(key, str);
        return str;
    }

    public final void c(String key, String program) {
        kotlin.jvm.internal.h.f(key, "key");
        kotlin.jvm.internal.h.f(program, "program");
        d(key);
        if (program.length() != 0 && program.length() <= this.f2069c) {
            while (this.f2068b + program.length() > this.f2069c) {
                Set setKeySet = this.f2067a.keySet();
                kotlin.jvm.internal.h.e(setKeySet, "<get-keys>(...)");
                Object objW = e7.w.w(setKeySet);
                kotlin.jvm.internal.h.e(objW, "first(...)");
                d((String) objW);
            }
            this.f2067a.put(key, program);
            this.f2068b += program.length();
        }
    }

    public final void d(String key) {
        kotlin.jvm.internal.h.f(key, "key");
        int i10 = this.f2068b;
        String str = (String) this.f2067a.remove(key);
        this.f2068b = i10 - (str != null ? str.length() : 0);
    }
}
