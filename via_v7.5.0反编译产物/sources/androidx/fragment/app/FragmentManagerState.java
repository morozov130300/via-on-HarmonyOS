package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f673c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f674e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BackStackRecordState[] f675m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f676n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f677o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f678p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f679q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f680r;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i10) {
            return new FragmentManagerState[i10];
        }
    }

    public FragmentManagerState() {
        this.f677o = null;
        this.f678p = new ArrayList();
        this.f679q = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f673c);
        parcel.writeStringList(this.f674e);
        parcel.writeTypedArray(this.f675m, i10);
        parcel.writeInt(this.f676n);
        parcel.writeString(this.f677o);
        parcel.writeStringList(this.f678p);
        parcel.writeTypedList(this.f679q);
        parcel.writeTypedList(this.f680r);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f677o = null;
        this.f678p = new ArrayList();
        this.f679q = new ArrayList();
        this.f673c = parcel.createStringArrayList();
        this.f674e = parcel.createStringArrayList();
        this.f675m = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f676n = parcel.readInt();
        this.f677o = parcel.readString();
        this.f678p = parcel.createStringArrayList();
        this.f679q = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f680r = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
