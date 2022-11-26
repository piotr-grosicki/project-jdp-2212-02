package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop/group")
@RequiredArgsConstructor
@Controller
public class GroupController {


    @GetMapping(value = "{groupId}")
    public GroupDto getGroup(@PathVariable long groupId){
        return new GroupDto(1L,"GetNameTest");
    }


    @GetMapping
    public List<GroupDto> getGroups(){
        return new ArrayList<GroupDto>();
    }


    @PostMapping
    public void createGroup(@RequestBody GroupDto groupDto){

    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        return new GroupDto(1L,"UpdateNameTest");
    }

    @DeleteMapping(value = "{groupId}")
    public void deleteGroup(@PathVariable long groupId){

    }

}
