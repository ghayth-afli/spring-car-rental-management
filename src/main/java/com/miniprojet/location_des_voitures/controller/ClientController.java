package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.dto.requests.ClientRequest;
import com.miniprojet.location_des_voitures.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    IClientService clientService;

    @GetMapping
    //display all clients
    public String getAllClients(Model model){
        return null;
    }

    @GetMapping("/create")
    //display create client form
    public String createClient(Model model){
        return null;
    }

    @PostMapping("/create")
    //create client
    public String createClient(Model model, @RequestBody ClientRequest clientRequest){
        return null;
    }

    @GetMapping("/{id}/edit")
    //display edit client form
    public String editClient(Model model, @PathVariable Long id){
        return null;
    }

    @PostMapping("/{id}/edit")
    //edit client
    public String editClient(Model model, @PathVariable Long id, @RequestBody ClientRequest clientRequest){
        return null;
    }

    @PostMapping("/{id}/delete")
    //delete client
    public String deleteClient(Model model, @PathVariable Long id){
        return null;
    }
}
