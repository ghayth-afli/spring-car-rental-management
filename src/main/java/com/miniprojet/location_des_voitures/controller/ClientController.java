package com.miniprojet.location_des_voitures.controller;

import com.miniprojet.location_des_voitures.dto.requests.ClientRequest;
import com.miniprojet.location_des_voitures.model.Client;
import com.miniprojet.location_des_voitures.service.IClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    IClientService clientService;

    @GetMapping
    //display all clients
    public String getAllClients(Model model){
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "backoffice/client/index";
    }

    @GetMapping("/create")
    //display create client form
    public String createClient(Model model){
        model.addAttribute("clientRequest",new ClientRequest());
        return "backoffice/client/create";
    }

    @PostMapping("/create")
    //create client
    public String createClient(@Valid @ModelAttribute("clientRequest") ClientRequest clientRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "backoffice/client/create";
        }
        Date dateEnregistrement = new Date();
        Client client = new Client(clientRequest.getCin(),
                clientRequest.getPermisDeConduire(),
                clientRequest.getNom(),
                clientRequest.getPrenom(),
                clientRequest.getAdresse(),
                clientRequest.getEmail(),
                clientRequest.getTelephone(),
                clientRequest.getDateDeNaissance(),
                dateEnregistrement
        );
        clientService.createClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    //display edit client form
    public String editClient(Model model, @PathVariable Long id){
        Optional<Client> client = clientService.getClientById(id);
        if (client.isPresent()){
            ClientRequest clientRequest = new ClientRequest(
                    client.get().getId(),
                    client.get().getCin(),
                    client.get().getPermisDeConduire(),
                    client.get().getNom(),
                    client.get().getPrenom(),
                    client.get().getAdresse(),
                    client.get().getEmail(),
                    client.get().getTelephone(),
                    client.get().getDateDeNaissance()
            );
            model.addAttribute("clientRequest", clientRequest);
            return "backoffice/client/edit";
        }
        return "redirect:/clients";
    }

    @PostMapping("/{id}/edit")
    //edit client
    public String editClient(Model model, @PathVariable Long id, @Valid @ModelAttribute("clientRequest") ClientRequest clientRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "backoffice/client/edit";
        }
        Optional<Client> client = clientService.getClientById(id);
        if (client.isPresent()){
            client.get().setCin(clientRequest.getCin());
            client.get().setPermisDeConduire(clientRequest.getPermisDeConduire());
            client.get().setNom(clientRequest.getNom());
            client.get().setPrenom(clientRequest.getPrenom());
            client.get().setAdresse(clientRequest.getAdresse());
            client.get().setEmail(clientRequest.getEmail());
            client.get().setTelephone(clientRequest.getTelephone());
            client.get().setDateDeNaissance(clientRequest.getDateDeNaissance());
            clientService.updateClient(client.get());
        }
        return "redirect:/clients";
    }

    @PostMapping("/{id}/delete")
    //delete client
    public String deleteClient(Model model, @PathVariable Long id){
        Optional<Client> client = clientService.getClientById(id);
        if (client.isPresent()){
            clientService.deleteClient(id);
        }
        return "redirect:/clients";
    }
}
