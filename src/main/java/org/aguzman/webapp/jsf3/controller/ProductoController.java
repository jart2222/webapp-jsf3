package org.aguzman.webapp.jsf3.controller;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.aguzman.webapp.jsf3.ProducerResources;
import org.aguzman.webapp.jsf3.entities.Categoria;
import org.aguzman.webapp.jsf3.entities.Producto;
import org.aguzman.webapp.jsf3.services.ProductoService;
import java.util.List;

@Model
public class ProductoController {
    private Producto producto;

    @Inject()
    private ProductoService service;

    private Long id;

    @Inject
    private ProducerResources facesContext;

    @Produces
    @Model
    public String titulo(){
        return "Hola mundo JavaServer Faces 3.0";
    }

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Producto> findAll(){
        //return Arrays.asList(new Producto("peras"), new Producto("manzanas"), new Producto("mandarina"));
        return service.listar();
    }


    @Produces
    @Model
    public Producto producto(){
        this.producto=new Producto();
        if (id != null && id> 0){
            service.porId(id).ifPresent(p ->{
                this.producto=p;
            } );
        }
        return this.producto;
    }

     @Produces
     @Model
     public List<Categoria> categorias(){
        return service.listarCategorias();
     }

    public String guardar(){
        System.out.println(producto);
        service.guardar(producto);
        if(producto.getId()!=null && producto.getId()>0){
            facesContext.getFacesContext().addMessage(null, new FacesMessage("Producto "+ producto.getNombre()+ " actualizado con exito!"));
        }else {
            facesContext.getFacesContext().addMessage(null, new FacesMessage("Producto "+ producto.getNombre()+ " creado con exito!"));
        }


        return "index.xhtml?faces-redirect=true";
    }

    public String editar(Long id){
        this.id=id;
        return "form.xhtml";
    }

    public String eliminar(Producto producto){
        service.eliminar(producto.getId());
        facesContext.getFacesContext().addMessage(null, new FacesMessage("Producto "+ producto.getNombre()+ " eliminado con exito!"));
        return "index.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
