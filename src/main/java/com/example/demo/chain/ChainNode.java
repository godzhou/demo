package com.example.demo.chain;

/**
 * 抽象链节点
 */
public class ChainNode implements Processor{

    private Processor processor;

    private ChainNode next;

    public ChainNode(Processor processor){
        this.processor = processor;
    }

    @Override
    public ProcessorContext process(ProcessorContext context) {
        return processor.process(context);
    }


    public void setNext(ChainNode next){
        this.next = next;
    }

    public ChainNode getNext(){
        return next;
    }

    public boolean hasNext(){
        return next != null;
    }
}
