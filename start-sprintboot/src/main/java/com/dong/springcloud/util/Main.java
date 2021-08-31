package com.dong.springcloud.util;

import java.util.Arrays;
import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/30
 */
public class Main {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("aa","bb","cc");
        list.forEach(e-> System.out.println(e));
        list.stream().forEach(System.out::println);
        list.parallelStream().forEach(System.out::println);

    }

}
