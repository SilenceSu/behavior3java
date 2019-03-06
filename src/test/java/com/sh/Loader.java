package com.sh;

import com.sh.b3.config.BTTreeCfg;
import com.sh.b3.config.BevTreeConfig;
import com.sh.b3.core.BehaviorTree;
import com.sh.b3.core.Blackboard;

/**
 * 测试
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class Loader {

    public static void main(String[] args) {


        BTTreeCfg btTreeCfg = BevTreeConfig.LoadTreeCfg("D:\\JProject\\behavior3java\\src\\main\\resources\\tree.json");


        BehaviorTree tree = new BehaviorTree();
        tree.load(btTreeCfg);


        Blackboard blackboard = new Blackboard();

        tree.tick(new Object(), blackboard);


    }
}
