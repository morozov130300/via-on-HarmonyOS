package mark.via.common.rx;

import androidx.lifecycle.x;
import autodispose2.lifecycle.LifecycleEndedException;
import mark.via.common.rx.AutoDisposeViewModel;
import u0.b;
import u0.f;
import x6.c;
import x6.j;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class AutoDisposeViewModel extends x implements b {

    /* renamed from: e, reason: collision with root package name */
    public static final u0.a f9543e = new u0.a() { // from class: mark.via.common.rx.a
        @Override // u0.a, a7.f
        public final Object apply(Object obj) {
            return AutoDisposeViewModel.j((AutoDisposeViewModel.ViewModelEvent) obj);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public final h7.a f9544d = h7.a.P(ViewModelEvent.CREATED);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum ViewModelEvent {
        CREATED,
        CLEARED
    }

    public static /* synthetic */ ViewModelEvent j(ViewModelEvent viewModelEvent) {
        if (viewModelEvent == ViewModelEvent.CREATED) {
            return ViewModelEvent.CLEARED;
        }
        throw new LifecycleEndedException("Cannot bind to ViewModel lifecycle after onCleared.");
    }

    @Override // u0.b
    public j b() {
        return this.f9544d.u();
    }

    @Override // u0.b
    public u0.a c() {
        return f9543e;
    }

    @Override // autodispose2.o
    public c d() {
        return f.c(this);
    }

    @Override // androidx.lifecycle.x
    public void h() {
        this.f9544d.onNext(ViewModelEvent.CLEARED);
        super.h();
    }

    @Override // u0.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public ViewModelEvent a() {
        return (ViewModelEvent) this.f9544d.Q();
    }
}
