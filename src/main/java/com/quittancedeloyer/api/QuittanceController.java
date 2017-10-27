package com.quittancedeloyer.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class QuittanceController {

    @RequestMapping("/")
    public String index() {
        return "todo";
    }

    @RequestMapping("/pdf")
    public boolean getPdf() {
        File file = null;
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource("extract-1508255346512.pdf").getFile());
        return file.exists();
    }

}
