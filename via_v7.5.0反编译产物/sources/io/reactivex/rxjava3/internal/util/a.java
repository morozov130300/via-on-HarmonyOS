package io.reactivex.rxjava3.internal.util;

import r6.o;
import u6.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f6705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f6706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6707d;

    /* JADX INFO: renamed from: io.reactivex.rxjava3.internal.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0081a extends i {
        @Override // u6.i
        boolean test(Object obj);
    }

    public a(int i10) {
        this.f6704a = i10;
        Object[] objArr = new Object[i10 + 1];
        this.f6705b = objArr;
        this.f6706c = objArr;
    }

    public boolean a(o oVar) {
        Object[] objArr = this.f6705b;
        int i10 = this.f6704a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    break;
                }
                if (NotificationLite.acceptFull(objArr2, oVar)) {
                    return true;
                }
            }
            objArr = objArr[i10];
        }
    }

    public void b(Object obj) {
        int i10 = this.f6704a;
        int i11 = this.f6707d;
        if (i11 == i10) {
            Object[] objArr = new Object[i10 + 1];
            this.f6706c[i10] = objArr;
            this.f6706c = objArr;
            i11 = 0;
        }
        this.f6706c[i11] = obj;
        this.f6707d = i11 + 1;
    }

    public void c(InterfaceC0081a interfaceC0081a) {
        int i10 = this.f6704a;
        for (Object[] objArr = this.f6705b; objArr != null; objArr = objArr[i10]) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = objArr[i11];
                if (obj == null) {
                    break;
                } else {
                    if (interfaceC0081a.test(obj)) {
                        return;
                    }
                }
            }
        }
    }

    public void d(Object obj) {
        this.f6705b[0] = obj;
    }
}
