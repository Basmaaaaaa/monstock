package com.stock.gestionstock.services.Impl;

import com.stock.gestionstock.dto.CategoryDTO;
import com.stock.gestionstock.exception.EntityNotFoundException;
import com.stock.gestionstock.exception.ErrorsCodes;
import com.stock.gestionstock.exception.InvalidEntityException;
import com.stock.gestionstock.model.Category;
import com.stock.gestionstock.repository.CategoryRepository;
import com.stock.gestionstock.services.CategoryService;
import com.stock.gestionstock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//fournir lombok pour le logging
@Slf4j

public class CategoryServiceImpl implements CategoryService {
    //injection par constructeur de CategoryRepository
    private CategoryRepository categoryRepository ;

    //injection par constructeur
    //injecter categoryRepository en faisant une injection par constructeur
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
   }


@Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        List<String> error= CategoryValidator.validate(categoryDTO);
        //si category is not valide enleve une exception de type un valide exception avec un message d'error
        if(error.isEmpty()){
            log.error("category is not valide",categoryDTO);
            throw  new InvalidEntityException("category n'est pas valide",ErrorsCodes.CATEGORY_NOT_VALID,error);
        }
    return CategoryDTO.fromEntity(categoryRepository.save(CategoryDTO.toEntity(categoryDTO)));
}


 @Override
    public CategoryDTO findById(Integer id) {
        if(id==null){
          log.error("Id category is null");
        return null;}
     Optional<Category> category=categoryRepository.findById(id);
     return Optional.of(CategoryDTO.fromEntity(category.get())).orElseThrow(()->
             new EntityNotFoundException( "Aucun category n'est été enregistrer dans la base de donnée",
                     ErrorsCodes.CATEGORY_NOT_FOUND)
     );
    }




    @Override
    public CategoryDTO findByCodeCategory(String code) {
        if (! StringUtils.hasLength(code)){
            log.error("category Code  is null");
            return null;}

        Optional<Category> category=categoryRepository.findArticleByCodeArticle(code);

        return Optional.of(CategoryDTO.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException( "Aucun code category n'est été enregistrer dans la base de donnée",
                        ErrorsCodes.CATEGORY_NOT_FOUND)
        );
    }



    @Override
    public List<CategoryDTO> findAll() {
        //appel a la methode findAll() en envoyant une liste en utilisant la methode stream()
        return categoryRepository.findAll().stream()
                //faire un mapping map(methode reference)
                //detecter autaumatiquement le type de parametre (expression lamda)
                .map(CategoryDTO::fromEntity)
                //parser dans une liste
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {

        if(id==null){
            log.error("category ID is null");

        }
        categoryRepository.deleteById(id);
    }
}
