package mark.via.common.rx;

import androidx.lifecycle.z;
import autodispose2.lifecycle.LifecycleEndedException;
import r6.c;
import r6.j;
import v0.b;
import v0.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class AutoDisposeViewModel extends z implements b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v0.a f9834e = new v0.a() { // from class: mark.via.common.rx.a
        @Override // v0.a, u6.g
        public final Object apply(Object obj) {
            return AutoDisposeViewModel.j((AutoDisposeViewModel.ViewModelEvent) obj);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b7.a f9835d = b7.a.S(ViewModelEvent.CREATED);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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

    @Override // v0.b
    public j b() {
        return this.f9835d.x();
    }

    @Override // v0.b
    public v0.a c() {
        return f9834e;
    }

    @Override // autodispose2.o
    public c d() {
        return f.e(this);
    }

    @Override // androidx.lifecycle.z
    public void h() {
        this.f9835d.onNext(ViewModelEvent.CLEARED);
        super.h();
    }

    @Override // v0.b
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ViewModelEvent a() {
        return (ViewModelEvent) this.f9835d.T();
    }
}
