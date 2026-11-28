package c6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f2105a = new u();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2107b;

        public a(String identifier, int i10) {
            kotlin.jvm.internal.h.f(identifier, "identifier");
            this.f2106a = identifier;
            this.f2107b = i10;
        }

        public final String a() {
            return this.f2106a;
        }

        public final int b() {
            return this.f2107b;
        }

        public final void c(int i10) {
            this.f2107b = i10;
        }

        public /* synthetic */ a(String str, int i10, int i11, kotlin.jvm.internal.f fVar) {
            this(str, (i11 & 2) != 0 ? 0 : i10);
        }
    }

    public static final Comparable h(r it) {
        kotlin.jvm.internal.h.f(it, "it");
        return Integer.valueOf(it.c());
    }

    public static final Comparable i(r it) {
        kotlin.jvm.internal.h.f(it, "it");
        return Boolean.valueOf(it.g() != null);
    }

    public final Map e(CharSequence charSequence, int i10) {
        int i11;
        char cCharValue;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (i10 < charSequence.length()) {
            while (i10 < charSequence.length() && kotlin.text.a.d(charSequence.charAt(i10))) {
                i10++;
            }
            int i12 = i10;
            while (i12 < charSequence.length() && !kotlin.text.a.d(charSequence.charAt(i12)) && charSequence.charAt(i12) != '=') {
                i12++;
            }
            String lowerCase = charSequence.subSequence(i10, i12).toString().toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
            while (i12 < charSequence.length() && kotlin.text.a.d(charSequence.charAt(i12))) {
                i12++;
            }
            if (i12 == charSequence.length() || charSequence.charAt(i12) != '=') {
                i10 = i12;
            } else {
                do {
                    i12++;
                    if (i12 >= charSequence.length()) {
                        break;
                    }
                } while (kotlin.text.a.d(charSequence.charAt(i12)));
                Character chZ0 = kotlin.text.b0.z0(charSequence, i12);
                if (chZ0 == null || ((cCharValue = chZ0.charValue()) != '\"' && cCharValue != '\'')) {
                    chZ0 = null;
                }
                if (chZ0 != null) {
                    i12++;
                }
                int i13 = i12;
                while (i13 < charSequence.length()) {
                    if (chZ0 != null) {
                        if (charSequence.charAt(i13) == chZ0.charValue() && ((i11 = i13 + 1) >= charSequence.length() || kotlin.text.a.d(charSequence.charAt(i11)))) {
                            break;
                        }
                        i13++;
                    } else {
                        if (kotlin.text.a.d(charSequence.charAt(i13))) {
                            break;
                        }
                        i13++;
                    }
                }
                int iHashCode = lowerCase.hashCode();
                if (iHashCode == -1236308852 ? lowerCase.equals("add_date") : iHashCode == -28366254 ? lowerCase.equals("last_modified") : !(iHashCode != 3211051 || !lowerCase.equals("href"))) {
                    linkedHashMap.put(lowerCase, kotlin.text.x.z(charSequence.subSequence(i12, i13).toString(), "\\\"", "\"", false, 4, null));
                }
                i10 = (chZ0 == null || i13 >= charSequence.length()) ? i13 : i13 + 1;
            }
        }
        return linkedHashMap;
    }

    public final String f(String str) {
        String strC = b0.f1960a.c(kotlin.text.z.v0(str).toString());
        StringBuilder sb2 = new StringBuilder();
        int length = strC.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = strC.charAt(i10);
            if (cCharAt != '\r') {
                if (kotlin.text.a.d(cCharAt)) {
                    cCharAt = ' ';
                }
                sb2.append(cCharAt);
            }
        }
        return sb2.toString();
    }

    public final boolean g(String str) {
        return (str == null || str.length() == 0 || str.length() > 1048576) ? false : true;
    }

    public final int j(List entries, p7.l emit) {
        kotlin.jvm.internal.h.f(entries, "entries");
        kotlin.jvm.internal.h.f(emit, "emit");
        int i10 = 0;
        if (entries.isEmpty()) {
            return 0;
        }
        List listI = e7.w.I(entries, g7.b.b(new p7.l() { // from class: c6.s
            @Override // p7.l
            public final Object invoke(Object obj) {
                return u.i((r) obj);
            }
        }, new p7.l() { // from class: c6.t
            @Override // p7.l
            public final Object invoke(Object obj) {
                return u.h((r) obj);
            }
        }));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listI) {
            String strD = ((r) obj).d();
            Object arrayList = linkedHashMap.get(strD);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strD, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        e7.h hVar = new e7.h();
        List listH = (List) linkedHashMap.remove("");
        if (listH == null) {
            listH = e7.o.h();
        }
        hVar.addLast(listH.iterator());
        emit.invoke("<!DOCTYPE NETSCAPE-Bookmark-file-1>\n<!-- This is an automatically generated file.\n     It will be read and overwritten.\n     DO NOT EDIT! -->\n<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">\n<TITLE>Bookmarks</TITLE>\n<H1>Bookmarks</H1>\n<DL><p>\n");
        while (!hVar.isEmpty()) {
            Iterator it = (Iterator) hVar.last();
            if (it.hasNext()) {
                r rVar = (r) it.next();
                String strV = kotlin.text.x.v("  ", hVar.size());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" ADD_DATE=\"");
                sb2.append(rVar.a());
                sb2.append('\"');
                sb2.append(rVar.a() == rVar.f() ? "" : " LAST_MODIFIED=\"" + rVar.f() + '\"');
                String string = sb2.toString();
                String strZ = kotlin.text.x.z(kotlin.text.x.z(kotlin.text.x.z(kotlin.text.x.z(kotlin.text.x.z(rVar.e(), "&", "&amp;", false, 4, null), "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null), "\"", "&quot;", false, 4, null), "'", "&apos;", false, 4, null);
                if (rVar.g() == null) {
                    emit.invoke(strV + "<DT><H3" + string + '>' + strZ + "</H3>\n" + strV + "<DL><p>\n");
                    List listH2 = (List) linkedHashMap.remove(rVar.b());
                    if (listH2 == null) {
                        listH2 = e7.o.h();
                    }
                    hVar.addLast(listH2.iterator());
                } else {
                    emit.invoke(strV + "<DT><A HREF=\"" + kotlin.text.x.z(rVar.g(), "\"", "&quot;", false, 4, null) + '\"' + string + '>' + strZ + "</A>\n");
                }
                i10++;
            } else {
                hVar.removeLast();
                emit.invoke(kotlin.text.x.v("  ", hVar.size()) + "</DL><p>\n");
            }
        }
        return i10;
    }
}
