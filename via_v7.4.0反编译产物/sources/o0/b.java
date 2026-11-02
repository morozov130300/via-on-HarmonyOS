package o0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f10323d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f10324e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10325f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10326g;

    /* renamed from: h, reason: collision with root package name */
    public final String f10327h;

    /* renamed from: i, reason: collision with root package name */
    public int f10328i;

    /* renamed from: j, reason: collision with root package name */
    public int f10329j;

    /* renamed from: k, reason: collision with root package name */
    public int f10330k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new k.a(), new k.a(), new k.a());
    }

    public b(Parcel parcel, int i10, int i11, String str, k.a aVar, k.a aVar2, k.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f10323d = new SparseIntArray();
        this.f10328i = -1;
        this.f10330k = -1;
        this.f10324e = parcel;
        this.f10325f = i10;
        this.f10326g = i11;
        this.f10329j = i10;
        this.f10327h = str;
    }

    @Override // o0.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f10324e.writeInt(-1);
        } else {
            this.f10324e.writeInt(bArr.length);
            this.f10324e.writeByteArray(bArr);
        }
    }

    @Override // o0.a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f10324e, 0);
    }

    @Override // o0.a
    public void E(int i10) {
        this.f10324e.writeInt(i10);
    }

    @Override // o0.a
    public void G(Parcelable parcelable) {
        this.f10324e.writeParcelable(parcelable, 0);
    }

    @Override // o0.a
    public void I(String str) {
        this.f10324e.writeString(str);
    }

    @Override // o0.a
    public void a() {
        int i10 = this.f10328i;
        if (i10 >= 0) {
            int i11 = this.f10323d.get(i10);
            int iDataPosition = this.f10324e.dataPosition();
            this.f10324e.setDataPosition(i11);
            this.f10324e.writeInt(iDataPosition - i11);
            this.f10324e.setDataPosition(iDataPosition);
        }
    }

    @Override // o0.a
    public a b() {
        Parcel parcel = this.f10324e;
        int iDataPosition = parcel.dataPosition();
        int i10 = this.f10329j;
        if (i10 == this.f10325f) {
            i10 = this.f10326g;
        }
        return new b(parcel, iDataPosition, i10, this.f10327h + "  ", this.f10320a, this.f10321b, this.f10322c);
    }

    @Override // o0.a
    public boolean g() {
        return this.f10324e.readInt() != 0;
    }

    @Override // o0.a
    public byte[] i() {
        int i10 = this.f10324e.readInt();
        if (i10 < 0) {
            return null;
        }
        byte[] bArr = new byte[i10];
        this.f10324e.readByteArray(bArr);
        return bArr;
    }

    @Override // o0.a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f10324e);
    }

    @Override // o0.a
    public boolean m(int i10) {
        while (this.f10329j < this.f10326g) {
            int i11 = this.f10330k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f10324e.setDataPosition(this.f10329j);
            int i12 = this.f10324e.readInt();
            this.f10330k = this.f10324e.readInt();
            this.f10329j += i12;
        }
        return this.f10330k == i10;
    }

    @Override // o0.a
    public int o() {
        return this.f10324e.readInt();
    }

    @Override // o0.a
    public Parcelable q() {
        return this.f10324e.readParcelable(getClass().getClassLoader());
    }

    @Override // o0.a
    public String s() {
        return this.f10324e.readString();
    }

    @Override // o0.a
    public void w(int i10) {
        a();
        this.f10328i = i10;
        this.f10323d.put(i10, this.f10324e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // o0.a
    public void y(boolean z10) {
        this.f10324e.writeInt(z10 ? 1 : 0);
    }
}
