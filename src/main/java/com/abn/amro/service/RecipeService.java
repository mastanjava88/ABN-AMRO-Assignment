package com.abn.amro.service;

import com.abn.amro.dto.RecipeDTO;
import com.abn.amro.exception.ObjectCreationException;
import com.abn.amro.exception.RecordNotFoundException;

import java.util.List;

public interface RecipeService {
    public List<RecipeDTO> getAllRecipes();
    public RecipeDTO getRecipeById(Long id) throws RecordNotFoundException;
    public RecipeDTO updateRecipe(RecipeDTO recipeDto) throws RecordNotFoundException;
    public RecipeDTO createRecipe(RecipeDTO recipeDto) throws ObjectCreationException;
    public void deleteRecipeById(Long id) throws RecordNotFoundException;

}
