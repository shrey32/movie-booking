package com.shrey.moviebooking.movieservice.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shrey.moviebooking.commons.model.Category;
import com.shrey.moviebooking.movieservice.repository.CategoryRepository;

/**
 * 
 * @author Shrey
 *
 */
@Service
@Qualifier("categoryService")
public class CategoryServiceImpl implements MovieDetailsService<Category> {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Category add(Category category) {
		logger.info("Adding a new Category ==>" + category);
		category.setCreated(new Date());
		Optional<Category> optionalCategory = this.findByName(category.getName());
		if (optionalCategory.isPresent()) {
			logger.info("category Already Exists, updating");
			category.setId(optionalCategory.get().getId());
			category.setUpdated(new Date());
			category.setCreated(optionalCategory.get().getCreated());
		}
		return this.categoryRepository.save(category);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Category> findById(long id) {
		logger.info("finding Category by id ==>" + id);
		return this.categoryRepository.findById(id);
	}

	@Override
	public Optional<Category> findByName(String name) {
		return this.categoryRepository.findByName(name);
	}
	
}
