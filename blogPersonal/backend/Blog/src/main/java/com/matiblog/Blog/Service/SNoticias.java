package com.matiblog.Blog.Service;

import com.matiblog.Blog.Entity.Noticias;
import com.matiblog.Blog.Repository.RNoticias;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SNoticias {

    @Autowired
    RNoticias rNoticias;

    public List<Noticias> list() {
        return rNoticias.findAll();
    }

    public Optional<Noticias> getOne(int id) {
        return rNoticias.findById(id);
    }

    public Optional<Noticias> getByNombreN(String nombreN) {
        return rNoticias.findByNombreN(nombreN);
    }

    public void save(Noticias noti) {
        rNoticias.save(noti);
    }

    public void delete(int id) {
        rNoticias.deleteById(id);
    }

    public boolean existsByNombreN(int id) {
        return rNoticias.existsById(id);
    }

    public boolean existsByNombreN(String nombreN) {
        return rNoticias.existsByNombreN(nombreN);
    }

}
