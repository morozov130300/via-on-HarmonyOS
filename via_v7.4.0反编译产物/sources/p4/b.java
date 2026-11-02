package p4;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    public List f10955a = null;

    @Override // p4.a
    public boolean A(t4.b bVar, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (H()) {
            return super.A(bVar, valueCallback, fileChooserParams);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).A(bVar, valueCallback, fileChooserParams)) {
                return true;
            }
        }
        return super.A(bVar, valueCallback, fileChooserParams);
    }

    @Override // p4.a
    public void B(t4.b bVar, String str) {
        if (H()) {
            super.B(bVar, str);
            return;
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).B(bVar, str);
        }
    }

    @Override // p4.a
    public void C(t4.b bVar) {
        if (H()) {
            super.C(bVar);
            return;
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).C(bVar);
        }
    }

    @Override // p4.a
    public void D(t4.b bVar, int i10) {
        if (H()) {
            super.D(bVar, i10);
            return;
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).D(bVar, i10);
        }
    }

    @Override // p4.a
    public int E(t4.b bVar, String str, boolean z10, boolean z11) {
        if (H()) {
            return super.E(bVar, str, z10, z11);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            int iE = ((a) it.next()).E(bVar, str, z10, z11);
            if (iE != 0) {
                return iE;
            }
        }
        return super.E(bVar, str, z10, z11);
    }

    @Override // p4.a
    public WebResourceResponse F(t4.b bVar, WebResourceRequest webResourceRequest, String str, String str2) {
        if (H()) {
            return super.F(bVar, webResourceRequest, str, str2);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            WebResourceResponse webResourceResponseF = ((a) it.next()).F(bVar, webResourceRequest, str, str2);
            if (webResourceResponseF != null) {
                return webResourceResponseF;
            }
        }
        return super.F(bVar, webResourceRequest, str, str2);
    }

    public void G(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f10955a == null) {
            this.f10955a = new ArrayList();
        }
        this.f10955a.add(aVar);
    }

    public final boolean H() {
        List list = this.f10955a;
        return list == null || list.isEmpty();
    }

    public void I() {
        List list = this.f10955a;
        if (list == null) {
            return;
        }
        list.clear();
        this.f10955a = null;
    }

    @Override // p4.a
    public View a() {
        if (H()) {
            return super.a();
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            View viewA = ((a) it.next()).a();
            if (viewA != null) {
                return viewA;
            }
        }
        return super.a();
    }

    @Override // p4.a
    public boolean b(t4.b bVar) {
        if (H()) {
            return super.b(bVar);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).b(bVar)) {
                return true;
            }
        }
        return super.b(bVar);
    }

    @Override // p4.a
    public boolean c(ConsoleMessage consoleMessage) {
        if (H()) {
            return super.c(consoleMessage);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).c(consoleMessage)) {
                return true;
            }
        }
        return super.c(consoleMessage);
    }

    @Override // p4.a
    public boolean d(String str, int i10, String str2) {
        if (H()) {
            return super.d(str, i10, str2);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).d(str, i10, str2)) {
                return true;
            }
        }
        return super.d(str, i10, str2);
    }

    @Override // p4.a
    public boolean e(t4.b bVar, boolean z10, boolean z11, Message message) {
        if (H()) {
            return super.e(bVar, z10, z11, message);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).e(bVar, z10, z11, message)) {
                return true;
            }
        }
        return super.e(bVar, z10, z11, message);
    }

    @Override // p4.a
    public boolean f(t4.b bVar, Message message, Message message2) {
        if (H()) {
            return super.f(bVar, message, message2);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).f(bVar, message, message2)) {
                return true;
            }
        }
        return super.f(bVar, message, message2);
    }

    @Override // p4.a
    public boolean g() {
        if (H()) {
            return super.g();
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).g()) {
                return true;
            }
        }
        return super.g();
    }

    @Override // p4.a
    public boolean h(String str, GeolocationPermissions.Callback callback) {
        if (H()) {
            return super.h(str, callback);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).h(str, callback)) {
                return true;
            }
        }
        return super.h(str, callback);
    }

    @Override // p4.a
    public boolean i() {
        if (H()) {
            return super.i();
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).i()) {
                return true;
            }
        }
        return super.i();
    }

    @Override // p4.a
    public boolean j(t4.b bVar, String str, String str2, JsResult jsResult) {
        if (H()) {
            return super.j(bVar, str, str2, jsResult);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).j(bVar, str, str2, jsResult)) {
                return true;
            }
        }
        return super.j(bVar, str, str2, jsResult);
    }

    @Override // p4.a
    public boolean k(t4.b bVar, String str, String str2, JsResult jsResult) {
        if (H()) {
            return super.k(bVar, str, str2, jsResult);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).k(bVar, str, str2, jsResult)) {
                return true;
            }
        }
        return super.k(bVar, str, str2, jsResult);
    }

    @Override // p4.a
    public boolean l(t4.b bVar, String str, String str2, JsResult jsResult) {
        if (H()) {
            return super.l(bVar, str, str2, jsResult);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).l(bVar, str, str2, jsResult)) {
                return true;
            }
        }
        return super.l(bVar, str, str2, jsResult);
    }

    @Override // p4.a
    public boolean m(t4.b bVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (H()) {
            return super.m(bVar, str, str2, str3, jsPromptResult);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            t4.b bVar2 = bVar;
            if (((a) it.next()).m(bVar2, str, str2, str3, jsPromptResult)) {
                return true;
            }
            bVar = bVar2;
        }
        return super.m(bVar, str, str2, str3, jsPromptResult);
    }

    @Override // p4.a
    public void n(t4.b bVar, String str) {
        super.n(bVar, str);
        if (H()) {
            return;
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).n(bVar, str);
        }
    }

    @Override // p4.a
    public void o(t4.b bVar, String str, Bitmap bitmap) {
        super.o(bVar, str, bitmap);
        if (H()) {
            return;
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).o(bVar, str, bitmap);
        }
    }

    @Override // p4.a
    public boolean p(PermissionRequest permissionRequest) {
        if (H()) {
            return super.p(permissionRequest);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).p(permissionRequest)) {
                return true;
            }
        }
        return super.p(permissionRequest);
    }

    @Override // p4.a
    public boolean q(PermissionRequest permissionRequest) {
        if (H()) {
            return super.q(permissionRequest);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).q(permissionRequest)) {
                return true;
            }
        }
        return super.q(permissionRequest);
    }

    @Override // p4.a
    public void r(t4.b bVar, int i10) {
        super.r(bVar, i10);
        if (H()) {
            return;
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).r(bVar, i10);
        }
    }

    @Override // p4.a
    public boolean s(t4.b bVar, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (H()) {
            return super.s(bVar, httpAuthHandler, str, str2);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).s(bVar, httpAuthHandler, str, str2)) {
                return true;
            }
        }
        return super.s(bVar, httpAuthHandler, str, str2);
    }

    @Override // p4.a
    public void t(t4.b bVar, Bitmap bitmap) {
        super.t(bVar, bitmap);
        if (H()) {
            return;
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).t(bVar, bitmap);
        }
    }

    @Override // p4.a
    public boolean u(t4.b bVar, int i10, String str, String str2) {
        if (H()) {
            return super.u(bVar, i10, str, str2);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).u(bVar, i10, str, str2)) {
                return true;
            }
        }
        return super.u(bVar, i10, str, str2);
    }

    @Override // p4.a
    public boolean v(t4.b bVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (H()) {
            return super.v(bVar, sslErrorHandler, sslError);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).v(bVar, sslErrorHandler, sslError)) {
                return true;
            }
        }
        return super.v(bVar, sslErrorHandler, sslError);
    }

    @Override // p4.a
    public void w(t4.b bVar, String str) {
        super.w(bVar, str);
        if (H()) {
            return;
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).w(bVar, str);
        }
    }

    @Override // p4.a
    public void x(t4.b bVar, String str, boolean z10) {
        super.x(bVar, str, z10);
        if (H()) {
            return;
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).x(bVar, str, z10);
        }
    }

    @Override // p4.a
    public boolean y(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (H()) {
            return super.y(view, customViewCallback);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).y(view, customViewCallback)) {
                return true;
            }
        }
        return super.y(view, customViewCallback);
    }

    @Override // p4.a
    public boolean z(ValueCallback valueCallback, String str, String str2) {
        if (H()) {
            return super.z(valueCallback, str, str2);
        }
        Iterator it = this.f10955a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).z(valueCallback, str, str2)) {
                return true;
            }
        }
        return super.z(valueCallback, str, str2);
    }
}
