package com.lambdaschool.bwafricanmarket.services;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class UserAuditing implements AuditorAware<String> {

}
