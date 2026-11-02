package u9;

import android.content.Context;
import android.net.Uri;
import g6.p;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import pa.r;
import w9.l;
import w9.n;
import x7.u;
import z8.c1;
import z8.f;
import z8.v0;
import z8.w2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator f12878a = new Comparator() { // from class: u9.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return c.a((File) obj, (File) obj2);
        }
    };

    public static /* synthetic */ int a(File file, File file2) {
        long jLastModified = file.lastModified() - file2.lastModified();
        if (jLastModified == 0) {
            return 0;
        }
        return jLastModified > 0 ? -1 : 1;
    }

    public static String b(Context context) throws Throwable {
        if (n.e().f() || !c1.M(context, "about.html")) {
            c1.Q(new File(context.getFilesDir(), "about.html"), d.h(context.getString(u.f14109oc)) + d.j(d.g(context, 5)) + "<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">" + d.a(context) + "</div></body></html>");
            n.e().o(false);
        }
        return "file://" + context.getFilesDir().getPath() + "/about.html";
    }

    public static String c(Context context) throws Throwable {
        if (n.e().g() || !c1.M(context, "blank.html")) {
            c1.Q(new File(context.getFilesDir(), "blank.html"), d.h(context.getString(u.f13984g)) + d.j("body{background:transparent;}") + "<body></body></html>");
            n.e().r(false);
        }
        return "file://" + context.getFilesDir().getPath() + "/blank.html";
    }

    public static String d(Context context, String str) throws IOException {
        boolean zF = p.f(str);
        File file = new File(context.getFilesDir(), zF ? "bookmarks.html" : "folder.html");
        if (!zF || n.e().h() || !file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                o9.c cVarD = r.d();
                o9.a aVarF = cVarD.f(str);
                if (aVarF == null) {
                    aVarF = o9.a.r();
                }
                str = aVarF.b();
                ArrayList<cb.a> arrayList = new ArrayList();
                if (!o9.a.g(str)) {
                    o9.a aVarK = o9.a.k(cVarD.f(aVarF.d()));
                    if (aVarK == null) {
                        aVarK = o9.a.i("", null);
                    }
                    aVarK.p("..");
                    cb.a aVar = new cb.a(aVarK);
                    aVar.j(true);
                    arrayList.add(aVar);
                }
                Iterator it = cVarD.s(str).iterator();
                while (it.hasNext()) {
                    arrayList.add(new cb.a((o9.a) it.next()));
                }
                Iterator it2 = cVarD.n(str).iterator();
                while (it2.hasNext()) {
                    arrayList.add(new cb.a((o9.b) it2.next()));
                }
                Collections.sort(arrayList, cb.b.c(r.j().V0()));
                bufferedWriter.write(d.h((zF || p.f(aVarF.e())) ? context.getString(u.f14026j) : aVarF.e()));
                bufferedWriter.write(d.j(d.g(context, 1)));
                bufferedWriter.write("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
                boolean z10 = false;
                boolean z11 = false;
                for (cb.a aVar2 : arrayList) {
                    if (!aVar2.g()) {
                        if (z11 && !z10) {
                            bufferedWriter.write("</div>");
                            bufferedWriter.write("<div id=\"bookmark_tags\">");
                        } else if (!z10) {
                            bufferedWriter.write("<div id=\"bookmark_tags\">");
                        }
                        z10 = true;
                    } else if (!z11) {
                        bufferedWriter.write("<div id=\"bookmark_folders\">");
                        z11 = true;
                    }
                    bufferedWriter.write(d.b(aVar2.b() != null ? w2.g(aVar2.b().g()) : w2.d(aVar2.a().b()), aVar2.f(), aVar2.g() ? "tag" : "bookmark"));
                }
                if (z10) {
                    bufferedWriter.write("</div>");
                }
                if (arrayList.size() == 0 && zF) {
                    bufferedWriter.write(d.e(context.getString(u.f14115p4)));
                }
                bufferedWriter.write("</div></body></html>");
                bufferedWriter.close();
                fileWriter.close();
                if (zF) {
                    n.e().s(false);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("file://");
        sb2.append(context.getFilesDir().getPath());
        sb2.append("/");
        sb2.append(p.f(str) ? "bookmarks.html" : "folder.html?folder=" + str);
        return sb2.toString();
    }

    public static List e(Context context) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {context.getString(u.f14026j), context.getString(u.H), context.getString(u.E8), context.getString(u.f13929c0), context.getString(u.f14144r6), context.getString(u.f14109oc)};
        String[] strArr2 = {"v://bookmarks", "v://history", "v://log", "v://offline", "v://home", "v://about"};
        for (int i10 = 0; i10 < 6; i10++) {
            n9.b bVar = new n9.b();
            bVar.m(i10);
            bVar.q(strArr2[i10]);
            bVar.o(strArr[i10]);
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static String f(Context context) throws Throwable {
        if (n.e().i() || !c1.M(context, "catalog.html")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d.h(context.getString(u.f13958e1)));
            sb2.append(d.j(d.g(context, 1)));
            sb2.append("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
            List<n9.b> listE = e(context);
            for (n9.b bVar : listE) {
                sb2.append(d.b(bVar.g(), bVar.e(), "tag"));
            }
            if (listE.size() == 0) {
                sb2.append(d.e(context.getString(u.f14115p4)));
            }
            sb2.append("</div></body></html>");
            c1.Q(new File(context.getFilesDir(), "catalog.html"), sb2.toString());
            n.e().t(false);
        }
        return "file://" + context.getFilesDir().getPath() + "/catalog.html";
    }

    public static String g(Context context) throws IOException {
        l lVarJ = r.j();
        File file = new File(context.getFilesDir(), "history.html");
        if (n.e().j() || !file.exists()) {
            System.currentTimeMillis();
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(d.h(context.getString(u.H)));
                bufferedWriter.write(d.j(d.g(context, 1)));
                bufferedWriter.write("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
                List<n9.b> listL = l(context);
                if (listL.size() == 0) {
                    bufferedWriter.write(d.e(context.getString(u.f14115p4)));
                } else if (lVarJ.m2().s()) {
                    bufferedWriter.write(d.e(context.getString(u.f14103o6)));
                }
                for (n9.b bVar : listL) {
                    bufferedWriter.write(d.b(bVar.g(), bVar.e(), "clock"));
                }
                bufferedWriter.write("</div></body></html>");
                n.e().u(false);
                bufferedWriter.close();
                fileWriter.close();
            } catch (Exception unused) {
            }
        }
        return "file://" + file.getPath();
    }

    public static String h(Context context, List list, boolean z10) throws IOException {
        int i10;
        String string;
        System.currentTimeMillis();
        File file = new File(context.getFilesDir(), z10 ? "res.html" : "log.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(d.h(context.getString(z10 ? u.f14038jb : u.E8)));
            bufferedWriter.write(d.j(d.g(context, 6)));
            bufferedWriter.write("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
            StringBuilder sb2 = new StringBuilder();
            if (list == null || list.size() <= 0) {
                i10 = 0;
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                int iMax = Math.max(0, list.size() - 64);
                i10 = 0;
                for (int size = list.size() - 1; size >= iMax; size--) {
                    n9.c cVar = (n9.c) list.get(size);
                    if (cVar != null && (!z10 || cVar.e())) {
                        i10++;
                        sb2.append(d.c(cVar.c(), cVar.b(), cVar.d(), simpleDateFormat.format(Long.valueOf(cVar.a()))));
                    }
                }
            }
            if (i10 > 0) {
                string = z10 ? context.getString(u.f13968eb) : context.getString(u.M7, c1.o(context));
            } else if (z10) {
                string = context.getString(u.T8) + context.getString(u.f14052kb).replace("\n", "<br>");
            } else {
                string = context.getString(u.f14115p4);
            }
            bufferedWriter.write(d.e(string));
            if (!z10 && i10 > 0) {
                bufferedWriter.write("<div id=\"filter-box\"><select id=\"filter\" onchange=\"filterChange()\"><option value=\"\">All</option><option value=\"js\">JS</option><option value=\"css\">CSS</option><option value=\"ico|png|jpg|gif|jpeg|webp|svg|avif\">Image</option><option value=\"block\">Blocked</option><option value=\"~js|css|ico|png|jpg|gif|jpeg|webp|svg|avif|block\">Other</option></select></div>");
            }
            bufferedWriter.write(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("function getDomain(a){var b=a.split(\"/\"),c=\"\";return a.indexOf(\"://\")>-0&&b.length>2&&\"\"!=b[2]&&(c=b[2]),c}function boldDomain(){var b,c,d,a=document.getElementsByClassName(\"url\");for(d=a.length-1;d>=0;d--)b=a[d].innerHTML,c=getDomain(b),\"\"!=c&&(a[d].innerHTML=b.replace(c,\"<b>\"+c+\"</b>\"))}boldDomain();");
            sb3.append(z10 ? "" : "function filterChange(){var filter=document.getElementById(\"filter\");var filterValue=filter.options[filter.selectedIndex].value;var inverted=filterValue.length>0&&filterValue.charAt(0)==\"~\";if(inverted){filterValue=filterValue.substring(1)}var rules=filterValue.split(\"|\");var es=document.getElementsByClassName(\"box\");var temp;var show;for(var i=0,size=es.length;i<size;i++){temp=es[i].getElementsByClassName(\"title\")[0].innerHTML;show=rules.length<1;for(var j=0,jsize=rules.length;j<jsize;j++){if(temp.indexOf(rules[j])>=0){show=true;break}}es[i].style.display=inverted!=show?\"block\":\"none\"}filter.blur()}");
            bufferedWriter.write(d.f(sb3.toString()));
            bufferedWriter.write("</div></body></html>");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception unused) {
        }
        return "file://" + file.getPath();
    }

    public static String i(Context context) throws IOException {
        File file = new File(context.getFilesDir(), "save.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(d.h(context.getString(u.f13929c0)));
            bufferedWriter.write(d.j(d.g(context, 1)));
            bufferedWriter.write("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
            List<n9.b> listJ = j(context);
            if (listJ.size() == 0) {
                bufferedWriter.write(d.e(context.getString(u.f14115p4)));
            } else {
                bufferedWriter.write(d.e(context.getString(u.f13924b9)));
            }
            for (n9.b bVar : listJ) {
                bufferedWriter.write(d.b(bVar.g(), bVar.e(), "clock"));
            }
            bufferedWriter.write("</div></body></html>");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception unused) {
        }
        return "file://" + file.getPath();
    }

    public static List j(Context context) {
        File[] fileArrListFiles;
        String[] strArr = {c1.D(context), f.b(context)};
        ArrayList arrayList = new ArrayList();
        File[] fileArr = new File[0];
        for (int i10 = 0; i10 < 2; i10++) {
            String str = strArr[i10];
            if (str != null && !str.isEmpty() && (fileArrListFiles = new File(str).listFiles()) != null && fileArrListFiles.length > 0) {
                fileArr = (File[]) g6.a.a(fileArr, fileArrListFiles);
            }
        }
        Arrays.sort(fileArr, f12878a);
        for (File file : fileArr) {
            String name = file.getName();
            if (name.endsWith(".mht")) {
                arrayList.add(new n9.b("file://" + file.getParentFile() + "/" + Uri.encode(name), v0.i(name.substring(0, name.length() - 4))));
            }
        }
        return arrayList;
    }

    public static String k(Context context, String str, List list) throws IOException {
        String str2;
        File file = new File(context.getFilesDir(), "images.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("<!DOCTYPE html><html><head>");
            bufferedWriter.write("<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>");
            bufferedWriter.write("<meta name=\"color-scheme\" content=\"light dark\">");
            bufferedWriter.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=1, minimal-ui\">");
            bufferedWriter.write("<title>" + context.getString(u.U) + "</title>");
            bufferedWriter.write("<link href=\"https://fastly.jsdelivr.net/npm/viewerjs@1.11.7/dist/viewer.min.css\" rel=\"stylesheet\"><script src=\"https://fastly.jsdelivr.net/npm/viewerjs@1.11.7/dist/viewer.min.js\"></script><style type=\"text/css\">*{padding:0;margin:0}#images img{display:block;margin:auto;text-align:center;max-width:100%}.viewer-backdrop{background-color:rgba(0,0,0,.9)}.viewer-toolbar>ul>li{width:32px;height:32px;padding:4px;box-sizing:border-box}.viewer-download{content:\"Download\";background-color:transparent;background-image:url('data:image/svg+xml,%3Csvg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"-494 -494 1500 1500\"%3E%3Cpath fill=\"%23fff\" d=\"M288 32c0-17.7-14.3-32-32-32s-32 14.3-32 32l0 242.7-73.4-73.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3l128 128c12.5 12.5 32.8 12.5 45.3 0l128-128c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L288 274.7 288 32zM64 352c-35.3 0-64 28.7-64 64l0 32c0 35.3 28.7 64 64 64l384 0c35.3 0 64-28.7 64-64l0-32c0-35.3-28.7-64-64-64l-101.5 0-45.3 45.3c-25 25-65.5 25-90.5 0L165.5 352 64 352zm368 56a24 24 0 1 1 0 48 24 24 0 1 1 0-48z\"/%3E%3C/svg%3E');background-repeat:no-repeat;background-size:32px;color:transparent;display:block;font-size:0;line-height:0}</style><script></script>");
            bufferedWriter.write("</head>");
            bufferedWriter.write("<body><div><ul id=\"images\">");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                n9.b bVar = (n9.b) it.next();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("<li><img src=\"");
                sb2.append(bVar.g());
                sb2.append("\"");
                if (bVar.e() != null) {
                    str2 = "alt=\"" + bVar.e() + "\"";
                } else {
                    str2 = "";
                }
                sb2.append(str2);
                sb2.append(" /></li>");
                bufferedWriter.write(sb2.toString());
            }
            bufferedWriter.write("</ul></div>");
            bufferedWriter.write("<script>var viewer = new Viewer(document.getElementById(\"images\"), {toolbar: {zoomIn: true, zoomOut: true, oneToOne: true, reset: true, prev: true, next: true, rotateLeft: true, download: function () { try {window.via.postMessage('" + str + "', JSON.stringify({action: 107, url: viewer.image.src, name: viewer.image.alt}))} catch(e) {}},},});</script>");
            bufferedWriter.write("</body></html>");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception unused) {
        }
        return "file://" + file.getPath();
    }

    public static List l(Context context) {
        y9.a aVarF = r.f();
        ArrayList arrayList = new ArrayList();
        try {
            return aVarF.k(256);
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }
}
