package r7;

import java.util.Random;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends r7.a {

    /* renamed from: j, reason: collision with root package name */
    public final a f11585j = new a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // r7.a
    public Random a() {
        Object obj = this.f11585j.get();
        h.e(obj, "implStorage.get()");
        return (Random) obj;
    }
}
