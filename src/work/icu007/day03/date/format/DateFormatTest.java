package work.icu007.day03.date.format;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.time.format.DateTimeFormatter;


/**
 * DateFormatTest
 *
 * `LocalDateTime`的默认格式是ISO 8601标准的日期时间格式，这是一种国际标准的日期和时间表示方法。在这种格式中，日期和时间部分之间用一个`T`字符分隔。
 *
 * 如果想要以不同的格式打印`LocalDateTime`，可以使用`DateTimeFormatter`类来自定义格式。例如，如果想要的格式是"yyyy-MM-dd HH:mm:ss"，可以这样做：
 *
 * ```java
 * LocalDateTime dateTime = LocalDateTime.now();
 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 * String formattedDateTime = dateTime.format(formatter);
 * System.out.println(formattedDateTime);
 * ```
 *
 *
 * Optional的基本知识
 * 当然，Optional是Java 8引入的一个新特性，主要用于解决null值问题。Optional是一个容器类，它可以保存类型T的值，或者仅仅保存null。Optional提供了很多有用的方法，这样我们可以在编译时就能检测出潜在的null指针异常。
 *
 * 以下是一些关于Optional的基本知识：
 *
 * 1. 创建Optional实例：可以使用Optional.empty()创建一个空的Optional对象，使用Optional.of(T value)创建一个包含值的Optional对象，或者使用Optional.ofNullable(T value)创建一个可以包含也可以不包含值的Optional对象。
 *
 * ```java
 * Optional<String> empty = Optional.empty();
 * Optional<String> value = Optional.of("Hello");
 * Optional<String> nullable = Optional.ofNullable(null);
 * ```
 *
 * 2. 使用isPresent()和isEmpty()检查Optional是否包含值：isPresent()在Optional包含值时返回true，否则返回false。isEmpty()在Optional不包含值时返回true，否则返回false。
 *
 * ```java
 * boolean isPresent = value.isPresent(); // true
 * boolean isEmpty = empty.isEmpty(); // true
 * ```
 *
 * 3. 使用get()获取Optional中的值：如果Optional有值则返回，否则抛出NoSuchElementException。
 *
 * ```java
 * String str = value.get(); // "Hello"
 * ```
 *
 * 4. 使用orElse(T other)返回Optional中的值，如果Optional为空则返回other。
 *
 * ```java
 * String str = empty.orElse("Default"); // "Default"
 * ```
 *
 * 5. 使用orElseGet(Supplier<? extends T> other)返回Optional中的值，如果Optional为空则返回由Supplier接口生成的值。
 *
 * ```java
 * String str = empty.orElseGet(() -> "Default"); // "Default"
 * ```
 *
 * 6. 使用orElseThrow(Supplier<? extends X> exceptionSupplier)返回Optional中的值，如果Optional为空则抛出由Supplier接口生成的异常。
 *
 * ```java
 * String str = empty.orElseThrow(IllegalStateException::new); // throws IllegalStateException
 * ```
 *
 * 7. 使用map(Function<? super T,? extends U> mapper)对Optional中的值执行mapper函数，并返回一个新的Optional。
 *
 * ```java
 * Optional<String> uppercased = value.map(String::toUpperCase); // Optional["HELLO"]
 * ```
 *
 * 8. 使用flatMap(Function<? super T,Optional<U>> mapper)对Optional中的值执行mapper函数，并返回一个新的Optional。这个方法和map()方法的区别在于，flatMap()的mapper函数返回值必须是Optional。
 *
 * ```java
 * Optional<String> uppercased = value.flatMap(val -> Optional.of(val.toUpperCase())); // Optional["HELLO"]
 * ```
 *
 * 9. 使用filter(Predicate<? super T> predicate)对Optional中的值进行过滤，如果值满足predicate则返回包含该值的Optional，否则返回一个空的Optional。
 *
 * ```java
 * Optional<String> longString = value.filter(val -> val.length() > 5); // Optional.empty()
 * ```
 *
 * 以上就是Optional的基本使用方法，使用Optional可以帮助我们更好地处理null值问题，使代码更加健壮。
 *
 *
 *
 */

public class DateFormatTest {
    public static void main(String[] args) {
        method1();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Optional<LocalDateTime> localDateTime = method2("2024-04-18 20:25:57");
        method2("2024-04-18 20:25:57").ifPresent(System.out::println);
        if (localDateTime.isPresent()) {
            String localDateTimeStr = localDateTime.get().format(formatter);
            System.out.println(localDateTimeStr);
        } else {
            System.out.println("Invalid date time format");
        }
    }

    public static void method1() {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

    /**
     *
     * LocalDateTime和DateTimeFormatter，来替代SimpleDateFormat。这样可以避免SimpleDateFormat的线程不安全问题。另外，我们可以使用Optional来避免返回null值。
     * 这个方法会尝试解析输入的字符串，并返回一个Optional的LocalDateTime。如果解析成功，Optional会包含解析得到的日期时间；如果解析失败，就会返回一个空的Optional。
     *
     * @param str 输入的日期时间字符串
     *            例如："2024-04-18 20:25:57"
     * @return Optional的LocalDateTime
     *        如果解析成功，Optional包含解析得到的日期时间；如果解析失败，返回一个空的Optional
     *
     */
    public static Optional<LocalDateTime> method2(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
            return Optional.of(dateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
