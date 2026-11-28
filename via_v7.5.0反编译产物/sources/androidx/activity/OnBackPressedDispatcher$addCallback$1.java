package androidx.activity;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class OnBackPressedDispatcher$addCallback$1 extends FunctionReferenceImpl implements p7.a {
    public OnBackPressedDispatcher$addCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    @Override // p7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m3invoke();
        return d7.h.f3935a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m3invoke() {
        ((OnBackPressedDispatcher) this.receiver).p();
    }
}
