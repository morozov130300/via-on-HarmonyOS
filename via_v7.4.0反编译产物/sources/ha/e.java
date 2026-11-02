package ha;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import z8.b1;
import z8.c1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements h {

    /* renamed from: c, reason: collision with root package name */
    public static final String f6456c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6457a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f6458b;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.DIRECTORY_DOWNLOADS);
        char c10 = File.separatorChar;
        sb2.append(c10);
        sb2.append("mark.via");
        sb2.append(c10);
        sb2.append("offline");
        f6456c = sb2.toString();
    }

    public e(Context context) {
        this.f6457a = context.getApplicationContext();
        int i10 = Build.VERSION.SDK_INT;
        String[] strArr = i10 >= 29 ? new String[1] : new String[2];
        this.f6458b = strArr;
        strArr[0] = c1.D(context);
        if (i10 < 29) {
            strArr[1] = c1.q(Environment.DIRECTORY_DOWNLOADS, null);
        }
    }

    public static /* synthetic */ int c(n9.d dVar, n9.d dVar2) {
        if (dVar.b() == dVar2.b()) {
            return 0;
        }
        return dVar.b() > dVar2.b() ? -1 : 1;
    }

    @Override // ha.h
    public boolean a(n9.d dVar) {
        if (dVar == null || dVar.a() == null) {
            return false;
        }
        return b1.e(this.f6457a, dVar.a());
    }

    @Override // ha.h
    public List b() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f6458b) {
            if (str.charAt(0) == File.separatorChar) {
                arrayList.addAll(f(str));
            } else {
                arrayList.addAll(e(str));
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: ha.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.c((n9.d) obj, (n9.d) obj2);
            }
        });
        return arrayList;
    }

    public final n9.d d(Uri uri, String str, String str2, long j10, long j11) {
        boolean z10;
        if (uri == null) {
            return null;
        }
        if (str == null || str.isEmpty()) {
            str = b1.k(this.f6457a, uri);
        }
        if (str == null || str.isEmpty()) {
            str = "Untitled";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        String lowerCase = iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1).toLowerCase(Locale.ROOT) : null;
        if ("multipart/related".equals(str2) || "mht".equals(lowerCase)) {
            z10 = true;
        } else {
            if (!"application/pdf".equals(str2) && !"pdf".equals(lowerCase)) {
                return null;
            }
            z10 = false;
        }
        n9.d dVar = new n9.d(uri);
        if (iLastIndexOf > 0) {
            str = str.substring(0, iLastIndexOf);
        }
        dVar.j(str);
        dVar.i(z10 ? "multipart/related" : "application/pdf");
        dVar.k(j11);
        dVar.h(j10);
        return dVar;
    }

    public final List e(String str) {
        e eVar = this;
        if (eVar.f6457a == null || Build.VERSION.SDK_INT < 29) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Uri contentUri = MediaStore.Downloads.getContentUri("external");
        try {
            Cursor cursorQuery = eVar.f6457a.getApplicationContext().getContentResolver().query(contentUri, new String[]{"_id", "_display_name", "date_added", "mime_type", "_size"}, "relative_path like ?", new String[]{str + "%"}, "date_added DESC");
            if (cursorQuery != null) {
                try {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("_display_name");
                    int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("date_added");
                    int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("mime_type");
                    int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("_size");
                    while (cursorQuery.moveToNext()) {
                        long j10 = cursorQuery.getLong(columnIndexOrThrow);
                        n9.d dVarD = eVar.d(ContentUris.withAppendedId(contentUri, j10), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getLong(columnIndexOrThrow3) * 1000, cursorQuery.getLong(columnIndexOrThrow5));
                        if (dVarD != null) {
                            arrayList.add(dVarD);
                        }
                        eVar = this;
                    }
                } finally {
                }
            } else if (cursorQuery == null) {
                return arrayList;
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e10) {
            pc.a.i(e10);
            return arrayList;
        }
    }

    public final List f(String str) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            if (str.charAt(0) == File.separatorChar) {
                File file = new File(str);
                if (file.canRead() && file.exists() && !file.isFile() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
                    boolean zContains = str.contains("mark.via");
                    for (File file2 : fileArrListFiles) {
                        n9.d dVarD = d(Uri.fromFile(file2), file2.getName(), null, file2.lastModified(), file2.length());
                        if (dVarD != null && (zContains || "application/pdf".equals(dVarD.c()))) {
                            arrayList.add(dVarD);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
