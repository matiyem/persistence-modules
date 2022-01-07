package com.example.hibernate.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * created by Atiye Mousavi
 * Date: 9/5/2021
 * Time: 3:06 PM
 */

public class AuditorAwareImpl implements AuditorAware<String> {
    //The columns annotated with @CreatedBy and @LastModifiedBy are populated
    // with the name of the principal that created or last modified the entity.
    // The information is pulled from SecurityContext‘s Authentication instance.
    // If you want to customize values that are set to the annotated fields, you can implement AuditorAware<T> interface:

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(e ->e.getAuthentication())
                .map(Authentication::getName);
    }
}
