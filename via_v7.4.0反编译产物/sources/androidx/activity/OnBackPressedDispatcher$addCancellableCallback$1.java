package androidx.activity;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public /* synthetic */ class OnBackPressedDispatcher$addCancellableCallback$1 extends FunctionReferenceImpl implements q7.a {
    public OnBackPressedDispatcher$addCancellableCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    @Override // q7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m4invoke();
        return j7.f.f7594a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m4invoke() {
        ((OnBackPressedDispatcher) this.receiver).p();
    }
}
