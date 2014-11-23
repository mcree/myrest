/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.rigo.myrest;

import java.util.Collections;
import java.util.Set;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.xml.bind.annotation.adapters.XmlAdapter;

@RequestScoped
public class MyXmlAdapter extends XmlAdapter<Set<Object>, Set<IdentEntity>> {

    public MyXmlAdapter() {
        LOG.severe("+++++++++ MyXmlAdapter instanced");
    }
    private static final Logger LOG = Logger.getLogger(MyXmlAdapter.class.getName());
    
    @Override
    public Set<IdentEntity> unmarshal(Set<Object> vt) throws Exception {
        LOG.severe("+++++++++ MyXmlAdapter unmarshal"); 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return Collections.emptySet();
    }

    @Override
    public Set<Object> marshal(Set<IdentEntity> bt) throws Exception {
        LOG.severe("+++++++++ MyXmlAdapter marshal"); 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return Collections.emptySet();
    }

}
