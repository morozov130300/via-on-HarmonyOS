package t4;

import android.R;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends WebView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12519c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12520e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f12521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12523o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12524p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12525q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f12526r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f12527s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ActionMode f12528t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List f12529u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public o4.b f12530v;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o4.a f12531a;

        public a(o4.a aVar) {
            this.f12531a = aVar;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            b.this.i(this.f12531a);
            return true;
        }
    }

    /* JADX INFO: renamed from: t4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class MenuItemOnMenuItemClickListenerC0125b implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o4.a f12533a;

        public MenuItemOnMenuItemClickListenerC0125b(o4.a aVar) {
            this.f12533a = aVar;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            b.this.i(this.f12533a);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o4.a f12535a;

        public c(o4.a aVar) {
            this.f12535a = aVar;
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            b.this.f12530v.a(this.f12535a, (str == null || str.length() <= 2 || str.charAt(0) != '\"') ? "" : str.substring(1, str.length() - 1).replace("\\\"", "\"").replace("\\\\", "\\"));
            b.this.n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f12537c;

        public d(WeakReference weakReference) {
            this.f12537c = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12537c.get() == null) {
                return;
            }
            b.this.n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface e {
        b a(Context context);
    }

    public b(Context context) {
        super(context);
        this.f12519c = 0;
        this.f12520e = Integer.MAX_VALUE;
        this.f12521m = null;
        this.f12522n = false;
        this.f12523o = 0;
        this.f12524p = 0;
        this.f12525q = false;
        this.f12526r = null;
        this.f12529u = null;
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        return this.f12520e > 0 && super.canGoForward();
    }

    public int getAccentColor() {
        return this.f12523o;
    }

    public int getFlags() {
        return this.f12519c;
    }

    public String getReferer() {
        return this.f12521m;
    }

    public int getTabId() {
        return this.f12524p;
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        String url = super.getUrl();
        return url != null ? url : this.f12527s;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (this.f12520e < Integer.MAX_VALUE && canGoBack()) {
            this.f12520e++;
        }
        super.goBack();
    }

    @Override // android.webkit.WebView
    public void goForward() {
        if (canGoForward()) {
            this.f12520e--;
        }
        super.goForward();
    }

    public void h(int i10) {
        this.f12519c = i10 | this.f12519c;
    }

    public final void i(o4.a aVar) {
        if (this.f12530v == null || aVar == null) {
            return;
        }
        evaluateJavascript("javascript:(function(){var win=window;try{while(true){var doc=win.document,active=doc.activeElement;if(active&&(active.tagName==='IFRAME'||active.tagName==='FRAME')){win=active.contentWindow;continue;}return win.getSelection?win.getSelection().toString():doc.getSelection?doc.getSelection().toString():doc.selection?doc.selection.createRange().text:'';}}catch(e){return '';}})();", new c(aVar));
        postDelayed(new d(new WeakReference(this.f12528t)), 100L);
    }

    public void j(int i10) {
        this.f12519c = (i10 ^ (-1)) & this.f12519c;
    }

    public void k() {
        n();
    }

    public final boolean l(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (this.f12519c == 0 && this.f12521m == null && this.f12526r == null) {
            super.loadUrl(str);
            return;
        }
        HashMap map = new HashMap();
        if ((this.f12519c & 1) == 1) {
            map.put("DNT", "1");
        }
        if ((this.f12519c & 2) == 2) {
            map.put("Save-Data", "on");
        }
        if ((this.f12519c & 4) == 4) {
            map.put("Sec-GPC", "1");
        }
        if (this.f12522n && this.f12521m != null) {
            if (!str.contains(".aliyundrive.net/")) {
                map.put("Referer", this.f12521m);
            }
            this.f12522n = false;
        }
        if ((this.f12519c & 8) == 8) {
            map.put("X-Requested-With", "");
            map.put("X-Wap-Profile", "");
        }
        String str2 = this.f12526r;
        if (str2 != null) {
            map.put("Accept-Language", str2);
        }
        super.loadUrl(str, map);
    }

    public boolean m() {
        return this.f12525q;
    }

    public final void n() {
        ActionMode actionMode = this.f12528t;
        if (actionMode == null) {
            return;
        }
        actionMode.finish();
        this.f12528t = null;
    }

    public void o() {
        this.f12520e = 0;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        if (z10 && getParent() != null) {
            this.f12525q = true;
        }
        super.onOverScrolled(i10, i11, z10, z11);
    }

    @Override // android.webkit.WebView
    public void onPause() {
        super.onPause();
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null && motionEvent.getAction() == 0) {
            this.f12525q = getUrl() == null;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final ActionMode p(ActionMode actionMode) {
        List list;
        Menu menu;
        this.f12528t = actionMode;
        if (actionMode != null && (list = this.f12529u) != null && !list.isEmpty() && getSettings().getJavaScriptEnabled() && (menu = actionMode.getMenu()) != null) {
            boolean z10 = false;
            int order = 0;
            for (int size = menu.size() - 1; size >= 0; size--) {
                MenuItem item = menu.getItem(size);
                String string = item.getTitle() == null ? null : item.getTitle().toString();
                if (string != null) {
                    if (string.equalsIgnoreCase(getContext().getString(R.string.selectAll))) {
                        order = item.getOrder();
                    } else if (string.equalsIgnoreCase(getContext().getString(R.string.copy))) {
                        z10 = true;
                    }
                    for (o4.a aVar : this.f12529u) {
                        if (aVar.c() != 0 && string.equalsIgnoreCase(aVar.b())) {
                            if (aVar.c() == 1) {
                                item.setVisible(false);
                            } else if (aVar.c() == 2) {
                                item.setOnMenuItemClickListener(new a(aVar));
                            }
                        }
                    }
                }
            }
            for (o4.a aVar2 : this.f12529u) {
                if (z10 && aVar2.c() == 0) {
                    menu.add(0, aVar2.a(), order, aVar2.b()).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0125b(aVar2));
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                actionMode.invalidateContentRect();
            }
        }
        return actionMode;
    }

    public void q() {
        this.f12520e = Integer.MAX_VALUE;
    }

    @Override // android.webkit.WebView
    public void reload() {
        String str;
        String url = super.getUrl();
        if (url == null && (str = this.f12527s) != null) {
            loadUrl(str);
            return;
        }
        if (this.f12527s == null) {
            this.f12527s = url;
        }
        super.reload();
    }

    @Override // android.webkit.WebView
    public WebBackForwardList restoreState(Bundle bundle) {
        setAccentColor(bundle.getInt("COLOR", this.f12523o));
        return super.restoreState(bundle);
    }

    @Override // android.webkit.WebView
    public WebBackForwardList saveState(Bundle bundle) {
        WebBackForwardList webBackForwardListSaveState = super.saveState(bundle);
        if (webBackForwardListSaveState != null) {
            bundle.putInt("COLOR", getAccentColor());
        }
        return webBackForwardListSaveState;
    }

    public void setAccentColor(int i10) {
        this.f12523o = i10;
    }

    public void setAcceptLanguageLocales(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f12526r = null;
            return;
        }
        if (!str.contains("en-US")) {
            str = str + ",en-US";
        }
        String[] strArrSplit = str.split(",");
        StringBuilder sb2 = new StringBuilder();
        HashSet hashSet = new HashSet();
        float fMax = 1.0f;
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String str2 = strArrSplit[i10];
            if (str2 != null && !str2.isEmpty() && !hashSet.contains(str2)) {
                hashSet.add(str2);
                fMax = Math.max(0.1f, fMax - 0.1f);
                sb2.append(',');
                sb2.append(str2);
                int iIndexOf = str2.indexOf(45);
                String strSubstring = iIndexOf > 0 ? str2.substring(0, iIndexOf) : str2;
                if (!str2.equals(strSubstring) && !hashSet.contains(strSubstring)) {
                    hashSet.add(strSubstring);
                    if (i10 == 0) {
                        sb2.append(',');
                        sb2.append(strSubstring);
                    } else {
                        sb2.append(";q=");
                        sb2.append(String.format(Locale.ROOT, "%.1f", Float.valueOf(fMax)));
                        sb2.append(',');
                        sb2.append(strSubstring);
                        fMax = Math.max(0.1f, fMax - 0.1f);
                    }
                }
                sb2.append(";q=");
                sb2.append(String.format(Locale.ROOT, "%.1f", Float.valueOf(fMax)));
            }
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(0);
            this.f12526r = sb2.toString();
        }
    }

    public void setActionItems(List<o4.a> list) {
        this.f12529u = list;
    }

    public void setFlags(int i10) {
        this.f12519c = i10;
    }

    public void setOnActionItemClickListener(o4.b bVar) {
        this.f12530v = bVar;
    }

    public void setReferer(String str) {
        if (!URLUtil.isNetworkUrl(str)) {
            str = null;
        }
        this.f12521m = str;
        this.f12522n = str != null;
    }

    public void setTabId(int i10) {
        this.f12524p = i10;
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return p(super.startActionMode(callback));
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        String url = super.getUrl();
        if (url != null) {
            this.f12527s = url;
        }
        super.stopLoading();
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback, int i10) {
        return p(super.startActionMode(callback, i10));
    }
}
