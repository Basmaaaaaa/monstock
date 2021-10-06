package com.stock.gestionstock.intercepter;

import org.hibernate.EmptyInterceptor;
import org.springframework.util.StringUtils;

import java.util.Locale;

public class Intercepter extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql) {
        //test sur la requette:n'st pas vide et commance par le "select
        if(StringUtils.hasLength(sql)&&sql.toLowerCase(Locale.ROOT).startsWith("select")){
            if(sql.contains("where")){
                sql=sql+"and idEntreprise=2";
                 }
            else{
                sql=sql+"where idEntreprise=2";
            }
            sql=sql+"idEntreprise";

        }
        return super.onPrepareStatement(sql);
    }
}
