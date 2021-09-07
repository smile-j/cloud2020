package com.dong.springcloud.entity;

import lombok.*;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/9/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Pet {

    private String name;
    private Double weight;

}
