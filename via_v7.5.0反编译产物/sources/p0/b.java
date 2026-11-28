package p0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f11540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f11541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f11542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f11543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f11544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11547k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new k.a(), new k.a(), new k.a());
    }

    @Override // p0.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f11541e.writeInt(-1);
        } else {
            this.f11541e.writeInt(bArr.length);
            this.f11541e.writeByteArray(bArr);
        }
    }

    @Override // p0.a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f11541e, 0);
    }

    @Override // p0.a
    public void E(int i10) {
        this.f11541e.writeInt(i10);
    }

    @Override // p0.a
    public void G(Parcelable parcelable) {
        this.f11541e.writeParcelable(parcelable, 0);
    }

    @Override // p0.a
    public void I(String str) {
        this.f11541e.writeString(str);
    }

    @Override // p0.a
    public void a() {
        int i10 = this.f11545i;
        if (i10 >= 0) {
            int i11 = this.f11540d.get(i10);
            int iDataPosition = this.f11541e.dataPosition();
            this.f11541e.setDataPosition(i11);
            this.f11541e.writeInt(iDataPosition - i11);
            this.f11541e.setDataPosition(iDataPosition);
        }
    }

    @Override // p0.a
    public a b() {
        Parcel parcel = this.f11541e;
        int iDataPosition = parcel.dataPosition();
        int i10 = this.f11546j;
        if (i10 == this.f11542f) {
            i10 = this.f11543g;
        }
        return new b(parcel, iDataPosition, i10, this.f11544h + "  ", this.f11537a, this.f11538b, this.f11539c);
    }

    @Override // p0.a
    public boolean g() {
        return this.f11541e.readInt() != 0;
    }

    @Override // p0.a
    public byte[] i() {
        int i10 = this.f11541e.readInt();
        if (i10 < 0) {
            return null;
        }
        byte[] bArr = new byte[i10];
        this.f11541e.readByteArray(bArr);
        return bArr;
    }

    @Override // p0.a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f11541e);
    }

    @Override // p0.a
    public boolean m(int i10) {
        while (this.f11546j < this.f11543g) {
            int i11 = this.f11547k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f11541e.setDataPosition(this.f11546j);
            int i12 = this.f11541e.readInt();
            this.f11547k = this.f11541e.readInt();
            this.f11546j += i12;
        }
        return this.f11547k == i10;
    }

    @Override // p0.a
    public int o() {
        return this.f11541e.readInt();
    }

    @Override // p0.a
    public Parcelable q() {
        return this.f11541e.readParcelable(getClass().getClassLoader());
    }

    @Override // p0.a
    public String s() {
        return this.f11541e.readString();
    }

    @Override // p0.a
    public void w(int i10) {
        a();
        this.f11545i = i10;
        this.f11540d.put(i10, this.f11541e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // p0.a
    public void y(boolean z10) {
        this.f11541e.writeInt(z10 ? 1 : 0);
    }

    public b(Parcel parcel, int i10, int i11, String str, k.a aVar, k.a aVar2, k.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f11540d = new SparseIntArray();
        this.f11545i = -1;
        this.f11547k = -1;
        this.f11541e = parcel;
        this.f11542f = i10;
        this.f11543g = i11;
        this.f11546j = i10;
        this.f11544h = str;
    }
}
