package d8;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends c {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f3955x0 = "h";

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public b f3956u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public EditText f3957v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public TextView f3958w0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(boolean z10);

        void b(boolean z10);

        void c(String str);
    }

    public static /* synthetic */ void Y2(h hVar, View view) {
        b bVar = hVar.f3956u0;
        if (bVar != null) {
            bVar.b(true);
        }
    }

    public static /* synthetic */ void Z2(h hVar, View view) {
        b bVar = hVar.f3956u0;
        if (bVar != null) {
            bVar.a(false);
        }
    }

    public static /* synthetic */ void a3(h hVar, View view) {
        b bVar = hVar.f3956u0;
        if (bVar != null) {
            bVar.a(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        d3();
        b bVar = this.f3956u0;
        if (bVar != null) {
            bVar.b(false);
            this.f3956u0 = null;
        }
        super.D1();
    }

    @Override // d8.c
    public CharSequence U2() {
        return X0(w7.u.G);
    }

    @Override // d8.c, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f3957v0 = (EditText) view.findViewById(o.f3978c);
        this.f3958w0 = (TextView) view.findViewById(o.f3979e);
        ImageView imageView = (ImageView) view.findViewById(o.f3981n);
        ImageView imageView2 = (ImageView) view.findViewById(o.f3980m);
        ImageView imageView3 = (ImageView) view.findViewById(o.f3982o);
        this.f3957v0.requestFocus();
        this.f3957v0.addTextChangedListener(new a());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: d8.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.Z2(this.f3950a, view2);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: d8.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.a3(this.f3952a, view2);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: d8.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                h.Y2(this.f3954a, view2);
            }
        });
        c3();
    }

    @Override // d8.c
    public View V2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        o oVar = new o(G());
        oVar.setLayoutParams(new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.f.d(G(), w7.n.f13749b)));
        oVar.setClickable(true);
        oVar.setFocusable(false);
        oVar.setImportantForAccessibility(2);
        return oVar;
    }

    @Override // d8.c
    public void W2() {
        com.tuyafeng.support.utils.x.L(this.f3957v0);
    }

    public final void c3() {
        if (this.f3957v0 == null) {
            return;
        }
        Bundle bundleW0 = w0();
        if (bundleW0 != null) {
            String string = bundleW0.getString("TEXT", null);
            if (!TextUtils.isEmpty(string)) {
                this.f3957v0.setText(string);
                return;
            }
        }
        Bundle bundleC = p5.b.d().c("FIND_CACHE");
        if (bundleC == null) {
            return;
        }
        String string2 = bundleC.getString("CACHED_TEXT", "");
        if (string2.isEmpty()) {
            return;
        }
        this.f3957v0.setText(string2);
    }

    public final void d3() {
        if (this.f3957v0 == null) {
            return;
        }
        p5.b.a().e("FIND_CACHE").f(180).d("CACHED_TEXT", this.f3957v0.getText().toString()).a();
    }

    public void e3(b bVar) {
        EditText editText;
        this.f3956u0 = bVar;
        if (bVar == null || (editText = this.f3957v0) == null) {
            return;
        }
        bVar.c(editText.getText().toString());
    }

    public void f3(int i10, int i11, boolean z10) {
        EditText editText = this.f3957v0;
        if (editText != null && z10) {
            boolean z11 = editText.getText().length() == 0 || i10 == -1;
            this.f3958w0.setVisibility(z11 ? 8 : 0);
            if (z11) {
                return;
            }
            if (i11 > 0) {
                i10++;
            }
            this.f3958w0.setText(String.format(Locale.ROOT, "%1$s/%2$s", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (h.this.f3956u0 != null) {
                h.this.f3956u0.c(editable.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
