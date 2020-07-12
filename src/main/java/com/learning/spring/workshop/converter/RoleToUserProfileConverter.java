package com.learning.spring.workshop.converter;

import com.learning.spring.workshop.model.UserProfile;
import com.learning.spring.workshop.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

    private final UserProfileService userProfileService;

    /**
     * Gets UserProfile by Id
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserProfile convert(Object element) {
        int id = Integer.parseInt((String) element);
        UserProfile profile = userProfileService.findById(id);
        System.out.println("Profile : " + profile);
        return profile;
    }
}
