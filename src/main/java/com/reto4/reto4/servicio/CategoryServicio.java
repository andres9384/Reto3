package com.reto4.reto4.servicio;

import java.util.List;


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
  
    public Category guardarCategoria(Category datos){
        
            return categoryRepositorio.guardarCategoria(datos);

        
    }
}
