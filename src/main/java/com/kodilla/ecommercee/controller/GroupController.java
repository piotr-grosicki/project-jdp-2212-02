package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop/group")
@Service
public class GroupController {

    @GetMapping(value = "{groupId}")
    public GroupDto getGroup(@PathVariable long id){
        return new GroupDto(1L,"GetNameTest");
    }


    @GetMapping
    public List<GroupDto> getGroups(){
        return new ArrayList<GroupDto>();
    }


    @PostMapping
    public void createGroup(GroupDto groupDto){

    }

    @PutMapping
    public GroupDto updateGroup(GroupDto groupDto){
        return new GroupDto(1L,"UpdateNameTest");
    }

    @DeleteMapping(value = "{groupId}")
    public void deleteGroup(@PathVariable long groupId){

    }

}
