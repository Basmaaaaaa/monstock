package com.stock.gestionstock.services.Impl;

import com.stock.gestionstock.dto.ArticleDTO;
import com.stock.gestionstock.exception.EntityNotFoundException;
import com.stock.gestionstock.exception.ErrorsCodes;
import com.stock.gestionstock.exception.InvalidEntityException;
import com.stock.gestionstock.model.Article;
import com.stock.gestionstock.repository.ArticleRepository;
import com.stock.gestionstock.services.ArticleSerivce;
import com.stock.gestionstock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleSerivce {


    //injection par constructeur de ArticleRepository
    private ArticleRepository articleRepository;
    @Autowired
    public  ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository=articleRepository;
        }


        @Override
    public ArticleDTO save(ArticleDTO articleDto) {
        List<String> error= ArticleValidator.Validate(articleDto);
        //si l'article n'est pas valide , enleve une exception de type EntityException (avec un message,un code d'errors,liste des errors,
        if(error.isEmpty()){
            log.error("article is not valide",articleDto);
            throw new InvalidEntityException("l'article n'est pas validé", ErrorsCodes.ARTICLE_NOT_VALID,error);
        }
        return ArticleDTO.fromEntity(articleRepository.save(ArticleDTO.toEntity(articleDto)));
    }


    @Override
    public ArticleDTO findById(Integer idCategory) {
        if (idCategory==null){
            log.error("article ID is null");
            return null;}
     Optional<Article> article=articleRepository.findById(idCategory);
        return Optional.of(ArticleDTO.fromEntity(article.get())).orElseThrow(()->
              new EntityNotFoundException( "Aucun article n'est été enregistrer dans la base de donnée",
                        ErrorsCodes.ARTICLE_NOT_FOUND)
        );
    }


    @Override
    public ArticleDTO findByCodeArticle(String codeArticle) {
        if (! StringUtils.hasLength(codeArticle)){
            log.error("Article Code  is null");
            return null;}

        Optional<Article> article=articleRepository.findArticleByCodeArticle(codeArticle);

        return Optional.of(ArticleDTO.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException( "Aucun code article n'est été enregistrer dans la base de donnée",
                        ErrorsCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDTO> findAll() {
        //appel a la methode findAll() en envoyant une liste en utilisant la methode stream()
        return articleRepository.findAll().stream()
                //faire un mapping map(methode reference)
                //detecter autaumatiquement le type de parametre (expression lamda)
                .map(ArticleDTO::fromEntity)
                //parser dans une liste
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
    if(id==null){
        log.error("Article ID is null");
    }
    articleRepository.deleteById(id);
    }
}
