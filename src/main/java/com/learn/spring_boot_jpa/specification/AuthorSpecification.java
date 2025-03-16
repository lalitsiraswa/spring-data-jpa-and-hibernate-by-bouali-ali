package com.learn.spring_boot_jpa.specification;

import ch.qos.logback.core.util.StringUtil;
import com.learn.spring_boot_jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {
    public static Specification<Author> hasAge(int age) {
        return (Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder) -> {
            if (age < 0) {
                return null;
            }
            return criteriaBuilder.equal(root.get("age"), age);
        };
    }

    public static Specification<Author> firstNameLike(String firstName) {
        return (Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder) -> {
            if (StringUtil.isNullOrEmpty(firstName)) {
                return null;
            }
            return criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
        };
    }
}
