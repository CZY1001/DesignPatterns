/**
 * Copyright © 2022 国网信通产业集团有限公司. All rights reserved.
 *
 * @title: changliang
 * @project: demo
 * @package: com.example.demo.test
 * @date: 2023/4/8
 * @version: V1.0
 */
package com.example.demo.test;

/**
 * changliang
 *
 * @author czy
 * @date 2023/4/8
 */
public class changliang {
    public static final String STR="{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"info\": {\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_smart\"\n" +
            "      },\n" +
            "      \"email\": {\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"name\": {\n" +
            "        \"type\": \"object\",\n" +
            "        \"properties\": {\n" +
            "          \"firstName\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "          },\n" +
            "          \"lastName\": {\n" +
            "            \"type\": \"keyword\"\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
