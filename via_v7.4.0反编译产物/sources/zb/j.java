package zb;

import java.util.List;
import okhttp3.internal.http2.ErrorCode;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f14959a = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements j {
        @Override // zb.j
        public boolean a(int i10, List list) {
            return true;
        }

        @Override // zb.j
        public boolean b(int i10, List list, boolean z10) {
            return true;
        }

        @Override // zb.j
        public void c(int i10, ErrorCode errorCode) {
        }

        @Override // zb.j
        public boolean d(int i10, okio.e eVar, int i11, boolean z10) {
            eVar.skip(i11);
            return true;
        }
    }

    boolean a(int i10, List list);

    boolean b(int i10, List list, boolean z10);

    void c(int i10, ErrorCode errorCode);

    boolean d(int i10, okio.e eVar, int i11, boolean z10);
}
