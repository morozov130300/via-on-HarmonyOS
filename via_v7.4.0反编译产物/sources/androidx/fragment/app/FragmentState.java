package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    public final String f778e;

    /* renamed from: j, reason: collision with root package name */
    public final String f779j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f780k;

    /* renamed from: l, reason: collision with root package name */
    public final int f781l;

    /* renamed from: m, reason: collision with root package name */
    public final int f782m;

    /* renamed from: n, reason: collision with root package name */
    public final String f783n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f784o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f785p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f786q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f787r;

    /* renamed from: s, reason: collision with root package name */
    public final int f788s;

    /* renamed from: t, reason: collision with root package name */
    public final String f789t;

    /* renamed from: u, reason: collision with root package name */
    public final int f790u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f791v;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    public FragmentState(Parcel parcel) {
        this.f778e = parcel.readString();
        this.f779j = parcel.readString();
        this.f780k = parcel.readInt() != 0;
        this.f781l = parcel.readInt();
        this.f782m = parcel.readInt();
        this.f783n = parcel.readString();
        this.f784o = parcel.readInt() != 0;
        this.f785p = parcel.readInt() != 0;
        this.f786q = parcel.readInt() != 0;
        this.f787r = parcel.readInt() != 0;
        this.f788s = parcel.readInt();
        this.f789t = parcel.readString();
        this.f790u = parcel.readInt();
        this.f791v = parcel.readInt() != 0;
    }

    public FragmentState(Fragment fragment) {
        this.f778e = fragment.getClass().getName();
        this.f779j = fragment.f670n;
        this.f780k = fragment.f680x;
        this.f781l = fragment.G;
        this.f782m = fragment.H;
        this.f783n = fragment.I;
        this.f784o = fragment.L;
        this.f785p = fragment.f677u;
        this.f786q = fragment.K;
        this.f787r = fragment.J;
        this.f788s = fragment.f655b0.ordinal();
        this.f789t = fragment.f673q;
        this.f790u = fragment.f674r;
        this.f791v = fragment.T;
    }

    public Fragment a(v vVar, ClassLoader classLoader) {
        Fragment fragmentA = vVar.a(classLoader, this.f778e);
        fragmentA.f670n = this.f779j;
        fragmentA.f680x = this.f780k;
        fragmentA.f682z = true;
        fragmentA.G = this.f781l;
        fragmentA.H = this.f782m;
        fragmentA.I = this.f783n;
        fragmentA.L = this.f784o;
        fragmentA.f677u = this.f785p;
        fragmentA.K = this.f786q;
        fragmentA.J = this.f787r;
        fragmentA.f655b0 = Lifecycle.State.values()[this.f788s];
        fragmentA.f673q = this.f789t;
        fragmentA.f674r = this.f790u;
        fragmentA.T = this.f791v;
        return fragmentA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f778e);
        sb2.append(" (");
        sb2.append(this.f779j);
        sb2.append(")}:");
        if (this.f780k) {
            sb2.append(" fromLayout");
        }
        if (this.f782m != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f782m));
        }
        String str = this.f783n;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f783n);
        }
        if (this.f784o) {
            sb2.append(" retainInstance");
        }
        if (this.f785p) {
            sb2.append(" removing");
        }
        if (this.f786q) {
            sb2.append(" detached");
        }
        if (this.f787r) {
            sb2.append(" hidden");
        }
        if (this.f789t != null) {
            sb2.append(" targetWho=");
            sb2.append(this.f789t);
            sb2.append(" targetRequestCode=");
            sb2.append(this.f790u);
        }
        if (this.f791v) {
            sb2.append(" userVisibleHint");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f778e);
        parcel.writeString(this.f779j);
        parcel.writeInt(this.f780k ? 1 : 0);
        parcel.writeInt(this.f781l);
        parcel.writeInt(this.f782m);
        parcel.writeString(this.f783n);
        parcel.writeInt(this.f784o ? 1 : 0);
        parcel.writeInt(this.f785p ? 1 : 0);
        parcel.writeInt(this.f786q ? 1 : 0);
        parcel.writeInt(this.f787r ? 1 : 0);
        parcel.writeInt(this.f788s);
        parcel.writeString(this.f789t);
        parcel.writeInt(this.f790u);
        parcel.writeInt(this.f791v ? 1 : 0);
    }
}
