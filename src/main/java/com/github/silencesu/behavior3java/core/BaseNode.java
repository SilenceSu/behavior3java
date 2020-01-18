package com.github.silencesu.behavior3java.core;

import com.github.silencesu.behavior3java.config.BTNodeCfg;
import com.github.silencesu.behavior3java.constant.B3Status;
import lombok.Data;

import java.util.Map;

/**
 * 基础节点
 *
 * @author SilenceSu
 * @Email Silence.Sx@Gmail.com
 * Created by Silence on 2019/3/2.
 */
@Data
public abstract class BaseNode implements INode, INodeWorker {


    private String id;
    private String name;
    private String title;
    private String description;

    private Map<String, String> parameters;
    private Map<String, String> properties;

    protected BehaviorTreeProject projectInfo;


    @Override
    public void onEnter(Tick tick) {

    }

    @Override
    public void onOpen(Tick tick) {

    }


    @Override
    public void onClose(Tick tick) {

    }

    @Override
    public void onExit(Tick tick) {

    }

    @Override
    public void initialize(BTNodeCfg nodeCfg) {

        this.id = nodeCfg.getId();
        this.name = nodeCfg.getName();
        this.title = nodeCfg.getTitle();
        this.description = nodeCfg.getDescription();
        this.parameters = nodeCfg.getParameters();
        this.properties = nodeCfg.getProperties();

    }

    @Override
    public B3Status run(Tick tick) {

        this.enter(tick);

        if (!tick.getBlackboard().getBool("isOpen", tick.getTree().getId(), this.id)) {
            this.open(tick);
        }

        B3Status status = this.tick(tick);

        if (status != B3Status.RUNNING) {
            this.onClose(tick);

        }

        this.exit(tick);

        return status;
    }


    @Override
    public void enter(Tick tick) {
        tick.enterNode(this);
        this.onEnter(tick);

    }

    @Override
    public void open(Tick tick) {

        tick.openNode(this);

        tick.getBlackboard().setParam("isOpen", true, tick.getTree().getId(), this.getId());


        this.onOpen(tick);
    }

    @Override
    public B3Status tick(Tick tick) {

        tick.tickNode(this);

        return this.onTick(tick);
    }

    @Override
    public void close(Tick tick) {
        tick.closeNode(this);
        tick.getBlackboard().setParam("isOpen", false, tick.getTree().getId(), this.getId());
        this.onClose(tick);

    }

    @Override
    public void exit(Tick tick) {
        tick.exitNNode(this
        );
        this.onExit(tick);
    }

    @Override
    public B3Status execute(Tick tick) {
        return this.run(tick);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

}
