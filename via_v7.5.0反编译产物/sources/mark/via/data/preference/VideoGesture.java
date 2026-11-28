package mark.via.data.preference;

import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public enum VideoGesture {
    SEEK(1, u.ji),
    HOLD(2, u.li),
    VOLUME(4, u.mi),
    BRIGHTNESS(8, u.ii);

    public final int flag;
    public final int label;

    VideoGesture(int i10, int i11) {
        this.flag = i10;
        this.label = i11;
    }
}
