package com.github.silencesu.behavior3java.config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 行为树节点配置
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
@Setter
@Getter
public class BTNodeCfg {
    private String id;
    private String name;
    private String title;
    private String category;
    private String description;
    private List<String> children;
    private String child;
    private Map<String, String> parameters;
    private Map<String, String> properties;

}
