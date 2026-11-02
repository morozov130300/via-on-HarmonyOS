package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ArrayTransform implements Transform {
    private final Transform delegate;
    private final Class entry;
    private final StringArrayTransform split = new StringArrayTransform();

    public ArrayTransform(Transform transform, Class cls) {
        this.delegate = transform;
        this.entry = cls;
    }

    private Object read(String[] strArr, int i10) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        Object objNewInstance = Array.newInstance((Class<?>) this.entry, i10);
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = this.delegate.read(strArr[i11]);
            if (obj != null) {
                Array.set(objNewInstance, i11, obj);
            }
        }
        return objNewInstance;
    }

    private String write(Object obj, int i10) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        String[] strArr = new String[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj2 = Array.get(obj, i11);
            if (obj2 != null) {
                strArr[i11] = this.delegate.write(obj2);
            }
        }
        return this.split.write(strArr);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public Object read(String str) {
        String[] strArr = this.split.read(str);
        return read(strArr, strArr.length);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Object obj) {
        return write(obj, Array.getLength(obj));
    }
}
