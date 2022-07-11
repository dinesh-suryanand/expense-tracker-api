package in.dinesh.expencetrackerapi.controller;

import in.dinesh.expencetrackerapi.entity.Expense;
import in.dinesh.expencetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;


    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable page){

        //this piece of code will  give an error purely for demonstration of internal error
//        int number=1;
//        factorial(number);
        return expenseService.getAllExpenses(page).toList();
    }

    //if  {id} and Path variable are same we can remove    --->    ("id")
    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id){
        //public String...   (@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // if  ?id= and Path variable are not same we can remove    --->    ("id")
    @ResponseStatus(code = HttpStatus.NO_CONTENT , reason = "deleted the expense")
    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam("id") Long id){
        expenseService.deleteExpenseById(id);
    }


    @ResponseStatus(code = HttpStatus.CREATED , reason = "created the expense")
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@RequestBody Expense expense){
        return expenseService.saveExpenseDetails(expense);
    }


    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense , @PathVariable Long id){
        return expenseService.updateExpenseDetails(id,expense);
    }

    // for demonstration of internal exception handling we create this fault method
    public int factorial(int num) {
            return (num * factorial(num - 1));
    }
}
