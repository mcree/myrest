/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rigo.myrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;


@Provider
@RequestScoped
//@Consumes({MediaType.APPLICATION_JSON, "text/json"})
//@Produces({MediaType.APPLICATION_JSON, "text/json"})
public class MyJacksonConfigurator implements ContextResolver<ObjectMapper> {

    private static final Logger LOG = Logger.getLogger(MyJacksonConfigurator.class.getName());

    @Context UriInfo uriinfo;

    public UriInfo getUriinfo() {
        return uriinfo;
    }

    public void setUriinfo(UriInfo uriinfo) {
        this.uriinfo = uriinfo;
    }
    
    public MyJacksonConfigurator() {
        LOG.log(Level.SEVERE, "+++++++++ MyJacksonConfigurator instanced");
    }

    
    
    @Override
    public ObjectMapper getContext(Class<?> type) {

        LOG.log(Level.SEVERE, "+++++++++ object mapper "+uriinfo.getPath());

        ObjectMapper om = new ObjectMapper();

        return om;
    }

}

//@Provider
//@Consumes({MediaType.APPLICATION_JSON, "text/json"})
//@Produces({MediaType.APPLICATION_JSON, "text/json"})
//public class MyJacksonConfigurator extends ResteasyJacksonProvider {
//
//    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZ";
//
//    private static final Logger log = Logger.getLogger(MyJacksonConfigurator.class.getName());
//
//    public MyJacksonConfigurator() {
//        super();
//        log.info("configuring date handling");
//        ObjectMapper mapper = _mapperConfig.getConfiguredMapper();
//        configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
//        configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
//        SerializationConfig serConfig = mapper.getSerializationConfig();
//        serConfig.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
//
//        serConfig.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
//        DeserializationConfig deserializationConfig = mapper.getDeserializationConfig();
//        deserializationConfig.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
//
//    }
//
//}
