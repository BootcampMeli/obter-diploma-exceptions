package com.digitalhouse.obtenerdiploma.Unit;

import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CertificateServiceImplTest {
    @Autowired
    CertificateServiceImpl certificateService;

    @Test
    void testAnalyzeNotesEquals() {
        //arrange
        StudentDTO baseStudent = new StudentDTO();
        baseStudent.setName("Kamila");
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        SubjectDTO subjectDTO1 = new SubjectDTO();
        SubjectDTO subjectDTO2 = new SubjectDTO();

        subjectDTO.setSubject("Matematica");
        subjectDTO.setNote(10);
        subjectDTOList.add(subjectDTO);
        subjectDTO1.setSubject("Fisica");
        subjectDTO1.setNote(7);
        subjectDTOList.add(subjectDTO1);
        subjectDTO2.setSubject("Quimica");
        subjectDTO2.setNote(6);
        subjectDTOList.add(subjectDTO2);

        baseStudent.setSubjects(subjectDTOList);

        CertificateDTO expected = new CertificateDTO(baseStudent);
        expected.setAverage(certificateService.calculateAverage(baseStudent));
        expected.setMessage(certificateService.writeDiploma(baseStudent));

        // act

        CertificateDTO certificateDTO = certificateService.analyzeNotes(baseStudent);

        // assert
        Assertions.assertEquals(expected.getAverage(), certificateDTO.getAverage());
        Assertions.assertEquals(expected.getMessage(), certificateDTO.getMessage());


    }

    @Test
    void testAnalyzeNotesNotEquals() {
        //arrange
        StudentDTO baseStudent = new StudentDTO();
        baseStudent.setName("Kamila");
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        SubjectDTO subjectDTO1 = new SubjectDTO();
        SubjectDTO subjectDTO2 = new SubjectDTO();

        subjectDTO.setSubject("Matematica");
        subjectDTO.setNote(10);
        subjectDTOList.add(subjectDTO);
        subjectDTO1.setSubject("Fisica");
        subjectDTO1.setNote(7);
        subjectDTOList.add(subjectDTO1);
        subjectDTO2.setSubject("Quimica");
        subjectDTO2.setNote(6);
        subjectDTOList.add(subjectDTO2);

        baseStudent.setSubjects(subjectDTOList);

        CertificateDTO expected = new CertificateDTO(baseStudent);
        expected.setAverage(certificateService.calculateAverage(baseStudent) - 1);
        expected.setMessage(certificateService.writeDiploma(baseStudent) + " ola");

        // act

        CertificateDTO certificateDTO = certificateService.analyzeNotes(baseStudent);

        // assert
        Assertions.assertNotEquals(expected.getAverage(), certificateDTO.getAverage());
        Assertions.assertNotEquals(expected.getMessage(), certificateDTO.getMessage());


    }

    @Test
    void testCalculateAverageEquals() {
        //arrange
        StudentDTO baseStudent = new StudentDTO();
        baseStudent.setName("Kamila");
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        SubjectDTO subjectDTO1 = new SubjectDTO();
        SubjectDTO subjectDTO2 = new SubjectDTO();

        subjectDTO.setSubject("Matematica");
        subjectDTO.setNote(10);
        subjectDTOList.add(subjectDTO);
        subjectDTO1.setSubject("Fisica");
        subjectDTO1.setNote(7);
        subjectDTOList.add(subjectDTO1);
        subjectDTO2.setSubject("Quimica");
        subjectDTO2.setNote(6);
        subjectDTOList.add(subjectDTO2);

        baseStudent.setSubjects(subjectDTOList);

        Double expected = (10 + 7 + 6)/3.0;

        // act

        Double average = certificateService.calculateAverage(baseStudent);

        // assert
        Assertions.assertEquals(expected, average);

    }

    @Test
    void testCalculateAverageNotEquals() {
        //arrange
        StudentDTO baseStudent = new StudentDTO();
        baseStudent.setName("Kamila");
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        SubjectDTO subjectDTO1 = new SubjectDTO();
        SubjectDTO subjectDTO2 = new SubjectDTO();

        subjectDTO.setSubject("Matematica");
        subjectDTO.setNote(10);
        subjectDTOList.add(subjectDTO);
        subjectDTO1.setSubject("Fisica");
        subjectDTO1.setNote(7);
        subjectDTOList.add(subjectDTO1);
        subjectDTO2.setSubject("Quimica");
        subjectDTO2.setNote(6);
        subjectDTOList.add(subjectDTO2);

        baseStudent.setSubjects(subjectDTOList);

        Double unexpected = (10 + 7 + 6)/2.0;

        // act

        Double average = certificateService.calculateAverage(baseStudent);

        // assert
        Assertions.assertNotEquals(unexpected, average);

    }

    @Test
    void testWriteDiplomaEquals() {
        //arrange
        StudentDTO baseStudent = new StudentDTO();
        baseStudent.setName("Kamila");
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        SubjectDTO subjectDTO1 = new SubjectDTO();
        SubjectDTO subjectDTO2 = new SubjectDTO();

        subjectDTO.setSubject("Matematica");
        subjectDTO.setNote(10);
        subjectDTOList.add(subjectDTO);
        subjectDTO1.setSubject("Fisica");
        subjectDTO1.setNote(7);
        subjectDTOList.add(subjectDTO1);
        subjectDTO2.setSubject("Quimica");
        subjectDTO2.setNote(6);
        subjectDTOList.add(subjectDTO2);

        baseStudent.setSubjects(subjectDTOList);

        Double expectedAverage = (10 + 7 + 6)/3.0;
        String expectedMessage = baseStudent.getName() + " usted ha conseguido el promedio de " + expectedAverage;

        // act

        String diploma = certificateService.writeDiploma(baseStudent);

        // assert
        Assertions.assertEquals(expectedMessage, diploma);

    }

    @Test
    void testWriteDiplomaNotEquals() {
        //arrange
        StudentDTO baseStudent = new StudentDTO();
        baseStudent.setName("Kamila");
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        SubjectDTO subjectDTO1 = new SubjectDTO();
        SubjectDTO subjectDTO2 = new SubjectDTO();

        subjectDTO.setSubject("Matematica");
        subjectDTO.setNote(10);
        subjectDTOList.add(subjectDTO);
        subjectDTO1.setSubject("Fisica");
        subjectDTO1.setNote(7);
        subjectDTOList.add(subjectDTO1);
        subjectDTO2.setSubject("Quimica");
        subjectDTO2.setNote(6);
        subjectDTOList.add(subjectDTO2);

        baseStudent.setSubjects(subjectDTOList);

        Double expectedAverage = (10 + 7 + 6)/3.0;
        String expectedMessage = "¡Felicitaciones " + baseStudent.getName() + " usted ha conseguido el promedio de " + expectedAverage;

        // act

        String diploma = certificateService.writeDiploma(baseStudent);

        // assert
        Assertions.assertNotEquals(expectedMessage, diploma);

    }

    @Test
    void testWithHonorsEquals() {
        //arrange
        CertificateServiceImpl certificateService = new CertificateServiceImpl();

        String student = "Kamila";
        Double average = 9.1;

        String expected = "¡Felicitaciones " + "Kamila" + "! Usted tiene el gran promedio de " + 9.1;

        // act
        String message = certificateService.withHonors(average, student);

        // assert
        Assertions.assertEquals(expected, message);

    }

    @Test
    void testWithHonorsNotEquals() {
        //arrange
        CertificateServiceImpl certificateService = new CertificateServiceImpl();

        String student = "Kamila";
        Double average = 9.1;

        String unexpected = "Kamila" + "! Usted tiene el gran promedio de " + 9.1;

        // act
        String message = certificateService.withHonors(average, student);

        // assert
        Assertions.assertNotEquals(unexpected, message);

    }

}
