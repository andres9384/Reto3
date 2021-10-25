package com.reto4.reto4.servicio;

import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Category;
import com.reto4.reto4.repositorio.CategoryRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio;

    public List<Category>obtenerTodo(){
        return  categoryRepositorio.obtenerTodo();
    }
  
    // public Category guardarCategoria(Category datos){
        
    //         return categoryRepositorio.guardarCategoria(datos);

    // }

    public Optional<Category>obtenerCategoria(int id){
        return categoryRepositorio.obtenerCategoria(id);
    }

    public Category guardarCategoria(Category datos){
        if(datos.getId()==null){
            return categoryRepositorio.guardarCategoria(datos);

        }else{
            Optional<Category> consulta= categoryRepositorio.obtenerCategoria(datos.getId());
            if (consulta.isEmpty()) {
                return categoryRepositorio.guardarCategoria(datos);
            }else{
                return datos;
            }
        }
    }
    public Category update(Category datos){
        if(datos.getId()!=null){
            Optional<Category>consulta= categoryRepositorio.obtenerCategoria(datos.getId());
            if(!consulta.isEmpty()){
                if (datos.getName()!=null) {
                    consulta.get().setName(datos.getName());   
                }if(datos.getDescription()!=null){
                    consulta.get().setDescription(datos.getDescription());
                }
                return categoryRepositorio.guardarCategoria(consulta.get());
            }
        }return datos;
    }
    public boolean eliminarCategoria(int id){
        Optional<Category>consulta = categoryRepositorio.obtenerCategoria(id);
        if(!consulta.isEmpty()){
            categoryRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }
}
