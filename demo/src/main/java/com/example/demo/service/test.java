package com.example.demo.service;

import com.example.demo.vo.TestUser;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/30 18:35
 */
public class test {
  /*  public static void main(String[] args) {
        List<TestUser> list = new ArrayList<>();
        list.add(new TestUser().setAddress("宣威").setId(1).setUserName("XiaoMing"));
        list.add(new TestUser().setAddress("曲靖").setId(2).setUserName("XiaoHong"));
        list.add(new TestUser().setAddress("昆明").setId(3).setUserName("Jack"));
        Map<Integer, TestUser> collect = list.stream().collect(Collectors.toMap(TestUser::getId, Function.identity()));
        collect.entrySet().stream().forEach(System.out::println);
        Map<Integer, List<TestUser>> collect1 = list.stream().collect(Collectors.groupingBy(x -> x.getId()));
        collect1.entrySet().stream().forEach(System.out::println);
        *//*String name = null;
        Assert.notNull(name,"name can not be null");*//*
    }*/

    public static void main(String[] args) {
        /*List<String> a = Arrays.asList(new String[]{"1","2","3"});
        List<String> b = Arrays.asList(new String[]{"1"});
        boolean flag =  false;
        for(String str: a){
            if(!b.contains(str)){
                flag = true;
            }
        }
        //System.out.println(flag);
        a.stream().forEach(x->x.contains("1"));
        a.forEach(x-> {
                    System.out.println(x);
                }
        );*/
        ExecutorService executorService = new Si();
    }
}
