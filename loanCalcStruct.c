#include <stdio.h>
#include <math.h>

#define MAX_PAYMENTS 100

typedef struct {
    double interest;
    double principal;
    double balance;
} Payment;

int main() {
    // Create all the variables we need
    double loanAmount, interestRate, monthlyRate, monthlyPayment;
    int numPayments, paymentNum;

    // Prompt for original loan amount
    printf("Enter the loan amount: $ ");
    scanf("%lf", &loanAmount);

    // Promt for interest rate
    printf("Enter the interest rate per year(in percent): %% ");
    scanf("%lf", &interestRate);

    // Prompt for number of payments
    printf("Enter the number of payments: ");
    scanf("%d", &numPayments);

    // Calculate the monthly interest rate
    monthlyRate = interestRate / 1200;

    // Calculate the monthly payment
    monthlyPayment = (loanAmount * monthlyRate) / (1 - pow(1 + monthlyRate, -numPayments));

    // Print the table header
    printf("\nMonthly payment should be $%.2lf\n", monthlyPayment);
    printf("======================AMORTIZATION SCHEDULE======================\n");
    printf("#\tPayment\t\tPrincipal\tInterest\tBalance\n");

    // Create the structure array to store all the payments
    Payment payments[MAX_PAYMENTS];

    // Set the initial balance to the loan amount
    payments[0].balance = loanAmount;

    // Print each row of the table and store the payment information in the structure array
    for (paymentNum = 1; paymentNum <= numPayments; paymentNum++) {
        // Calculate the interest and principal for the current payment
        payments[paymentNum - 1].interest = payments[paymentNum - 1].balance * monthlyRate;
        payments[paymentNum - 1].principal = monthlyPayment - payments[paymentNum - 1].interest;

        // Calculate the new balance
        payments[paymentNum].balance = payments[paymentNum - 1].balance - payments[paymentNum - 1].principal;

        // Print the row
        printf("%d\t$%.2lf\t\t$%.2lf\t\t$%.2lf\t\t$%.2lf\n", paymentNum, monthlyPayment,
               payments[paymentNum - 1].principal, payments[paymentNum - 1].interest, payments[paymentNum].balance);
    }

    return 0;
}