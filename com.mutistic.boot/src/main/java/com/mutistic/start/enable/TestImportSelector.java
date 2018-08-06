package com.mutistic.start.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.mutistic.utils.CommonUtil;

/**
 * @program 使用 ImportSelector 设置需要导入的class数组
 * @description 1、ImportSelector.selectImports()：方法的返回值必须是 class全称。2、由@Import导入后，那么这些class将会被spring托管
 * @author mutisitic
 * @date 2018年6月22日
 */
public class TestImportSelector implements ImportSelector {

	/**
	 * @description 
	 * @author mutisitic
	 * @date 2018年6月22日
	 * @param importingClassMetadata
	 * @return 不能返回null
	 * @see org.springframework.context.annotation.ImportSelector#selectImports(org.springframework.core.type.AnnotationMetadata)
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		/**
		 * 可以获取注解的详细信息，然后根据信息去动态的返回需要被spring管理的bean的class name
		 */
		CommonUtil.printTwo("获取自定义注解@TestEnableByImportSelectory的值name：", importingClassMetadata.getAnnotationAttributes(TestEnableByImport.class.getName()));
		return new String[] {"com.mutistic.start.enable.TestBeanByImport", TestImportConfiguration.class.getName()};
	}

}
