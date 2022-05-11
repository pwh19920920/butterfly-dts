# 数据交换中心

| 类型 |
| --- |
| 单纯取值赋值 |
| 数字转字符串 |
| 数组对象转换 |
| 取某字段到数据库转换 |
| 字符串截取前几位 |
| 设为固定值 |

JSONObject jsonObject = new JSONObject();
JSONPath.set(jsonObject, "x.y.z", "#replaceReplace#${x.y.z}#replaceReplace#");
JSONPath.set(jsonObject, "x.y.z.t[0].u", "xx");
JSONPath.set(jsonObject, "x.y.z.t[1].u", "yy");
System.out.println(StringUtils.remove(StringUtils.remove(jsonObject.toJSONString(), "\"#replaceReplace#"), "#replaceReplace#\""));

