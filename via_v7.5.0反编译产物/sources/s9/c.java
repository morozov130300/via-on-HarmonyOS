package s9;

import android.content.Context;
import android.net.Uri;
import c6.o0;
import com.tuyafeng.support.utils.p;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import la.s;
import u9.l;
import u9.n;
import w7.u;
import x8.c1;
import x8.f;
import x8.r2;
import x8.v0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator f12229a = new Comparator() { // from class: s9.b
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

    public static String b(Context context) {
        if (n.e().f() || !c1.M(context, "blank.html")) {
            if (c1.Q(new File(context.getFilesDir(), "blank.html"), o0.f2075a.a(context.getString(u.f14050g), true))) {
                n.e().p(false);
            }
        }
        return "file://" + context.getFilesDir().getPath() + "/blank.html";
    }

    public static String c(Context context, String str) {
        boolean zF = p.f(str);
        File file = new File(context.getFilesDir(), zF ? "bookmarks.html" : "folder.html");
        if (!zF || n.e().g() || !file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                m9.c cVarD = s.d();
                m9.a aVarE = cVarD.e(str);
                if (aVarE == null) {
                    aVarE = m9.a.r();
                }
                str = aVarE.b();
                ArrayList<cb.a> arrayList = new ArrayList();
                if (!m9.a.g(str)) {
                    m9.a aVarK = m9.a.k(cVarD.e(aVarE.d()));
                    if (aVarK == null) {
                        aVarK = m9.a.i("", null);
                    }
                    aVarK.p("..");
                    cb.a aVar = new cb.a(aVarK);
                    aVar.k(true);
                    arrayList.add(aVar);
                }
                Iterator it = cVarD.t(str).iterator();
                while (it.hasNext()) {
                    arrayList.add(new cb.a((m9.a) it.next()));
                }
                Iterator it2 = cVarD.o(str).iterator();
                while (it2.hasNext()) {
                    arrayList.add(new cb.a((m9.b) it2.next()));
                }
                Collections.sort(arrayList, cb.b.c(s.j().X0()));
                bufferedWriter.write(d.g((zF || p.f(aVarE.e())) ? context.getString(u.f14092j) : aVarE.e()));
                bufferedWriter.write(d.i(d.f(context, 1)));
                bufferedWriter.write("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
                boolean z10 = false;
                boolean z11 = false;
                for (cb.a aVar2 : arrayList) {
                    if (!aVar2.h()) {
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
                    bufferedWriter.write(d.a(aVar2.b() != null ? r2.g(aVar2.b().g()) : r2.d(aVar2.a().b()), aVar2.g(), aVar2.h() ? "tag" : "bookmark"));
                }
                if (z10) {
                    bufferedWriter.write("</div>");
                }
                if (arrayList.size() == 0 && zF) {
                    bufferedWriter.write(d.d(context.getString(u.C4)));
                }
                bufferedWriter.write("</div></body></html>");
                bufferedWriter.close();
                fileWriter.close();
                if (zF) {
                    n.e().q(false);
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

    public static List d(Context context) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {context.getString(u.f14092j), context.getString(u.I), context.getString(u.Q8), context.getString(u.f14009d0), context.getString(u.D6)};
        String[] strArr2 = {"v://bookmarks", "v://history", "v://log", "v://offline", "v://home"};
        for (int i10 = 0; i10 < 5; i10++) {
            l9.b bVar = new l9.b();
            bVar.m(i10);
            bVar.q(strArr2[i10]);
            bVar.o(strArr[i10]);
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static String e(Context context) throws Throwable {
        if (n.e().h() || !c1.M(context, "catalog.html")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d.g(context.getString(u.f14066h1)));
            sb2.append(d.i(d.f(context, 1)));
            sb2.append("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
            List<l9.b> listD = d(context);
            for (l9.b bVar : listD) {
                sb2.append(d.a(bVar.g(), bVar.e(), "tag"));
            }
            if (listD.size() == 0) {
                sb2.append(d.d(context.getString(u.C4)));
            }
            sb2.append("</div></body></html>");
            c1.Q(new File(context.getFilesDir(), "catalog.html"), sb2.toString());
            n.e().r(false);
        }
        return "file://" + context.getFilesDir().getPath() + "/catalog.html";
    }

    public static String f(Context context) {
        l lVarJ = s.j();
        File file = new File(context.getFilesDir(), "history.html");
        if (n.e().i() || !file.exists()) {
            System.currentTimeMillis();
            try {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(d.g(context.getString(u.I)));
                bufferedWriter.write(d.i(d.f(context, 1)));
                bufferedWriter.write("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
                List<l9.b> listK = k(context);
                if (listK.size() == 0) {
                    bufferedWriter.write(d.d(context.getString(u.C4)));
                } else if (lVarJ.n2().s()) {
                    bufferedWriter.write(d.d(context.getString(u.A6)));
                }
                for (l9.b bVar : listK) {
                    bufferedWriter.write(d.a(bVar.g(), bVar.e(), "clock"));
                }
                bufferedWriter.write("</div></body></html>");
                n.e().s(false);
                bufferedWriter.close();
                fileWriter.close();
            } catch (Exception unused) {
            }
        }
        return "file://" + file.getPath();
    }

    public static String g(Context context, List list, boolean z10) {
        int i10;
        String string;
        System.currentTimeMillis();
        File file = new File(context.getFilesDir(), z10 ? "res.html" : "log.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(d.g(context.getString(z10 ? u.f14271vb : u.Q8)));
            bufferedWriter.write(d.i(d.f(context, 6)));
            bufferedWriter.write("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
            StringBuilder sb2 = new StringBuilder();
            if (list == null || list.size() <= 0) {
                i10 = 0;
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                int iMax = Math.max(0, list.size() - 64);
                i10 = 0;
                for (int size = list.size() - 1; size >= iMax; size--) {
                    l9.c cVar = (l9.c) list.get(size);
                    if (cVar != null && (!z10 || cVar.e())) {
                        i10++;
                        sb2.append(d.b(cVar.c(), cVar.b(), cVar.d(), simpleDateFormat.format(Long.valueOf(cVar.a()))));
                    }
                }
            }
            if (i10 > 0) {
                string = z10 ? context.getString(u.f14202qb) : context.getString(u.Y7, c1.p(context));
            } else if (z10) {
                string = context.getString(u.f14046f9) + context.getString(u.f14284wb).replace("\n", "<br>");
            } else {
                string = context.getString(u.C4);
            }
            bufferedWriter.write(d.d(string));
            if (!z10 && i10 > 0) {
                bufferedWriter.write("<div id=\"filter-box\"><select id=\"filter\" onchange=\"filterChange()\"><option value=\"\">All</option><option value=\"js\">JS</option><option value=\"css\">CSS</option><option value=\"ico|png|jpg|gif|jpeg|webp|svg|avif\">Image</option><option value=\"block\">Blocked</option><option value=\"~js|css|ico|png|jpg|gif|jpeg|webp|svg|avif|block\">Other</option></select></div>");
            }
            bufferedWriter.write(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("function getDomain(n){var e=n.split(\"/\"),t=\"\";return n.indexOf(\"://\")>-0&&e.length>2&&\"\"!=e[2]&&(t=e[2]),t}function boldDomain(){var n,e,t,i=document.getElementsByClassName(\"url\");for(t=i.length-1;t>=0;t--)\"\"!=(e=getDomain(n=i[t].innerHTML))&&(i[t].innerHTML=n.replace(e,\"<b>\"+e+\"</b>\"))}boldDomain();");
            sb3.append(z10 ? "" : "function filterChange(){var filter=document.getElementById(\"filter\");var filterValue=filter.options[filter.selectedIndex].value;var inverted=filterValue.length>0&&filterValue.charAt(0)==\"~\";if(inverted){filterValue=filterValue.substring(1)}var rules=filterValue.split(\"|\");var es=document.getElementsByClassName(\"box\");var temp;var show;for(var i=0,size=es.length;i<size;i++){temp=es[i].getElementsByClassName(\"title\")[0].innerHTML;show=rules.length<1;for(var j=0,jsize=rules.length;j<jsize;j++){if(temp.indexOf(rules[j])>=0){show=true;break}}es[i].style.display=inverted!=show?\"block\":\"none\"}filter.blur()}");
            bufferedWriter.write(d.e(sb3.toString()));
            bufferedWriter.write("</div></body></html>");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception unused) {
        }
        return "file://" + file.getPath();
    }

    public static String h(Context context) {
        File file = new File(context.getFilesDir(), "save.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(d.g(context.getString(u.f14009d0)));
            bufferedWriter.write(d.i(d.f(context, 1)));
            bufferedWriter.write("<body><div class='frosted-glass' id='gesture-indicator'></div><div id=\"content\">");
            List<l9.b> listI = i(context);
            if (listI.size() == 0) {
                bufferedWriter.write(d.d(context.getString(u.C4)));
            } else {
                bufferedWriter.write(d.d(context.getString(u.f14144m9)));
            }
            for (l9.b bVar : listI) {
                bufferedWriter.write(d.a(bVar.g(), bVar.e(), "clock"));
            }
            bufferedWriter.write("</div></body></html>");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception unused) {
        }
        return "file://" + file.getPath();
    }

    public static List i(Context context) {
        File[] fileArrListFiles;
        String[] strArr = {c1.D(context), f.b(context)};
        ArrayList arrayList = new ArrayList();
        File[] fileArr = new File[0];
        for (int i10 = 0; i10 < 2; i10++) {
            String str = strArr[i10];
            if (str != null && !str.isEmpty() && (fileArrListFiles = new File(str).listFiles()) != null && fileArrListFiles.length > 0) {
                fileArr = (File[]) com.tuyafeng.support.utils.a.a(fileArr, fileArrListFiles);
            }
        }
        Arrays.sort(fileArr, f12229a);
        for (File file : fileArr) {
            String name = file.getName();
            if (name.endsWith(".mht")) {
                arrayList.add(new l9.b("file://" + file.getParentFile() + "/" + Uri.encode(name), v0.i(name.substring(0, name.length() - 4))));
            }
        }
        return arrayList;
    }

    public static String j(Context context, String str, List list) {
        String str2;
        File file = new File(context.getFilesDir(), "images.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("<!DOCTYPE html><html><head>");
            bufferedWriter.write("<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>");
            bufferedWriter.write("<meta name=\"color-scheme\" content=\"light dark\">");
            bufferedWriter.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=1, minimal-ui\">");
            bufferedWriter.write("<title>" + context.getString(u.V) + "</title>");
            bufferedWriter.write("<link href=\"https://fastly.jsdelivr.net/npm/viewerjs@1.15.2/dist/viewer.min.css\" rel=\"stylesheet\"><script src=\"https://fastly.jsdelivr.net/npm/viewerjs@1.15.2/dist/viewer.min.js\"></script><style type=\"text/css\">*{padding:0;margin:0}#images img{display:block;margin:auto;text-align:center;max-width:100%}.viewer-backdrop{background-color:rgba(0,0,0,.9)}.viewer-toolbar>ul>li{width:32px;height:32px;padding:4px;box-sizing:border-box}.viewer-download{content:\"Download\";background-color:transparent;background-image:url('data:image/svg+xml,%3Csvg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"-494 -494 1500 1500\"%3E%3Cpath fill=\"%23fff\" d=\"M288 32c0-17.7-14.3-32-32-32s-32 14.3-32 32l0 242.7-73.4-73.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3l128 128c12.5 12.5 32.8 12.5 45.3 0l128-128c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L288 274.7 288 32zM64 352c-35.3 0-64 28.7-64 64l0 32c0 35.3 28.7 64 64 64l384 0c35.3 0 64-28.7 64-64l0-32c0-35.3-28.7-64-64-64l-101.5 0-45.3 45.3c-25 25-65.5 25-90.5 0L165.5 352 64 352zm368 56a24 24 0 1 1 0 48 24 24 0 1 1 0-48z\"/%3E%3C/svg%3E');background-repeat:no-repeat;background-size:32px;color:transparent;display:block;font-size:0;line-height:0}</style><script></script>");
            bufferedWriter.write("</head>");
            bufferedWriter.write("<body><div><ul id=\"images\">");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                l9.b bVar = (l9.b) it.next();
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

    public static List k(Context context) {
        w9.a aVarF = s.f();
        ArrayList arrayList = new ArrayList();
        try {
            return aVarF.k(256);
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }
}
