package org.behavior3.b3.config;

import com.alibaba.fastjson.JSON;
import org.behavior3.b3.util.FileUtil;

import java.util.Map;

/**
 * bt配置
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
public class BevTreeConfig {


    /**
     * 加载行为树配置
     *
     * @param path
     * @return
     */
    public static BTTreeCfg LoadTreeCfg(String path) {
        BTTreeCfg treeCfg;
        String text = FileUtil.readFile(path);
        treeCfg = JSON.parseObject(text, BTTreeCfg.class);
        return treeCfg;
    }


    /**
     * 获取节点配置的文件
     *
     * @param cfg
     * @param name
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getProperty(BTNodeCfg cfg, String name) {

        Map<String, String> props = cfg.getProperties();
        if (props != null) {
            return (T) props.get(name);
        }
        return null;
    }


}
