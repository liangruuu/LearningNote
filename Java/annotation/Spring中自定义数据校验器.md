## 1. 以判断手机号为例

**miaosha_2\src\main\java\com\imooc\miaosha\validator\IsMobile.java**

```java
package com.imooc.miaosha.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { IsMobileValidator.class })
public @interface IsMobile {

  // 注解是否可以为空,若为true则不能为空
  boolean required() default true;

  String message() default "手机号码格式错误";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}

```

**miaosha_2\src\main\java\com\imooc\miaosha\validator\IsMobileValidator.java**

```java
package com.imooc.miaosha.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.imooc.miaosha.util.ValidatorUtil;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

  private boolean required = false;

  @Override
  // 初始化方法
  public void initialize(IsMobile constraintAnnotation) {
    required = constraintAnnotation.required();
  }

  @Override
  // 第一个参数是Object的子类
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // 字段是否是必须的，若为是则判断是否符合条件，若为否则直接返回true
    if (required) {
      return ValidatorUtil.isMobile(value);
    } else {
      if (StringUtils.isEmpty(value)) {
        return true;
      } else {
        return ValidatorUtil.isMobile(value);
      }
    }
  }

}

```

**miaosha_2\src\main\java\com\imooc\miaosha\util\ValidatorUtil.java**

```java
package com.imooc.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ValidatorUtil {

  private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

  public static boolean isMobile(String src) {
    if (StringUtils.isEmpty(src)) {
      return false;
    }
    Matcher m = mobile_pattern.matcher(src);
    return m.matches();
  }

  // public static void main(String[] args) {
  // System.out.println(isMobile("18912341234"));
  // System.out.println(isMobile("1891234123"));
  // }
}
```

**test**

```java
@IsMobile(value="手机号码错误")
String phone = "12345667";
```

spring会把标有注解的值传递给`IsMobileValidator`的`isValid()`调用，若返回false则会返回`IsMobile`注解的message字段