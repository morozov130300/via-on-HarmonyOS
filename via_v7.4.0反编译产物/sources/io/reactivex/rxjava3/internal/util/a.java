package io.reactivex.rxjava3.internal.util;

import a7.h;
import x6.m;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f7469a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f7470b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f7471c;

    /* renamed from: d, reason: collision with root package name */
    public int f7472d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: io.reactivex.rxjava3.internal.util.a$a, reason: collision with other inner class name */
    public interface InterfaceC0087a extends h {
        @Override // a7.h
        boolean test(Object obj);
    }

    public a(int i10) {
        this.f7469a = i10;
        Object[] objArr = new Object[i10 + 1];
        this.f7470b = objArr;
        this.f7471c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(m mVar) {
        Object[] objArr = this.f7470b;
        int i10 = this.f7469a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    break;
                }
                if (NotificationLite.acceptFull(objArr2, mVar)) {
                    return true;
                }
            }
            objArr = objArr[i10];
        }
    }

    public void b(Object obj) {
        int i10 = this.f7469a;
        int i11 = this.f7472d;
        if (i11 == i10) {
            Object[] objArr = new Object[i10 + 1];
            this.f7471c[i10] = objArr;
            this.f7471c = objArr;
            i11 = 0;
        }
        this.f7471c[i11] = obj;
        this.f7472d = i11 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(InterfaceC0087a interfaceC0087a) {
        int i10 = this.f7469a;
        for (Object[] objArr = this.f7470b; objArr != null; objArr = objArr[i10]) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = objArr[i11];
                if (obj == null) {
                    break;
                } else {
                    if (interfaceC0087a.test(obj)) {
                        return;
                    }
                }
            }
        }
    }

    public void d(Object obj) {
        this.f7470b[0] = obj;
    }
}
