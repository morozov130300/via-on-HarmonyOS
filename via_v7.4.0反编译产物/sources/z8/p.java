package z8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class p {
    public static /* synthetic */ int c(o9.b bVar, o9.b bVar2) {
        int iCompareToIgnoreCase = bVar.b().compareToIgnoreCase(bVar2.b());
        return iCompareToIgnoreCase == 0 ? Integer.compare(bVar.d(), bVar2.d()) : iCompareToIgnoreCase;
    }

    public static List d(w.d dVar) {
        if (dVar == null || (((List) dVar.f13207a).isEmpty() && ((List) dVar.f13208b).isEmpty())) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList((Collection) dVar.f13207a);
        ArrayList<o9.b> arrayList3 = new ArrayList((Collection) dVar.f13208b);
        Collections.sort(arrayList3, new Comparator() { // from class: z8.o
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return p.c((o9.b) obj, (o9.b) obj2);
            }
        });
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(o9.a.r());
        int i10 = 0;
        for (int size = arrayList4.size(); i10 < size; size = arrayList4.size()) {
            o9.a aVar = (o9.a) arrayList4.get(i10);
            String str = (String) map.get(aVar.b());
            String str2 = str == null ? "" : str + "/";
            i10++;
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                o9.a aVar2 = (o9.a) arrayList2.get(size2);
                if (aVar.b().equals(aVar2.d())) {
                    arrayList4.add(i10, aVar2);
                    map.put(aVar2.b(), str2 + aVar2.e().replace("/", "\\/"));
                    arrayList2.remove(size2);
                }
            }
        }
        for (o9.b bVar : arrayList3) {
            n9.b bVar2 = new n9.b();
            bVar2.o(bVar.e());
            bVar2.q(bVar.g());
            bVar2.n(bVar.d());
            bVar2.l((String) map.get(bVar.b()));
            bVar2.k(bVar.a());
            bVar2.p(bVar.f());
            arrayList.add(bVar2);
        }
        return arrayList;
    }

    public static w.d e(List list) {
        long j10;
        long jA;
        if (list == null || list.isEmpty()) {
            List list2 = Collections.EMPTY_LIST;
            return w.d.a(list2, list2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        map.put("", "");
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - list.size();
        Iterator it = list.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            n9.b bVar = (n9.b) it.next();
            if (!o(bVar.g())) {
                o9.b bVar2 = new o9.b();
                bVar2.j(UUID.randomUUID().toString());
                bVar2.l(bVar.e());
                bVar2.n(bVar.g());
                bVar2.k(bVar.d());
                if (bVar.a() == 0) {
                    jA = jCurrentTimeMillis + 1;
                    j10 = jA;
                } else {
                    j10 = jCurrentTimeMillis;
                    jA = bVar.a();
                }
                bVar2.h(jA);
                bVar2.m(bVar.f() == 0 ? bVar2.a() : bVar.f());
                String str = (String) map.get(bVar.b() == null ? "" : bVar.b());
                if (str == null) {
                    String strB = bVar.b();
                    int i12 = 0;
                    while (i12 < strB.length()) {
                        int iIndexOf = strB.indexOf(47, i12);
                        while (iIndexOf > 0 && strB.charAt(iIndexOf - 1) == '\\') {
                            iIndexOf = strB.indexOf(47, iIndexOf + 1);
                        }
                        if (iIndexOf == -1) {
                            iIndexOf = strB.length();
                        }
                        String strSubstring = strB.substring(i10, iIndexOf);
                        if (map.containsKey(strSubstring)) {
                            i12 = iIndexOf + 1;
                        } else {
                            String strSubstring2 = strB.substring(i10, Math.max(i10, i12 - 1));
                            String strReplace = strB.substring(i12, iIndexOf).replace("\\/", "/");
                            String strB2 = (String) map.get(strSubstring2);
                            if (strB2 == null) {
                                strB2 = o9.a.r().b();
                            }
                            o9.a aVarJ = o9.a.j(UUID.randomUUID().toString(), strReplace, strB2);
                            i11++;
                            aVarJ.n(i11);
                            map.put(strSubstring, aVarJ.b());
                            arrayList.add(aVarJ);
                            i12 = iIndexOf + 1;
                            i10 = 0;
                        }
                    }
                    str = (String) map.get(strB);
                }
                if (str == null) {
                    str = "";
                }
                bVar2.i(str);
                arrayList2.add(bVar2);
                jCurrentTimeMillis = j10;
                i10 = 0;
            }
        }
        return w.d.a(arrayList, arrayList2);
    }

    public static String f(String str) {
        if (str == null || str.isEmpty() || !str.contains("&#")) {
            return str;
        }
        Matcher matcher = Pattern.compile("&#(\\d+);").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, Character.toString((char) Integer.parseInt(matcher.group(1))));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String g(String str) {
        return (str == null || str.length() < 4 || str.indexOf(38) < 0) ? str : str.replace("&apos;", "'").replace("&quot;", "\"").replace("&gt;", ">").replace("&lt;", "<").replace("&amp;", "&");
    }

    public static String h(String str) {
        return (str == null || str.length() < 4 || str.indexOf(38) < 0) ? str : str.replace("&quot;", "\"");
    }

    public static String i(String str) {
        return (str == null || str.length() < 2) ? str : str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&apos;");
    }

    public static String j(String str) {
        return (str == null || str.length() < 2) ? str : str.replace("\"", "&quot;");
    }

    public static void k(BufferedWriter bufferedWriter, List list, List list2, o9.a aVar, int i10) throws IOException {
        String strL = l(i10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o9.a aVar2 = (o9.a) it.next();
            if (aVar.b().equals(aVar2.d())) {
                bufferedWriter.write(strL);
                bufferedWriter.write(m(aVar2));
                bufferedWriter.newLine();
                bufferedWriter.write(strL);
                bufferedWriter.write("<DL><p>");
                bufferedWriter.newLine();
                k(bufferedWriter, list, list2, aVar2, i10 + 1);
                bufferedWriter.write(strL);
                bufferedWriter.write("</DL><p>");
                bufferedWriter.newLine();
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            o9.b bVar = (o9.b) it2.next();
            if (aVar.b().equals(bVar.b())) {
                bufferedWriter.write(strL);
                bufferedWriter.write(n(bVar));
                bufferedWriter.newLine();
            }
        }
    }

    public static String l(int i10) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("  ");
        }
        return sb2.toString();
    }

    public static String m(o9.a aVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<DT><H3 ADD_DATE=\"");
        sb2.append(aVar.a());
        sb2.append("\"");
        if (aVar.f() != aVar.a()) {
            sb2.append(" LAST_MODIFIED=\"");
            sb2.append(aVar.f());
            sb2.append("\"");
        }
        sb2.append(">");
        sb2.append(i(aVar.e()));
        sb2.append("</H3>");
        return sb2.toString();
    }

    public static String n(o9.b bVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<DT><A HREF=\"");
        sb2.append(j(bVar.g()));
        sb2.append("\" ADD_DATE=\"");
        sb2.append(bVar.a());
        sb2.append("\"");
        if (bVar.f() != bVar.a()) {
            sb2.append(" LAST_MODIFIED=\"");
            sb2.append(bVar.f());
            sb2.append("\"");
        }
        sb2.append(">");
        sb2.append(i(bVar.e()));
        sb2.append("</A>");
        return sb2.toString();
    }

    public static boolean o(String str) {
        return str == null || str.isEmpty() || str.length() > 1048576;
    }

    public static void p(w.d dVar, List list, o9.a aVar) {
        String str;
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o9.a aVar2 = (o9.a) it.next();
            if (aVar.b().equals(aVar2.d()) && aVar2.e() != null) {
                map.put(aVar2.e(), aVar2.b());
            }
        }
        if (map.isEmpty()) {
            return;
        }
        HashMap map2 = new HashMap();
        for (o9.a aVar3 : (List) dVar.f13207a) {
            if (aVar.b().equals(aVar3.d()) && aVar3.e() != null && (str = (String) map.get(aVar3.e())) != null) {
                map2.put(aVar3.b(), str);
            }
        }
        if (map2.isEmpty()) {
            return;
        }
        for (o9.b bVar : (List) dVar.f13208b) {
            String str2 = (String) map2.get(bVar.b());
            if (str2 != null) {
                bVar.i(str2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (o9.a aVar4 : (List) dVar.f13207a) {
            String str3 = (String) map2.get(aVar4.b());
            String str4 = (String) map2.get(aVar4.d());
            if (str3 != null || str4 != null) {
                if (str3 != null) {
                    aVar4.m(str3);
                }
                if (str4 != null) {
                    aVar4.o(str4);
                }
                arrayList.add(aVar4);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            p(dVar, list, (o9.a) it2.next());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r3.size() <= 0) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r3.remove(r3.size() - 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static w.d q(InputStream inputStream) {
        o9.b bVar;
        if (inputStream == null) {
            List list = Collections.EMPTY_LIST;
            return w.d.a(list, list);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        e1 e1Var = new e1();
        e1Var.f(inputStream);
        o9.b bVar2 = null;
        String strG = null;
        int i10 = 0;
        loop0: while (true) {
            int i11 = 0;
            while (true) {
                try {
                    int iD = e1Var.d();
                    if (iD == 1) {
                        break loop0;
                    }
                    if (iD != 2) {
                        if (iD != 3) {
                            if (iD == 4 && (bVar2 != null || arrayList3.size() > 0)) {
                                strG = g(e1Var.a());
                            }
                        } else {
                            if ("</DL>".equalsIgnoreCase(e1Var.a())) {
                                break;
                            }
                            if ("</A>".equalsIgnoreCase(e1Var.a())) {
                                if (bVar2 != null) {
                                    bVar2.l(f(strG));
                                    arrayList2.add(bVar2);
                                    bVar2 = null;
                                }
                            } else if ("</H3>".equalsIgnoreCase(e1Var.a()) && arrayList3.size() > 0) {
                                o9.a aVar = (o9.a) arrayList3.get(arrayList3.size() - 1);
                                aVar.p(f(strG));
                                arrayList.add(aVar);
                            }
                        }
                    } else if (!"<DL>".equalsIgnoreCase(e1Var.a())) {
                        if (e1Var.a().startsWith("<A ") || e1Var.a().startsWith("<a ")) {
                            bVar2 = new o9.b();
                            bVar2.j(UUID.randomUUID().toString());
                            String strH = h(e1Var.b("href"));
                            if (strH != null && !strH.isEmpty()) {
                                strH = strH.trim();
                            }
                            bVar2.n(strH);
                            if (o(bVar2.g())) {
                                bVar2 = null;
                            } else {
                                bVar2.i(arrayList3.isEmpty() ? "" : ((o9.a) arrayList3.get(arrayList3.size() - 1)).b());
                                String strB = e1Var.b("add_date");
                                if (strB != null) {
                                    try {
                                        bVar2.h(Long.parseLong(strB));
                                    } catch (NumberFormatException e10) {
                                        pc.a.i(e10);
                                    }
                                }
                                String strB2 = e1Var.b("last_modified");
                                if (strB2 != null) {
                                    try {
                                        bVar2.m(Long.parseLong(strB2));
                                    } catch (NumberFormatException e11) {
                                        pc.a.i(e11);
                                    }
                                }
                                if (bVar2.a() == 0) {
                                    bVar2.h(System.currentTimeMillis() / 1000);
                                }
                                if (bVar2.f() == 0) {
                                    bVar2.m(bVar2.a());
                                }
                                i11++;
                                bVar2.k(i11);
                            }
                        } else if (e1Var.a().startsWith("<H3") || e1Var.a().startsWith("<h3")) {
                            o9.a aVar2 = new o9.a();
                            aVar2.m(UUID.randomUUID().toString());
                            String strB3 = e1Var.b("add_date");
                            if (strB3 != null) {
                                bVar = bVar2;
                                try {
                                    aVar2.l(Long.parseLong(strB3));
                                } catch (NumberFormatException e12) {
                                    pc.a.i(e12);
                                }
                            } else {
                                bVar = bVar2;
                            }
                            String strB4 = e1Var.b("last_modified");
                            if (strB4 != null) {
                                try {
                                    aVar2.q(Long.parseLong(strB4));
                                } catch (NumberFormatException e13) {
                                    pc.a.i(e13);
                                }
                            }
                            if (aVar2.a() == 0) {
                                aVar2.l(System.currentTimeMillis() / 1000);
                            }
                            if (aVar2.f() == 0) {
                                aVar2.q(aVar2.a());
                            }
                            i10++;
                            aVar2.n(i10);
                            if (arrayList3.size() > 0) {
                                aVar2.o(((o9.a) arrayList3.get(arrayList3.size() - 1)).b());
                            }
                            arrayList3.add(aVar2);
                            bVar2 = bVar;
                        }
                    }
                } catch (IOException e14) {
                    pc.a.d(e14);
                }
            }
        }
        return w.d.a(arrayList, arrayList2);
    }

    public static int r(OutputStream outputStream, w.d dVar) throws IOException {
        if (outputStream == null || dVar == null) {
            return -1;
        }
        int size = 0;
        if (((List) dVar.f13207a).isEmpty() && ((List) dVar.f13208b).isEmpty()) {
            return 0;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, m8.a.f8676a));
            try {
                bufferedWriter.write("<!DOCTYPE NETSCAPE-Bookmark-file-1>\n<!-- This is an automatically generated file.\n     It will be read and overwritten.\n     DO NOT EDIT! -->\n<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">\n<TITLE>Bookmarks</TITLE>\n<H1>Bookmarks</H1>\n<DL><p>\n");
                ArrayList arrayList = new ArrayList((Collection) dVar.f13207a);
                Collections.sort(arrayList, new Comparator() { // from class: z8.m
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Integer.compare(((o9.a) obj).c(), ((o9.a) obj2).c());
                    }
                });
                ArrayList arrayList2 = new ArrayList((Collection) dVar.f13208b);
                Collections.sort(arrayList2, new Comparator() { // from class: z8.n
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Integer.compare(((o9.b) obj).d(), ((o9.b) obj2).d());
                    }
                });
                k(bufferedWriter, arrayList, arrayList2, o9.a.r(), 1);
                bufferedWriter.write("</DL><p>\n");
                size = arrayList2.size();
                bufferedWriter.close();
                return size;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return size;
        }
    }
}
