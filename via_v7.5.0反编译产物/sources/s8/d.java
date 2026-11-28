package s8;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import r6.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends s8.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f12226c;

    public d(TextView textView) {
        this.f12226c = textView;
    }

    @Override // s8.a
    public void R(o oVar) {
        a aVar = new a(this.f12226c, oVar);
        oVar.onSubscribe(aVar);
        this.f12226c.addTextChangedListener(aVar);
    }

    @Override // s8.a
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public CharSequence Q() {
        return this.f12226c.getText();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends o6.b implements TextWatcher {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f12227e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final o f12228m;

        public a(TextView textView, o oVar) {
            this.f12227e = textView;
            this.f12228m = oVar;
        }

        @Override // o6.b
        public void a() {
            this.f12227e.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (isDisposed()) {
                return;
            }
            this.f12228m.onNext(charSequence);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
