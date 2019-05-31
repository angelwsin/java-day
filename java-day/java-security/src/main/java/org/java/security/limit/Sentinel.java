package org.java.security.limit;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRuleManager;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;

import java.util.ArrayList;
import java.util.List;

public class Sentinel {




    /*Node  类似zookeeper 数据结构组织

​       root                       hash      key-childer

​        ………….childer



     调用链使用责任链模式
     使用 spi
     com.alibaba.csp.sentinel.slots.DefaultSlotChainBuilder  默认使用
     调用链使用   Resource   chain

     NodeSelectorSlot 负责收集资源的路径，并将这些资源的调用路径，以树状结构存储起来，用于根据调用路径来限流降级；
     ClusterBuilderSlot 则用于存储资源的统计信息以及调用者信息，例如该资源的 RT, QPS, thread count 等等，
                        这些信息将用作为多维度限流，降级的依据；
     StatisticSlot 则用于记录、统计不同纬度的 runtime 指标监控信息；
     FlowSlot 则用于根据预设的限流规则以及前面 slot 统计的状态，来进行流量控制；
     AuthoritySlot 则根据配置的黑白名单和调用来源信息，来做黑白名单控制；
     DegradeSlot 则通过统计信息以及预设的规则，来做熔断降级；
     SystemSlot 则通过系统的状态，例如 load1 等，来控制总的入口流量；
     */


    public static void main(String[] args) throws  Exception{

        initDegradeRule();
        ContextUtil.enter("key", "172.16.20.160");
        Entry nodeA = SphU.entry("key");
        System.out.println("xxx");
        if (nodeA != null) {
            nodeA.exit();
        }
        ContextUtil.exit();
    }

    private static void initDegradeRule() {
        List<AuthorityRule> rules = new ArrayList<>();
        /*DegradeRule rule = new DegradeRule();
        rule.setResource(KEY);
        // set threshold RT, 10 ms
        rule.setCount(10);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        rule.setTimeWindow(10);
        rules.add(rule);*/
        AuthorityRule authorityRule = new AuthorityRule();
        //白名单
        authorityRule.setLimitApp("172.16.20.169");
        authorityRule.setResource("key");
        rules.add(authorityRule);
        AuthorityRuleManager.loadRules(rules);
    }




}
