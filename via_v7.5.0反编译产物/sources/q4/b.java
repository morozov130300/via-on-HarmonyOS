package q4;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f11733a = null;

    @Override // q4.a
    public boolean A(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (K()) {
            return super.A(view, customViewCallback);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).A(view, customViewCallback)) {
                return true;
            }
        }
        return super.A(view, customViewCallback);
    }

    @Override // q4.a
    public boolean B(ValueCallback valueCallback, String str, String str2) {
        if (K()) {
            return super.B(valueCallback, str, str2);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).B(valueCallback, str, str2)) {
                return true;
            }
        }
        return super.B(valueCallback, str, str2);
    }

    @Override // q4.a
    public boolean C(t4.b bVar, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (K()) {
            return super.C(bVar, valueCallback, fileChooserParams);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).C(bVar, valueCallback, fileChooserParams)) {
                return true;
            }
        }
        return super.C(bVar, valueCallback, fileChooserParams);
    }

    @Override // q4.a
    public void D(t4.b bVar, String str) {
        if (K()) {
            super.D(bVar, str);
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).D(bVar, str);
        }
    }

    @Override // q4.a
    public void E(t4.b bVar, int i10) {
        if (K()) {
            super.E(bVar, i10);
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).E(bVar, i10);
        }
    }

    @Override // q4.a
    public void F(t4.b bVar) {
        if (K()) {
            super.F(bVar);
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).F(bVar);
        }
    }

    @Override // q4.a
    public void G(t4.b bVar, int i10) {
        if (K()) {
            super.G(bVar, i10);
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).G(bVar, i10);
        }
    }

    @Override // q4.a
    public WebResourceResponse H(t4.b bVar, WebResourceRequest webResourceRequest, String str, String str2) {
        if (K()) {
            return super.H(bVar, webResourceRequest, str, str2);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            WebResourceResponse webResourceResponseH = ((a) it.next()).H(bVar, webResourceRequest, str, str2);
            if (webResourceResponseH != null) {
                return webResourceResponseH;
            }
        }
        return super.H(bVar, webResourceRequest, str, str2);
    }

    @Override // q4.a
    public boolean I(t4.b bVar, k kVar) {
        if (K()) {
            return false;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).I(bVar, kVar)) {
                return true;
            }
        }
        return false;
    }

    public void J(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f11733a == null) {
            this.f11733a = new ArrayList();
        }
        this.f11733a.add(aVar);
    }

    public final boolean K() {
        List list = this.f11733a;
        return list == null || list.isEmpty();
    }

    public void L() {
        List list = this.f11733a;
        if (list == null) {
            return;
        }
        list.clear();
        this.f11733a = null;
    }

    @Override // q4.a
    public View a() {
        if (K()) {
            return super.a();
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            View viewA = ((a) it.next()).a();
            if (viewA != null) {
                return viewA;
            }
        }
        return super.a();
    }

    @Override // q4.a
    public boolean b(t4.b bVar) {
        if (K()) {
            return super.b(bVar);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).b(bVar)) {
                return true;
            }
        }
        return super.b(bVar);
    }

    @Override // q4.a
    public boolean c(ConsoleMessage consoleMessage) {
        if (K()) {
            return super.c(consoleMessage);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).c(consoleMessage)) {
                return true;
            }
        }
        return super.c(consoleMessage);
    }

    @Override // q4.a
    public boolean d(String str, int i10, String str2) {
        if (K()) {
            return super.d(str, i10, str2);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).d(str, i10, str2)) {
                return true;
            }
        }
        return super.d(str, i10, str2);
    }

    @Override // q4.a
    public boolean e(t4.b bVar, boolean z10, boolean z11, Message message) {
        if (K()) {
            return super.e(bVar, z10, z11, message);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).e(bVar, z10, z11, message)) {
                return true;
            }
        }
        return super.e(bVar, z10, z11, message);
    }

    @Override // q4.a
    public boolean f(t4.b bVar, Message message, Message message2) {
        if (K()) {
            return super.f(bVar, message, message2);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).f(bVar, message, message2)) {
                return true;
            }
        }
        return super.f(bVar, message, message2);
    }

    @Override // q4.a
    public boolean g() {
        if (K()) {
            return super.g();
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).g()) {
                return true;
            }
        }
        return super.g();
    }

    @Override // q4.a
    public boolean h(String str, GeolocationPermissions.Callback callback) {
        if (K()) {
            return super.h(str, callback);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).h(str, callback)) {
                return true;
            }
        }
        return super.h(str, callback);
    }

    @Override // q4.a
    public boolean i() {
        if (K()) {
            return super.i();
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).i()) {
                return true;
            }
        }
        return super.i();
    }

    @Override // q4.a
    public boolean j(t4.b bVar, String str, String str2, JsResult jsResult) {
        if (K()) {
            return super.j(bVar, str, str2, jsResult);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).j(bVar, str, str2, jsResult)) {
                return true;
            }
        }
        return super.j(bVar, str, str2, jsResult);
    }

    @Override // q4.a
    public boolean k(t4.b bVar, String str, String str2, JsResult jsResult) {
        if (K()) {
            return super.k(bVar, str, str2, jsResult);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).k(bVar, str, str2, jsResult)) {
                return true;
            }
        }
        return super.k(bVar, str, str2, jsResult);
    }

    @Override // q4.a
    public boolean l(t4.b bVar, String str, String str2, JsResult jsResult) {
        if (K()) {
            return super.l(bVar, str, str2, jsResult);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).l(bVar, str, str2, jsResult)) {
                return true;
            }
        }
        return super.l(bVar, str, str2, jsResult);
    }

    @Override // q4.a
    public boolean m(t4.b bVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (K()) {
            return super.m(bVar, str, str2, str3, jsPromptResult);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            t4.b bVar2 = bVar;
            if (((a) it.next()).m(bVar2, str, str2, str3, jsPromptResult)) {
                return true;
            }
            bVar = bVar2;
        }
        return super.m(bVar, str, str2, str3, jsPromptResult);
    }

    @Override // q4.a
    public boolean n(t4.b bVar, k kVar) {
        if (K()) {
            return false;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).n(bVar, kVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // q4.a
    public void o(t4.b bVar, String str) {
        super.o(bVar, str);
        if (K()) {
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).o(bVar, str);
        }
    }

    @Override // q4.a
    public void p(t4.b bVar, String str, Bitmap bitmap) {
        super.p(bVar, str, bitmap);
        if (K()) {
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).p(bVar, str, bitmap);
        }
    }

    @Override // q4.a
    public boolean q(PermissionRequest permissionRequest) {
        if (K()) {
            return super.q(permissionRequest);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).q(permissionRequest)) {
                return true;
            }
        }
        return super.q(permissionRequest);
    }

    @Override // q4.a
    public boolean r(PermissionRequest permissionRequest) {
        if (K()) {
            return super.r(permissionRequest);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).r(permissionRequest)) {
                return true;
            }
        }
        return super.r(permissionRequest);
    }

    @Override // q4.a
    public void s(t4.b bVar, k kVar) {
        if (K()) {
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).s(bVar, kVar);
        }
    }

    @Override // q4.a
    public void t(t4.b bVar, int i10) {
        super.t(bVar, i10);
        if (K()) {
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).t(bVar, i10);
        }
    }

    @Override // q4.a
    public boolean u(t4.b bVar, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (K()) {
            return super.u(bVar, httpAuthHandler, str, str2);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).u(bVar, httpAuthHandler, str, str2)) {
                return true;
            }
        }
        return super.u(bVar, httpAuthHandler, str, str2);
    }

    @Override // q4.a
    public void v(t4.b bVar, Bitmap bitmap) {
        super.v(bVar, bitmap);
        if (K()) {
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).v(bVar, bitmap);
        }
    }

    @Override // q4.a
    public boolean w(t4.b bVar, int i10, String str, String str2) {
        if (K()) {
            return super.w(bVar, i10, str, str2);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).w(bVar, i10, str, str2)) {
                return true;
            }
        }
        return super.w(bVar, i10, str, str2);
    }

    @Override // q4.a
    public boolean x(t4.b bVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (K()) {
            return super.x(bVar, sslErrorHandler, sslError);
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).x(bVar, sslErrorHandler, sslError)) {
                return true;
            }
        }
        return super.x(bVar, sslErrorHandler, sslError);
    }

    @Override // q4.a
    public void y(t4.b bVar, String str) {
        super.y(bVar, str);
        if (K()) {
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).y(bVar, str);
        }
    }

    @Override // q4.a
    public void z(t4.b bVar, String str, boolean z10) {
        super.z(bVar, str, z10);
        if (K()) {
            return;
        }
        Iterator it = this.f11733a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).z(bVar, str, z10);
        }
    }
}
