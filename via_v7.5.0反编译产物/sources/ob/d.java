package ob;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.lifecycle.a0;
import w7.p;
import w7.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public m f11090o0;

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(r.f13944m, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        v8.g.f(view);
        view.findViewById(p.J).setOnClickListener(new View.OnClickListener() { // from class: ob.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f11087a.f11090o0.w(0);
            }
        });
        final CheckBox checkBox = (CheckBox) view.findViewById(p.f13870g);
        EditText editText = (EditText) view.findViewById(p.f13888m);
        checkBox.setChecked(this.f11090o0.r());
        editText.setText(this.f11090o0.p());
        view.findViewById(p.f13874h0).setOnClickListener(new View.OnClickListener() { // from class: ob.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CheckBox checkBox2 = checkBox;
                checkBox2.setChecked(!checkBox2.isChecked());
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ob.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f11089a.f11090o0.v(z10);
            }
        });
        editText.addTextChangedListener(new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        if (K0() != null) {
            this.f11090o0 = (m) new a0(K0()).a(m.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.this.f11090o0.x(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
