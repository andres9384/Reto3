package com.reto4.reto4.repositorio;

import java.util.List;


import com.reto4.reto4.modelo.Category;

import com.reto4.reto4.repositorio.crud.CategoryCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositorio {
    @Autowired

    private CategoryCrudRepositorio categoryCrudRepositorio;

    public List<Category> obtenerTodo(){
        return (List<Category>)categoryCrudRepositorio.findAll();
    }

    public Category guardarCategoria(Category datos){
        return categoryCrudRepositorio.save(datos);
    }
}
