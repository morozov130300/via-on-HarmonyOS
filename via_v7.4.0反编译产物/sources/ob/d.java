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
import androidx.lifecycle.y;
import x7.p;
import x7.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public m f10504m0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.this.f10504m0.x(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(r.f13878m, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        x8.g.f(view);
        view.findViewById(p.K).setOnClickListener(new View.OnClickListener() { // from class: ob.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f10501a.f10504m0.w(0);
            }
        });
        final CheckBox checkBox = (CheckBox) view.findViewById(p.f13804g);
        EditText editText = (EditText) view.findViewById(p.f13822m);
        checkBox.setChecked(this.f10504m0.r());
        editText.setText(this.f10504m0.p());
        view.findViewById(p.f13820l0).setOnClickListener(new View.OnClickListener() { // from class: ob.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                checkBox.setChecked(!r0.isChecked());
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ob.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f10503a.f10504m0.v(z10);
            }
        });
        editText.addTextChangedListener(new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        if (M0() != null) {
            this.f10504m0 = (m) new y(M0()).a(m.class);
        }
    }
}
