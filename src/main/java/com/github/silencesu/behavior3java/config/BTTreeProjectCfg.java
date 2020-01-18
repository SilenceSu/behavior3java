package com.github.silencesu.behavior3java.config;

import lombok.Getter;
import lombok.Setter;

/**
 * 行为树工程配置
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2020/1/18.
 */
@Setter
@Getter
public class BTTreeProjectCfg {
    private String name;

    private String description;

    private String scope;


    private BTTreeProjectDataCfg data;



}
