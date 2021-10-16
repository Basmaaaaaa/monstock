package com.stock.gestionstock.services.Impl;
import com.stock.gestionstock.dto.CategoryDTO;
import com.stock.gestionstock.exception.ErrorsCodes;
import com.stock.gestionstock.exception.InvalidEntityException;
import com.stock.gestionstock.services.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService service;

    @Test
    public void ShouldSaveCategoryWithSuccess(){
        CategoryDTO expectedCategory=CategoryDTO.builder()
                .code("cat code")
                .designation("designation test")
                .idEntreprise(1)
                .build();

        CategoryDTO savedCategory=service.save(expectedCategory);
        //il faut que l'objet savedCategory not null
        assertNotNull(savedCategory);

        assertNotNull(savedCategory.getId());

        assertEquals(expectedCategory.getCode(),savedCategory.getCode());
        assertEquals(expectedCategory.getDesignation(),savedCategory.getDesignation());
        assertEquals(expectedCategory.getIdEntreprise(),savedCategory.getIdEntreprise());
         }

    @Test
    public void ShouldUpdateCategoryWithSuccess(){
        CategoryDTO expectedCategory=CategoryDTO.builder()
                .code("cat code")
                .designation("designation test")
                .idEntreprise(1)
                .build();

        CategoryDTO savedCategory=service.save(expectedCategory);

        CategoryDTO categoryToUpdate=savedCategory;
        categoryToUpdate.setCode("cat update");

        savedCategory=service.save(categoryToUpdate);
        //il faut que l'objet categoryToUpdate not null
        assertNotNull(categoryToUpdate);
        assertNotNull(categoryToUpdate.getId());
        assertEquals(expectedCategory.getCode(),categoryToUpdate.getCode());
        assertEquals(expectedCategory.getDesignation(),categoryToUpdate.getDesignation());
        assertEquals(expectedCategory.getIdEntreprise(),categoryToUpdate.getIdEntreprise());
    }

    //traiter le cas si l'objet est de type ThrowsInvalidEntityException
    @Test
    public void ShouldThrowsInvalideEntityException(){
        CategoryDTO expectedCategory=CategoryDTO.builder()
                .build();

        InvalidEntityException expectedException=assertThrows(InvalidEntityException.class,()->service.save(expectedCategory));
        //il faut que le code d'error soit egal a un categoryInvalid
        assertEquals(ErrorsCodes.CATEGORY_NOT_VALID,expectedException.getErrorsCodes());
        //il faut que la taille des errors soit =1
        assertEquals(1,expectedException.getErrors().size());
        assertEquals(1,"Veuillez renseigner sur le code de la category",expectedException.getErrors().get(0));

    }

}