package com.matiblog.Blog.Repository;

import com.matiblog.Blog.Entity.Noticias;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RNoticias extends JpaRepository<Noticias, Integer> {
    public Optional <Noticias> findByNombreN(String nombreN);
    public boolean existsByNombreN(String nombreN);
    
}
