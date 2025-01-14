package work.icu007.day03.string;

import java.io.FilterOutputStream;

/**
 * | 方法签名                                                         | 说明                                                                 |
 * |--------------------------------------------------------------|--------------------------------------------------------------------|
 * | public int length()                                        | 返回字符串的长度。                                                        |
 * | public char charAt(int index)                              | 返回指定索引处的字符。                                                      |
 * | public int indexOf(String str)                             | 返回指定子字符串第一次出现在该字符串中的索引。                                              |
 * | public int indexOf(String str, int fromIndex)              | 返回指定子字符串第一次出现在该字符串中的索引，从指定的索引开始。                                      |
 * | public int lastIndexOf(String str)                         | 返回指定子字符串最后一次出现在该字符串中的索引。                                             |
 * | public int lastIndexOf(String str, int fromIndex)          | 返回指定子字符串最后一次出现在该字符串中的索引，从指定的索引开始。                                     |
 * | public String substring(int beginIndex)                   | 返回一个新的字符串，它是此字符串的一个子字符串。                                             |
 * | public String substring(int beginIndex, int endIndex)      | 返回一个新的字符串，它是此字符串的一个子字符串。                                             |
 * | public String replace(char oldChar, char newChar)          | 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。                           |
 * | public boolean startsWith(String prefix)                   | 测试此字符串是否以指定的前缀开始。                                                 |
 * | public boolean endsWith(String suffix)                     | 测试此字符串是否以指定的后缀结束。                                                 |
 * | public boolean isEmpty()                                   | 当且仅当 length() 为 0 时返回 true。                                              |
 * | public String toLowerCase()                                | 使用默认语言环境的规则将此 String 中的所有字符都转换为小写。                                       |
 * | public String toUpperCase()                                | 使用默认语言环境的规则将此 String 中的所有字符都转换为大写。                                       |
 * | public String trim()                                       | 返回字符串的副本，忽略前导空白和尾部空白。                                              |
 * | public char[] toCharArray()                                | 将此字符串转换为一个新的字符数组。                                                |
 * | public static String valueOf(char[] data)                 | 返回 char 数组参数的字符串表示形式。                                              |
 * | public static String valueOf(int i)                       | 返回 int 参数的字符串表示形式。                                                |
 * | public static String valueOf(long l)                      | 返回 long 参数的字符串表示形式。                                               |
 * | public static String valueOf(float f)                     | 返回 float 参数的字符串表示形式。                                              |
 * | public static String valueOf(double d)                    | 返回 double 参数的字符串表示形式。                                             |
 * | public static String valueOf(boolean b)                   | 返回 boolean 参数的字符串表示形式。                                            |
 * | public String[] split(String regex)                        | 根据给定正则表达式的匹配拆分此字符串。                                             |
 * |public String concat(String str)                            | 将指定字符串连接到此字符串的结尾。                                               |
 * |public boolean contains(CharSequence s)                     | 当且仅当此字符串包含指定的 char 值序列时，返回 true。                                      |
 * |public boolean equals(Object anObject)                      | 将此字符串与指定的对象比较。                                                 |
 * |public boolean equalsIgnoreCase(String anotherString)       | 将此 String 与另一个 String 比较，不考虑大小写。                                        |
 * |public String format(String format, Object... args)         | 使用指定的格式字符串和参数返回一个格式化字符串。                                          |
 * |public byte[] getBytes()                                    | 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。                |
 * |public int hashCode()                                       | 返回此字符串的哈希码。                                                    |
 * |public boolean matches(String regex)                        | 告知此字符串是否匹配给定的正则表达式。                                              |
 * |public String replaceAll(String regex, String replacement)  | 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。                                |
 * |public String replaceFirst(String regex, String replacement)| 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。                              |
 * |public String[] split(String regex, int limit)              | 根据匹配给定的正则表达式来拆分此字符串，最多不超过 limit 个子字符串。                                   |
 * |public CharSequence subSequence(int beginIndex, int endIndex)| 返回一个新的字符序列，它是此序列的一个子序列。                                            |
 * |public String toString()                                    | 返回此对象本身（它已经是一个字符串！）。                                              |
 * |public static String join(CharSequence delimiter, CharSequence... elements)| 使用指定的定界符和元素数组返回一个字符串。                                             |
 */

