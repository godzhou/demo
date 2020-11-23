package com.example.demo.chain;

import org.springframework.stereotype.Service;

@Service
@ChainRegister(namespace = "TEST",name = "SAMPLE",order = 0)
public class SecondChainNode implements Processor{
    @Override
    public ProcessorContext process(ProcessorContext context) {
        System.out.println("到达节点2");
        System.out.println(context);
        context.put("key3","node2");
        return context;
    }
}
