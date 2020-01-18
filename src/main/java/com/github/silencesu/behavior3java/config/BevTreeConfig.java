package com.github.silencesu.behavior3java.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.silencesu.behavior3java.util.FileUtil;

import java.util.List;
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
     * 加载项目工程，将整个行为树都加载了
     *
     * @param path
     * @return
     */
    public static List<BTTreeCfg> LoadTreesCfg(String path) {
        String text = FileUtil.readFile(path);
        JSONObject jsonObj = JSON.parseObject(text);
        JSONArray trees = jsonObj.getJSONArray("trees");
        List<BTTreeCfg> list = trees.toJavaList(BTTreeCfg.class);
        return list;
    }


    /**
     * 加载整体工程数据
     *
     * @param path
     * @return
     */
    public static BTTreeProjectCfg LoadBTTreePorjectCfg(String path) {
        String json = FileUtil.readFile(path);
        return JSON.parseObject(json, BTTreeProjectCfg.class);
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
