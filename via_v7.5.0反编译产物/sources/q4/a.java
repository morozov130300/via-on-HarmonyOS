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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public boolean A(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        return false;
    }

    public boolean B(ValueCallback valueCallback, String str, String str2) {
        return false;
    }

    public boolean C(t4.b bVar, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return false;
    }

    public WebResourceResponse H(t4.b bVar, WebResourceRequest webResourceRequest, String str, String str2) {
        return null;
    }

    public boolean I(t4.b bVar, k kVar) {
        return false;
    }

    public View a() {
        return null;
    }

    public boolean b(t4.b bVar) {
        return false;
    }

    public boolean c(ConsoleMessage consoleMessage) {
        return false;
    }

    public boolean d(String str, int i10, String str2) {
        return false;
    }

    public boolean e(t4.b bVar, boolean z10, boolean z11, Message message) {
        return false;
    }

    public boolean f(t4.b bVar, Message message, Message message2) {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h(String str, GeolocationPermissions.Callback callback) {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean j(t4.b bVar, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean k(t4.b bVar, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean l(t4.b bVar, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean m(t4.b bVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    public boolean n(t4.b bVar, k kVar) {
        return false;
    }

    public boolean q(PermissionRequest permissionRequest) {
        return false;
    }

    public boolean r(PermissionRequest permissionRequest) {
        return false;
    }

    public void s(t4.b bVar, k kVar) {
        D(bVar, kVar.b());
    }

    public boolean u(t4.b bVar, HttpAuthHandler httpAuthHandler, String str, String str2) {
        return false;
    }

    public boolean w(t4.b bVar, int i10, String str, String str2) {
        return false;
    }

    public boolean x(t4.b bVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        return false;
    }

    public void F(t4.b bVar) {
    }

    public void D(t4.b bVar, String str) {
    }

    public void E(t4.b bVar, int i10) {
    }

    public void G(t4.b bVar, int i10) {
    }

    public void o(t4.b bVar, String str) {
    }

    public void t(t4.b bVar, int i10) {
    }

    public void v(t4.b bVar, Bitmap bitmap) {
    }

    public void y(t4.b bVar, String str) {
    }

    public void p(t4.b bVar, String str, Bitmap bitmap) {
    }

    public void z(t4.b bVar, String str, boolean z10) {
    }
}
