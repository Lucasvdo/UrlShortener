package br.com.challange.controller;

import br.com.challange.UrlShortenerSpringApplication;
import br.com.challange.entity.Links;
import br.com.challange.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.Media;

@RestController
public class UrlShortenerController {

    @Autowired
    LinksService linksService;

    @RequestMapping(path = "/urlshortener", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Links> urlShortener(@RequestParam String url){

        if(linksService.verificaSeAUrlNaoExiste(url)){
            return ResponseEntity.badRequest().build();
        }
        ResponseEntity<Links> response;
        try {
            String id = linksService.gerarIdValido();
            response = linksService.insereUrlEncurtada(id,url);
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }

        return response;
    }

    @RequestMapping(path = "/{urlId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> urlRedirect(@PathVariable(name = "urlId") String id){

        return linksService.getRedirectLink(id);

    }

}
