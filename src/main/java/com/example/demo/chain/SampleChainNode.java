package com.example.demo.chain;

import org.springframework.stereotype.Service;

/**
 * 实现链节点
 */
@Service
@ChainRegister(namespace = "TEST",name = "SAMPLE",order = 0)
public class SampleChainNode implements Processor{

    @Override
    public ProcessorContext process(ProcessorContext context) {
        System.out.println("execute");
        System.out.println(context.get("key"));
        context.put("key2","value2");
        return context;
    }
}
