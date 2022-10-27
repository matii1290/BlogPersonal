/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.matiblog.Blog.Controller;

import com.matiblog.Blog.Dto.dtoNoticias;
import com.matiblog.Blog.Entity.Noticias;
import com.matiblog.Blog.Service.SNoticias;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("noticias")
@CrossOrigin(origins = "https://frontblog1.web.app/")
public class CNoticias {

    @Autowired
    SNoticias sNoticias;

    @GetMapping("/lista")
    public ResponseEntity<List<Noticias>> list() {
        List<Noticias> list = sNoticias.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoNoticias dtonoti) {
        if (StringUtils.isBlank(dtonoti.getNombreN())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sNoticias.existsByNombreN(dtonoti.getNombreN())) {
            return new ResponseEntity(new Mensaje("Esa noticia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Noticias noticias = new Noticias(dtonoti.getNombreN(), dtonoti.getDescripcionN());
        sNoticias.save(noticias);

        return new ResponseEntity(new Mensaje("Noticia Agregada correctamente"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoNoticias dtonoti) {
        if (!sNoticias.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        if (sNoticias.existsByNombreN(dtonoti.getNombreN()) && sNoticias.getByNombreN(dtonoti.getNombreN()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Noticia ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtonoti.getNombreN())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Noticias noticias = sNoticias.getOne(id).get();
        noticias.setNombreN(dtonoti.getNombreN());
        noticias.setDescripcionN(dtonoti.getDescripcionN());

        sNoticias.save(noticias);
        return new ResponseEntity(new Mensaje("Noticia editada con exito"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sNoticias.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sNoticias.delete(id);
        return new ResponseEntity(new Mensaje("Noticia elminada correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Noticias> getById(@PathVariable("id") int id){
        if(!sNoticias.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Noticias noticias = sNoticias.getOne(id).get();
        return new ResponseEntity(noticias, HttpStatus.OK);
    }

}
