package com.sml.controller;

import com.sml.model.Link;
import com.sml.model.User;
import com.sml.repository.LinkRepository;
import com.sml.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LinkController {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public LinkController(LinkRepository linkRepository,
                          UserRepository userRepository){
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }




    // GET LINKS FOR SPECIFIC USER


    @GetMapping("/links/{userId}")
    public List<Link> getUserLinks(@PathVariable Long userId){
        return linkRepository.findByUserId(userId);
    }





    // ADD LINK FOR USER




    @PostMapping("/links")
    public Link addLink(@RequestBody Map<String, String> data){

        String url = data.get("url");
        String userIdStr = data.get("userId");

        // Guard against null
        if(userIdStr == null || url == null){
            return null;
        }

        Long userId = Long.parseLong(userIdStr);
        User user = userRepository.findById(userId).orElse(null);

        if(user == null){
            return null;
        }

        Link link = new Link();
        link.setUrl(url);
        link.setUser(user);

        return linkRepository.save(link);
    }

    // DELETE LINK
    @DeleteMapping("/links/{id}")
    public String deleteLink(@PathVariable Long id){
        linkRepository.deleteById(id);
        return "Deleted";
    }

}