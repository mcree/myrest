/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rigo.myrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.PostConstruct;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
//git test
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonMapper implements MessageBodyWriter<Object> {

    ObjectMapper mapper;

    @PostConstruct
    void init() {
        mapper = new ObjectMapper();
        JaxbAnnotationModule jaxbModule = new JaxbAnnotationModule();
        mapper.registerModule(jaxbModule);
    }

    @Override
    public boolean isWriteable(Class<?> aClass, Type type,
            Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(Object object, Class<?> aClass, Type type,
            Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(Object object, Class<?> aClass, Type type,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> stringObjectMultivaluedMap,
            OutputStream outputStream) throws IOException,
            WebApplicationException {
        mapper.writeValue(outputStream, object);
    }

}
