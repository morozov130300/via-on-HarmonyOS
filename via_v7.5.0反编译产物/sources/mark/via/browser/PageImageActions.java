package mark.via.browser;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.tuyafeng.support.utils.FragmentUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class PageImageActions implements androidx.lifecycle.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f8947c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p8 f8948e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final u9.l f8949m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final x.h f8950n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final x.h f8951o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ld f8952p = new ld();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.activity.result.b f8953q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f8954r;

    public PageImageActions(final Fragment fragment, p8 p8Var, u9.l lVar, x.h hVar, x.h hVar2) {
        this.f8947c = fragment;
        this.f8948e = p8Var;
        this.f8949m = lVar;
        this.f8950n = hVar;
        this.f8951o = hVar2;
        this.f8953q = x8.y1.e(fragment, new Runnable() { // from class: mark.via.browser.ka
            @Override // java.lang.Runnable
            public final void run() {
                PageImageActions.d(this.f9285c);
            }
        }, new Runnable() { // from class: mark.via.browser.pa
            @Override // java.lang.Runnable
            public final void run() {
                PageImageActions.m(this.f9440c, fragment);
            }
        });
        FragmentUtils.f(fragment, this);
    }

    public static /* synthetic */ void a(final PageImageActions pageImageActions, s5.a aVar) {
        pageImageActions.getClass();
        if (!aVar.d()) {
            com.tuyafeng.support.utils.n.q(pageImageActions.f8947c.G(), w7.u.Ng);
        } else {
            final x.d dVar = (x.d) aVar.b();
            com.tuyafeng.support.utils.n.r(pageImageActions.f8947c.G(), w7.u.J6, w7.u.oi, new View.OnClickListener() { // from class: mark.via.browser.xa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PageImageActions.u(this.f9765a, dVar, view);
                }
            });
        }
    }

    public static /* synthetic */ void d(PageImageActions pageImageActions) {
        String str = pageImageActions.f8954r;
        pageImageActions.f8954r = null;
        pageImageActions.B(str, 4);
    }

    public static /* synthetic */ void h(PageImageActions pageImageActions, String str, View view, q5.k.p pVar) {
        pageImageActions.getClass();
        pageImageActions.f8948e.j1(c6.a2.f1958a.w(str, pageImageActions.f8949m.b1()), true);
    }

    public static /* synthetic */ void l(PageImageActions pageImageActions, String str, AdapterView adapterView, View view, int i10, long j10) {
        String str2;
        pageImageActions.getClass();
        switch ((int) j10) {
            case 2:
                str2 = "https://lens.google.com/uploadbyurl?url=";
                break;
            case 3:
                str2 = "https://www.bing.com/images/search?view=detailv2&iss=sbi&form=SBIVSP&sbisrc=UrlPaste&q=imgurl:";
                break;
            case 4:
                str2 = "https://tineye.com/search/?url=";
                break;
            case 5:
                str2 = "https://yandex.com/images/touch/search?family=yes&rpt=imageview&url=";
                break;
            case 6:
                str2 = "https://graph.baidu.com/details?isfromtusoupc=1&tn=pc&carousel=0&promotion_name=pc_image_shituindex&extUiData%5bisLogoShow%5d=1&image=";
                break;
            case 7:
                str2 = "https://st.so.com/r?img_url=";
                break;
            case 8:
                str2 = "https://saucenao.com/search.php?db=999&url=";
                break;
            case 9:
                str2 = "https://iqdb.org/?url=";
                break;
            case 10:
                str2 = "https://3d.iqdb.org/?url=";
                break;
            case 11:
                str2 = "https://trace.moe/?url=";
                break;
            case 12:
                str2 = "https://ascii2d.net/search/url/";
                break;
            default:
                str2 = "https://www.google.com/searchbyimage?safe=off&sbisrc=tg&image_url=";
                break;
        }
        pageImageActions.f8948e.j1(str2 + Uri.encode(str), true);
    }

    public static /* synthetic */ void m(PageImageActions pageImageActions, Fragment fragment) {
        pageImageActions.f8954r = null;
        x8.y1.f(fragment.i0());
    }

    public static /* synthetic */ String n(Context context, Uri uri) {
        try {
            InputStream inputStreamI = x8.b1.i(context, uri);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamI);
                String strC = n5.z.c(bitmapDecodeStream);
                if (bitmapDecodeStream != null && !bitmapDecodeStream.isRecycled()) {
                    bitmapDecodeStream.recycle();
                }
                if (inputStreamI != null) {
                    inputStreamI.close();
                }
                return strC;
            } catch (Throwable th) {
                if (inputStreamI != null) {
                    try {
                        inputStreamI.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e10) {
            tc.a.j(e10);
            return "";
        }
    }

    public static /* synthetic */ void o(boolean z10, String str, String str2, String str3, String str4, Context context, File file) throws IOException {
        if (z10) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                if (!l5.a.h(str, fileOutputStream)) {
                    throw new IOException("Cannot decode image data");
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                return;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        g5.c cVar = new g5.c();
        cVar.K(file.getName());
        cVar.T(str2);
        cVar.N(str3);
        cVar.J(str4);
        cVar.C(Uri.fromFile(file));
        m5.j jVar = (m5.j) c5.b.r(context).q(cVar).call();
        if (jVar.b()) {
            return;
        }
        throw new IOException("Cannot download image: " + str2, jVar.a() == null ? null : jVar.a().d());
    }

    public static /* synthetic */ void q(final PageImageActions pageImageActions, final String str) {
        if (str != null) {
            pageImageActions.getClass();
            if (!str.isEmpty()) {
                q5.k.l(pageImageActions.f8947c.G()).f0(w7.u.Qa).K(str).P(R.string.cancel, null).T(R.string.copy, new View.OnClickListener() { // from class: mark.via.browser.ma
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.tuyafeng.support.utils.n.a(this.f9353a.f8947c.G(), str, w7.u.Eg);
                    }
                }).X(c6.a2.f1958a.u(str) ? w7.u.S : w7.u.f14063gc, new q5.k.m() { // from class: mark.via.browser.na
                    @Override // q5.k.m
                    public final void a(View view, q5.k.p pVar) {
                        PageImageActions.h(this.f9373a, str, view, pVar);
                    }
                }).h0();
                return;
            }
        }
        com.tuyafeng.support.utils.n.q(pageImageActions.f8947c.G(), w7.u.Pa);
    }

    public static /* synthetic */ void r(PageImageActions pageImageActions, String str, File file) {
        int iC = pageImageActions.f8952p.c(str);
        if (iC != 0) {
            pageImageActions.f8952p.a(str, file);
            pageImageActions.v(str, file, iC);
        }
    }

    public static /* synthetic */ void s(PageImageActions pageImageActions, String str, Context context, Throwable th) {
        pageImageActions.f8952p.c(str);
        tc.a.j(th);
        com.tuyafeng.support.utils.n.q(context, w7.u.f14027e4);
    }

    public static /* synthetic */ File t(final Context context, final String str, final String str2, final String str3) throws IOException {
        String strJ = x8.c1.j(context, "download");
        if (strJ == null) {
            throw new IOException("Cannot create image cache directory");
        }
        c6.a2 a2Var = c6.a2.f1958a;
        final boolean zL = a2Var.l(str);
        if (!zL && !a2Var.t(str2)) {
            throw new IOException("Unsupported image URL");
        }
        final String strD = zL ? l5.a.d(str) : mark.via.download.t1.d(str2, "image/*");
        String strB = l5.c.b(strD);
        if (zL && strB == null) {
            strB = "png";
        }
        return ld.h(new File(strJ, "images-v2"), strB, new ld.d() { // from class: mark.via.browser.la
            @Override // mark.via.browser.ld.d
            public final void a(File file) throws IOException {
                PageImageActions.o(zL, str, str2, str3, strD, context, file);
            }
        });
    }

    public static /* synthetic */ void u(PageImageActions pageImageActions, x.d dVar, View view) {
        pageImageActions.getClass();
        try {
            Fragment fragment = pageImageActions.f8947c;
            fragment.N2(x8.e1.i(fragment.G(), (Uri) dVar.f14455a, (String) dVar.f14456b));
        } catch (Exception e10) {
            tc.a.j(e10);
            com.tuyafeng.support.utils.n.q(pageImageActions.f8947c.G(), w7.u.Ng);
        }
    }

    public final boolean A() {
        return (this.f8947c.a1() == null || this.f8947c.b1().h0().b() == Lifecycle.State.DESTROYED) ? false : true;
    }

    public final void B(String str, int i10) {
        if (!A() || TextUtils.isEmpty(str)) {
            return;
        }
        c6.a2 a2Var = c6.a2.f1958a;
        if (a2Var.m(str)) {
            v(str, new File(Uri.parse(str).getPath()), i10);
            return;
        }
        File fileD = this.f8952p.d(str);
        if (fileD != null) {
            v(str, fileD, i10);
            return;
        }
        if (this.f8952p.f(str, i10)) {
            if (a2Var.l(str)) {
                y(str, str);
                return;
            }
            r4.a aVar = (r4.a) this.f8950n.get();
            t4.b bVarO = aVar == null ? null : aVar.o();
            if (bVarO == null) {
                this.f8952p.c(str);
                return;
            }
            if (this.f8948e.f1(bVarO.getUrl())) {
                s4.b.g(bVarO, "javascript:(function(){var n=\"__URL__\",e=new XMLHttpRequest;e.open(\"GET\",n,!0);e.responseType=\"blob\";e.onload=function(){if(200===e.status){var a=new FileReader;a.onloadend=function(){window.via.postMessage(\"__SECRET__\",JSON.stringify({action:119,url:n,data:a.result}))};a.readAsDataURL(e.response)}else window.via.postMessage(\"__SECRET__\",JSON.stringify({action:119,url:n,data:\"\"}))};e.onerror=function(){window.via.postMessage(\"__SECRET__\",JSON.stringify({action:119,url:n,data:\"\"}))};e.send()})();".replace("\"__URL__\"", JSONObject.quote(str)).replace("__SECRET__", (CharSequence) this.f8951o.get()));
            } else {
                y(str, null);
            }
            com.tuyafeng.support.utils.n.q(this.f8947c.G(), w7.u.si);
        }
    }

    public void C(String str) {
        if (!A() || TextUtils.isEmpty(str)) {
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29 || i10 < 23 || com.tuyafeng.support.utils.f.g(this.f8947c.G(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            B(str, 4);
            return;
        }
        this.f8954r = str;
        try {
            this.f8953q.a("android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Exception e10) {
            this.f8954r = null;
            tc.a.j(e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.net.Uri, java.lang.Object] */
    public final x.d D(Context context, File file, String str) throws Throwable {
        OutputStream fileOutputStream;
        Uri uri = 0;
        if (!file.isFile()) {
            return null;
        }
        String strT = x8.c1.t(file.getPath());
        String strC = l5.c.c(strT, "image/*");
        String strB = l5.b.b(str, null, strC);
        int iLastIndexOf = strB.lastIndexOf(46);
        boolean z10 = false;
        Uri uri2 = strB;
        uri2 = strB;
        if (strT != null && iLastIndexOf > 0) {
            int length = (strB.length() - strT.length()) - 3;
            uri2 = strB;
            if (iLastIndexOf > length) {
                int i10 = iLastIndexOf + 1;
                boolean zEquals = strT.equals(strB.substring(i10));
                uri2 = strB;
                if (!zEquals) {
                    uri2 = strB.substring(0, i10) + strT;
                }
            }
        }
        try {
            try {
                try {
                    if (Build.VERSION.SDK_INT >= 29) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_display_name", (String) uri2);
                        contentValues.put("mime_type", strC);
                        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/Via");
                        Uri uriInsert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                        if (uriInsert == null) {
                            if (uriInsert != null) {
                                x8.b1.e(context, uriInsert);
                            }
                            return null;
                        }
                        fileOutputStream = context.getContentResolver().openOutputStream(uriInsert);
                        uri2 = uriInsert;
                    } else {
                        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Via");
                        File file3 = new File(file2, x8.c1.K(file2.getAbsolutePath(), uri2));
                        Uri uriFromFile = Uri.fromFile(file3);
                        fileOutputStream = new FileOutputStream(file3);
                        uri2 = uriFromFile;
                    }
                    try {
                        InputStream inputStreamI = x8.b1.i(context, Uri.fromFile(file));
                        if (fileOutputStream == null || inputStreamI == null) {
                            if (inputStreamI != null) {
                                inputStreamI.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (uri2 != 0) {
                                x8.b1.e(context, uri2);
                            }
                            return null;
                        }
                        try {
                            x8.s2.a(inputStreamI, fileOutputStream);
                            fileOutputStream.flush();
                            inputStreamI.close();
                            fileOutputStream.close();
                            try {
                                mark.via.download.t1.g(context, uri2);
                                return x.d.a(uri2, strC);
                            } catch (Exception e10) {
                                e = e10;
                                z10 = true;
                                tc.a.j(e);
                                if (!z10 && uri2 != 0) {
                                    x8.b1.e(context, uri2);
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                uri = uri2;
                                z10 = true;
                                if (!z10 && uri != 0) {
                                    x8.b1.e(context, uri);
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                inputStreamI.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                            }
                        }
                        throw th4;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th6) {
                th = th6;
                uri = uri2;
            }
        } catch (Exception e12) {
            e = e12;
            uri2 = 0;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public void E(String str) {
        B(str, 2);
    }

    public final void F(final Uri uri) {
        final Context contextG = this.f8947c.G();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.va
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PageImageActions.n(contextG, uri);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this.f8947c.b1()))).a(new u6.f() { // from class: mark.via.browser.wa
            @Override // u6.f
            public final void accept(Object obj) {
                PageImageActions.q(this.f9738c, (String) obj);
            }
        }, new w7.e0());
    }

    public void G(final String str, int i10, int i11) {
        if (A()) {
            boolean z10 = x8.a0.f() || x8.f.h();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new q5.k.l(1, this.f8947c.X0(w7.u.f14085i6)));
            arrayList.add(new q5.k.l(2, this.f8947c.X0(w7.u.f14071h6)));
            arrayList.add(new q5.k.l(3, this.f8947c.X0(w7.u.f14248u1)));
            arrayList.add(new q5.k.l(4, this.f8947c.X0(w7.u.bg)));
            arrayList.add(new q5.k.l(5, this.f8947c.X0(w7.u.Bi)));
            if (z10) {
                arrayList.add(new q5.k.l(6, this.f8947c.X0(w7.u.f14234t1)));
                arrayList.add(new q5.k.l(7, this.f8947c.X0(w7.u.f14127l6)));
            }
            arrayList.add(new q5.k.l(8, this.f8947c.X0(w7.u.Hb)));
            arrayList.add(new q5.k.l(9, this.f8947c.X0(w7.u.f14212r7)));
            arrayList.add(new q5.k.l(10, this.f8947c.X0(w7.u.f14198q7)));
            arrayList.add(new q5.k.l(11, this.f8947c.X0(w7.u.xi)));
            arrayList.add(new q5.k.l(12, this.f8947c.X0(w7.u.f14094j1)));
            q5.k.l(this.f8947c.G()).f0(w7.u.f14035ec).D(arrayList, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.oa
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                    PageImageActions.l(this.f9397a, str, adapterView, view, i12, j10);
                }
            }).i0(i10, i11);
        }
    }

    public void H(String str) {
        B(str, 1);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void b(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.c(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void c(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.a(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void f(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.b(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void g(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.e(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public void i(androidx.lifecycle.j jVar) {
        this.f8952p.b();
        this.f8954r = null;
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void j(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.d(this, jVar);
    }

    public final void v(final String str, final File file, int i10) {
        if ((i10 & 4) != 0) {
            final Context contextG = this.f8947c.G();
            ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.qa
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return s5.a.f(this.f9573c.D(contextG, file, str));
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this.f8947c.b1()))).a(new u6.f() { // from class: mark.via.browser.ra
                @Override // u6.f
                public final void accept(Object obj) {
                    PageImageActions.a(this.f9605c, (s5.a) obj);
                }
            }, new w7.e0());
        }
        Uri uriFromFile = Uri.fromFile(file);
        if ((i10 & 8) != 0) {
            x(file);
        }
        if ((i10 & 1) != 0) {
            int iLastIndexOf = file.getName().lastIndexOf(46);
            x8.e1.m(this.f8947c.G(), uriFromFile, iLastIndexOf > 0 ? l5.c.c(file.getName().substring(iLastIndexOf + 1), "image/*") : "image/*");
        }
        if ((i10 & 2) != 0) {
            F(uriFromFile);
        }
    }

    public void w(String str) {
        B(str, 8);
    }

    public final void x(File file) {
        Context contextG = this.f8947c.G();
        try {
            if (file.isFile() && file.canRead()) {
                ClipboardManager clipboardManager = (ClipboardManager) contextG.getSystemService("clipboard");
                if (clipboardManager == null) {
                    com.tuyafeng.support.utils.n.q(contextG, w7.u.Ng);
                    return;
                }
                clipboardManager.setPrimaryClip(ClipData.newUri(contextG.getContentResolver(), this.f8947c.X0(w7.u.f14246u), FileProvider.f(contextG, contextG.getPackageName() + ".provider", file)));
                com.tuyafeng.support.utils.n.q(contextG, w7.u.Dg);
                return;
            }
            com.tuyafeng.support.utils.n.q(contextG, w7.u.Ng);
        } catch (Exception e10) {
            tc.a.j(e10);
            com.tuyafeng.support.utils.n.q(contextG, w7.u.Ng);
        }
    }

    public final void y(final String str, final String str2) {
        if (this.f8952p.g(str)) {
            final Context contextG = this.f8947c.G();
            r4.a aVar = (r4.a) this.f8950n.get();
            final String url = aVar == null ? null : aVar.getUrl();
            ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.sa
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PageImageActions.t(contextG, str2, str, url);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this.f8947c.b1()))).a(new u6.f() { // from class: mark.via.browser.ta
                @Override // u6.f
                public final void accept(Object obj) {
                    PageImageActions.r(this.f9671c, str, (File) obj);
                }
            }, new u6.f() { // from class: mark.via.browser.ua
                @Override // u6.f
                public final void accept(Object obj) {
                    PageImageActions.s(this.f9692c, str, contextG, (Throwable) obj);
                }
            });
        }
    }

    public boolean z(String str, String str2) {
        if (this.f8952p.e(str) == 0) {
            return false;
        }
        if (!TextUtils.isEmpty(str2) || c6.a2.f1958a.t(str)) {
            y(str, str2);
            return true;
        }
        this.f8952p.c(str);
        com.tuyafeng.support.utils.n.q(this.f8947c.G(), w7.u.X1);
        return true;
    }
}
