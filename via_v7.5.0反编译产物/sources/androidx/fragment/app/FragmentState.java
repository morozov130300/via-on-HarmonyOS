package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f681c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f682e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f686p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f687q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f688r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f689s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f690t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f691u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f692v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f693w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f694x;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f681c = fragment.getClass().getName();
        this.f682e = fragment.f575p;
        this.f683m = fragment.f585z;
        this.f684n = fragment.I;
        this.f685o = fragment.J;
        this.f686p = fragment.K;
        this.f687q = fragment.N;
        this.f688r = fragment.f582w;
        this.f689s = fragment.M;
        this.f690t = fragment.L;
        this.f691u = fragment.f561d0.ordinal();
        this.f692v = fragment.f578s;
        this.f693w = fragment.f579t;
        this.f694x = fragment.V;
    }

    public Fragment a(v vVar, ClassLoader classLoader) {
        Fragment fragmentA = vVar.a(classLoader, this.f681c);
        fragmentA.f575p = this.f682e;
        fragmentA.f585z = this.f683m;
        fragmentA.B = true;
        fragmentA.I = this.f684n;
        fragmentA.J = this.f685o;
        fragmentA.K = this.f686p;
        fragmentA.N = this.f687q;
        fragmentA.f582w = this.f688r;
        fragmentA.M = this.f689s;
        fragmentA.L = this.f690t;
        fragmentA.f561d0 = Lifecycle.State.values()[this.f691u];
        fragmentA.f578s = this.f692v;
        fragmentA.f579t = this.f693w;
        fragmentA.V = this.f694x;
        return fragmentA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f681c);
        sb2.append(" (");
        sb2.append(this.f682e);
        sb2.append(")}:");
        if (this.f683m) {
            sb2.append(" fromLayout");
        }
        if (this.f685o != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f685o));
        }
        String str = this.f686p;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f686p);
        }
        if (this.f687q) {
            sb2.append(" retainInstance");
        }
        if (this.f688r) {
            sb2.append(" removing");
        }
        if (this.f689s) {
            sb2.append(" detached");
        }
        if (this.f690t) {
            sb2.append(" hidden");
        }
        if (this.f692v != null) {
            sb2.append(" targetWho=");
            sb2.append(this.f692v);
            sb2.append(" targetRequestCode=");
            sb2.append(this.f693w);
        }
        if (this.f694x) {
            sb2.append(" userVisibleHint");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f681c);
        parcel.writeString(this.f682e);
        parcel.writeInt(this.f683m ? 1 : 0);
        parcel.writeInt(this.f684n);
        parcel.writeInt(this.f685o);
        parcel.writeString(this.f686p);
        parcel.writeInt(this.f687q ? 1 : 0);
        parcel.writeInt(this.f688r ? 1 : 0);
        parcel.writeInt(this.f689s ? 1 : 0);
        parcel.writeInt(this.f690t ? 1 : 0);
        parcel.writeInt(this.f691u);
        parcel.writeString(this.f692v);
        parcel.writeInt(this.f693w);
        parcel.writeInt(this.f694x ? 1 : 0);
    }

    public FragmentState(Parcel parcel) {
        this.f681c = parcel.readString();
        this.f682e = parcel.readString();
        this.f683m = parcel.readInt() != 0;
        this.f684n = parcel.readInt();
        this.f685o = parcel.readInt();
        this.f686p = parcel.readString();
        this.f687q = parcel.readInt() != 0;
        this.f688r = parcel.readInt() != 0;
        this.f689s = parcel.readInt() != 0;
        this.f690t = parcel.readInt() != 0;
        this.f691u = parcel.readInt();
        this.f692v = parcel.readString();
        this.f693w = parcel.readInt();
        this.f694x = parcel.readInt() != 0;
    }
}
