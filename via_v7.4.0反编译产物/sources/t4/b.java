package t4;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import q4.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends WebView implements a.c {

    /* renamed from: e, reason: collision with root package name */
    public int f12126e;

    /* renamed from: j, reason: collision with root package name */
    public int f12127j;

    /* renamed from: k, reason: collision with root package name */
    public String f12128k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12129l;

    /* renamed from: m, reason: collision with root package name */
    public int f12130m;

    /* renamed from: n, reason: collision with root package name */
    public int f12131n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12132o;

    /* renamed from: p, reason: collision with root package name */
    public String f12133p;

    /* renamed from: q, reason: collision with root package name */
    public String f12134q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12135r;

    /* renamed from: s, reason: collision with root package name */
    public q4.a f12136s;

    /* renamed from: t, reason: collision with root package name */
    public ActionMode f12137t;

    /* renamed from: u, reason: collision with root package name */
    public List f12138u;

    /* renamed from: v, reason: collision with root package name */
    public n4.b f12139v;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n4.a f12140a;

        public a(n4.a aVar) {
            this.f12140a = aVar;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            b.this.i(this.f12140a);
            return true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: t4.b$b, reason: collision with other inner class name */
    public class MenuItemOnMenuItemClickListenerC0123b implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n4.a f12142a;

        public MenuItemOnMenuItemClickListenerC0123b(n4.a aVar) {
            this.f12142a = aVar;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            b.this.i(this.f12142a);
            return true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n4.a f12144a;

        public c(n4.a aVar) {
            this.f12144a = aVar;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            b.this.f12139v.a(this.f12144a, (str == null || str.length() <= 2 || str.charAt(0) != '\"') ? "" : str.substring(1, str.length() - 1).replace("\\\"", "\"").replace("\\\\", "\\"));
            b.this.o();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ WeakReference f12146e;

        public d(WeakReference weakReference) {
            this.f12146e = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12146e.get() == null) {
                return;
            }
            b.this.o();
        }
    }

    public b(Context context) {
        super(context);
        this.f12126e = 0;
        this.f12127j = Integer.MAX_VALUE;
        this.f12128k = null;
        this.f12129l = false;
        this.f12130m = 0;
        this.f12131n = 0;
        this.f12132o = false;
        this.f12133p = null;
        this.f12135r = false;
        this.f12138u = null;
        this.f12136s = new a.b(this).e(TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics())).a();
    }

    @Override // q4.a.c
    public int a() {
        return super.computeVerticalScrollRange();
    }

    @Override // android.view.View
    public boolean awakenScrollBars() {
        return this.f12136s.c();
    }

    @Override // q4.a.c
    public void b(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
    }

    @Override // q4.a.c
    public int c() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        return this.f12127j > 0 && super.canGoForward();
    }

    @Override // q4.a.c
    public int d() {
        return super.computeVerticalScrollOffset();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f12136s.e(canvas);
    }

    public int getAccentColor() {
        return this.f12130m;
    }

    public q4.a getDelegate() {
        return getFastScrollDelegate();
    }

    @Override // q4.a.c
    public q4.a getFastScrollDelegate() {
        return this.f12136s;
    }

    @Override // q4.a.c
    public View getFastScrollableView() {
        return this;
    }

    public int getFlags() {
        return this.f12126e;
    }

    public String getReferer() {
        return this.f12128k;
    }

    public int getTabId() {
        return this.f12131n;
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        String url = super.getUrl();
        return url != null ? url : this.f12134q;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (this.f12127j < Integer.MAX_VALUE && canGoBack()) {
            this.f12127j++;
        }
        super.goBack();
    }

    @Override // android.webkit.WebView
    public void goForward() {
        if (canGoForward()) {
            this.f12127j--;
        }
        super.goForward();
    }

    public void h(int i10) {
        this.f12126e = i10 | this.f12126e;
    }

    public final void i(n4.a aVar) {
        if (this.f12139v == null || aVar == null) {
            return;
        }
        evaluateJavascript("javascript:(function(){return window.getSelection?window.getSelection().toString():window.document.getSelection?window.document.getSelection().toString():window.document.selection?window.document.selection.createRange().text:\"\"})();", new c(aVar));
        postDelayed(new d(new WeakReference(this.f12137t)), 100L);
    }

    public void j(int i10) {
        this.f12126e = (i10 ^ (-1)) & this.f12126e;
    }

    public void k() {
        o();
    }

    public boolean l() {
        return this.f12132o;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (this.f12126e == 0 && this.f12128k == null && this.f12133p == null) {
            super.loadUrl(str);
            return;
        }
        HashMap map = new HashMap();
        if ((this.f12126e & 1) == 1) {
            map.put("DNT", "1");
        }
        if ((this.f12126e & 2) == 2) {
            map.put("Save-Data", "on");
        }
        if ((this.f12126e & 4) == 4) {
            map.put("Sec-GPC", "1");
        }
        if (this.f12129l && this.f12128k != null) {
            if (!str.contains(".aliyundrive.net/")) {
                map.put("Referer", this.f12128k);
            }
            this.f12129l = false;
        }
        if ((this.f12126e & 8) == 8) {
            map.put("X-Requested-With", "");
            map.put("X-Wap-Profile", "");
        }
        String str2 = this.f12133p;
        if (str2 != null) {
            map.put("Accept-Language", str2);
        }
        super.loadUrl(str, map);
    }

    public boolean m() {
        return this.f12136s.h();
    }

    public void n() {
        s4.b.g(this, "javascript:(function(){for(var c=document.querySelectorAll(\"video, audio\"),a,b=0;b<c.length;b++)a=c[b],a.paused||(a.pause(),a.setAttribute(\"via-data-playing\",\"true\"))})();");
        this.f12135r = true;
    }

    public final void o() {
        ActionMode actionMode = this.f12137t;
        if (actionMode == null) {
            return;
        }
        actionMode.finish();
        this.f12137t = null;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12136s.i();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f12136s.l(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        if (z10 && getParent() != null) {
            this.f12132o = true;
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
        if (this.f12136s.n(motionEvent)) {
            return true;
        }
        if (getParent() != null && motionEvent.getAction() == 0) {
            this.f12132o = getUrl() == null;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        q4.a aVar = this.f12136s;
        if (aVar != null) {
            aVar.p(view, i10);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f12136s.q(i10);
    }

    public void p() {
        this.f12127j = 0;
    }

    public final ActionMode q(ActionMode actionMode) {
        List list;
        Menu menu;
        this.f12137t = actionMode;
        if (actionMode != null && (list = this.f12138u) != null && !list.isEmpty() && getSettings().getJavaScriptEnabled() && (menu = actionMode.getMenu()) != null) {
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
                    for (n4.a aVar : this.f12138u) {
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
            for (n4.a aVar2 : this.f12138u) {
                if (z10 && aVar2.c() == 0) {
                    menu.add(0, aVar2.a(), order, aVar2.b()).setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0123b(aVar2));
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                actionMode.invalidateContentRect();
            }
        }
        return actionMode;
    }

    public void r() {
        if (this.f12135r) {
            s4.b.g(this, "javascript:(function(){for(var c=document.querySelectorAll('video[via-data-playing=\"true\"], audio[via-data-playing=\"true\"]'),a,b=0;b<c.length;b++)a=c[b],a.play(),a.removeAttribute(\"via-data-playing\")})();");
            this.f12135r = false;
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        String str;
        String url = super.getUrl();
        if (url == null && (str = this.f12134q) != null) {
            loadUrl(str);
            return;
        }
        if (this.f12134q == null) {
            this.f12134q = url;
        }
        super.reload();
    }

    @Override // android.webkit.WebView
    public WebBackForwardList restoreState(Bundle bundle) {
        setAccentColor(bundle.getInt("COLOR", this.f12130m));
        return super.restoreState(bundle);
    }

    public void s() {
        this.f12127j = Integer.MAX_VALUE;
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
        this.f12130m = i10;
    }

    public void setAcceptLanguageLocales(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f12133p = null;
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
            this.f12133p = sb2.toString();
        }
    }

    public void setActionItems(List<n4.a> list) {
        this.f12138u = list;
    }

    public void setFastScrollDelegate(q4.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("setNewFastScrollDelegate must NOT be NULL.");
        }
        this.f12136s.j();
        this.f12136s = aVar;
        aVar.i();
    }

    public void setFlags(int i10) {
        this.f12126e = i10;
    }

    public void setOnActionItemClickListener(n4.b bVar) {
        this.f12139v = bVar;
    }

    public void setReferer(String str) {
        if (!URLUtil.isNetworkUrl(str)) {
            str = null;
        }
        this.f12128k = str;
        this.f12129l = str != null;
    }

    public void setTabId(int i10) {
        this.f12131n = i10;
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return q(super.startActionMode(callback));
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback, int i10) {
        return q(super.startActionMode(callback, i10));
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        String url = super.getUrl();
        if (url != null) {
            this.f12134q = url;
        }
        super.stopLoading();
    }
}
