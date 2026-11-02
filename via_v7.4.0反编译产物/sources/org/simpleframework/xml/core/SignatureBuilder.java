package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class SignatureBuilder {
    private final Constructor factory;
    private final ParameterTable table = new ParameterTable();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class ParameterList extends ArrayList<Parameter> {
        public ParameterList() {
        }

        public ParameterList(ParameterList parameterList) {
            super(parameterList);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class ParameterTable extends ArrayList<ParameterList> {
        /* JADX INFO: Access modifiers changed from: private */
        public int height() {
            if (width() > 0) {
                return get(0).size();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int width() {
            return size();
        }

        public Parameter get(int i10, int i11) {
            return get(i10).get(i11);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public ParameterList get(int i10) {
            for (int size = size(); size <= i10; size++) {
                add(new ParameterList());
            }
            return (ParameterList) super.get(i10);
        }

        public void insert(Parameter parameter, int i10) {
            ParameterList parameterList = get(i10);
            if (parameterList != null) {
                parameterList.add(parameter);
            }
        }
    }

    public SignatureBuilder(Constructor constructor) {
        this.factory = constructor;
    }

    private List<Signature> build(ParameterTable parameterTable) {
        if (this.table.isEmpty()) {
            return create();
        }
        build(parameterTable, 0);
        return create(parameterTable);
    }

    private void build(ParameterTable parameterTable, int i10) {
        build(parameterTable, new ParameterList(), i10);
    }

    private void build(ParameterTable parameterTable, ParameterList parameterList, int i10) {
        ParameterList parameterList2 = this.table.get(i10);
        int size = parameterList2.size();
        if (this.table.width() - 1 <= i10) {
            populate(parameterTable, parameterList, i10);
            return;
        }
        for (int i11 = 0; i11 < size; i11++) {
            ParameterList parameterList3 = new ParameterList(parameterList);
            if (parameterList != null) {
                parameterList3.add(parameterList2.get(i11));
                build(parameterTable, parameterList3, i10 + 1);
            }
        }
    }

    private List<Signature> create() {
        ArrayList arrayList = new ArrayList();
        Signature signature = new Signature(this.factory);
        if (isValid()) {
            arrayList.add(signature);
        }
        return arrayList;
    }

    private List<Signature> create(ParameterTable parameterTable) throws ConstructorException {
        ArrayList arrayList = new ArrayList();
        int iHeight = parameterTable.height();
        int iWidth = parameterTable.width();
        for (int i10 = 0; i10 < iHeight; i10++) {
            Signature signature = new Signature(this.factory);
            for (int i11 = 0; i11 < iWidth; i11++) {
                Parameter parameter = parameterTable.get(i11, i10);
                String path = parameter.getPath();
                if (signature.contains(parameter.getKey())) {
                    throw new ConstructorException("Parameter '%s' is a duplicate in %s", path, this.factory);
                }
                signature.add(parameter);
            }
            arrayList.add(signature);
        }
        return arrayList;
    }

    private void populate(ParameterTable parameterTable, ParameterList parameterList, int i10) {
        ParameterList parameterList2 = this.table.get(i10);
        int size = parameterList.size();
        int size2 = parameterList2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            for (int i12 = 0; i12 < size; i12++) {
                parameterTable.get(i12).add(parameterList.get(i12));
            }
            parameterTable.get(i10).add(parameterList2.get(i11));
        }
    }

    public List<Signature> build() {
        return build(new ParameterTable());
    }

    public void insert(Parameter parameter, int i10) {
        this.table.insert(parameter, i10);
    }

    public boolean isValid() {
        return this.factory.getParameterTypes().length == this.table.width();
    }
}
