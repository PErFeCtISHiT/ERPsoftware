package mock;

import server.Po.cutPO;
import server.Po.packPO;
import server.Po.selloutPO;

/**
 * Created by Leonarda on 2017/11/7.
 */
public class MockCutEnvironment {
    cutPO cut;
    packPO pack;

    public cutPO Cutoutmake(selloutPO sellout) {
        return cut;
    }

    public packPO Packmake(packPO pack) {
        return pack;
    }
}
