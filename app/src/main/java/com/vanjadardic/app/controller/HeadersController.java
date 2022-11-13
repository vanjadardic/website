package com.vanjadardic.app.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/headers")
public class HeadersController {

    @GetMapping("")
    String index(Model model, HttpServletRequest request) {
        List<HeaderPair> headers = new ArrayList<>();
        for (Enumeration<String> headerNames = request.getHeaderNames(); headerNames.hasMoreElements(); ) {
            String headerName = headerNames.nextElement();
            for (Enumeration<String> headerValues = request.getHeaders(headerName); headerValues.hasMoreElements(); ) {
                headers.add(new HeaderPair(headerName, headerValues.nextElement()));
            }
        }
        headers.sort(Comparator.comparing(s -> s.value));
        headers.sort(Comparator.comparing(s -> s.key));

        model.addAttribute("h", headers);
        return "headers";
    }

    public record HeaderPair(String key, String value) {
    }
}