public class StringDemo {
    public static void main(String[] args) {
        String str = "I am Charlie, I am a programmer.";

        // 返回字符串的长度
        System.out.println("字符串的长度为：");
        System.out.println(str.length());

        // 返回指定索引处的字符
        System.out.println("指定索引处的字符为：");
        System.out.println(str.charAt(0));

        // 返回指定子字符串第一次出现在该字符串中的索引
        System.out.println("指定子字符串第一次出现在该字符串中的索引为：");
        System.out.println(str.indexOf("Charlie"));

        // 返回指定子字符串第一次出现在该字符串中的索引，从指定的索引开始
        System.out.println("am 第一次出现在该字符串中的索引为：从指定索引：5");
        System.out.println(str.indexOf("am", 5));

        // 返回指定子字符串最后一次出现在该字符串中的索引
        System.out.println("指定子字符串(am)最后一次出现在该字符串中的索引为：");
        System.out.println(str.lastIndexOf("am"));

        // 返回指定子字符串最后一次出现在该字符串中的索引，从指定的索引开始
        System.out.println("指定子字符串(am)最后一次出现在该字符串中的索引为：指定索引：5");
        System.out.println(str.lastIndexOf("am", 5));

        // 返回一个新的字符串，它是此字符串的一个子字符串
        System.out.println("返回一个新的字符串，它是此字符串的一个子字符串：从索引 5 开始");
        System.out.println(str.substring(5));

        // 返回一个新的字符串，它是此字符串的一个子字符串
        System.out.println("返回一个新的字符串，它是此字符串的一个子字符串：从索引 5 到 12");
        System.out.println(str.substring(5, 12));

        // 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的
        System.out.println("返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的：");
        System.out.println(str.replace('a', 'A'));

        // 测试此字符串是否以指定的前缀开始
        System.out.println("测试此字符串是否以\"I am\"的前缀开始：");
        System.out.println(str.startsWith("I am"));

        // 测试此字符串是否以指定的后缀结束
        System.out.println("测试此字符串是否以\"programmer.\"的后缀结束：");
        System.out.println(str.endsWith("programmer."));

        // 当且仅当 length() 为 0 时返回 true
        System.out.println("当且仅当 length() 为 0 时返回 true：");
        System.out.println(str.isEmpty());

        // 使用默认语言环境的规则将此 String 中的所有字符都转换为小写
        System.out.println("使用默认语言环境的规则将此 String 中的所有字符都转换为小写：");
        System.out.println(str.toLowerCase());

        // 使用默认语言环境的规则将此 String 中的所有字符都转换为大写
        System.out.println("使用默认语言环境的规则将此 String 中的所有字符都转换为大写：");
        System.out.println(str.toUpperCase());

        // 返回字符串的副本，忽略前导空白和尾部空白
        System.out.println("返回字符串的副本，忽略前导空白和尾部空白：");
        System.out.println(("  " + str + "  ").trim());

        // 将此字符串转换为一个新的字符数组
        System.out.println("将此字符串转换为一个新的字符数组：");
        char[] chars = str.toCharArray();
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();

        // 返回 char 数组参数的字符串表示形式
        System.out.println("返回 char 数组参数的字符串表示形式：");
        System.out.println(String.valueOf(chars));

        // 根据给定正则表达式的匹配拆分此字符串
        System.out.println("根据给定正则表达式的匹配拆分此字符串：");

        String[] split = str.split(" ");
        for (String s : split) {
            System.out.print(s + "\t");
        }
        System.out.println();

        // 将指定字符串连接到此字符串的结尾
        System.out.println("将指定字符串连接到此字符串的结尾：");
        System.out.println(str.concat(" I am a student."));

        // 当且仅当此字符串包含指定的 char 值序列时，返回 true
        System.out.println("当且仅当此字符串包含指定的 char 值序列时，返回 true：");
        System.out.println(str.contains("Charlie"));

        // 将此字符串与指定的对象比较
        System.out.println("将此字符串与指定的对象比较：");
        System.out.println(str.equals("I am Charlie, I am a programmer."));

        // 将此 String 与另一个 String 比较，不考虑大小写
        System.out.println("将此 String 与另一个 String 比较，不考虑大小写：");
        System.out.println(str.equalsIgnoreCase("i am charlie, i am a programmer."));

        // 使用指定的格式字符串和参数返回一个格式化字符串
        System.out.println("使用指定的格式字符串和参数返回一个格式化字符串：");
        System.out.println(String.format("I am %s, I am a %s.", "Charlie", "programmer"));

        // 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中
        System.out.println("使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中：");
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();

        // 返回此字符串的哈希码
        System.out.println("返回此字符串的哈希码：");
        System.out.println(str.hashCode());

        // 告知此字符串是否匹配给定的正则表达式
        System.out.println("告知此字符串是否匹配给定的正则表达式：");
        System.out.println(str.matches("I am Charlie, I am a programmer."));

        // 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串
        System.out.println("使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串：");
        System.out.println(str.replaceAll("am", "AM"));

        // 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串
        System.out.println("使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串：");
        System.out.println(str.replaceFirst("am", "AM"));

        // 根据匹配给定的正则表达式来拆分此字符串，最多不超过 limit 个子字符串
        System.out.println("根据匹配给定的正则表达式来拆分此字符串，最多不超过 limit 个子字符串：");
        String[] split2 = str.split(" ", 5);
        for (String s : split2) {
            System.out.print(s + "\t");
        }
        System.out.println();

        // 返回一个新的字符序列，它是此序列的一个子序列
        System.out.println("返回一个新的字符序列，它是此序列的一个子序列：");
        CharSequence subSequence = str.subSequence(5, 12);

        // 返回此对象本身（它已经是一个字符串！）
        System.out.println("返回此对象本身（它已经是一个字符串！）：");
        System.out.println(str.toString());

        // 使用指定的定界符和元素数组返回一个字符串
        System.out.println("使用指定的定界符和元素数组返回一个字符串：");
        System.out.println(String.join(" ", split2));
    }
}
