package com.reto4.reto4.web;

import java.util.List;
import java.util.Optional;

import com.reto4.reto4.modelo.Category;
import com.reto4.reto4.servicio.CategoryServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryControlador {
    @Autowired
    private CategoryServicio categoryServicio;
    
    @GetMapping("/all")
    public List<Category>obtenerTodo(){
        return categoryServicio.obtenerTodo();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category guardarDepartamento(@RequestBody Category datos){
        return categoryServicio.guardarCategoria(datos);
    }

    @GetMapping("/{numId}")
    public Optional<Category>getCategory(@PathVariable("numId")int id){
        return categoryServicio.obtenerCategoria(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category datos){
        return categoryServicio.update(datos);
    }
    @DeleteMapping("/{numId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCategoria(@PathVariable("numId")int id){
        return categoryServicio.eliminarCategoria(id);
    }
}
