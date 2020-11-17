package com.lambdaschool.bwafricanmarket.services;

import com.lambdaschool.bwafricanmarket.models.Section;

import java.util.List;

public interface SectionService {
    List<Section> findAll();
    Section findSectionById(long id);
    void delete(long id);
    Section save(Section role);
    Section update(Section role, long id);
    void deleteAll();
}
