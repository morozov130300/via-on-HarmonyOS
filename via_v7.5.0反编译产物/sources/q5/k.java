package q5;

import android.R;
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
import android.view.ContextThemeWrapper;
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
import com.tuyafeng.support.utils.FragmentUtils;
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.d0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mark.via.common.widget.MaxHeightLayout;
import w7.r;
import w7.v;
import x8.h3;
import x8.n0;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f11765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f11766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f11770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference f11771g = null;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = k.this.f11766b.f11808q;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            k.this.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = k.this.f11766b.f11810s;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            k.this.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f11774a;

        public c(m mVar) {
            this.f11774a = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f11774a.a(view, k.this.p());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ListView f11776c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f11777e;

        public d(ListView listView, int i10) {
            this.f11776c = listView;
            this.f11777e = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11776c.smoothScrollToPositionFromTop(this.f11777e, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q5.d f11779a;

        public e(q5.d dVar) {
            this.f11779a = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            k.this.f11766b.f11801j.onItemClick(adapterView, view, i10, j10);
            if (this.f11779a.f()) {
                return;
            }
            k.this.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ListView f11781c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f11782e;

        public f(ListView listView, int i10) {
            this.f11781c = listView;
            this.f11782e = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11781c.smoothScrollToPositionFromTop(this.f11782e, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g implements AdapterView.OnItemClickListener {
        public g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            AdapterView.OnItemClickListener onItemClickListener = k.this.f11766b.f11801j;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i10, j10);
            }
            k.this.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class h implements AdapterView.OnItemLongClickListener {
        public h() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
            AdapterView.OnItemLongClickListener onItemLongClickListener = k.this.f11766b.f11802k;
            return onItemLongClickListener != null && onItemLongClickListener.onItemLongClick(adapterView, view, i10, j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class i implements CompoundButton.OnCheckedChangeListener {
        public i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            k.this.f11766b.f11798g = Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f11787a;

        public j(CheckBox checkBox) {
            this.f11787a = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CheckBox checkBox = this.f11787a;
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    /* JADX INFO: renamed from: q5.k$k, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class ViewOnClickListenerC0114k implements View.OnClickListener {
        public ViewOnClickListenerC0114k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p pVarP = k.this.p();
            k kVar = k.this;
            o oVar = kVar.f11766b;
            if (!oVar.f11799h || pVarP.f11818b) {
                m mVar = oVar.f11806o;
                if (mVar != null) {
                    mVar.a(view, pVarP);
                }
                k.this.o();
                return;
            }
            View viewFindViewById = kVar.f11770f.findViewById(w7.p.f13867f);
            View viewFindViewById2 = k.this.f11770f.findViewById(w7.p.f13905r1);
            x.Y(viewFindViewById);
            x.Y(viewFindViewById2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11791b;

        public l(int i10, String str) {
            this.f11790a = i10;
            this.f11791b = str;
        }

        public int a() {
            return this.f11790a;
        }

        public String b() {
            return this.f11791b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface m {
        void a(View view, p pVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface n {
        void a(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f11817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f11819c;

        public static p a() {
            return new p();
        }

        public String toString() {
            return "Result{selected=" + Arrays.toString(this.f11817a) + ", checked=" + this.f11818b + ", edit=" + Arrays.toString(this.f11819c) + '}';
        }
    }

    public k(Context context) {
        o oVar = new o(null);
        this.f11766b = oVar;
        oVar.f11792a = context;
        View viewFindViewById = com.tuyafeng.support.utils.f.a(context).findViewById(R.id.content);
        if (viewFindViewById == null) {
            this.f11767c = x.y(context);
            this.f11768d = x.z(context);
            this.f11769e = x.u(context);
        } else {
            this.f11767c = viewFindViewById.getHeight();
            this.f11768d = viewFindViewById.getWidth();
            int[] iArr = new int[2];
            viewFindViewById.getLocationOnScreen(iArr);
            this.f11769e = iArr[1];
        }
    }

    public static /* synthetic */ void a(HorizontalScrollView horizontalScrollView) {
        horizontalScrollView.setFillViewport(true);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setVerticalScrollBarEnabled(false);
        r3.g(horizontalScrollView);
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
        editText.setTextColor(v8.h.o(kVar.f11766b.f11792a));
        editText.setHintTextColor(v8.h.p(kVar.f11766b.f11792a));
        v8.g.m(editText, v8.h.q(kVar.f11766b.f11792a));
        editText.setGravity(48);
        editText.setSelectAllOnFocus(i10 <= 3);
        v8.g.h(editText);
    }

    public static /* synthetic */ void c(k kVar, DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener = kVar.f11766b.f11813v;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
        WeakReference weakReference = kVar.f11771g;
        d0 d0Var = weakReference == null ? null : (d0) weakReference.get();
        if (d0Var != null) {
            d0Var.setGestureEnabled(true);
        }
    }

    public static k l(Context context) {
        return new k(context);
    }

    public static k m(Context context, int i10) {
        return new k(new ContextThemeWrapper(context, i10));
    }

    public k A(String[] strArr, AdapterView.OnItemClickListener onItemClickListener) {
        return I(strArr, true, onItemClickListener, null);
    }

    public k B(int i10) {
        o oVar = this.f11766b;
        oVar.f11797f = oVar.f11792a.getString(i10);
        return this;
    }

    public k C(int i10) {
        this.f11766b.f11793b = i10;
        return this;
    }

    public k D(List list, AdapterView.OnItemClickListener onItemClickListener) {
        return E(list, onItemClickListener, null);
    }

    public k E(List list, AdapterView.OnItemClickListener onItemClickListener, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        return F(list, false, onItemClickListener, onItemLongClickListener);
    }

    public k F(List list, boolean z10, AdapterView.OnItemClickListener onItemClickListener, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        q5.c cVar = new q5.c(this.f11766b.f11792a, list);
        cVar.c(z10);
        o oVar = this.f11766b;
        oVar.f11800i = cVar;
        oVar.f11801j = onItemClickListener;
        oVar.f11802k = onItemLongClickListener;
        return this;
    }

    public k G(String[] strArr, AdapterView.OnItemClickListener onItemClickListener) {
        return H(strArr, onItemClickListener, null);
    }

    public k H(String[] strArr, AdapterView.OnItemClickListener onItemClickListener, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        return I(strArr, false, onItemClickListener, onItemLongClickListener);
    }

    public k I(String[] strArr, boolean z10, AdapterView.OnItemClickListener onItemClickListener, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(new l(i10, strArr[i10]));
        }
        return F(arrayList, z10, onItemClickListener, onItemLongClickListener);
    }

    public k J(int i10) {
        o oVar = this.f11766b;
        oVar.f11796e = oVar.f11792a.getString(i10);
        return this;
    }

    public k K(CharSequence charSequence) {
        this.f11766b.f11796e = charSequence;
        return this;
    }

    public k L(int i10, int[] iArr) {
        return M(this.f11766b.f11792a.getResources().getStringArray(i10), iArr);
    }

    public k M(String[] strArr, int[] iArr) {
        return N(strArr, iArr, null);
    }

    public k N(String[] strArr, int[] iArr, AdapterView.OnItemClickListener onItemClickListener) {
        o oVar = this.f11766b;
        oVar.f11801j = onItemClickListener;
        oVar.f11800i = new q5.d(Arrays.asList(strArr), iArr, true);
        return this;
    }

    public k O(boolean z10) {
        this.f11766b.f11799h = z10;
        return this;
    }

    public k P(int i10, View.OnClickListener onClickListener) {
        return Q(this.f11766b.f11792a.getString(i10), onClickListener);
    }

    public k Q(String str, View.OnClickListener onClickListener) {
        o oVar = this.f11766b;
        oVar.f11807p = str;
        oVar.f11808q = onClickListener;
        return this;
    }

    public k R(int i10, m mVar) {
        return S(this.f11766b.f11792a.getString(i10), mVar);
    }

    public k S(String str, m mVar) {
        return Q(str, mVar != null ? new c(mVar) : null);
    }

    public k T(int i10, View.OnClickListener onClickListener) {
        return U(this.f11766b.f11792a.getString(i10), onClickListener);
    }

    public k U(String str, View.OnClickListener onClickListener) {
        o oVar = this.f11766b;
        oVar.f11809r = str;
        oVar.f11810s = onClickListener;
        return this;
    }

    public k V(DialogInterface.OnCancelListener onCancelListener) {
        this.f11766b.f11814w = onCancelListener;
        return this;
    }

    public k W(DialogInterface.OnDismissListener onDismissListener) {
        this.f11766b.f11813v = onDismissListener;
        return this;
    }

    public k X(int i10, m mVar) {
        return Y(this.f11766b.f11792a.getString(i10), mVar);
    }

    public k Y(String str, m mVar) {
        o oVar = this.f11766b;
        oVar.f11805n = str;
        oVar.f11806o = mVar;
        return this;
    }

    public k Z(int i10) {
        return a0(this.f11766b.f11792a.getString(i10));
    }

    public k a0(String str) {
        if (str != null && !str.isEmpty()) {
            LinearLayout linearLayout = new LinearLayout(this.f11766b.f11792a);
            linearLayout.setOrientation(0);
            ProgressBar progressBar = new ProgressBar(this.f11766b.f11792a);
            progressBar.setIndeterminate(false);
            progressBar.setIndeterminateDrawable(com.tuyafeng.support.utils.f.e(this.f11766b.f11792a, w7.o.f13798i));
            TextView textView = new TextView(this.f11766b.f11792a);
            int iH = x.h(this.f11766b.f11792a, 4.0f);
            int iH2 = x.h(this.f11766b.f11792a, 16.0f);
            x.V(linearLayout, iH2, iH, iH2, iH);
            x.V(progressBar, 0, 0, 0, 0);
            x.V(textView, iH2, 0, 0, 0);
            androidx.core.widget.d.b(textView, v.f14330g);
            linearLayout.addView(progressBar);
            linearLayout.addView(textView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.gravity = 16;
            textView.setLayoutParams(layoutParams);
            textView.setText(str);
            this.f11766b.f11803l = linearLayout;
        }
        return this;
    }

    public k b0(int i10, int i11, AdapterView.OnItemClickListener onItemClickListener) {
        return d0(this.f11766b.f11792a.getResources().getStringArray(i10), i11, onItemClickListener);
    }

    public k c0(String[] strArr, int i10) {
        this.f11766b.f11800i = new q5.d(Arrays.asList(strArr), new int[]{i10}, false);
        return this;
    }

    public k d0(String[] strArr, int i10, AdapterView.OnItemClickListener onItemClickListener) {
        this.f11766b.f11800i = new q5.d(Arrays.asList(strArr), new int[]{i10}, false);
        this.f11766b.f11801j = onItemClickListener;
        return this;
    }

    public k e0(String[] strArr, int i10, AdapterView.OnItemClickListener onItemClickListener) {
        this.f11766b.f11800i = new q5.b(Arrays.asList(strArr), new int[]{i10}, false);
        this.f11766b.f11801j = onItemClickListener;
        return this;
    }

    public k f(int i10, String str, int i11, int i12) {
        return g(i10, str, this.f11766b.f11792a.getString(i11), i12);
    }

    public k f0(int i10) {
        o oVar = this.f11766b;
        oVar.f11795d = oVar.f11792a.getString(i10);
        return this;
    }

    public k g(int i10, final String str, final String str2, final int i11) {
        ViewGroup viewGroup;
        o oVar = this.f11766b;
        oVar.f11804m = true;
        View view = oVar.f11803l;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            LinearLayout linearLayout = new LinearLayout(this.f11766b.f11792a);
            linearLayout.setOrientation(1);
            this.f11766b.f11803l = linearLayout;
            viewGroup = linearLayout;
        }
        EditText editText = (EditText) new b6.a(new EditText(this.f11766b.f11792a), new FrameLayout.LayoutParams(-1, -2)).o(i10).X(i11 == 1 ? -2 : -1).d(w7.o.f13792g).T(1, i11 == 1 ? 0 : 8).x(1, i11 == 1 ? 0 : 12).t(1, i11 == 1 ? 0 : 12).V(new b6.a.InterfaceC0033a() { // from class: q5.i
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k.b(this.f11761a, str, str2, i11, (EditText) obj);
            }
        }).l();
        if (i11 != 1) {
            viewGroup.addView(editText);
            return this;
        }
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) new b6.a(new HorizontalScrollView(this.f11766b.f11792a), new FrameLayout.LayoutParams(-1, -2)).d(w7.o.f13792g).x(1, 16).t(1, 12).T(1, 8).V(new b6.a.InterfaceC0033a() { // from class: q5.j
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k.a((HorizontalScrollView) obj);
            }
        }).l();
        editText.setBackgroundColor(0);
        horizontalScrollView.addView(editText);
        viewGroup.addView(horizontalScrollView);
        return this;
    }

    public k g0(String str) {
        this.f11766b.f11795d = str;
        return this;
    }

    public k h(String str, int i10, int i11) {
        return g(-1, str, this.f11766b.f11792a.getString(i10), i11);
    }

    public void h0() {
        o oVar;
        if (this.f11765a == null && (oVar = this.f11766b) != null) {
            boolean zE = x.E(oVar.f11792a);
            int i10 = this.f11766b.f11804m ? 8 : 6;
            int iMin = Math.min(this.f11768d, this.f11767c) - x.h(this.f11766b.f11792a, 72.0f);
            if ((zE || this.f11768d > this.f11767c) && iMin > x.h(this.f11766b.f11792a, i10 * 60)) {
                iMin = x.h(this.f11766b.f11792a, (i10 - 1) * 60);
            }
            int i11 = this.f11766b.f11793b;
            if (i11 > 0) {
                iMin = Math.min(iMin, i11);
            }
            int iMin2 = (this.f11767c / 7) * 4;
            int i12 = this.f11766b.f11794c;
            if (i12 > 0) {
                iMin2 = Math.min(iMin2, i12);
            }
            Dialog dialogN = n(iMin, iMin2, false);
            this.f11765a = dialogN;
            dialogN.setCancelable(this.f11766b.f11811t);
            Dialog dialog = this.f11765a;
            o oVar2 = this.f11766b;
            dialog.setCanceledOnTouchOutside(oVar2.f11811t && oVar2.f11812u);
            r(this.f11765a);
            this.f11765a.setOnCancelListener(this.f11766b.f11814w);
            if (this.f11765a.getWindow() != null) {
                WindowManager.LayoutParams attributes = this.f11765a.getWindow().getAttributes();
                attributes.width = iMin;
                attributes.gravity = 17;
                this.f11765a.getWindow().setAttributes(attributes);
                if (n0.c(this.f11766b.f11792a)) {
                    h3.q(this.f11765a.getWindow(), true);
                }
                k(this.f11765a.getWindow(), false);
            }
        }
        l0();
    }

    public k i(String str, String str2, int i10) {
        return g(-1, str, str2, i10);
    }

    public void i0(int i10, int i11) {
        o oVar;
        int i12;
        int i13;
        WindowManager windowManager;
        int i14;
        if (this.f11765a == null && (oVar = this.f11766b) != null) {
            int iMin = Math.min(x.h(oVar.f11792a, 240.0f), (Math.min(this.f11767c, this.f11768d) / 7) * (oVar.f11804m ? 5 : 4));
            int i15 = this.f11766b.f11793b;
            if (i15 > 0) {
                iMin = Math.min(i15, iMin);
            }
            int iMin2 = (this.f11767c * 3) / 5;
            int i16 = this.f11766b.f11794c;
            if (i16 > 0) {
                iMin2 = Math.min(iMin2, i16);
            }
            Dialog dialogN = n(iMin, iMin2, true);
            this.f11765a = dialogN;
            Window window = dialogN.getWindow();
            if (window != null) {
                window.getDecorView().measure(View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                window.setSoftInputMode(16);
                WindowManager.LayoutParams attributes = window.getAttributes();
                int i17 = this.f11768d;
                if (i10 > (i17 >> 1)) {
                    i10 -= iMin;
                }
                if (i10 <= 10) {
                    i10 = x.h(this.f11766b.f11792a, 12.0f);
                } else if (i10 + iMin >= i17 - 10) {
                    i10 = (i17 - iMin) - x.h(this.f11766b.f11792a, 12.0f);
                }
                int i18 = this.f11767c;
                boolean z10 = i11 > (i18 >> 1);
                if (z10) {
                    i11 = i18 - i11;
                    i12 = 80;
                } else {
                    i12 = 48;
                }
                int i19 = this.f11769e;
                if (i19 > 0) {
                    i11 = z10 ? i11 + i19 : i11 - i19;
                }
                if (h3.f14580a && (i13 = Build.VERSION.SDK_INT) >= 30 && (windowManager = (WindowManager) this.f11766b.f11792a.getSystemService(WindowManager.class)) != null) {
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
            this.f11765a.setCancelable(true);
            this.f11765a.setCanceledOnTouchOutside(true);
            r(this.f11765a);
            if (n0.c(this.f11766b.f11792a)) {
                h3.q(this.f11765a.getWindow(), true);
            }
            k(this.f11765a.getWindow(), true);
        }
        l0();
    }

    public k j(int i10, n nVar) {
        EditText editTextQ = q(i10);
        if (editTextQ != null && nVar != null) {
            nVar.a(editTextQ);
        }
        return this;
    }

    public void j0(View view) {
        if (view == null) {
            h0();
        } else {
            k0(view, view.getWidth(), view.getHeight() / 2);
        }
    }

    public final void k(Window window, boolean z10) {
        int i10 = this.f11766b.f11815x;
        if (i10 == -1) {
            x8.l.a(window, z10 ? 2 : 1);
        } else {
            x8.l.a(window, i10);
        }
    }

    public void k0(View view, int i10, int i11) {
        if (view == null) {
            h0();
            return;
        }
        int[] iArr = {i, i};
        view.getLocationOnScreen(iArr);
        int i12 = iArr[0] + i10;
        int i13 = iArr[1] + i11;
        i0(i12, i13);
    }

    public final void l0() {
        if (this.f11765a == null) {
            return;
        }
        Fragment fragmentC = FragmentUtils.c(this.f11766b.f11792a);
        if (fragmentC == null || !FragmentUtils.e(fragmentC)) {
            this.f11765a.show();
        }
    }

    public boolean m0(List list) {
        ListAdapter listAdapter = this.f11766b.f11800i;
        if (!(listAdapter instanceof q5.c)) {
            return false;
        }
        ((q5.c) listAdapter).b(list);
        return true;
    }

    public final Dialog n(int i10, int i11, boolean z10) {
        ListAdapter listAdapter;
        Dialog dialog = new Dialog(this.f11766b.f11792a, v.f14326c);
        this.f11770f = LayoutInflater.from(this.f11766b.f11792a).inflate(r.f13950s, (ViewGroup) com.tuyafeng.support.utils.f.a(this.f11766b.f11792a).findViewById(R.id.content), false);
        boolean z11 = z10 && (listAdapter = this.f11766b.f11800i) != null && listAdapter.getCount() > 0;
        if (this.f11766b.f11795d != null) {
            TextView textView = (TextView) this.f11770f.findViewById(w7.p.H1);
            textView.setVisibility(0);
            textView.setText(this.f11766b.f11795d);
            if (z11) {
                textView.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f11766b.f11792a, w7.n.f13759l));
            }
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            if (this.f11766b.f11816y) {
                textView.setGravity(17);
            }
            textView.setLines(1);
            textView.setMaxLines(2);
        }
        if (this.f11766b.f11796e != null) {
            TextView textView2 = (TextView) this.f11770f.findViewById(w7.p.f13917v1);
            textView2.setVisibility(0);
            textView2.setText(this.f11766b.f11796e);
            ViewGroup viewGroup = (ViewGroup) textView2.getParent();
            viewGroup.setHorizontalFadingEdgeEnabled(false);
            viewGroup.setVerticalFadingEdgeEnabled(true);
            textView2.setFadingEdgeLength(x.h(this.f11766b.f11792a, 12.0f));
            if (z11) {
                textView2.setTextSize(0, com.tuyafeng.support.utils.f.d(this.f11766b.f11792a, w7.n.f13760m));
            }
            int iN = x.n(textView2, i10);
            ListAdapter listAdapter2 = this.f11766b.f11800i;
            int i12 = (listAdapter2 == null || listAdapter2.getCount() == 0) ? i11 : i11 / 3;
            if (i12 <= 0 || iN <= i12) {
                o oVar = this.f11766b;
                if (oVar.f11800i == null && oVar.f11803l == null) {
                    textView2.setMinHeight(x.h(oVar.f11792a, 76.0f));
                }
            } else {
                this.f11770f.findViewById(w7.p.B0).getLayoutParams().height = i12;
            }
            if (this.f11766b.f11796e instanceof SpannableString) {
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (this.f11766b.f11816y) {
                textView2.setGravity(17);
            }
        }
        ListAdapter listAdapter3 = this.f11766b.f11800i;
        if (listAdapter3 != null && listAdapter3.getCount() > 0) {
            ListView listView = (ListView) this.f11770f.findViewById(w7.p.f13886l0);
            listView.setHorizontalScrollBarEnabled(false);
            listView.setVerticalScrollBarEnabled(false);
            ((MaxHeightLayout) listView.getParent()).setMaxHeight(this.f11766b.f11796e != null ? (i11 * 2) / 3 : i11);
            listView.setVisibility(0);
            listView.setSelector(w7.o.f13786e);
            ListAdapter listAdapter4 = this.f11766b.f11800i;
            if (listAdapter4 instanceof q5.d) {
                q5.d dVar = (q5.d) listAdapter4;
                int[] iArrD = dVar.d();
                if (iArrD.length == 1) {
                    listView.post(new d(listView, iArrD[0]));
                }
                dVar.b(listView, this.f11766b.f11801j == null ? null : new e(dVar), this.f11766b.f11802k);
            } else {
                listView.setAdapter(listAdapter4);
                o oVar2 = this.f11766b;
                if (oVar2.f11800i instanceof q5.c) {
                    if (!TextUtils.isEmpty(oVar2.f11796e)) {
                        ((q5.c) this.f11766b.f11800i).c(true);
                    }
                    o oVar3 = this.f11766b;
                    if (oVar3.f11816y) {
                        ((q5.c) oVar3.f11800i).a(true);
                    }
                }
                ListAdapter listAdapter5 = this.f11766b.f11800i;
                if (listAdapter5 instanceof q5.b) {
                    int[] iArrB = ((q5.b) listAdapter5).b();
                    if (iArrB.length == 1) {
                        listView.post(new f(listView, iArrB[0]));
                    }
                }
                listView.setOnItemClickListener(new g());
                listView.setOnItemLongClickListener(new h());
            }
            View view = this.f11766b.f11800i.getView(0, null, listView);
            int count = this.f11766b.f11800i.getCount();
            int measuredHeight = view.getMeasuredHeight();
            if (measuredHeight == 0) {
                view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                measuredHeight = view.getMeasuredHeight();
            }
            if (measuredHeight * count > i11) {
                listView.getLayoutParams().height = i11;
            }
        }
        if (this.f11766b.f11803l != null) {
            FrameLayout frameLayout = (FrameLayout) this.f11770f.findViewById(w7.p.C);
            frameLayout.setVisibility(0);
            frameLayout.addView(this.f11766b.f11803l);
        }
        if (this.f11766b.f11797f != null) {
            TextView textView3 = (TextView) this.f11770f.findViewById(w7.p.f13905r1);
            textView3.setVisibility(0);
            textView3.setText(this.f11766b.f11797f);
            if (this.f11766b.f11798g != null) {
                CheckBox checkBox = (CheckBox) this.f11770f.findViewById(w7.p.f13867f);
                checkBox.setVisibility(0);
                checkBox.setChecked(this.f11766b.f11798g == Boolean.TRUE);
                checkBox.setOnCheckedChangeListener(new i());
                View viewFindViewById = this.f11770f.findViewById(w7.p.f13877i0);
                viewFindViewById.setClickable(true);
                viewFindViewById.setFocusable(true);
                viewFindViewById.setOnClickListener(new j(checkBox));
            }
        }
        if (this.f11766b.f11805n != null) {
            TextView textView4 = (TextView) this.f11770f.findViewById(w7.p.f13860c1);
            textView4.setVisibility(0);
            textView4.setText(this.f11766b.f11805n);
            textView4.setOnClickListener(new ViewOnClickListenerC0114k());
        }
        if (this.f11766b.f11807p != null) {
            TextView textView5 = (TextView) this.f11770f.findViewById(w7.p.f13854a1);
            textView5.setVisibility(0);
            textView5.setText(this.f11766b.f11807p);
            textView5.setOnClickListener(new a());
        }
        if (this.f11766b.f11809r != null) {
            TextView textView6 = (TextView) this.f11770f.findViewById(w7.p.f13857b1);
            textView6.setVisibility(0);
            textView6.setText(this.f11766b.f11809r);
            textView6.setOnClickListener(new b());
        }
        v8.g.f(this.f11770f);
        dialog.setContentView(this.f11770f);
        return dialog;
    }

    public void o() {
        Dialog dialog = this.f11765a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final p p() {
        p pVarA = p.a();
        ListAdapter listAdapter = this.f11766b.f11800i;
        if (listAdapter instanceof q5.d) {
            pVarA.f11817a = ((q5.d) listAdapter).d();
        }
        o oVar = this.f11766b;
        if (oVar.f11804m) {
            View view = oVar.f11803l;
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
                pVarA.f11819c = (String[]) Arrays.copyOf(strArr, i10);
            }
        }
        pVarA.f11818b = this.f11766b.f11798g == Boolean.TRUE;
        return pVarA;
    }

    public EditText q(int i10) {
        View view = this.f11766b.f11803l;
        if (view == null) {
            return null;
        }
        return (EditText) view.findViewById(i10);
    }

    public final void r(Dialog dialog) {
        d0 d0VarV = x.v(this.f11766b.f11792a);
        if (d0VarV == null || !d0VarV.u()) {
            this.f11771g = null;
            dialog.setOnDismissListener(this.f11766b.f11813v);
        } else {
            d0VarV.setGestureEnabled(false);
            this.f11771g = new WeakReference(d0VarV);
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: q5.h
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    k.c(this.f11760c, dialogInterface);
                }
            });
        }
    }

    public boolean s() {
        Dialog dialog = this.f11765a;
        return dialog != null && dialog.isShowing();
    }

    public k t(int i10) {
        this.f11766b.f11815x = i10;
        return this;
    }

    public k u(boolean z10) {
        this.f11766b.f11811t = z10;
        return this;
    }

    public k v(boolean z10) {
        this.f11766b.f11812u = z10;
        return this;
    }

    public k w(boolean z10) {
        this.f11766b.f11816y = z10;
        return this;
    }

    public k x(int i10, boolean z10) {
        o oVar = this.f11766b;
        oVar.f11797f = oVar.f11792a.getString(i10);
        this.f11766b.f11798g = Boolean.valueOf(z10);
        return this;
    }

    public k y(String str, boolean z10) {
        o oVar = this.f11766b;
        oVar.f11797f = str;
        oVar.f11798g = Boolean.valueOf(z10);
        return this;
    }

    public k z(View view) {
        this.f11766b.f11803l = view;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f11792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f11796e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f11797f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Boolean f11798g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f11799h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ListAdapter f11800i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public AdapterView.OnItemClickListener f11801j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public AdapterView.OnItemLongClickListener f11802k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public View f11803l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f11804m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f11805n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public m f11806o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f11807p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public View.OnClickListener f11808q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f11809r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public View.OnClickListener f11810s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f11811t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f11812u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public DialogInterface.OnDismissListener f11813v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public DialogInterface.OnCancelListener f11814w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f11815x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f11816y;

        public o() {
            this.f11793b = 0;
            this.f11794c = 0;
            this.f11799h = false;
            this.f11811t = true;
            this.f11812u = true;
            this.f11815x = -1;
            this.f11816y = false;
        }

        public /* synthetic */ o(c cVar) {
            this();
        }
    }
}
