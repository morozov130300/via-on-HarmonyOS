package z;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15078c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d0 f15079e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f15080m;

    public a(int i10, d0 d0Var, int i11) {
        this.f15078c = i10;
        this.f15079e = d0Var;
        this.f15080m = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f15078c);
        this.f15079e.L(this.f15080m, bundle);
    }
}
