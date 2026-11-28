package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f504c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f505e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int[] f506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int[] f507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f511r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CharSequence f512s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f513t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CharSequence f514u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f515v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f516w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f517x;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i10) {
            return new BackStackRecordState[i10];
        }
    }

    public BackStackRecordState(androidx.fragment.app.a aVar) {
        int size = aVar.f790c.size();
        this.f504c = new int[size * 6];
        if (!aVar.f796i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f505e = new ArrayList(size);
        this.f506m = new int[size];
        this.f507n = new int[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            l0.a aVar2 = (l0.a) aVar.f790c.get(i11);
            int i12 = i10 + 1;
            this.f504c[i10] = aVar2.f807a;
            ArrayList arrayList = this.f505e;
            Fragment fragment = aVar2.f808b;
            arrayList.add(fragment != null ? fragment.f575p : null);
            int[] iArr = this.f504c;
            iArr[i12] = aVar2.f809c ? 1 : 0;
            iArr[i10 + 2] = aVar2.f810d;
            iArr[i10 + 3] = aVar2.f811e;
            int i13 = i10 + 5;
            iArr[i10 + 4] = aVar2.f812f;
            i10 += 6;
            iArr[i13] = aVar2.f813g;
            this.f506m[i11] = aVar2.f814h.ordinal();
            this.f507n[i11] = aVar2.f815i.ordinal();
        }
        this.f508o = aVar.f795h;
        this.f509p = aVar.f798k;
        this.f510q = aVar.f724v;
        this.f511r = aVar.f799l;
        this.f512s = aVar.f800m;
        this.f513t = aVar.f801n;
        this.f514u = aVar.f802o;
        this.f515v = aVar.f803p;
        this.f516w = aVar.f804q;
        this.f517x = aVar.f805r;
    }

    public final void a(androidx.fragment.app.a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= this.f504c.length) {
                aVar.f795h = this.f508o;
                aVar.f798k = this.f509p;
                aVar.f796i = true;
                aVar.f799l = this.f511r;
                aVar.f800m = this.f512s;
                aVar.f801n = this.f513t;
                aVar.f802o = this.f514u;
                aVar.f803p = this.f515v;
                aVar.f804q = this.f516w;
                aVar.f805r = this.f517x;
                return;
            }
            l0.a aVar2 = new l0.a();
            int i12 = i10 + 1;
            aVar2.f807a = this.f504c[i10];
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i11 + " base fragment #" + this.f504c[i12]);
            }
            aVar2.f814h = Lifecycle.State.values()[this.f506m[i11]];
            aVar2.f815i = Lifecycle.State.values()[this.f507n[i11]];
            int[] iArr = this.f504c;
            int i13 = i10 + 2;
            if (iArr[i12] == 0) {
                z10 = false;
            }
            aVar2.f809c = z10;
            int i14 = iArr[i13];
            aVar2.f810d = i14;
            int i15 = iArr[i10 + 3];
            aVar2.f811e = i15;
            int i16 = i10 + 5;
            int i17 = iArr[i10 + 4];
            aVar2.f812f = i17;
            i10 += 6;
            int i18 = iArr[i16];
            aVar2.f813g = i18;
            aVar.f791d = i14;
            aVar.f792e = i15;
            aVar.f793f = i17;
            aVar.f794g = i18;
            aVar.f(aVar2);
            i11++;
        }
    }

    public androidx.fragment.app.a b(FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        a(aVar);
        aVar.f724v = this.f510q;
        for (int i10 = 0; i10 < this.f505e.size(); i10++) {
            String str = (String) this.f505e.get(i10);
            if (str != null) {
                ((l0.a) aVar.f790c.get(i10)).f808b = fragmentManager.k0(str);
            }
        }
        aVar.y(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f504c);
        parcel.writeStringList(this.f505e);
        parcel.writeIntArray(this.f506m);
        parcel.writeIntArray(this.f507n);
        parcel.writeInt(this.f508o);
        parcel.writeString(this.f509p);
        parcel.writeInt(this.f510q);
        parcel.writeInt(this.f511r);
        TextUtils.writeToParcel(this.f512s, parcel, 0);
        parcel.writeInt(this.f513t);
        TextUtils.writeToParcel(this.f514u, parcel, 0);
        parcel.writeStringList(this.f515v);
        parcel.writeStringList(this.f516w);
        parcel.writeInt(this.f517x ? 1 : 0);
    }

    public BackStackRecordState(Parcel parcel) {
        this.f504c = parcel.createIntArray();
        this.f505e = parcel.createStringArrayList();
        this.f506m = parcel.createIntArray();
        this.f507n = parcel.createIntArray();
        this.f508o = parcel.readInt();
        this.f509p = parcel.readString();
        this.f510q = parcel.readInt();
        this.f511r = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f512s = (CharSequence) creator.createFromParcel(parcel);
        this.f513t = parcel.readInt();
        this.f514u = (CharSequence) creator.createFromParcel(parcel);
        this.f515v = parcel.createStringArrayList();
        this.f516w = parcel.createStringArrayList();
        this.f517x = parcel.readInt() != 0;
    }
}
