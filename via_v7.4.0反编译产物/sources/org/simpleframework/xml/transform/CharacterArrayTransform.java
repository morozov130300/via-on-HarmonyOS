package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class CharacterArrayTransform implements Transform {
    private final Class entry;

    public CharacterArrayTransform(Class cls) {
        this.entry = cls;
    }

    private Object read(char[] cArr, int i10) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        Object objNewInstance = Array.newInstance((Class<?>) this.entry, i10);
        for (int i11 = 0; i11 < i10; i11++) {
            Array.set(objNewInstance, i11, Character.valueOf(cArr[i11]));
        }
        return objNewInstance;
    }

    private String write(Object obj, int i10) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        StringBuilder sb2 = new StringBuilder(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj2 = Array.get(obj, i11);
            if (obj2 != null) {
                sb2.append(obj2);
            }
        }
        return sb2.toString();
    }

    @Override // org.simpleframework.xml.transform.Transform
    public Object read(String str) {
        char[] charArray = str.toCharArray();
        return this.entry == Character.TYPE ? charArray : read(charArray, charArray.length);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Object obj) {
        return this.entry == Character.TYPE ? new String((char[]) obj) : write(obj, Array.getLength(obj));
    }
}
