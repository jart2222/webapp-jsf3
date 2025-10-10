package org.aguzman.webapp.jsf3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.ws.rs.Produces;

@Produces
@RequestScoped
public class ProducerResources {
    private FacesContext facesContext;

    public ProducerResources() {
    }

    public FacesContext getFacesContext() {
        return beanFacesContext();
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    @RequestScoped
    public FacesContext beanFacesContext(){
        FacesContext facesContext=FacesContext.getCurrentInstance();
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        return facesContext;
    }

}
