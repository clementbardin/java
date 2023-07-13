import java.util.ArrayList;
import java.util.List;

public class Account {
        private String accountNumber; // Numéro de compte
        private Customer customer; // Client associé au compte
        private double balance; // Solde du compte
        private List<String> transactionHistory; // Historique des transactions

        public Account(String accountNumber, Customer customer) {
            this.accountNumber = accountNumber;
            this.customer = customer;
            this.balance = 0.0;
            this.transactionHistory = new ArrayList<>(); // Initialisation de l'historique des transactions
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public Customer getCustomer() {
            return customer;
        }

        public double getBalance() {
            return balance;
        }

        public List<String> getTransactionHistory() {
            return transactionHistory;
        }

        public void deposit(double amount) {
            balance += amount;
            String transaction = "Dépôt : +" + amount;
            transactionHistory.add(transaction);
        }

        public boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                String transaction = "Retrait : -" + amount;
                transactionHistory.add(transaction);
                return true;
            }

            return false;
        }
    }

