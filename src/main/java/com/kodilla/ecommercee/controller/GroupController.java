package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.entity.Group;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/group")
@RequiredArgsConstructor
@Controller
public class GroupController {
    private GroupService service;
    private final GroupMapper mapper;

    @GetMapping(value = "{groupId}")
    public GroupDto getGroup(@PathVariable long groupId) throws GroupNotFoundException {
        return mapper.mapToGroupDto(service.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }


    @GetMapping
    public List<GroupDto> getGroups() {
        List<Group> groups = service.getGroups();
        return mapper.mapToGroupDtoList(groups);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto){
        Group group = mapper.mapToGroup(groupDto);
        service.saveGroup(group);
    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        Group group = mapper.mapToGroup(groupDto);
        Group updatedGroup = service.saveGroup(group);
        return mapper.mapToGroupDto(updatedGroup);
    }

    @DeleteMapping(value = "{groupId}")
    public void deleteGroup(@PathVariable long groupId){
        service.deleteGroup(groupId);
    }

}
