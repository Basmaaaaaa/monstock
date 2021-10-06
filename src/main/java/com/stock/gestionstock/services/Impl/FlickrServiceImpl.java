package com.stock.gestionstock.services.Impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.stock.gestionstock.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Service
@Slf4j

public class FlickrServiceImpl implements FlickrService {
    @Value("${flickr.apikey}")
    private String apikey;

    @Value("${flickr.apisecret}")
    private String apisecret;

    @Value("${flickr.appkey}")
    private String appkey;

    @Value("${flickr.appsecret}")
    private String appsecret;

    private Flickr flickr;

    @Override
    public String savePhoto(InputStream photo, String title) {
         return null;
    }

    public  void  connect(){
        flickr=new Flickr(apikey,apisecret,new REST());
        Auth auth=new Auth();
        auth.setPermission(Permission.DELETE);
        auth.setToken(appkey);
        auth.getTokenSecret();

        RequestContext requestContext=RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);


    }
}
