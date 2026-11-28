package c8;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import androidx.activity.result.ActivityResult;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b0 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f2163c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(Intent intent, i8.o oVar);

        void b(i8.o oVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i8.o f2164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File f2165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri f2166c;

        public b(i8.o oVar, File file, Uri uri) {
            this.f2164a = oVar;
            this.f2165b = file;
            this.f2166c = uri;
        }

        public static /* synthetic */ void a(b bVar) {
            b0.this.f2161a.revokeUriPermission(bVar.f2166c, 3);
            b0.b0(bVar.f2165b);
        }

        public void b(ActivityResult activityResult) {
            if (this.f2165b != null && activityResult.b() != -1) {
                c();
            }
            this.f2164a.a(activityResult);
        }

        public void c() {
            a7.a.c().d(new Runnable() { // from class: c8.c0
                @Override // java.lang.Runnable
                public final void run() {
                    b0.b.a(this.f2169c);
                }
            });
        }

        public ActivityResult d(ActivityResult activityResult) {
            b0.this.f2161a.revokeUriPermission(this.f2166c, 3);
            if (this.f2165b.isFile() && this.f2165b.canRead() && this.f2165b.length() > 0) {
                return new ActivityResult(-1, new Intent().setData(this.f2166c));
            }
            b0.b0(this.f2165b);
            Intent intentA = activityResult.a();
            if (intentA != null) {
                if (this.f2166c.equals(intentA.getData())) {
                    return new ActivityResult(0, null);
                }
                ClipData clipData = intentA.getClipData();
                if (clipData != null) {
                    for (int i10 = 0; i10 < clipData.getItemCount(); i10++) {
                        if (this.f2166c.equals(clipData.getItemAt(i10).getUri())) {
                            return new ActivityResult(0, null);
                        }
                    }
                }
            }
            return activityResult;
        }
    }

    public b0(Context context, a aVar) {
        this.f2161a = context;
        this.f2162b = aVar;
    }

    public static /* synthetic */ void J(b0 b0Var, b bVar, Intent intent, Intent intent2, b bVar2) {
        if (b0Var.f2163c != bVar) {
            bVar2.c();
            return;
        }
        b0Var.f2163c = bVar2;
        intent.putExtra("output", bVar2.f2166c);
        intent.setClipData(ClipData.newRawUri("photo", bVar2.f2166c));
        intent.addFlags(3);
        b0Var.c0(intent, intent2, bVar2);
    }

    public static /* synthetic */ void M(b0 b0Var, b bVar, Intent intent, Throwable th) {
        b0Var.getClass();
        tc.a.j(th);
        if (b0Var.f2163c == bVar) {
            b0Var.c0(intent, null, bVar);
        }
    }

    public static /* synthetic */ void N(final b0 b0Var, final b bVar, final ActivityResult activityResult) {
        if (b0Var.f2163c != bVar) {
            return;
        }
        if (bVar.f2165b == null || activityResult.b() != -1) {
            b0Var.a0(bVar, activityResult);
        } else {
            r6.q.f(new Callable() { // from class: c8.u
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return bVar.d(activityResult);
                }
            }).k(a7.a.c()).i(q6.b.b()).a(new u6.f() { // from class: c8.v
                @Override // u6.f
                public final void accept(Object obj) {
                    this.f2286c.a0(bVar, (ActivityResult) obj);
                }
            }, new u6.f() { // from class: c8.w
                @Override // u6.f
                public final void accept(Object obj) {
                    b0.P(this.f2293c, bVar, (Throwable) obj);
                }
            });
        }
    }

    public static /* synthetic */ b O(b0 b0Var, b bVar) throws Exception {
        b0Var.getClass();
        File file = new File(b0Var.f2161a.getCacheDir(), "uploads");
        if (!file.isDirectory() && !file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Cannot create upload directory");
        }
        File fileCreateTempFile = File.createTempFile("photo-", ".jpg", file);
        try {
            return b0Var.new b(bVar.f2164a, fileCreateTempFile, FileProvider.f(b0Var.f2161a, b0Var.f2161a.getPackageName() + ".provider", fileCreateTempFile));
        } catch (Exception e10) {
            b0(fileCreateTempFile);
            throw e10;
        }
    }

    public static /* synthetic */ void P(b0 b0Var, b bVar, Throwable th) {
        b0Var.getClass();
        tc.a.j(th);
        b0Var.a0(bVar, new ActivityResult(0, null));
    }

    public static /* synthetic */ void T(b0 b0Var, b bVar, Intent intent, Intent intent2, Boolean bool) {
        if (b0Var.f2163c != bVar) {
            return;
        }
        if (bool.booleanValue()) {
            b0Var.f0(intent, intent2, bVar);
        } else {
            b0Var.c0(intent, null, bVar);
        }
    }

    public static void b0(File file) {
        if (file.delete() || !file.exists()) {
            return;
        }
        tc.a.i("Cannot delete upload photo", new Object[0]);
    }

    public static List d0(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                if (str != null) {
                    String strTrim = str.trim();
                    if (!strTrim.isEmpty()) {
                        if (strTrim.charAt(0) == '.') {
                            strTrim = l5.c.c(strTrim.substring(1), null);
                        }
                        if (strTrim != null && !arrayList.contains(strTrim)) {
                            arrayList.add(strTrim);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // q4.a
    public boolean B(final ValueCallback valueCallback, String str, String str2) {
        b bVarW = W(new i8.o() { // from class: c8.y
            @Override // i8.o
            public final void a(Object obj) {
                ActivityResult activityResult = (ActivityResult) obj;
                valueCallback.onReceiveValue((activityResult.b() != -1 || activityResult.a() == null) ? null : activityResult.a().getData());
            }
        });
        if (bVarW == null) {
            return true;
        }
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            List listD0 = d0(str == null ? null : str.split(","));
            Y(intent, this.f2161a.getString(w7.u.mg), (!(listD0.contains("image/*") || listD0.contains("image/jpeg")) || TextUtils.isEmpty(str2) || "filesystem".equals(str2)) ? false : true, bVarW);
        } catch (Exception e10) {
            tc.a.j(e10);
            a0(bVarW, new ActivityResult(0, null));
        }
        return true;
    }

    @Override // q4.a
    public boolean C(t4.b bVar, final ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        b bVarW = W(new i8.o() { // from class: c8.x
            @Override // i8.o
            public final void a(Object obj) {
                valueCallback.onReceiveValue(this.f2295a.e0((ActivityResult) obj));
            }
        });
        if (bVarW == null) {
            return true;
        }
        try {
            Intent intentCreateIntent = fileChooserParams.createIntent();
            List listD0 = d0(fileChooserParams.getAcceptTypes());
            tc.a.a("upload file, mime types: %s", listD0);
            if (listD0.isEmpty()) {
                intentCreateIntent.setType("*/*");
            } else if (listD0.size() == 1) {
                intentCreateIntent.setType((String) listD0.get(0));
            } else {
                intentCreateIntent.setType("*/*");
                intentCreateIntent.putExtra("android.intent.extra.MIME_TYPES", (String[]) listD0.toArray(new String[0]));
            }
            CharSequence title = fileChooserParams.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.f2161a.getString(w7.u.mg);
            }
            int mode = fileChooserParams.getMode();
            Y(intentCreateIntent, title, (mode == 0 || mode == 1) && (listD0.contains("image/*") || listD0.contains("image/jpeg")) && fileChooserParams.isCaptureEnabled(), bVarW);
        } catch (Exception e10) {
            tc.a.j(e10);
            a0(bVarW, new ActivityResult(0, null));
        }
        return true;
    }

    public final b W(i8.o oVar) {
        b bVar = new b(oVar, null, null);
        b bVar2 = this.f2163c;
        this.f2163c = bVar;
        if (bVar2 != null) {
            bVar2.b(new ActivityResult(0, null));
        }
        if (this.f2163c == bVar) {
            return bVar;
        }
        return null;
    }

    public void X() {
        b bVar = this.f2163c;
        if (bVar != null) {
            a0(bVar, new ActivityResult(0, null));
        }
    }

    public final void Y(Intent intent, CharSequence charSequence, boolean z10, final b bVar) {
        a7.a.c().d(new Runnable() { // from class: c8.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f2304c.Z();
            }
        });
        final Intent intentCreateChooser = Intent.createChooser(intent, charSequence);
        final Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        if (!z10 || intent2.resolveActivity(this.f2161a.getPackageManager()) == null) {
            c0(intentCreateChooser, null, bVar);
        } else if (Build.VERSION.SDK_INT < 23 || com.tuyafeng.support.utils.f.g(this.f2161a, "android.permission.CAMERA")) {
            f0(intentCreateChooser, intent2, bVar);
        } else {
            this.f2162b.b(new i8.o() { // from class: c8.a0
                @Override // i8.o
                public final void a(Object obj) {
                    b0.T(this.f2152a, bVar, intentCreateChooser, intent2, (Boolean) obj);
                }
            });
        }
    }

    public final void Z() {
        File[] fileArrListFiles = new File(this.f2161a.getCacheDir(), "uploads").listFiles();
        if (fileArrListFiles != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - 86400000;
            for (File file : fileArrListFiles) {
                if (file.lastModified() < jCurrentTimeMillis) {
                    b0(file);
                }
            }
        }
    }

    public final void a0(b bVar, ActivityResult activityResult) {
        if (this.f2163c != bVar) {
            return;
        }
        this.f2163c = null;
        bVar.b(activityResult);
    }

    public final void c0(Intent intent, Intent intent2, final b bVar) {
        try {
            this.f2162b.a(intent, new i8.o() { // from class: c8.t
                @Override // i8.o
                public final void a(Object obj) {
                    b0.N(this.f2270a, bVar, (ActivityResult) obj);
                }
            });
        } catch (Exception e10) {
            tc.a.j(e10);
            if (intent2 != null) {
                c0(intent2, null, bVar);
            } else {
                a0(bVar, new ActivityResult(0, null));
            }
        }
    }

    public final Uri[] e0(ActivityResult activityResult) {
        int iB = activityResult.b();
        Intent intentA = activityResult.a();
        if (iB == -1 && intentA != null) {
            try {
                ClipData clipData = intentA.getClipData();
                if (clipData != null && clipData.getItemCount() > 0) {
                    int itemCount = clipData.getItemCount();
                    Uri[] uriArr = new Uri[itemCount];
                    for (int i10 = 0; i10 < itemCount; i10++) {
                        uriArr[i10] = clipData.getItemAt(i10).getUri();
                    }
                    return uriArr;
                }
            } catch (Exception e10) {
                tc.a.j(e10);
                return null;
            }
        }
        return WebChromeClient.FileChooserParams.parseResult(iB, intentA);
    }

    public final void f0(final Intent intent, final Intent intent2, final b bVar) {
        r6.q.f(new Callable() { // from class: c8.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b0.O(this.f2242c, bVar);
            }
        }).k(a7.a.c()).i(q6.b.b()).a(new u6.f() { // from class: c8.r
            @Override // u6.f
            public final void accept(Object obj) {
                b0.J(this.f2249c, bVar, intent2, intent, (b0.b) obj);
            }
        }, new u6.f() { // from class: c8.s
            @Override // u6.f
            public final void accept(Object obj) {
                b0.M(this.f2261c, bVar, intent, (Throwable) obj);
            }
        });
    }
}
