package com.doak.springbootMybatisdemo.util;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementScanner8;

/**
 * @author ：zhanyiqun
 * @date ：Created in 2019/12/28 22:02
 * @description：命名检查实体类
 */
public class NameChecker {

    private ProcessingEnvironment processingEnv;

    public NameChecker(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
    }

    /**
     * 将会以visitor模式访问抽象语法树中的元素
     */
    private class NameCheckScanner extends ElementScanner8<Void, Void> {

        @Override
        public Void visitType(TypeElement e, Void p) {
            scan(e.getTypeParameters(), p);
            checkCamelCase(e, true);
            return null;
        }

        /**
         * 检查传入的element是否符号驼峰命名
         * @param e
         * @param initialCaps 首字母是否大写
         * @return
         */
        public Void checkCamelCase(TypeElement e, Boolean initialCaps) {
return null;
        }
    }


}