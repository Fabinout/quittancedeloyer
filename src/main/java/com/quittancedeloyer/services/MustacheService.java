package com.quittancedeloyer.services;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MustacheService {


    protected Template getTemplate() throws FileNotFoundException {
        return Mustache.compiler()
                .defaultValue("-")
                .withLoader(name -> new FileReader(new ClassPathResource("re/arrg/partials/" + name + ".mustache").getPath()))
                .compile(new FileReader(new ClassPathResource("").getPath()));
    }

}
