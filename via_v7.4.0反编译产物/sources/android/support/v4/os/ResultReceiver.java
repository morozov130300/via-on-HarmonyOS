package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    public final boolean f415e = false;

    /* renamed from: j, reason: collision with root package name */
    public final Handler f416j = null;

    /* renamed from: k, reason: collision with root package name */
    public android.support.v4.os.a f417k;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i10) {
            return new ResultReceiver[i10];
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends a.AbstractBinderC0008a {
        public b() {
        }

        @Override // android.support.v4.os.a
        public void X(int i10, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f416j;
            if (handler != null) {
                handler.post(resultReceiver.new c(i10, bundle));
            } else {
                resultReceiver.a(i10, bundle);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final int f419e;

        /* renamed from: j, reason: collision with root package name */
        public final Bundle f420j;

        public c(int i10, Bundle bundle) {
            this.f419e = i10;
            this.f420j = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.f419e, this.f420j);
        }
    }

    public ResultReceiver(Parcel parcel) {
        this.f417k = a.AbstractBinderC0008a.Y(parcel.readStrongBinder());
    }

    public void a(int i10, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            try {
                if (this.f417k == null) {
                    this.f417k = new b();
                }
                parcel.writeStrongBinder(this.f417k.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
