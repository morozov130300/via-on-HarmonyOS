package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntentSender f437c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Intent f438e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f439m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f440n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f436o = new c(null);
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new b();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentSender f441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Intent f442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f444d;

        public a(IntentSender intentSender) {
            h.f(intentSender, "intentSender");
            this.f441a = intentSender;
        }

        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f441a, this.f442b, this.f443c, this.f444d);
        }

        public final a b(Intent intent) {
            this.f442b = intent;
            return this;
        }

        public final a c(int i10, int i11) {
            this.f444d = i10;
            this.f443c = i11;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel inParcel) {
            h.f(inParcel, "inParcel");
            return new IntentSenderRequest(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i10) {
            return new IntentSenderRequest[i10];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c {
        public /* synthetic */ c(f fVar) {
            this();
        }

        public c() {
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i10, int i11) {
        h.f(intentSender, "intentSender");
        this.f437c = intentSender;
        this.f438e = intent;
        this.f439m = i10;
        this.f440n = i11;
    }

    public final Intent a() {
        return this.f438e;
    }

    public final int b() {
        return this.f439m;
    }

    public final int c() {
        return this.f440n;
    }

    public final IntentSender d() {
        return this.f437c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        h.f(dest, "dest");
        dest.writeParcelable(this.f437c, i10);
        dest.writeParcelable(this.f438e, i10);
        dest.writeInt(this.f439m);
        dest.writeInt(this.f440n);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public IntentSenderRequest(Parcel parcel) {
        h.f(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        h.c(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
