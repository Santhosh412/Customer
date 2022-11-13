package com.springcsvfile.csvfile.service;


import com.springcsvfile.csvfile.UniqueIndexvalueException;
import com.springcsvfile.csvfile.helper.CSVHelper;
import com.springcsvfile.csvfile.model.Tutorial;
import com.springcsvfile.csvfile.repository.TutorialRepository;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

@Autowired
private TutorialRepository repository;
  public void save(MultipartFile file) {
   try {
    	//System.out.println("csvfilees");
      List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
     
//      for (Tutorial dto : tutorials) {​​
//      try {​​
//      if(dto.getCard_hash()!=null) {​​
//      carddao.cardNoToCardHash(ExcelCardDetailsDaoImpl.generateCardHash(dto.getCard_hash()));
//      }​​
//      }​​ catch (Exception e) {​​
//      e.getMessage();
//      }​​


     System.out.println(tutorials);
		/*
		 * for (Tutorial tutorial : tutorials) { repository.save(tutorial); }
		 */
     try {
     repository.saveAll(tutorials);
     }
     catch (Exception un) {
	      throw new UniqueIndexvalueException("Unique violation  for index column");
	    }

     // repository.save(tutorials);
   } 
   catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
   
  }

//  public ByteArrayInputStream load() {
//   List<Tutorial> tutorials = repository.findAll();
//
//    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
//    return in;
//  }

  public List<Tutorial> getAllTutorials() {
  return repository.findAll();
  }
}
