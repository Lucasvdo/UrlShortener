package br.com.challange.repository;

import br.com.challange.entity.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinksRepository extends JpaRepository<Links,String> {

    Optional<Links> findByUrlFullPath(String url);

}
