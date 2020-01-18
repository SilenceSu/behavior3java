package com.github.silencesu.behavior3java.config;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2020/1/18.
 */
@Setter
@Getter
public class BTTreeProjectDataCfg {
    private String version;
    private String scope;
    private String selectedTree;
    private List<BTTreeCfg> trees = new ArrayList<>();

}
