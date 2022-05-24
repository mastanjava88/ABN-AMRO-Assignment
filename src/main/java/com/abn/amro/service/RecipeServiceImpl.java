package com.abn.amro.service;

import com.abn.amro.dto.RecipeDTO;
import com.abn.amro.exception.ObjectCreationException;
import com.abn.amro.exception.RecordNotFoundException;
import com.abn.amro.model.RecipeEntity;
import com.abn.amro.repository.RecipeDao;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static final Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);
    @Autowired
    RecipeDao recipeDao;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Method to persist the entity by mapping the request DTO to entity, saving the entity and finally mapping the persisted
     * entity to the response DTO.
     *
     * @param recipeDTO contain api request data
     * @return contain api response data
     */

    @Transactional
    @Override
    public RecipeDTO createRecipe(RecipeDTO recipeDTO) throws ObjectCreationException {
        RecipeEntity entity = modelMapper.map(recipeDTO, RecipeEntity.class);
        if (Objects.isNull(entity)) {
            logger.error("Recipe Object creation exception");
            throw new ObjectCreationException("Recipe Object creation exception");
        }
        logger.debug("Request mapped to Entity: {}", Boolean.TRUE);
        recipeDTO = modelMapper.map(recipeDao.save(entity), RecipeDTO.class);
        logger.debug("Entity mapped to Response: {}", Boolean.TRUE);
        return recipeDTO;
    }

    /**
     * Method to update the persisted recipe by mapping the request DTO to entity,
     * saving the updated entity and finally mapping the persisted entity to the response DTO.
     * If recipe not found then user custom error message is returned.
     *
     * @param recipeDTO contain api request data
     * @return contain api response data
     */
    @Transactional
    @Override
    public RecipeDTO updateRecipe(RecipeDTO recipeDTO) throws RecordNotFoundException {
        Optional<RecipeEntity> recipeEntity = recipeDao.findById(recipeDTO.getId());
        logger.debug("Recipe found to update {}", recipeEntity.isPresent());
        if (!recipeEntity.isPresent()) {
            throw new RecordNotFoundException("No Recipe record exist for given id");
        }
        RecipeEntity updatedEntity = modelMapper.map(recipeDTO, RecipeEntity.class);
        logger.debug("Request mapped to Entity: {}", Boolean.TRUE);
        recipeDTO = modelMapper.map(recipeDao.save(updatedEntity), RecipeDTO.class);
        logger.debug("Entity mapped to Response: {}", Boolean.TRUE);
        return recipeDTO;
    }

    /**
     * Method to fetch the persisted recipe based on id. Mapping the entity to response dto.
     * if not found then user custom message is returned.
     *
     * @param id of recipe to select from records
     * @return the recipe detail with given id
     */
    @Override
    @Transactional
    public RecipeDTO getRecipeById(Long id) throws RecordNotFoundException {
        Optional<RecipeEntity> recipeEntity = recipeDao.findById(id);
        logger.debug("Recipe found {}", recipeEntity.isPresent());
        return modelMapper.map(
                recipeEntity.orElseThrow(() -> new RecordNotFoundException("Recipe not found to with id: " + id))
                , RecipeDTO.class);

    }
    /**
     * Method to fetch all the persisted recipes
     * and mapping to response DTO.
     *
     * @return All recipes present in records
     */
    @Override
    @Transactional
    public List<RecipeDTO> getAllRecipes() {
        List<RecipeEntity> recipeEntities = recipeDao.findAll();
        logger.debug("{} Recipe(s) found.", recipeEntities.size());
        Type type = new TypeToken<List<RecipeDTO>>() {
        }.getType();
        return modelMapper.map(recipeEntities, type);
    }

    /**
     * Method to delete the recipe with provided id.
     * if not found then user custom message is returned.
     *
     * @param id to delete the recipe from records
     * @return void
     */
    @Override
    @Transactional
    public void deleteRecipeById(Long id) throws RecordNotFoundException {
        Optional<RecipeEntity> recipeEntity = recipeDao.findById(id);
        logger.debug("Recipe found to delete {}", recipeEntity.isPresent());
        recipeDao.deleteById(recipeEntity.orElseThrow(
                () -> new RecordNotFoundException("No Recipe record exist for given id " + id)
        ).getId());
    }

}