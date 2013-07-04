package models;

import java.util.List;

public class TranslateWord {
	
/**
 * {
    "translation": [
        "后缀"
    ], 
    "basic": {
        "phonetic": "pəʊs(t)'fɪks", 
        "explains": [
            "n. [语] 后缀；词尾", 
            "vt. 加字尾于"
        ]
    }, 
    "query": "postfix", 
    "errorCode": 0, 
    "web": [
        {
            "value": [
                "后缀", 
                "邮件服务器", 
                "后置式"
            ], 
            "key": "postfix"
        }, 
        {
            "value": [
                "逆波兰表示法", 
                "后置形式"
            ], 
            "key": "Postfix form"
        }, 
        {
            "value": [
                "后自减操作"
            ], 
            "key": "postfix decrement"
        }
    ]
}
 */
	
	public List<String> translation;
	public Basic basic;
	public String query;
	public int errorCode;
	public List<Web> web;
	
}

class Basic{
	public String phonetic;
	public List<String> explains;
}

class Web{
	public List<String> value;
	public String key;
}
