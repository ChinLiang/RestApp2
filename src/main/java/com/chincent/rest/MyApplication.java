package com.chincent.rest;
 
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.chincent.rest.filter.JaxRsFilterAuthentication;
import com.chincent.rest.service.MessageService;
 
@ApplicationPath("/rest")
public class MyApplication extends Application {
////	public class MyApplication  {
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> s = new HashSet<Class<?>>();
////        s.add(com.chincent.rest.service.MessageService.class);
//        s.add(JaxRsFilterAuthentication.class);
//        s.add(MessageService.class);
//        return s;
//    }
}