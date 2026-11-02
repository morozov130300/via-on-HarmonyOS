package mb;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f10031a;

    public b(String str) {
        this.f10031a = str;
    }

    public static /* synthetic */ int c(c cVar, c cVar2) {
        if (cVar.b() == cVar2.b()) {
            return 0;
        }
        return cVar.b() > cVar2.b() ? -1 : 1;
    }

    @Override // mb.e
    public List a() {
        return g();
    }

    @Override // mb.e
    public boolean b(String str) {
        return e(str);
    }

    public final boolean d(File file) {
        String[] list;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
            for (String str : list) {
                if (!d(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public final boolean e(String str) {
        String strF = f(str);
        if (strF == null) {
            return false;
        }
        return d(new File(strF));
    }

    public final String f(String str) {
        String str2 = this.f10031a;
        if (str2 == null || str2.isEmpty() || str == null || str.isEmpty()) {
            return null;
        }
        return new File(this.f10031a, str).getAbsolutePath();
    }

    public final List g() {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        String str = this.f10031a;
        if (str != null && !str.isEmpty()) {
            File file = new File(this.f10031a);
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        arrayList.add(new c(file2.getName(), file2.getName(), file2.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator() { // from class: mb.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return b.c((c) obj, (c) obj2);
                    }
                });
            }
        }
        return arrayList;
    }
}
