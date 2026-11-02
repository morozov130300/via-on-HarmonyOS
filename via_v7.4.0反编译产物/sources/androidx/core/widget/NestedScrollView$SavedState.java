package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class NestedScrollView$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<NestedScrollView$SavedState> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    public int f598e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NestedScrollView$SavedState createFromParcel(Parcel parcel) {
            return new NestedScrollView$SavedState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NestedScrollView$SavedState[] newArray(int i10) {
            return new NestedScrollView$SavedState[i10];
        }
    }

    public NestedScrollView$SavedState(Parcel parcel) {
        super(parcel);
        this.f598e = parcel.readInt();
    }

    public String toString() {
        return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f598e + "}";
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeInt(this.f598e);
    }
}
