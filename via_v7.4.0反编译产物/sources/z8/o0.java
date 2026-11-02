package z8;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class o0 {
    public static void a(Context context) {
        File codeCacheDir;
        ArrayList<File> arrayList = new ArrayList();
        arrayList.add(context.getCacheDir());
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            arrayList.add(externalCacheDir);
        }
        if (Build.VERSION.SDK_INT >= 21 && (codeCacheDir = context.getCodeCacheDir()) != null) {
            arrayList.add(codeCacheDir);
        }
        arrayList.add(new File(context.getFilesDir(), "chunks"));
        File externalFilesDir = context.getExternalFilesDir("chunks");
        if (externalFilesDir != null) {
            arrayList.add(externalFilesDir);
        }
        for (File file : arrayList) {
            if (file != null && file.exists()) {
                c(file);
            }
        }
    }

    public static void b(Context context, w9.l lVar) {
        File[] fileArrListFiles;
        boolean z10;
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        pc.a.a("clear unused content files", new Object[0]);
        File file = new File(c1.l(context));
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        HashSet hashSet = new HashSet();
        String strN = lVar.n();
        if (i6.i0.f7006a.l(strN)) {
            Uri uri = Uri.parse(strN);
            if (uri.getPath() != null) {
                hashSet.add(uri.getLastPathSegment());
            }
        }
        String strC = lVar.c();
        if (strC == null || strC.isEmpty()) {
            z10 = false;
        } else {
            hashSet.add(new File(strC).getName());
            z10 = true;
        }
        String strA0 = lVar.a0();
        if (strA0 != null && !strA0.isEmpty() && (iIndexOf = strA0.indexOf("<img")) >= 0 && (iIndexOf2 = strA0.indexOf(" src=\"", iIndexOf)) > 0 && (iIndexOf3 = strA0.indexOf("\"", iIndexOf2 + 6)) > iIndexOf2) {
            Uri uri2 = Uri.parse(strA0.substring(iIndexOf2, iIndexOf3));
            if (uri2.getPath() != null) {
                hashSet.add(uri2.getLastPathSegment());
            }
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null && !hashSet.contains(file2.getName()) && (!z10 || !file2.getName().startsWith("background-"))) {
                c(file2);
            }
        }
    }

    public static boolean c(File file) {
        int i10;
        String[] list;
        if (file == null || !file.exists()) {
            return true;
        }
        if (!file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            i10 = 0;
        } else {
            i10 = 0;
            for (String str : list) {
                if (!c(new File(file, str))) {
                    i10++;
                }
            }
        }
        return i10 == 0 && file.delete();
    }
}
