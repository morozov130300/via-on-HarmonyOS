package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class ModelList extends ArrayList<Model> {
    public ModelList build() {
        ModelList modelList = new ModelList();
        Iterator<Model> it = iterator();
        while (it.hasNext()) {
            modelList.register(it.next());
        }
        return modelList;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        for (Model model : this) {
            if (model != null && !model.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Model lookup(int i10) {
        if (i10 <= size()) {
            return get(i10 - 1);
        }
        return null;
    }

    public void register(Model model) {
        int index = model.getIndex();
        int size = size();
        for (int i10 = 0; i10 < index; i10++) {
            if (i10 >= size) {
                add(null);
            }
            int i11 = index - 1;
            if (i10 == i11) {
                set(i11, model);
            }
        }
    }

    public Model take() {
        while (!isEmpty()) {
            Model modelRemove = remove(0);
            if (!modelRemove.isEmpty()) {
                return modelRemove;
            }
        }
        return null;
    }
}
