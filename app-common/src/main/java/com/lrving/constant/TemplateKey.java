package com.lrving.constant;

import org.springframework.beans.factory.annotation.Value;


public class TemplateKey {

    @Value("'list:prdName|'+#prdName+':shopId|'+#shopId+':ctgId|'+#ctgId+':paging|'+#paging+':prdTags|'+#prdTags+':page|'+#pageable.pageNumber+':size|'+#pageable.pageSize+':sort|'+#pageable.sort")
    public static String Prd_List="";
}
