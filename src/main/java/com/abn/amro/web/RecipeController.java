package com.abn.amro.web;

import com.abn.amro.dto.RecipeDTO;
import com.abn.amro.exception.ObjectCreationException;
import com.abn.amro.exception.RecordNotFoundException;
import com.abn.amro.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/* RecipeController class */

@RestController
@RequestMapping("/recipe")
public class RecipeController
{
    private static final Logger logger = LoggerFactory.getLogger(RecipeController.class);
    @Autowired
    RecipeService service;
 
    @GetMapping("/list")
    public ResponseEntity<List<RecipeDTO>> getList() {
        List<RecipeDTO> list = service.getAllRecipes();
        logger.info("Recipe list  Size {}",list.size());
        return new ResponseEntity<List<RecipeDTO>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/get/{id}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        logger.info("getRecipeById id {}" , id);
        RecipeDTO entity = service.getRecipeById(id);
        return new ResponseEntity<RecipeDTO>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping("/add")
    public ResponseEntity<RecipeDTO> createRecipe(@Valid @RequestBody RecipeDTO recipe)
                                                    throws ObjectCreationException {
        RecipeDTO created = service.createRecipe(recipe);
        logger.info("Recipe record created ");
        return new ResponseEntity<RecipeDTO>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<RecipeDTO> updateRecipe(@Valid @RequestBody RecipeDTO recipe)
            throws RecordNotFoundException {
        RecipeDTO updated = service.updateRecipe(recipe);
        logger.info("Recipe record Updated ");
        return new ResponseEntity<RecipeDTO>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteRecipeById(id);
        logger.info("Recipe record deleted id{}" , id);
        return new ResponseEntity<String>("Record deleted", new HttpHeaders(), HttpStatus.OK);
    }
 
}