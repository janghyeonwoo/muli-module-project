package com.multi.module.anno;


import com.multi.module.enums.UserRole;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface AuthLogin {
    UserRole type() default UserRole.APP;
    boolean required() default true;
}
