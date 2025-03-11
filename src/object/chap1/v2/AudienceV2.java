package object.chap1.v2;

import object.chap1.v1.BagV1;

public class AudienceV2 {

    private BagV1 bag;

    public AudienceV2(BagV1 bag) {
        this.bag = bag;
    }

    public BagV1 getBag() {
        return bag;
    }
}
