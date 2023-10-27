package com.dustore.dustore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteHtmlController {

    @GetMapping("/")
    public String exibirCliente() {
		return "cliente";
    }
}