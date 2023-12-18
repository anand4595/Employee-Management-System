package com.example.AdministratorService.repository;


import com.example.AdministratorService.model.ContactUsModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
//import org.springframework.boot.test.context.SpringBootTest;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ContactUsRepositoryTests {

    @Autowired
    ContactUsRepository contactUsRepository;
    @Test
    public void ContactUsRepository_save_ReturnsSavedContactUsModel() {
//        arrange
        ContactUsModel contactUsModel = ContactUsModel
                .builder()
                .name("anand")
                .email("anand@xyz.com")
                .query("test query")
                .build();

//        act
        ContactUsModel responce = contactUsRepository.save(contactUsModel);

//        assert
        Assertions.assertThat(responce).isNotNull();
    }

    @Test
    public void ContactUsRepository_findAll_ReturnsAllQuery_noRepeatedEmailSavedAndFinalAllWorking () {
//        arrange

        ContactUsModel contactUsModel1 = ContactUsModel
                .builder()
                .name("anand")
                .email("anand@xyz.com")
                .query("test query")
                .build();
//        act
        contactUsRepository.save(contactUsModel1);
        contactUsRepository.save(contactUsModel1);
        contactUsRepository.save(
                ContactUsModel.builder()
                        .name("").query("").email("").build()
        );
//      assert
        List<ContactUsModel> queryList = contactUsRepository.findAll();

        Assertions.assertThat(queryList.size()).isEqualTo(2);
    }

    @Test
    public void ContactUsRepository_ExistsByEmail_ReturnsQuery () {
//        arrange
        ContactUsModel contactUsModel = ContactUsModel
                .builder()
                .name("xyz")
                .email("xyz@acb.com")
                .query("thi is sample query")
                .build();
//        act
        contactUsRepository.save(contactUsModel);
        boolean savedEmail = contactUsRepository.existsByEmail(contactUsModel.getEmail());
        boolean notSavedEmail = contactUsRepository.existsByEmail("abs@kjdf.com");

//        assert
        Assertions.assertThat(savedEmail).isEqualTo(true);
        Assertions.assertThat(notSavedEmail).isEqualTo(false);

    }
}