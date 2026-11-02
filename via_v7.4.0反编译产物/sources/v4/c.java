package v4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Map f13028a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f13029b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map f13030c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map f13031d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final Set f13032e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public Set f13033f = null;

    @Override // v4.d
    public void a() {
        if (this.f13033f != null) {
            return;
        }
        this.f13033f = new LinkedHashSet();
        if (!this.f13029b.isEmpty()) {
            this.f13033f.addAll(this.f13029b.values());
            this.f13029b.clear();
        }
        if (!this.f13028a.isEmpty()) {
            this.f13033f.addAll(this.f13028a.values());
            this.f13028a.clear();
        }
        if (!this.f13031d.isEmpty()) {
            this.f13033f.addAll(this.f13031d.values());
            this.f13031d.clear();
        }
        if (this.f13030c.isEmpty()) {
            return;
        }
        this.f13033f.addAll(this.f13030c.values());
        this.f13030c.clear();
    }

    @Override // v4.d
    public void b() {
        Set set = this.f13033f;
        if (set == null || set.isEmpty()) {
            this.f13033f = null;
            return;
        }
        for (w4.d dVar : this.f13033f) {
            if (dVar.g()) {
                String strG = b5.c.g(dVar.b(), this.f13029b.keySet());
                if (strG != null) {
                    this.f13029b.put(strG, dVar);
                } else {
                    f(dVar);
                }
            } else {
                String strG2 = b5.c.g(dVar.b(), this.f13028a.keySet());
                if (strG2 != null) {
                    this.f13028a.put(strG2, dVar);
                } else {
                    f(dVar);
                }
            }
        }
        this.f13033f.clear();
        this.f13033f = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c3, code lost:
    
        if (r15 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cb, code lost:
    
        if (r12.f13031d.isEmpty() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d3, code lost:
    
        if (r12.f13030c.isEmpty() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d6, code lost:
    
        r2 = r15.length() - 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00dc, code lost:
    
        r5 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00de, code lost:
    
        if (r5 > r2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e0, code lost:
    
        if (r6 >= 32) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e2, code lost:
    
        r3 = r15.substring(r5, r3 + 6);
        r7 = (w4.d) r12.f13031d.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        if (r7 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f6, code lost:
    
        if (r7.h(r13, r15, r14, r0) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f8, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f9, code lost:
    
        if (r1 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fb, code lost:
    
        r1 = (w4.d) r12.f13030c.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0103, code lost:
    
        if (r1 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0105, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010b, code lost:
    
        if (r1.h(r13, r15, r14, r0) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010d, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x010e, code lost:
    
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0116, code lost:
    
        if (r12.f13031d.isEmpty() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0118, code lost:
    
        return r1;
     */
    @Override // v4.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w4.d c(String str, int i10, String str2) {
        w4.d dVar;
        String strM = b5.c.m(str);
        if (this.f13032e.contains(strM)) {
            dVar = new w4.d('|' + strM + '^');
        } else {
            dVar = null;
        }
        if (dVar == null && strM != null) {
            String strP = b5.c.p(strM);
            if (!strP.equals(strM) && this.f13032e.contains(strP)) {
                dVar = new w4.d('|' + strP + '^');
            }
        }
        if (this.f13029b.isEmpty() && this.f13031d.isEmpty()) {
            return dVar;
        }
        String strM2 = b5.c.m(str2);
        boolean zS = b5.c.s(strM, strM2);
        int iIndexOf = str.indexOf("://");
        int i11 = -1;
        int i12 = iIndexOf < 0 ? -1 : iIndexOf + 2;
        int length = str.length() - 5;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i12 + 1;
            if (i15 > length || i14 >= 32) {
                break;
            }
            String strSubstring = str.substring(i15, i12 + 6);
            w4.d dVar2 = (w4.d) this.f13029b.get(strSubstring);
            if (dVar2 != null && dVar2.h(str, strM2, i10, zS)) {
                return dVar2;
            }
            if (dVar == null && (dVar = (w4.d) this.f13028a.get(strSubstring)) != null) {
                i14++;
                if (!dVar.h(str, strM2, i10, zS)) {
                    dVar = null;
                } else if (this.f13029b.isEmpty()) {
                    break;
                }
            }
            i12 = i15;
        }
    }

    @Override // v4.d
    public void clear() {
        this.f13029b.clear();
        this.f13028a.clear();
        this.f13031d.clear();
        this.f13030c.clear();
        this.f13032e.clear();
    }

    @Override // v4.d
    public void d(w4.d dVar) {
        String strG = g(dVar);
        if (strG != null) {
            this.f13032e.add(strG);
            return;
        }
        Set set = this.f13033f;
        if (set != null) {
            set.add(dVar);
            return;
        }
        String[] strArrH = b5.c.h(dVar.b());
        if (strArrH == null || strArrH.length == 0) {
            f(dVar);
            return;
        }
        for (String str : strArrH) {
            w4.d dVar2 = (w4.d) (dVar.g() ? this.f13029b : this.f13028a).get(str);
            if (dVar2 != null && dVar2.equals(dVar)) {
                return;
            }
        }
        for (String str2 : strArrH) {
            if (dVar.g()) {
                if (((w4.d) this.f13029b.get(str2)) == null) {
                    this.f13029b.put(str2, dVar);
                    return;
                }
            } else if (((w4.d) this.f13028a.get(str2)) == null) {
                this.f13028a.put(str2, dVar);
                return;
            }
        }
    }

    @Override // v4.d
    public void e(w4.d dVar) {
        String strG = g(dVar);
        if (strG != null) {
            this.f13032e.remove(strG);
            return;
        }
        Set set = this.f13033f;
        if (set != null) {
            set.remove(dVar);
            return;
        }
        String[] strArrH = b5.c.h(dVar.b());
        if (strArrH == null || strArrH.length == 0) {
            h(dVar);
            return;
        }
        for (String str : strArrH) {
            w4.d dVar2 = (w4.d) (dVar.g() ? this.f13029b : this.f13028a).get(str);
            if (dVar2 != null && dVar2.equals(dVar)) {
                if (dVar.g()) {
                    this.f13029b.remove(str);
                    return;
                } else {
                    this.f13028a.remove(str);
                    return;
                }
            }
        }
    }

    public final void f(w4.d dVar) {
        if (dVar.c() == null || dVar.c().length == 0 || b5.c.a(dVar.b())) {
            return;
        }
        int i10 = 0;
        if (dVar.c().length != 1) {
            String[] strArrC = dVar.c();
            int length = strArrC.length;
            while (i10 < length) {
                f(new w4.d(dVar.b(), new String[]{strArrC[i10]}, dVar.d()));
                i10++;
            }
            return;
        }
        String[] strArrH = b5.c.h(dVar.c()[0]);
        if (strArrH == null || strArrH.length == 0) {
            return;
        }
        for (String str : strArrH) {
            w4.d dVar2 = (w4.d) (dVar.g() ? this.f13031d : this.f13030c).get(str);
            if (dVar2 != null && dVar2.equals(dVar)) {
                return;
            }
        }
        int length2 = strArrH.length;
        while (i10 < length2) {
            String str2 = strArrH[i10];
            if (dVar.g()) {
                if (((w4.d) this.f13031d.get(str2)) == null) {
                    this.f13031d.put(str2, dVar);
                    return;
                }
            } else if (((w4.d) this.f13030c.get(str2)) == null) {
                this.f13030c.put(str2, dVar);
                return;
            }
            i10++;
        }
    }

    public final String g(w4.d dVar) {
        if (dVar.d() == 0 && dVar.c() == null && dVar.b() != null && dVar.b().length() >= 3) {
            String strB = dVar.b();
            int length = strB.length();
            if (strB.charAt(0) == '|') {
                int i10 = length - 1;
                if (strB.charAt(i10) == '^' && strB.charAt(1) != '.' && strB.charAt(length - 2) != '.') {
                    int i11 = -1;
                    for (int i12 = 1; i12 < i10; i12++) {
                        char cCharAt = strB.charAt(i12);
                        if (cCharAt == '.') {
                            if (i11 == i12 - 1) {
                                return null;
                            }
                            i11 = i12;
                        } else if ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < '0' || cCharAt > '9') && cCharAt != '-'))) {
                            return null;
                        }
                    }
                    if (i11 < 0) {
                        return null;
                    }
                    return strB.substring(1, i10);
                }
            }
        }
        return null;
    }

    public final void h(w4.d dVar) {
        if (dVar.c() == null || dVar.c().length == 0 || b5.c.a(dVar.b())) {
            return;
        }
        int i10 = 0;
        if (dVar.c().length != 1) {
            String[] strArrC = dVar.c();
            int length = strArrC.length;
            while (i10 < length) {
                h(new w4.d(dVar.b(), new String[]{strArrC[i10]}, dVar.d()));
                i10++;
            }
            return;
        }
        String[] strArrH = b5.c.h(dVar.c()[0]);
        if (strArrH == null || strArrH.length == 0) {
            return;
        }
        int length2 = strArrH.length;
        while (i10 < length2) {
            String str = strArrH[i10];
            w4.d dVar2 = (w4.d) (dVar.g() ? this.f13031d : this.f13030c).get(str);
            if (dVar2 != null && dVar2.equals(dVar)) {
                if (dVar.g()) {
                    this.f13031d.remove(str);
                    return;
                } else {
                    this.f13030c.remove(str);
                    return;
                }
            }
            i10++;
        }
    }
}
