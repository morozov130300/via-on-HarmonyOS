package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.l0;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    public final int[] f601e;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f602j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f603k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f604l;

    /* renamed from: m, reason: collision with root package name */
    public final int f605m;

    /* renamed from: n, reason: collision with root package name */
    public final String f606n;

    /* renamed from: o, reason: collision with root package name */
    public final int f607o;

    /* renamed from: p, reason: collision with root package name */
    public final int f608p;

    /* renamed from: q, reason: collision with root package name */
    public final CharSequence f609q;

    /* renamed from: r, reason: collision with root package name */
    public final int f610r;

    /* renamed from: s, reason: collision with root package name */
    public final CharSequence f611s;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f612t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f613u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f614v;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i10) {
            return new BackStackRecordState[i10];
        }
    }

    public BackStackRecordState(Parcel parcel) {
        this.f601e = parcel.createIntArray();
        this.f602j = parcel.createStringArrayList();
        this.f603k = parcel.createIntArray();
        this.f604l = parcel.createIntArray();
        this.f605m = parcel.readInt();
        this.f606n = parcel.readString();
        this.f607o = parcel.readInt();
        this.f608p = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f609q = (CharSequence) creator.createFromParcel(parcel);
        this.f610r = parcel.readInt();
        this.f611s = (CharSequence) creator.createFromParcel(parcel);
        this.f612t = parcel.createStringArrayList();
        this.f613u = parcel.createStringArrayList();
        this.f614v = parcel.readInt() != 0;
    }

    public BackStackRecordState(androidx.fragment.app.a aVar) {
        int size = aVar.f889c.size();
        this.f601e = new int[size * 6];
        if (!aVar.f895i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f602j = new ArrayList(size);
        this.f603k = new int[size];
        this.f604l = new int[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            l0.a aVar2 = (l0.a) aVar.f889c.get(i11);
            int i12 = i10 + 1;
            this.f601e[i10] = aVar2.f906a;
            ArrayList arrayList = this.f602j;
            Fragment fragment = aVar2.f907b;
            arrayList.add(fragment != null ? fragment.f670n : null);
            int[] iArr = this.f601e;
            iArr[i12] = aVar2.f908c ? 1 : 0;
            iArr[i10 + 2] = aVar2.f909d;
            iArr[i10 + 3] = aVar2.f910e;
            int i13 = i10 + 5;
            iArr[i10 + 4] = aVar2.f911f;
            i10 += 6;
            iArr[i13] = aVar2.f912g;
            this.f603k[i11] = aVar2.f913h.ordinal();
            this.f604l[i11] = aVar2.f914i.ordinal();
        }
        this.f605m = aVar.f894h;
        this.f606n = aVar.f897k;
        this.f607o = aVar.f821v;
        this.f608p = aVar.f898l;
        this.f609q = aVar.f899m;
        this.f610r = aVar.f900n;
        this.f611s = aVar.f901o;
        this.f612t = aVar.f902p;
        this.f613u = aVar.f903q;
        this.f614v = aVar.f904r;
    }

    public final void a(androidx.fragment.app.a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= this.f601e.length) {
                aVar.f894h = this.f605m;
                aVar.f897k = this.f606n;
                aVar.f895i = true;
                aVar.f898l = this.f608p;
                aVar.f899m = this.f609q;
                aVar.f900n = this.f610r;
                aVar.f901o = this.f611s;
                aVar.f902p = this.f612t;
                aVar.f903q = this.f613u;
                aVar.f904r = this.f614v;
                return;
            }
            l0.a aVar2 = new l0.a();
            int i12 = i10 + 1;
            aVar2.f906a = this.f601e[i10];
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i11 + " base fragment #" + this.f601e[i12]);
            }
            aVar2.f913h = Lifecycle.State.values()[this.f603k[i11]];
            aVar2.f914i = Lifecycle.State.values()[this.f604l[i11]];
            int[] iArr = this.f601e;
            int i13 = i10 + 2;
            if (iArr[i12] == 0) {
                z10 = false;
            }
            aVar2.f908c = z10;
            int i14 = iArr[i13];
            aVar2.f909d = i14;
            int i15 = iArr[i10 + 3];
            aVar2.f910e = i15;
            int i16 = i10 + 5;
            int i17 = iArr[i10 + 4];
            aVar2.f911f = i17;
            i10 += 6;
            int i18 = iArr[i16];
            aVar2.f912g = i18;
            aVar.f890d = i14;
            aVar.f891e = i15;
            aVar.f892f = i17;
            aVar.f893g = i18;
            aVar.f(aVar2);
            i11++;
        }
    }

    public androidx.fragment.app.a b(FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        a(aVar);
        aVar.f821v = this.f607o;
        for (int i10 = 0; i10 < this.f602j.size(); i10++) {
            String str = (String) this.f602j.get(i10);
            if (str != null) {
                ((l0.a) aVar.f889c.get(i10)).f907b = fragmentManager.k0(str);
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
        parcel.writeIntArray(this.f601e);
        parcel.writeStringList(this.f602j);
        parcel.writeIntArray(this.f603k);
        parcel.writeIntArray(this.f604l);
        parcel.writeInt(this.f605m);
        parcel.writeString(this.f606n);
        parcel.writeInt(this.f607o);
        parcel.writeInt(this.f608p);
        TextUtils.writeToParcel(this.f609q, parcel, 0);
        parcel.writeInt(this.f610r);
        TextUtils.writeToParcel(this.f611s, parcel, 0);
        parcel.writeStringList(this.f612t);
        parcel.writeStringList(this.f613u);
        parcel.writeInt(this.f614v ? 1 : 0);
    }
}
