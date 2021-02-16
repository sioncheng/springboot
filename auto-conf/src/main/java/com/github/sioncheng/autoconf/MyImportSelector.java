package com.github.sioncheng.autoconf;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        long d2 = System.currentTimeMillis() % 2;
        if (d2 == 0) {
            return new String[]{MySelectedClass.class.getName()};
        } else {
            return new String[]{};
        }
    }
}
