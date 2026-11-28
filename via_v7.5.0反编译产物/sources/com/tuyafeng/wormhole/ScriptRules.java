package com.tuyafeng.wormhole;

import com.tuyafeng.wormhole.ScriptRules;
import e7.p;
import e7.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.text.Regex;
import kotlin.text.b0;
import kotlin.text.z;
import p7.l;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ScriptRules {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f3785e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f3787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f3788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f3789d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static final boolean h(String it) {
            h.f(it, "it");
            return true;
        }

        public static final boolean i(String it) {
            h.f(it, "it");
            return false;
        }

        public static final boolean j(String str, String it) {
            h.f(it, "it");
            return h.a(it, str);
        }

        public static final boolean k(String str, String it) {
            h.f(it, "it");
            return ScriptRules.f3785e.n(str, it);
        }

        public static final boolean l(String str, String str2, String it) {
            h.f(it, "it");
            Companion companion = ScriptRules.f3785e;
            return companion.n(str, it) || companion.n(str2, it);
        }

        public final l g(String str) {
            final String lowerCase = str.toLowerCase(Locale.ROOT);
            h.e(lowerCase, "toLowerCase(...)");
            if (lowerCase.length() == 0) {
                return new l() { // from class: c6.m1
                    @Override // p7.l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ScriptRules.Companion.h((String) obj));
                    }
                };
            }
            if (lowerCase.length() >= 2 && b0.y0(lowerCase) == '/' && b0.A0(lowerCase) == '/') {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(lowerCase.charAt(1) != '^' ? ".*" : "");
                String strSubstring = lowerCase.substring(1, lowerCase.length() - 1);
                h.e(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                sb2.append(lowerCase.charAt(lowerCase.length() - 2) != '$' ? ".*" : "");
                try {
                    return new ScriptRules$Companion$compile$2(new Regex(sb2.toString()));
                } catch (IllegalArgumentException unused) {
                    return new l() { // from class: c6.n1
                        @Override // p7.l
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(ScriptRules.Companion.i((String) obj));
                        }
                    };
                }
            }
            if (!z.H(lowerCase, '*', false, 2, null)) {
                return new l() { // from class: c6.o1
                    @Override // p7.l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ScriptRules.Companion.j(lowerCase, (String) obj));
                    }
                };
            }
            int iT = z.T(lowerCase, "://*.", 0, false, 6, null);
            if (1 > iT || iT >= 10) {
                return new l() { // from class: c6.p1
                    @Override // p7.l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ScriptRules.Companion.k(lowerCase, (String) obj));
                    }
                };
            }
            final String string = z.j0(lowerCase, iT + 3, iT + 5).toString();
            return new l() { // from class: c6.q1
                @Override // p7.l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ScriptRules.Companion.l(lowerCase, string, (String) obj));
                }
            };
        }

        public final ScriptRules m(List includes, List excludes, List userIncludes, List userExcludes) {
            h.f(includes, "includes");
            h.f(excludes, "excludes");
            h.f(userIncludes, "userIncludes");
            h.f(userExcludes, "userExcludes");
            ArrayList arrayList = new ArrayList();
            for (Object obj : excludes) {
                if (!userIncludes.contains((String) obj)) {
                    arrayList.add(obj);
                }
            }
            List listH = w.H(userExcludes, arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : includes) {
                if (!listH.contains((String) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            return new ScriptRules(w.H(userIncludes, arrayList2), listH);
        }

        public final boolean n(String str, String value) {
            h.f(value, "value");
            if (str == null) {
                return false;
            }
            int i10 = 0;
            int i11 = 0;
            int i12 = -1;
            int i13 = -1;
            while (i10 < value.length()) {
                if (i11 < str.length() && str.charAt(i11) == value.charAt(i10)) {
                    i10++;
                    i11++;
                } else if (i11 < str.length() && str.charAt(i11) == '*') {
                    i12 = i11;
                    i11++;
                    i13 = i10;
                } else {
                    if (i12 == -1) {
                        return false;
                    }
                    i11 = i12 + 1;
                    i13++;
                    i10 = i13;
                }
            }
            while (i11 < str.length() && str.charAt(i11) == '*') {
                i11++;
            }
            return i11 == str.length();
        }

        public Companion() {
        }
    }

    public ScriptRules(List includes, List excludes) {
        h.f(includes, "includes");
        h.f(excludes, "excludes");
        List listM = w.M(includes);
        this.f3786a = listM;
        this.f3787b = w.M(excludes);
        Companion companion = f3785e;
        ArrayList arrayList = new ArrayList(p.o(listM, 10));
        Iterator it = listM.iterator();
        while (it.hasNext()) {
            arrayList.add(companion.g((String) it.next()));
        }
        this.f3788c = arrayList;
        List list = this.f3787b;
        Companion companion2 = f3785e;
        ArrayList arrayList2 = new ArrayList(p.o(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(companion2.g((String) it2.next()));
        }
        this.f3789d = arrayList2;
    }

    public final List a() {
        return this.f3787b;
    }

    public final List b() {
        return this.f3786a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:? A[LOOP:0: B:27:0x005e->B:36:?, LOOP_END, SYNTHETIC] */
    public final boolean c(String str) {
        List list;
        Iterator it;
        if (str != null && str.length() != 0 && !this.f3788c.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            h.e(lowerCase, "toLowerCase(...)");
            List list2 = this.f3789d;
            if (androidx.activity.p.a(list2) && list2.isEmpty()) {
                list = this.f3788c;
                if (androidx.activity.p.a(list)) {
                    it = list.iterator();
                    while (it.hasNext()) {
                        if (((Boolean) ((l) it.next()).invoke(lowerCase)).booleanValue()) {
                            return true;
                        }
                    }
                } else {
                    it = list.iterator();
                    while (it.hasNext()) {
                        if (((Boolean) ((l) it.next()).invoke(lowerCase)).booleanValue()) {
                            return true;
                        }
                    }
                }
            } else {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (((Boolean) ((l) it2.next()).invoke(lowerCase)).booleanValue()) {
                    }
                }
                list = this.f3788c;
                if (androidx.activity.p.a(list) || !list.isEmpty()) {
                    it = list.iterator();
                    while (it.hasNext()) {
                        if (((Boolean) ((l) it.next()).invoke(lowerCase)).booleanValue()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
