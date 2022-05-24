package com.abn.amro;

import com.abn.amro.dto.RecipeDTO;
import com.abn.amro.model.IngredientsEntity;
import com.abn.amro.model.RecipeEntity;
import com.abn.amro.repository.RecipeDao;
import com.abn.amro.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeServiceImplTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RecipeService recipeService;

    @MockBean
    RecipeDao recipeDao;



    RecipeEntity entity;

    IngredientsEntity inEntity;
    RecipeDTO recipeDTO;

    @BeforeEach
    public void setUp() throws IOException {
        recipeDTO = getRecipeDTO();
        entity = new RecipeEntity();
        entity.setId(recipeDTO.getId());
        entity.setName(recipeDTO.getName());
        inEntity = new IngredientsEntity();
        inEntity.setName("Oil");
        inEntity.setId(recipeDTO.getId());
        Set<IngredientsEntity> ingridientEntities = new HashSet<>();
        ingridientEntities.add(inEntity);
    }


    RecipeDTO getRecipeDTO() throws IOException {
        return objectMapper.readValue(ResourceUtils.getFile("./src/test/resources/request.json"), RecipeDTO.class);
    }

    @Test
    void addRecipeTest() throws Exception {
        Mockito.when(recipeDao.save(Mockito.any())).thenReturn(entity);
        RecipeDTO responseDTO = recipeService.createRecipe(recipeDTO);
        assertEquals("Mutton", responseDTO.getName());
    }

    @Test
    void updateRecipeTest() throws Exception {

        Mockito.when(recipeDao.findById(Mockito.anyLong())).thenReturn(Optional.of(entity));
        Mockito.when(recipeDao.save(Mockito.any())).thenReturn(entity);

        RecipeDTO responseDTO = recipeService.updateRecipe(recipeDTO);
        assertEquals("Mutton", responseDTO.getName());
    }

    @Test
    void getRecipeByIDTest() throws Exception {

        Mockito.when(recipeDao.findById(Mockito.anyLong())).thenReturn(Optional.of(entity));
        RecipeDTO responseDTO = recipeService.getRecipeById(1l);
        assertEquals("Mutton", responseDTO.getName());
    }

    @Test
    void getRecipeAllTest() throws Exception {
        List<RecipeEntity> listRecipe = new ArrayList<>();
        listRecipe.add(entity);
        Mockito.when(recipeDao.findAll()).thenReturn(listRecipe);
        List<RecipeDTO> listRecipeDTO = recipeService.getAllRecipes();
        assertTrue(listRecipeDTO.size() > 0);
    }

    @Test
    void getDeleteTest() throws Exception {
        Mockito.when(recipeDao.findById(Mockito.anyLong())).thenReturn(Optional.of(entity));
        recipeDao.deleteById(1l);
        recipeService.deleteRecipeById(1l);
        assertTrue(true);
    }

}
