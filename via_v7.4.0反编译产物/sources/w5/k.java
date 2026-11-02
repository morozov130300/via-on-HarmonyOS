package w5;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Insets;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import g6.y;
import h6.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mark.via.common.widget.MaxHeightLayout;
import x7.r;
import x7.v;
import z8.l3;
import z8.n0;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f13286a;

    /* renamed from: b, reason: collision with root package name */
    public o f13287b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13288c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13289d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13290e;

    /* renamed from: f, reason: collision with root package name */
    public View f13291f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference f13292g = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = k.this.f13287b.f13328q;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            k.this.n();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = k.this.f13287b.f13330s;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            k.this.n();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f13295a;

        public c(m mVar) {
            this.f13295a = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13295a.a(view, k.this.o());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ListView f13297e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f13298j;

        public d(ListView listView, int i10) {
            this.f13297e = listView;
            this.f13298j = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13297e.smoothScrollToPositionFromTop(this.f13298j, 0);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            AdapterView.OnItemClickListener onItemClickListener = k.this.f13287b.f13321j;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i10, j10);
            }
            k.this.n();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ListView f13301e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f13302j;

        public f(ListView listView, int i10) {
            this.f13301e = listView;
            this.f13302j = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13301e.smoothScrollToPositionFromTop(this.f13302j, 0);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class g implements AdapterView.OnItemClickListener {
        public g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            AdapterView.OnItemClickListener onItemClickListener = k.this.f13287b.f13321j;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i10, j10);
            }
            k.this.n();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class h implements AdapterView.OnItemLongClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
            AdapterView.OnItemLongClickListener onItemLongClickListener = k.this.f13287b.f13322k;
            return onItemLongClickListener != null && onItemLongClickListener.onItemLongClick(adapterView, view, i10, j10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class i implements CompoundButton.OnCheckedChangeListener {
        public i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            k.this.f13287b.f13318g = Boolean.valueOf(z10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class j implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f13307a;

        public j(CheckBox checkBox) {
            this.f13307a = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f13307a.setChecked(!r2.isChecked());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: w5.k$k, reason: collision with other inner class name */
    public class ViewOnClickListenerC0149k implements View.OnClickListener {
        public ViewOnClickListenerC0149k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p pVarO = k.this.o();
            k kVar = k.this;
            o oVar = kVar.f13287b;
            if (!oVar.f13319h || pVarO.f13338b) {
                m mVar = oVar.f13326o;
                if (mVar != null) {
                    mVar.a(view, pVarO);
                }
                k.this.n();
                return;
            }
            View viewFindViewById = kVar.f13291f.findViewById(x7.p.f13801f);
            View viewFindViewById2 = k.this.f13291f.findViewById(x7.p.f13839r1);
            y.X(viewFindViewById);
            y.X(viewFindViewById2);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public int f13310a;

        /* renamed from: b, reason: collision with root package name */
        public String f13311b;

        public l(int i10, String str) {
            this.f13310a = i10;
            this.f13311b = str;
        }

        public int a() {
            return this.f13310a;
        }

        public String b() {
            return this.f13311b;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface m {
        void a(View view, p pVar);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface n {
        void a(View view);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public Context f13312a;

        /* renamed from: b, reason: collision with root package name */
        public int f13313b;

        /* renamed from: c, reason: collision with root package name */
        public int f13314c;

        /* renamed from: d, reason: collision with root package name */
        public String f13315d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f13316e;

        /* renamed from: f, reason: collision with root package name */
        public String f13317f;

        /* renamed from: g, reason: collision with root package name */
        public Boolean f13318g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f13319h;

        /* renamed from: i, reason: collision with root package name */
        public ListAdapter f13320i;

        /* renamed from: j, reason: collision with root package name */
        public AdapterView.OnItemClickListener f13321j;

        /* renamed from: k, reason: collision with root package name */
        public AdapterView.OnItemLongClickListener f13322k;

        /* renamed from: l, reason: collision with root package name */
        public View f13323l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f13324m;

        /* renamed from: n, reason: collision with root package name */
        public String f13325n;

        /* renamed from: o, reason: collision with root package name */
        public m f13326o;

        /* renamed from: p, reason: collision with root package name */
        public String f13327p;

        /* renamed from: q, reason: collision with root package name */
        public View.OnClickListener f13328q;

        /* renamed from: r, reason: collision with root package name */
        public String f13329r;

        /* renamed from: s, reason: collision with root package name */
        public View.OnClickListener f13330s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f13331t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f13332u;

        /* renamed from: v, reason: collision with root package name */
        public DialogInterface.OnDismissListener f13333v;

        /* renamed from: w, reason: collision with root package name */
        public DialogInterface.OnCancelListener f13334w;

        /* renamed from: x, reason: collision with root package name */
        public int f13335x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f13336y;

        public o() {
            this.f13313b = 0;
            this.f13314c = 0;
            this.f13319h = false;
            this.f13331t = true;
            this.f13332u = true;
            this.f13335x = -1;
            this.f13336y = false;
        }

        public /* synthetic */ o(c cVar) {
            this();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class p {

        /* renamed from: a, reason: collision with root package name */
        public int[] f13337a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f13338b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f13339c;

        public static p a() {
            return new p();
        }

        public String toString() {
            return "Result{selected=" + Arrays.toString(this.f13337a) + ", checked=" + this.f13338b + ", edit=" + Arrays.toString(this.f13339c) + '}';
        }
    }

    public k(Context context) {
        o oVar = new o(null);
        this.f13287b = oVar;
        oVar.f13312a = context;
        View viewFindViewById = ((Activity) context).findViewById(R.id.content);
        if (viewFindViewById == null) {
            this.f13288c = y.y(context);
            this.f13289d = y.z(context);
            this.f13290e = y.u(context);
        } else {
            this.f13288c = viewFindViewById.getHeight();
            this.f13289d = viewFindViewById.getWidth();
            int[] iArr = new int[2];
            viewFindViewById.getLocationOnScreen(iArr);
            this.f13290e = iArr[1];
        }
    }

    public static /* synthetic */ void a(HorizontalScrollView horizontalScrollView) {
        horizontalScrollView.setFillViewport(true);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setVerticalScrollBarEnabled(false);
        r3.f(horizontalScrollView);
    }

    public static /* synthetic */ void b(k kVar, String str, String str2, int i10, EditText editText) {
        kVar.getClass();
        editText.setText(str);
        editText.setHint(str2);
        editText.setMaxLines(i10);
        editText.setMinLines(i10);
        editText.setLines(i10);
        editText.setEllipsize(TextUtils.TruncateAt.END);
        if (i10 > 1) {
            editText.setInputType(671745);
            editText.setImeOptions(1);
        } else {
            editText.setInputType(524289);
            editText.setImeOptions(5);
        }
        editText.setTextColor(x8.h.p(kVar.f13287b.f13312a));
        editText.setHintTextColor(x8.h.q(kVar.f13287b.f13312a));
        x8.g.m(editText, x8.h.r(kVar.f13287b.f13312a));
        editText.setGravity(48);
        editText.setSelectAllOnFocus(i10 <= 3);
        x8.g.h(editText);
    }

    public static /* synthetic */ void c(k kVar, DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener = kVar.f13287b.f13333v;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
        WeakReference weakReference = kVar.f13292g;
        com.tuyafeng.support.widget.y yVar = weakReference == null ? null : (com.tuyafeng.support.widget.y) weakReference.get();
        if (yVar != null) {
            yVar.setGestureEnabled(true);
        }
    }

    public static k l(Context context) {
        return new k(context);
    }

    public k A(int i10) {
        o oVar = this.f13287b;
        oVar.f13317f = oVar.f13312a.getString(i10);
        return this;
    }

    public k B(int i10) {
        this.f13287b.f13313b = i10;
        return this;
    }

    public k C(List list, AdapterView.OnItemClickListener onItemClickListener) {
        return D(list, onItemClickListener, null);
    }

    public k D(List list, AdapterView.OnItemClickListener onItemClickListener, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        return E(list, false, onItemClickListener, onItemLongClickListener);
    }

    public k E(List list, boolean z10, AdapterView.OnItemClickListener onItemClickListener, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        w5.c cVar = new w5.c(this.f13287b.f13312a, list);
        cVar.c(z10);
        o oVar = this.f13287b;
        oVar.f13320i = cVar;
        oVar.f13321j = onItemClickListener;
        oVar.f13322k = onItemLongClickListener;
        return this;
    }

    public k F(String[] strArr, AdapterView.OnItemClickListener onItemClickListener) {
        return G(strArr, onItemClickListener, null);
    }

    public k G(String[] strArr, AdapterView.OnItemClickListener onItemClickListener, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        return H(strArr, false, onItemClickListener, onItemLongClickListener);
    }

    public k H(String[] strArr, boolean z10, AdapterView.OnItemClickListener onItemClickListener, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(new l(i10, strArr[i10]));
        }
        return E(arrayList, z10, onItemClickListener, onItemLongClickListener);
    }

    public k I(int i10) {
        o oVar = this.f13287b;
        oVar.f13316e = oVar.f13312a.getString(i10);
        return this;
    }

    public k J(CharSequence charSequence) {
        this.f13287b.f13316e = charSequence;
        return this;
    }

    public k K(int i10, int[] iArr) {
        return L(this.f13287b.f13312a.getResources().getStringArray(i10), iArr);
    }

    public k L(String[] strArr, int[] iArr) {
        this.f13287b.f13320i = new w5.d(Arrays.asList(strArr), iArr, true);
        return this;
    }

    public k M(boolean z10) {
        this.f13287b.f13319h = z10;
        return this;
    }

    public k N(int i10, View.OnClickListener onClickListener) {
        return O(this.f13287b.f13312a.getString(i10), onClickListener);
    }

    public k O(String str, View.OnClickListener onClickListener) {
        o oVar = this.f13287b;
        oVar.f13327p = str;
        oVar.f13328q = onClickListener;
        return this;
    }

    public k P(int i10, m mVar) {
        return Q(this.f13287b.f13312a.getString(i10), mVar);
    }

    public k Q(String str, m mVar) {
        return O(str, mVar != null ? new c(mVar) : null);
    }

    public k R(int i10, View.OnClickListener onClickListener) {
        return S(this.f13287b.f13312a.getString(i10), onClickListener);
    }

    public k S(String str, View.OnClickListener onClickListener) {
        o oVar = this.f13287b;
        oVar.f13329r = str;
        oVar.f13330s = onClickListener;
        return this;
    }

    public k T(DialogInterface.OnCancelListener onCancelListener) {
        this.f13287b.f13334w = onCancelListener;
        return this;
    }

    public k U(DialogInterface.OnDismissListener onDismissListener) {
        this.f13287b.f13333v = onDismissListener;
        return this;
    }

    public k V(int i10, m mVar) {
        return W(this.f13287b.f13312a.getString(i10), mVar);
    }

    public k W(String str, m mVar) {
        o oVar = this.f13287b;
        oVar.f13325n = str;
        oVar.f13326o = mVar;
        return this;
    }

    public k X(int i10) {
        return Y(this.f13287b.f13312a.getString(i10));
    }

    public k Y(String str) {
        if (str != null && !str.isEmpty()) {
            LinearLayout linearLayout = new LinearLayout(this.f13287b.f13312a);
            linearLayout.setOrientation(0);
            ProgressBar progressBar = new ProgressBar(this.f13287b.f13312a);
            progressBar.setIndeterminate(false);
            progressBar.setIndeterminateDrawable(g6.f.e(this.f13287b.f13312a, x7.o.f13735j));
            TextView textView = new TextView(this.f13287b.f13312a);
            int iH = y.h(this.f13287b.f13312a, 4.0f);
            int iH2 = y.h(this.f13287b.f13312a, 16.0f);
            y.U(linearLayout, iH2, iH, iH2, iH);
            y.U(progressBar, 0, 0, 0, 0);
            y.U(textView, iH2, 0, 0, 0);
            androidx.core.widget.c.b(textView, v.f14261h);
            linearLayout.addView(progressBar);
            linearLayout.addView(textView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.gravity = 16;
            textView.setLayoutParams(layoutParams);
            textView.setText(str);
            this.f13287b.f13323l = linearLayout;
        }
        return this;
    }

    public k Z(int i10, int i11, AdapterView.OnItemClickListener onItemClickListener) {
        return b0(this.f13287b.f13312a.getResources().getStringArray(i10), i11, onItemClickListener);
    }

    public k a0(String[] strArr, int i10) {
        this.f13287b.f13320i = new w5.d(Arrays.asList(strArr), new int[]{i10}, false);
        return this;
    }

    public k b0(String[] strArr, int i10, AdapterView.OnItemClickListener onItemClickListener) {
        this.f13287b.f13320i = new w5.d(Arrays.asList(strArr), new int[]{i10}, false);
        this.f13287b.f13321j = onItemClickListener;
        return this;
    }

    public k c0(String[] strArr, int i10, AdapterView.OnItemClickListener onItemClickListener) {
        this.f13287b.f13320i = new w5.b(Arrays.asList(strArr), new int[]{i10}, false);
        this.f13287b.f13321j = onItemClickListener;
        return this;
    }

    public k d0(int i10) {
        o oVar = this.f13287b;
        oVar.f13315d = oVar.f13312a.getString(i10);
        return this;
    }

    public k e0(String str) {
        this.f13287b.f13315d = str;
        return this;
    }

    public k f(int i10, String str, int i11, int i12) {
        return g(i10, str, this.f13287b.f13312a.getString(i11), i12);
    }

    public void f0() {
        o oVar;
        if (this.f13286a == null && (oVar = this.f13287b) != null) {
            boolean zE = y.E(oVar.f13312a);
            int i10 = this.f13287b.f13324m ? 8 : 6;
            int iMin = Math.min(this.f13289d, this.f13288c) - y.h(this.f13287b.f13312a, 72.0f);
            if ((zE || this.f13289d > this.f13288c) && iMin > y.h(this.f13287b.f13312a, i10 * 60)) {
                iMin = y.h(this.f13287b.f13312a, (i10 - 1) * 60);
            }
            int i11 = this.f13287b.f13313b;
            if (i11 > 0) {
                iMin = Math.min(iMin, i11);
            }
            int iMin2 = (this.f13288c / 7) * 4;
            int i12 = this.f13287b.f13314c;
            if (i12 > 0) {
                iMin2 = Math.min(iMin2, i12);
            }
            Dialog dialogM = m(iMin, iMin2, false);
            this.f13286a = dialogM;
            dialogM.setCancelable(this.f13287b.f13331t);
            Dialog dialog = this.f13286a;
            o oVar2 = this.f13287b;
            dialog.setCanceledOnTouchOutside(oVar2.f13331t && oVar2.f13332u);
            q(this.f13286a);
            this.f13286a.setOnCancelListener(this.f13287b.f13334w);
            if (this.f13286a.getWindow() != null) {
                WindowManager.LayoutParams attributes = this.f13286a.getWindow().getAttributes();
                attributes.width = iMin;
                attributes.gravity = 17;
                this.f13286a.getWindow().setAttributes(attributes);
                if (n0.c(this.f13287b.f13312a)) {
                    l3.n(this.f13286a.getWindow(), true);
                }
                k(this.f13286a.getWindow(), false);
            }
        }
        j0();
    }

    public k g(int i10, final String str, final String str2, final int i11) {
        ViewGroup viewGroup;
        o oVar = this.f13287b;
        oVar.f13324m = true;
        View view = oVar.f13323l;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            LinearLayout linearLayout = new LinearLayout(this.f13287b.f13312a);
            linearLayout.setOrientation(1);
            this.f13287b.f13323l = linearLayout;
            viewGroup = linearLayout;
        }
        EditText editText = (EditText) new h6.a(new EditText(this.f13287b.f13312a), new FrameLayout.LayoutParams(-1, -2)).o(i10).X(i11 == 1 ? -2 : -1).d(x7.o.f13729h).T(1, i11 == 1 ? 0 : 8).x(1, i11 == 1 ? 0 : 12).t(1, i11 == 1 ? 0 : 12).V(new a.InterfaceC0076a() { // from class: w5.i
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k.b(this.f13282a, str, str2, i11, (EditText) obj);
            }
        }).l();
        if (i11 != 1) {
            viewGroup.addView(editText);
            return this;
        }
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) new h6.a(new HorizontalScrollView(this.f13287b.f13312a), new FrameLayout.LayoutParams(-1, -2)).d(x7.o.f13729h).x(1, 16).t(1, 12).T(1, 8).V(new a.InterfaceC0076a() { // from class: w5.j
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k.a((HorizontalScrollView) obj);
            }
        }).l();
        editText.setBackgroundColor(0);
        horizontalScrollView.addView(editText);
        viewGroup.addView(horizontalScrollView);
        return this;
    }

    public void g0(int i10, int i11) {
        o oVar;
        int i12;
        int i13;
        WindowManager windowManager;
        int i14;
        if (this.f13286a == null && (oVar = this.f13287b) != null) {
            int iMin = Math.min(y.h(oVar.f13312a, 240.0f), (Math.min(this.f13288c, this.f13289d) / 7) * (oVar.f13324m ? 5 : 4));
            int i15 = this.f13287b.f13313b;
            if (i15 > 0) {
                iMin = Math.min(i15, iMin);
            }
            int iMin2 = (this.f13288c * 3) / 5;
            int i16 = this.f13287b.f13314c;
            if (i16 > 0) {
                iMin2 = Math.min(iMin2, i16);
            }
            Dialog dialogM = m(iMin, iMin2, true);
            this.f13286a = dialogM;
            Window window = dialogM.getWindow();
            if (window != null) {
                window.getDecorView().measure(View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                window.setSoftInputMode(16);
                WindowManager.LayoutParams attributes = window.getAttributes();
                int i17 = this.f13289d;
                if (i10 > (i17 >> 1)) {
                    i10 -= iMin;
                }
                if (i10 <= 10) {
                    i10 = y.h(this.f13287b.f13312a, 12.0f);
                } else if (i10 + iMin >= i17 - 10) {
                    i10 = (i17 - iMin) - y.h(this.f13287b.f13312a, 12.0f);
                }
                int i18 = this.f13288c;
                boolean z10 = i11 > (i18 >> 1);
                if (z10) {
                    i11 = i18 - i11;
                    i12 = 80;
                } else {
                    i12 = 48;
                }
                int i19 = this.f13290e;
                if (i19 > 0) {
                    i11 = z10 ? i11 + i19 : i11 - i19;
                }
                if (l3.f14720a && (i13 = Build.VERSION.SDK_INT) >= 30 && (windowManager = (WindowManager) this.f13287b.f13312a.getSystemService(WindowManager.class)) != null) {
                    WindowInsets windowInsets = windowManager.getCurrentWindowMetrics().getWindowInsets();
                    boolean zIsVisible = windowInsets.isVisible(WindowInsets.Type.statusBars());
                    Insets insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
                    if (zIsVisible) {
                        i14 = z10 ? insetsIgnoringVisibility.bottom : insetsIgnoringVisibility.top;
                    } else if (i13 >= 35) {
                        if (!z10) {
                            i14 = insetsIgnoringVisibility.top;
                        }
                    } else if (i13 >= 30 && z10) {
                        i14 = insetsIgnoringVisibility.bottom;
                    }
                    i11 -= i14;
                }
                attributes.gravity = i12 | 3;
                attributes.x = i10;
                attributes.y = i11;
                attributes.width = iMin;
                attributes.flags &= -3;
                window.setAttributes(attributes);
            }
            this.f13286a.setCancelable(true);
            this.f13286a.setCanceledOnTouchOutside(true);
            q(this.f13286a);
            if (n0.c(this.f13287b.f13312a)) {
                l3.n(this.f13286a.getWindow(), true);
            }
            k(this.f13286a.getWindow(), true);
        }
        j0();
    }

    public k h(String str, int i10, int i11) {
        return g(-1, str, this.f13287b.f13312a.getString(i10), i11);
    }

    public void h0(View view) {
        if (view == null) {
            f0();
        } else {
            i0(view, view.getWidth(), view.getHeight() / 2);
        }
    }

    public k i(String str, String str2, int i10) {
        return g(-1, str, str2, i10);
    }

    public void i0(View view, int i10, int i11) {
        if (view == null) {
            f0();
            return;
        }
        int[] iArr = {i, i};
        view.getLocationOnScreen(iArr);
        int i12 = iArr[0] + i10;
        int i13 = iArr[1] + i11;
        g0(i12, i13);
    }

    public k j(int i10, n nVar) {
        EditText editTextP = p(i10);
        if (editTextP != null && nVar != null) {
            nVar.a(editTextP);
        }
        return this;
    }

    public final void j0() {
        if (this.f13286a == null) {
            return;
        }
        Fragment fragmentB = g6.i.b(this.f13287b.f13312a);
        if (fragmentB == null || !g6.i.d(fragmentB)) {
            this.f13286a.show();
        }
    }

    public final void k(Window window, boolean z10) {
        int i10 = this.f13287b.f13335x;
        if (i10 == -1) {
            z8.l.a(window, z10 ? 2 : 1);
        } else {
            z8.l.a(window, i10);
        }
    }

    public boolean k0(List list) {
        ListAdapter listAdapter = this.f13287b.f13320i;
        if (!(listAdapter instanceof w5.c)) {
            return false;
        }
        ((w5.c) listAdapter).b(list);
        return true;
    }

    public final Dialog m(int i10, int i11, boolean z10) {
        ListAdapter listAdapter;
        Dialog dialog = new Dialog(this.f13287b.f13312a, v.f14256c);
        this.f13291f = LayoutInflater.from(this.f13287b.f13312a).inflate(r.f13885t, (ViewGroup) ((Activity) this.f13287b.f13312a).findViewById(R.id.content), false);
        boolean z11 = z10 && (listAdapter = this.f13287b.f13320i) != null && listAdapter.getCount() > 0;
        if (this.f13287b.f13315d != null) {
            TextView textView = (TextView) this.f13291f.findViewById(x7.p.H1);
            textView.setVisibility(0);
            textView.setText(this.f13287b.f13315d);
            if (z11) {
                textView.setTextSize(0, g6.f.d(this.f13287b.f13312a, x7.n.f13693l));
            }
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            if (this.f13287b.f13336y) {
                textView.setGravity(17);
            }
            textView.setLines(1);
            textView.setMaxLines(2);
        }
        if (this.f13287b.f13316e != null) {
            TextView textView2 = (TextView) this.f13291f.findViewById(x7.p.f13851v1);
            textView2.setVisibility(0);
            textView2.setText(this.f13287b.f13316e);
            ViewGroup viewGroup = (ViewGroup) textView2.getParent();
            viewGroup.setHorizontalFadingEdgeEnabled(false);
            viewGroup.setVerticalFadingEdgeEnabled(true);
            textView2.setFadingEdgeLength(y.h(this.f13287b.f13312a, 12.0f));
            if (z11) {
                textView2.setTextSize(0, g6.f.d(this.f13287b.f13312a, x7.n.f13694m));
            }
            int iN = y.n(textView2, i10);
            ListAdapter listAdapter2 = this.f13287b.f13320i;
            int i12 = (listAdapter2 == null || listAdapter2.getCount() == 0) ? i11 : i11 / 3;
            if (i12 <= 0 || iN <= i12) {
                o oVar = this.f13287b;
                if (oVar.f13320i == null && oVar.f13323l == null) {
                    textView2.setMinHeight(y.h(oVar.f13312a, 76.0f));
                }
            } else {
                this.f13291f.findViewById(x7.p.F0).getLayoutParams().height = i12;
            }
            if (this.f13287b.f13316e instanceof SpannableString) {
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (this.f13287b.f13336y) {
                textView2.setGravity(17);
            }
        }
        ListAdapter listAdapter3 = this.f13287b.f13320i;
        if (listAdapter3 != null && listAdapter3.getCount() > 0) {
            ListView listView = (ListView) this.f13291f.findViewById(x7.p.f13832p0);
            listView.setHorizontalScrollBarEnabled(false);
            listView.setVerticalScrollBarEnabled(false);
            ((MaxHeightLayout) listView.getParent()).setMaxHeight(this.f13287b.f13316e != null ? (i11 * 2) / 3 : i11);
            listView.setVisibility(0);
            listView.setSelector(x7.o.f13723f);
            ListAdapter listAdapter4 = this.f13287b.f13320i;
            if (listAdapter4 instanceof w5.d) {
                w5.d dVar = (w5.d) listAdapter4;
                int[] iArrD = dVar.d();
                if (iArrD.length == 1) {
                    listView.post(new d(listView, iArrD[0]));
                }
                dVar.b(listView, (dVar.f() || this.f13287b.f13321j == null) ? null : new e(), this.f13287b.f13322k);
            } else {
                listView.setAdapter(listAdapter4);
                o oVar2 = this.f13287b;
                if (oVar2.f13320i instanceof w5.c) {
                    if (!TextUtils.isEmpty(oVar2.f13316e)) {
                        ((w5.c) this.f13287b.f13320i).c(true);
                    }
                    o oVar3 = this.f13287b;
                    if (oVar3.f13336y) {
                        ((w5.c) oVar3.f13320i).a(true);
                    }
                }
                ListAdapter listAdapter5 = this.f13287b.f13320i;
                if (listAdapter5 instanceof w5.b) {
                    int[] iArrB = ((w5.b) listAdapter5).b();
                    if (iArrB.length == 1) {
                        listView.post(new f(listView, iArrB[0]));
                    }
                }
                listView.setOnItemClickListener(new g());
                listView.setOnItemLongClickListener(new h());
            }
            View view = this.f13287b.f13320i.getView(0, null, listView);
            int count = this.f13287b.f13320i.getCount();
            int measuredHeight = view.getMeasuredHeight();
            if (measuredHeight == 0) {
                view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                measuredHeight = view.getMeasuredHeight();
            }
            if (measuredHeight * count > i11) {
                listView.getLayoutParams().height = i11;
            }
        }
        if (this.f13287b.f13323l != null) {
            FrameLayout frameLayout = (FrameLayout) this.f13291f.findViewById(x7.p.D);
            frameLayout.setVisibility(0);
            frameLayout.addView(this.f13287b.f13323l);
        }
        if (this.f13287b.f13317f != null) {
            TextView textView3 = (TextView) this.f13291f.findViewById(x7.p.f13839r1);
            textView3.setVisibility(0);
            textView3.setText(this.f13287b.f13317f);
            if (this.f13287b.f13318g != null) {
                CheckBox checkBox = (CheckBox) this.f13291f.findViewById(x7.p.f13801f);
                checkBox.setVisibility(0);
                checkBox.setChecked(this.f13287b.f13318g == Boolean.TRUE);
                checkBox.setOnCheckedChangeListener(new i());
                View viewFindViewById = this.f13291f.findViewById(x7.p.f13823m0);
                viewFindViewById.setClickable(true);
                viewFindViewById.setFocusable(true);
                viewFindViewById.setOnClickListener(new j(checkBox));
            }
        }
        if (this.f13287b.f13325n != null) {
            TextView textView4 = (TextView) this.f13291f.findViewById(x7.p.f13794c1);
            textView4.setVisibility(0);
            textView4.setText(this.f13287b.f13325n);
            textView4.setOnClickListener(new ViewOnClickListenerC0149k());
        }
        if (this.f13287b.f13327p != null) {
            TextView textView5 = (TextView) this.f13291f.findViewById(x7.p.f13788a1);
            textView5.setVisibility(0);
            textView5.setText(this.f13287b.f13327p);
            textView5.setOnClickListener(new a());
        }
        if (this.f13287b.f13329r != null) {
            TextView textView6 = (TextView) this.f13291f.findViewById(x7.p.f13791b1);
            textView6.setVisibility(0);
            textView6.setText(this.f13287b.f13329r);
            textView6.setOnClickListener(new b());
        }
        x8.g.f(this.f13291f);
        dialog.setContentView(this.f13291f);
        return dialog;
    }

    public void n() {
        Dialog dialog = this.f13286a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final p o() {
        p pVarA = p.a();
        ListAdapter listAdapter = this.f13287b.f13320i;
        if (listAdapter instanceof w5.d) {
            pVarA.f13337a = ((w5.d) listAdapter).d();
        }
        o oVar = this.f13287b;
        if (oVar.f13324m) {
            View view = oVar.f13323l;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                String[] strArr = new String[childCount];
                int i10 = 0;
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        if (viewGroup2.getChildCount() > 0) {
                            childAt = viewGroup2.getChildAt(0);
                        }
                    }
                    if (childAt instanceof EditText) {
                        Editable text = ((EditText) childAt).getText();
                        for (CharacterStyle characterStyle : (CharacterStyle[]) text.getSpans(0, text.length(), MetricAffectingSpan.class)) {
                            text.removeSpan(characterStyle);
                        }
                        strArr[i10] = text.toString();
                        i10++;
                    }
                }
                pVarA.f13339c = (String[]) Arrays.copyOf(strArr, i10);
            }
        }
        pVarA.f13338b = this.f13287b.f13318g == Boolean.TRUE;
        return pVarA;
    }

    public EditText p(int i10) {
        View view = this.f13287b.f13323l;
        if (view == null) {
            return null;
        }
        return (EditText) view.findViewById(i10);
    }

    public final void q(Dialog dialog) {
        com.tuyafeng.support.widget.y yVarV = y.v(this.f13287b.f13312a);
        if (yVarV == null || !yVarV.u()) {
            this.f13292g = null;
            dialog.setOnDismissListener(this.f13287b.f13333v);
        } else {
            yVarV.setGestureEnabled(false);
            this.f13292g = new WeakReference(yVarV);
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: w5.h
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    k.c(this.f13281e, dialogInterface);
                }
            });
        }
    }

    public boolean r() {
        Dialog dialog = this.f13286a;
        return dialog != null && dialog.isShowing();
    }

    public k s(int i10) {
        this.f13287b.f13335x = i10;
        return this;
    }

    public k t(boolean z10) {
        this.f13287b.f13331t = z10;
        return this;
    }

    public k u(boolean z10) {
        this.f13287b.f13332u = z10;
        return this;
    }

    public k v(boolean z10) {
        this.f13287b.f13336y = z10;
        return this;
    }

    public k w(int i10, boolean z10) {
        o oVar = this.f13287b;
        oVar.f13317f = oVar.f13312a.getString(i10);
        this.f13287b.f13318g = Boolean.valueOf(z10);
        return this;
    }

    public k x(String str, boolean z10) {
        o oVar = this.f13287b;
        oVar.f13317f = str;
        oVar.f13318g = Boolean.valueOf(z10);
        return this;
    }

    public k y(View view) {
        this.f13287b.f13323l = view;
        return this;
    }

    public k z(String[] strArr, AdapterView.OnItemClickListener onItemClickListener) {
        return H(strArr, true, onItemClickListener, null);
    }
}
