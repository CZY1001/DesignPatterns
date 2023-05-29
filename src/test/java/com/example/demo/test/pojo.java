/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: pojo
 * @project: demo
 * @package: com.example.demo.test
 * @date: 2023/4/8
 * @version: V1.0
 */
package com.example.demo.test;
import java.io.Serializable;
import lombok.Data;

/**
 * pojo
 *
 * @author czy
 * @date 2023/4/8
 */
@Data
public class pojo implements Serializable{
    private String info;
    private String email;
    private String sex;
}
