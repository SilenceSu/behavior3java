package com.github.silencesu.behavior3java.config;

import lombok.Data;

import java.util.Map;

/**
 * 行为树配置
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
@Data
public class BTTreeCfg {
    private String id;
    private String title;
    private String description;
    private String root;
    private Map<String, Object> properties;
    private Map<String, BTNodeCfg> nodes;
}
