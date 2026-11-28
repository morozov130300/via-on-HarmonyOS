package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class WriteState extends WeakCache<WriteGraph> {
    private Contract contract;

    public WriteState(Contract contract) {
        this.contract = contract;
    }

    public WriteGraph find(Object obj) {
        WriteGraph writeGraphFetch = fetch(obj);
        if (writeGraphFetch != null) {
            return writeGraphFetch;
        }
        WriteGraph writeGraph = new WriteGraph(this.contract);
        cache(obj, writeGraph);
        return writeGraph;
    }
}
