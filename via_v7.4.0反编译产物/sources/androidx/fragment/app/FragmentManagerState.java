package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f770e;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f771j;

    /* renamed from: k, reason: collision with root package name */
    public BackStackRecordState[] f772k;

    /* renamed from: l, reason: collision with root package name */
    public int f773l;

    /* renamed from: m, reason: collision with root package name */
    public String f774m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f775n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f776o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f777p;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i10) {
            return new FragmentManagerState[i10];
        }
    }

    public FragmentManagerState() {
        this.f774m = null;
        this.f775n = new ArrayList();
        this.f776o = new ArrayList();
    }

    public FragmentManagerState(Parcel parcel) {
        this.f774m = null;
        this.f775n = new ArrayList();
        this.f776o = new ArrayList();
        this.f770e = parcel.createStringArrayList();
        this.f771j = parcel.createStringArrayList();
        this.f772k = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f773l = parcel.readInt();
        this.f774m = parcel.readString();
        this.f775n = parcel.createStringArrayList();
        this.f776o = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f777p = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f770e);
        parcel.writeStringList(this.f771j);
        parcel.writeTypedArray(this.f772k, i10);
        parcel.writeInt(this.f773l);
        parcel.writeString(this.f774m);
        parcel.writeStringList(this.f775n);
        parcel.writeTypedList(this.f776o);
        parcel.writeTypedList(this.f777p);
    }
}
