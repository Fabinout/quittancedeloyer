package com.quittancedeloyer.services;

import com.samskivert.mustache.Template;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;

import static org.assertj.core.api.Assertions.assertThat;

public class MustacheServiceTest {

    private MustacheService mustacheService;

    @Before
    public void setUp() throws Exception {
        mustacheService = new MustacheService();
    }

    @Test
    public void resourceReader_should_work_with_partial() throws Exception {
        //when
        FileReader fileReader = mustacheService.getFileReader("name");
        //then
        assertThat(fileReader).isNotNull();
    }

    @Test
    public void templateLoader_should_work_with_quittance() throws Exception {
        //when
        Template template = mustacheService.getTemplate();
        //then
        assertThat(template).isNotNull();
    }
}