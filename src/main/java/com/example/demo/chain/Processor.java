package com.example.demo.chain;

/**
 * 责任链接口
 */
public interface Processor {
    ProcessorContext process(ProcessorContext context);
}
