package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czy
 * @summary 力扣第30题  串联所有单词的子串
 * @date 2023-12-28 16:33
 *
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 *
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案
 *
 * 解法：滑动窗口（官方解法）
 */
public class thirty {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        //所有的单次个数
        int num = words.length;
        //每个单次的长度   (每个单次长度都是一样 的  所以取第一个就可以了)
        int wordlen = words[0].length();
        //字符串的长度
        int stringLen = s.length();

        for (int i = 0; i < wordlen; i++) {
            //遍历的长度超过了整个字符串的长度，就退出循环
            if (i + num * wordlen > stringLen) {
                break;
            }
            //differ表示窗口中单次的频次  和words中的单次频次之差
            Map<String,Integer> differ = new HashMap<>();
            //初始化窗口，窗口长度为num * wordLen,依次计算窗口里每个切分的单次的频次
            for (int j = 0; j < num; j++) {
                /*
                 s = barfoofoobarthefoobarman   num是3    wordlen是3    stringLen = 24
                 words = ["bar","foo","the"]
                 输出：[6,9,12]
                 */
                String word = s.substring(i + j * wordlen, i + (j + 1) * wordlen);
                //把当前出现的词存入到map里，value去计数
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            //遍历words中的word 对窗口里每个单次计算差值
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                //差值为0的时候 ，移除掉这个word
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            //开始滑动
            for (int start = i; start < stringLen - num * wordlen + 1; start += wordlen) {

            }
        }


        return null;
    }
}
