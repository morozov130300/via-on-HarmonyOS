package s9;

import android.graphics.Typeface;
import android.os.Build;
import android.util.LruCache;
import android.webkit.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import z8.c1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f11868a;

    /* renamed from: b, reason: collision with root package name */
    public final LruCache f11869b = new LruCache(4);

    public d(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("fontDirectory == null || fontDirectory.isEmpty()");
        }
        this.f11868a = str;
    }

    public static /* synthetic */ boolean a(File file, String str) {
        return str.endsWith(".ttf") || str.endsWith(".otf") || str.endsWith(".woff") || str.endsWith(".woff2");
    }

    public a c(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        if (!this.f11868a.equals(file.getParent()) && !c1.a(file, new File(this.f11868a))) {
            return null;
        }
        this.f11869b.remove(file.getName());
        return new a(new File(this.f11868a, file.getName()).getAbsolutePath());
    }

    public boolean d(String str) {
        if (str != null && !str.isEmpty()) {
            File file = new File(this.f11868a, str);
            if (file.exists() && file.delete()) {
                this.f11869b.remove(str);
                return true;
            }
        }
        return false;
    }

    public String e() {
        return this.f11868a;
    }

    public WebResourceResponse f(String str) {
        if (str != null && !str.isEmpty()) {
            File file = new File(this.f11868a, str);
            if (!file.isFile()) {
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                String strC = l5.c.c(c1.r(str), "font/ttf");
                WebResourceResponse webResourceResponse = new WebResourceResponse(strC, "UTF-8", fileInputStream);
                if (Build.VERSION.SDK_INT < 21) {
                    return webResourceResponse;
                }
                HashMap map = new HashMap();
                map.put("Cache-Control", "immutable");
                map.put("Access-Control-Allow-Origin", "*");
                map.put("Content-Type", strC);
                webResourceResponse.setResponseHeaders(map);
                return webResourceResponse;
            } catch (Exception e10) {
                pc.a.b(e10);
            }
        }
        return null;
    }

    public Typeface g(String str) {
        if (str == null || str.isEmpty()) {
            return Typeface.DEFAULT;
        }
        Typeface typefaceCreateFromFile = (Typeface) this.f11869b.get(str);
        if (typefaceCreateFromFile == null) {
            File file = new File(this.f11868a, str);
            if (!file.exists()) {
                return null;
            }
            try {
                typefaceCreateFromFile = Typeface.createFromFile(file);
            } catch (Exception e10) {
                pc.a.b(e10);
            }
            if (typefaceCreateFromFile == null) {
                typefaceCreateFromFile = Typeface.DEFAULT;
            }
            this.f11869b.put(str, typefaceCreateFromFile);
        }
        return typefaceCreateFromFile;
    }

    public List h() {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(""));
        File file = new File(this.f11868a);
        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: s9.b
            @Override // java.io.FilenameFilter
            public final boolean accept(File file2, String str) {
                return d.a(file2, str);
            }
        })) != null && fileArrListFiles.length != 0) {
            Arrays.sort(fileArrListFiles, new Comparator() { // from class: s9.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ((File) obj).getName().compareToIgnoreCase(((File) obj2).getName());
                }
            });
            for (File file2 : fileArrListFiles) {
                arrayList.add(new a(file2.getAbsolutePath()));
            }
        }
        return arrayList;
    }

    public a i(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty() && !str.equals(str2)) {
            File file = new File(this.f11868a, str);
            if (!file.isFile()) {
                return null;
            }
            String str3 = this.f11868a;
            File file2 = new File(str3, c1.K(str3, c1.n(str2)));
            if (file.renameTo(file2)) {
                return new a(file2.getAbsolutePath());
            }
        }
        return null;
    }
}
