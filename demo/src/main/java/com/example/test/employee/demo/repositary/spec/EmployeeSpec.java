package com.example.test.employee.demo.repositary.spec;

import com.example.test.employee.demo.model.Employee;
import com.example.test.employee.demo.model.Office;
import com.example.test.employee.demo.model.Role;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.validation.constraints.Email;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeSpec {

    public static Specification<Employee> isEqualTo(String filter,String filterValue) {

        return new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root,CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {

                switch (filter.toLowerCase())
                {
                    case "firstname":
                       return builder.equal(root.get("firstName"),filterValue);

                    case "lastname":
                        return builder.equal(root.get("lastName"),filterValue);

                    case "birthday":
                        return builder.equal(root.get("birthday"),filterValue);

                    case "hiringdate":
                        return builder.equal(root.get("hiringDate"),filterValue);

                    case "contractexpirationdate":
                        return builder.equal(root.get("contractExpirationDate"),filterValue);

                    case "phonenumber":
                        return builder.equal(root.get("phoneNumber"),filterValue);

                    case "email":
                        return builder.equal(root.get("email"),filterValue);

                    default:
                        return null;
                }
            }
        };
    }
}
