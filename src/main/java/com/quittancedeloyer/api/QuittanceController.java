package com.quittancedeloyer.api;

import com.quittancedeloyer.services.MustacheService;
import com.samskivert.mustache.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QuittanceController {

    @Autowired
    MustacheService mustacheService;

    @RequestMapping("/")
    public String index() {
        return "todo";
    }

    @RequestMapping("/txt")
    public String getTxt() throws FileNotFoundException {
        return getContent();
    }

    @RequestMapping("/pdf")
    public ResponseEntity<byte[]> getPdf() throws FileNotFoundException {
        //String content = getContent();
        byte[] contents = {};

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "output.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;

    }

    private String getContent() throws FileNotFoundException {
        Template template = mustacheService.getTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("param", "PAS WAM");
        return template.execute(map);
    }
}
