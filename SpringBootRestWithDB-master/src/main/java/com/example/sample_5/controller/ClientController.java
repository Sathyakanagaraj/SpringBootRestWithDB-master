package com.example.sample_5.controller;

import com.example.sample_5.repository.ClientRepository;
import com.example.sample_5.service.ClientService;
import com.example.sample_5.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository repo;

    @Autowired
    private ClientService service;

     @GetMapping("/client")
     public List<Client> showClient(){
         return repo.findAll();
     }

     @PostMapping("/addclient")
     public Client addClient(@RequestBody Client client){
         Client add=new Client();
         add.setName(client.getName());
         add.setPassword(client.getPassword());
         return repo.save(add);

     }
    @PutMapping("/update/{id}")
    public Client userUpdate(@PathVariable int id, @RequestBody Client client){
        Client up=repo.findById(id).get();
        up.setName(client.getName());
        up.setPassword(client.getPassword());
        repo.save(up);
        return up;

    }
     @DeleteMapping("/api/{id}")
     public void deleteClient(@PathVariable int id,Client client){
         repo.deleteById(id);
     }

    @GetMapping({"/showclient", "/", "/addlist"})
    public ModelAndView getClient() {
        ModelAndView model = new ModelAndView("emplist");
        List<Client> list = repo.findAll();
        model.addObject("employees", list);
        return model;
    }

    /*@GetMapping("/addclient")
    public ModelAndView addClient(){
        ModelAndView addlist=new ModelAndView("registration");
        Client newclient=new Client();
        addlist.addObject("employee",newclient);
        return addlist;
}
    @PostMapping("/savecli")
    public String saveClient(@ModelAttribute Client client){
        repo.save(client);
        return "redirect:/addlist";
    }*/
}
