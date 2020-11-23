package com.example.demo.chain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 责任链上下文
 */
public class ProcessorContext {

    private ConcurrentHashMap<String, Object> CONTEXT = new ConcurrentHashMap<>();

    public Object get(String key){
        return CONTEXT.get(key);
    }

    public Object put(String key, Object obj){
        return CONTEXT.put(key,obj);
    }

    public ProcessorContext(){

    }

    public ProcessorContext(Map<String,Object> contextMap){
        this.CONTEXT.putAll(contextMap);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Object> entry : CONTEXT.entrySet()){
            sb.append("key:").append(entry.getKey()).append(",");
            sb.append("value:").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
