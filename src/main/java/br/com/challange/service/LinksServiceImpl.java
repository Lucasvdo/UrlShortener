package br.com.challange.service;

import br.com.challange.domain.utils.UrlGenerator;
import br.com.challange.entity.Links;
import br.com.challange.repository.LinksRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinksServiceImpl implements LinksService{

    @Autowired
    LinksRepository linksRepository;


    @Override
    public boolean verificaSeAUrlNaoExiste(String url) {
        return linksRepository.findByUrlFullPath(url).isPresent();
    }

    @Override
    public String gerarIdValido() {
        String idAleatorio = UrlGenerator.gerarId();
        while(linksRepository.findById(idAleatorio).isPresent()){
            idAleatorio = UrlGenerator.gerarId();
        }
        return idAleatorio;
    }

    @Override
    public ResponseEntity<Links> insereUrlEncurtada(String id, String urlFull) {
        Links links = new Links(id,urlFull);
        try {
            linksRepository.save(links);
            return ResponseEntity.ok().body(links);
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public ResponseEntity<String> getRedirectLink(String id) {
        Optional<Links> links = linksRepository.findById(id);
        if(links.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new Gson().toJson("url:"+links.get().getUrlFullPath()));

    }


}
