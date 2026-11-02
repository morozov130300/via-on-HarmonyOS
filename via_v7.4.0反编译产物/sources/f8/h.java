package f8;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h extends c {

    /* renamed from: v0, reason: collision with root package name */
    public static final String f5979v0 = "h";

    /* renamed from: s0, reason: collision with root package name */
    public b f5980s0;

    /* renamed from: t0, reason: collision with root package name */
    public EditText f5981t0;

    /* renamed from: u0, reason: collision with root package name */
    public TextView f5982u0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (h.this.f5980s0 != null) {
                h.this.f5980s0.c(editable.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(boolean z10);

        void b(boolean z10);

        void c(String str);
    }

    public static /* synthetic */ void a3(h hVar, View view) {
        b bVar = hVar.f5980s0;
        if (bVar != null) {
            bVar.b(true);
        }
    }

    public static /* synthetic */ void b3(h hVar, View view) {
        b bVar = hVar.f5980s0;
        if (bVar != null) {
            bVar.a(false);
        }
    }

    public static /* synthetic */ void c3(h hVar, View view) {
        b bVar = hVar.f5980s0;
        if (bVar != null) {
            bVar.a(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F1() {
        f3();
        b bVar = this.f5980s0;
        if (bVar != null) {
            bVar.b(false);
            this.f5980s0 = null;
        }
        super.F1();
    }

    @Override // f8.c
    public CharSequence W2() {
        return Z0(x7.u.F);
    }

    @Override // f8.c, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f5981t0 = (EditText) view.findViewById(o.f6007e);
        this.f5982u0 = (TextView) view.findViewById(o.f6008j);
        ImageView imageView = (ImageView) view.findViewById(o.f6010l);
        ImageView imageView2 = (ImageView) view.findViewById(o.f6009k);
        ImageView imageView3 = (ImageView) view.findViewById(o.f6011m);
        this.f5981t0.requestFocus();
        this.f5981t0.addTextChangedListener(new a());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: f8.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.b3(this.f5974a, view2);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: f8.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.c3(this.f5976a, view2);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: f8.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.a3(this.f5978a, view2);
            }
        });
        e3();
    }

    @Override // f8.c
    public View X2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        o oVar = new o(I());
        oVar.setLayoutParams(new FrameLayout.LayoutParams(-1, g6.f.d(I(), x7.n.f13683b)));
        oVar.setClickable(true);
        oVar.setFocusable(false);
        oVar.setImportantForAccessibility(2);
        return oVar;
    }

    @Override // f8.c
    public void Y2() {
        g6.y.K(this.f5981t0);
    }

    public final void e3() {
        if (this.f5981t0 == null) {
            return;
        }
        Bundle bundleY0 = y0();
        if (bundleY0 != null) {
            String string = bundleY0.getString("TEXT", null);
            if (!TextUtils.isEmpty(string)) {
                this.f5981t0.setText(string);
                return;
            }
        }
        Bundle bundleC = v5.b.d().c("FIND_CACHE");
        if (bundleC == null) {
            return;
        }
        String string2 = bundleC.getString("CACHED_TEXT", "");
        if (string2.isEmpty()) {
            return;
        }
        this.f5981t0.setText(string2);
    }

    public final void f3() {
        if (this.f5981t0 == null) {
            return;
        }
        v5.b.a().e("FIND_CACHE").f(180).d("CACHED_TEXT", this.f5981t0.getText().toString()).a();
    }

    public void g3(b bVar) {
        EditText editText;
        this.f5980s0 = bVar;
        if (bVar == null || (editText = this.f5981t0) == null) {
            return;
        }
        bVar.c(editText.getText().toString());
    }

    public void h3(int i10, int i11, boolean z10) {
        EditText editText = this.f5981t0;
        if (editText != null && z10) {
            boolean z11 = editText.getText().length() == 0 || i10 == -1;
            this.f5982u0.setVisibility(z11 ? 8 : 0);
            if (z11) {
                return;
            }
            if (i11 > 0) {
                i10++;
            }
            this.f5982u0.setText(String.format(Locale.ROOT, "%1$s/%2$s", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }
}
