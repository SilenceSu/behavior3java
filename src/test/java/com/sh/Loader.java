package com.sh;

import com.sh.b3.config.BTTreeCfg;
import com.sh.b3.config.BevTreeConfig;
import com.sh.b3.core.BehaviorTree;
import com.sh.b3.core.Blackboard;
import com.sh.b3.loader.BvTreeFactory;

/**
 * 测试
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class Loader {

    public static void main(String[] args) {


        BevTreeConfig bevTreeConfig = new BevTreeConfig();

        BTTreeCfg btTreeCfg = bevTreeConfig.LoadTreeCfg("D:\\JProject\\behavior3java\\src\\main\\resources\\tree.json");


        BehaviorTree tree = BvTreeFactory.createBtTreeFromConfig(btTreeCfg);



        Blackboard blackboard = new Blackboard();

        tree.tick(new Object(), blackboard);


    }
}
