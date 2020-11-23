package com.example.demo.chain;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 执行器
 */
@Log4j2
public class ChainExecutor {

    //链对象列表
    private Map<String, List<Processor>> chainArrayList = new HashMap<>();

    //链对象链表(需要自己定义一个头节点)
    private Map<String, ChainNode> chainLinkedList = new HashMap<>();

    private Map<String,Object> processorMap;

    public ChainExecutor(Map<String,Object> processorMap){
        this.processorMap = processorMap;
        init();
    }

    //初始化方法
    private void init(){
        for (Object p : processorMap.values()){
            ChainRegister anno = p.getClass().getAnnotation(ChainRegister.class);
            chainArrayList.compute(anno.namespace(),(key,value) -> {
                if (value == null){
                    value = new ArrayList<>();
                }
                value.add((Processor) p);
                return value;
            });
        }
        //排序
        for (List<Processor> processorList : chainArrayList.values()){
            Collections.sort(processorList,Comparator.comparing(p -> p.getClass().getAnnotation(ChainRegister.class).order()));
        }
    }


    //执行器1
    public ProcessorContext processArrayList(String chainName,Map<String,Object> contextMap){
        ProcessorContext context = new ProcessorContext(contextMap);
        List<Processor> processors = chainArrayList.get(chainName);
        if (CollectionUtils.isEmpty(processors)){
            log.info("没有找到或执行链为空");
            return context;
        }
        for (int i = 0;i < processors.size();i++){
            context = processors.get(i).process(context);
        }
        return context;
    }

    //执行器2
    public ProcessorContext processLinkedList(String chainName,Map<String,Object> contextMap){
        ProcessorContext context = new ProcessorContext(contextMap);
        ChainNode chainNode = chainLinkedList.get(chainName);
        if (chainNode == null || chainNode.getNext() == null){
            log.info("没有找到或执行链为空");
        }
        while (chainNode.hasNext()){
            chainNode = chainNode.getNext();
            context = chainNode.process(context);
        }
        return context;
    }

}
