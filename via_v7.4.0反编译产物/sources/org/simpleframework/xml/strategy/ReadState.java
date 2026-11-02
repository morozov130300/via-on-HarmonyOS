package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
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
