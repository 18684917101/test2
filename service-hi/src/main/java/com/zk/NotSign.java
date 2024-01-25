package com.zk;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 不参与签名生成
 * @author Sang
 */
@Target({FIELD})
@Retention(RUNTIME)
public @interface NotSign {
}
