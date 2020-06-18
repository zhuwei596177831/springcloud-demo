package com.zhuweiwei.eureka.eurekaserver.support;

import com.zhuweiwei.eureka.eurekaserver.annotation.CustomizeComponent;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * @author zww
 * @date 2020-06-18 14:30
 * @description
 */
public class Scanner extends ClassPathBeanDefinitionScanner {

    public Scanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected void registerDefaultFilters() {
        this.addIncludeFilter(new AnnotationTypeFilter(CustomizeComponent.class));
    }

//    @Override
//    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
//        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
//        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
//            GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
//            genericBeanDefinition.getPropertyValues().add("myScanClassName", genericBeanDefinition.getBeanClassName());
//            genericBeanDefinition.setBeanClass(FactoryBeanTest.class);
//        }
//        return beanDefinitionHolders;
//    }

//    @Override
//    protected boolean isCandidateComponent(MetadataReader metadataReader) throws IOException {
//        return super.isCandidateComponent(metadataReader);
//    }
//
//    @Override
//    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
//        return super.isCandidateComponent(beanDefinition)
//                && beanDefinition.getMetadata().hasAnnotation(CustomizeComponent.class.getName());
//    }
}
