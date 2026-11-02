package u8;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends u8.a {

    /* renamed from: e, reason: collision with root package name */
    public final TextView f12875e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends u6.b implements TextWatcher {

        /* renamed from: j, reason: collision with root package name */
        public final TextView f12876j;

        /* renamed from: k, reason: collision with root package name */
        public final m f12877k;

        public a(TextView textView, m mVar) {
            this.f12876j = textView;
            this.f12877k = mVar;
        }

        @Override // u6.b
        public void a() {
            this.f12876j.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (isDisposed()) {
                return;
            }
            this.f12877k.onNext(charSequence);
        }
    }

    public d(TextView textView) {
        this.f12875e = textView;
    }

    @Override // u8.a
    public void O(m mVar) {
        a aVar = new a(this.f12875e, mVar);
        mVar.onSubscribe(aVar);
        this.f12875e.addTextChangedListener(aVar);
    }

    @Override // u8.a
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public CharSequence N() {
        return this.f12875e.getText();
    }
}
