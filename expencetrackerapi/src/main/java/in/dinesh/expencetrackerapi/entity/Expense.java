package in.dinesh.expencetrackerapi.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "tbl_expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "expense_name")
    @NotBlank(message = "Expense name must not be null")
    @Size(min=3, message = " Expense name should be 3 characters")
    private String name;
    private String description;
    @Column(name = "expense_amount")
    private BigDecimal amount;
    private String category;
    private Date date;

    @Column(name = "created_at",nullable = false , updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

}
