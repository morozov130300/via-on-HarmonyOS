package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {

    /* renamed from: e, reason: collision with root package name */
    public final IntentSender f534e;

    /* renamed from: j, reason: collision with root package name */
    public final Intent f535j;

    /* renamed from: k, reason: collision with root package name */
    public final int f536k;

    /* renamed from: l, reason: collision with root package name */
    public final int f537l;

    /* renamed from: m, reason: collision with root package name */
    public static final c f533m = new c(null);
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new b();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final IntentSender f538a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f539b;

        /* renamed from: c, reason: collision with root package name */
        public int f540c;

        /* renamed from: d, reason: collision with root package name */
        public int f541d;

        public a(IntentSender intentSender) {
            h.f(intentSender, "intentSender");
            this.f538a = intentSender;
        }

        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f538a, this.f539b, this.f540c, this.f541d);
        }

        public final a b(Intent intent) {
            this.f539b = intent;
            return this;
        }

        public final a c(int i10, int i11) {
            this.f541d = i10;
            this.f540c = i11;
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel inParcel) {
            h.f(inParcel, "inParcel");
            return new IntentSenderRequest(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i10) {
            return new IntentSenderRequest[i10];
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i10, int i11) {
        h.f(intentSender, "intentSender");
        this.f534e = intentSender;
        this.f535j = intent;
        this.f536k = i10;
        this.f537l = i11;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public IntentSenderRequest(Parcel parcel) {
        h.f(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        h.c(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    public final Intent a() {
        return this.f535j;
    }

    public final int b() {
        return this.f536k;
    }

    public final int c() {
        return this.f537l;
    }

    public final IntentSender d() {
        return this.f534e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        h.f(dest, "dest");
        dest.writeParcelable(this.f534e, i10);
        dest.writeParcelable(this.f535j, i10);
        dest.writeInt(this.f536k);
        dest.writeInt(this.f537l);
    }
}
