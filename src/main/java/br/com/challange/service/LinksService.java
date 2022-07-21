package br.com.challange.service;

import br.com.challange.entity.Links;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

public interface LinksService{
    boolean verificaSeAUrlNaoExiste(String url);

    String gerarIdValido();

    ResponseEntity<Links> insereUrlEncurtada(String id, String urlFull);

    ResponseEntity<String> getRedirectLink(String id);
}
