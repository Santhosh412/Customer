package com.springcsvfile.csvfile;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito.Then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.springcsvfile.csvfile.helper.CSVHelper;
import com.springcsvfile.csvfile.model.Tutorial;
import com.springcsvfile.csvfile.repository.TutorialRepository;
import com.springcsvfile.csvfile.service.CSVService;

@SpringBootTest
class CsvfileApplicationTests {

	@InjectMocks
	CSVService csvService;
	
	@Mock
	TutorialRepository tutorialRepository;
	
	@Test
	public void saveTest() throws Exception {
		
	     // List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());

		//when(tutorialRepository.saveAll(tutorials))Then<T>
		
			/*
			 * MockMultipartFile file = new MockMultipartFile( "file", "hello.txt",
			 * MediaType.TEXT_CSV .TEXT_PLAIN_VALUE, "Hello, World!".getBytes() ); MockMvc
			 * mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			 * mockMvc.perform(multipart("/upload").file(file)) .andExpect(status().isOk());
			 */
		 


	}
    
    

}
