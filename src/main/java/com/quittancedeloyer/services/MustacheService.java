package com.quittancedeloyer.services;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class MustacheService {

    public Template getTemplate() throws FileNotFoundException {
        return Mustache.compiler()
                .withLoader(this::getFileReader)
                .compile(getTemplateFileReader());
    }

    FileReader getTemplateFileReader() {
        Resource resource = new ClassPathResource("templates/quittance.mustache");
        try {
            return new FileReader(resource.getFile());
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    FileReader getFileReader(String name) {
        Resource resource = new ClassPathResource("templates/partial/" + name + ".mustache");
        try {
            return new FileReader(resource.getFile());
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
}
