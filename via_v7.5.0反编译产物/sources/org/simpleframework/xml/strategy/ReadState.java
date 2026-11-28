package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class ReadState extends WeakCache<ReadGraph> {
    private final Contract contract;
    private final Loader loader = new Loader();

    public ReadState(Contract contract) {
        this.contract = contract;
    }

    private ReadGraph create(Object obj) {
        ReadGraph readGraphFetch = fetch(obj);
        if (readGraphFetch != null) {
            return readGraphFetch;
        }
        ReadGraph readGraph = new ReadGraph(this.contract, this.loader);
        cache(obj, readGraph);
        return readGraph;
    }

    public ReadGraph find(Object obj) {
        ReadGraph readGraphFetch = fetch(obj);
        return readGraphFetch != null ? readGraphFetch : create(obj);
    }
}
